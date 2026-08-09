package eu.isas.peptideshaker.test.cmd;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.TimeUnit;
import junit.framework.TestCase;
import org.junit.Assert;

/**
 * Integration test running the PeptideShaker command line on InstaNovo de novo
 * results without a protein sequence database (FASTA). Mirrors a SearchGUI de
 * novo only run: it imports the three InstaNovo result files against the
 * spectrum file and verifies that a PSM level project is created.
 *
 * @author Jeroen Van Goey
 */
public class PeptideShakerInstaNovoCLITest extends TestCase {

    /**
     * Runs the CLI without a FASTA file and checks that a de novo only project
     * is created.
     *
     * @throws Exception if an error occurs while running the CLI
     */
    public void testDeNovoImportWithoutFasta() throws Exception {

        File csv = getResource("instanovo/small.instanovo.csv");
        File csvPlus = getResource("instanovo/small.instanovoplus.csv");
        File csvRefined = getResource("instanovo/small.instanovo.refined.csv");
        File mgfResource = getResource("instanovo/small.mgf");
        File idParams = getResource("instanovo/Identification_biological.par");

        // copy the spectrum file to a temporary folder so the generated .cms
        // index and the output project do not pollute the test resources
        Path tempDir = Files.createTempDirectory("ps-instanovo-cli");
        File mgf = new File(tempDir.toFile(), "small.mgf");
        Files.copy(mgfResource.toPath(), mgf.toPath(), StandardCopyOption.REPLACE_EXISTING);
        File out = new File(tempDir.toFile(), "instanovo_test.psdb");

        String identificationFiles = csv.getAbsolutePath()
                + "," + csvPlus.getAbsolutePath()
                + "," + csvRefined.getAbsolutePath();

        String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";

        ProcessBuilder processBuilder = new ProcessBuilder(
                javaBin,
                "-cp", System.getProperty("java.class.path"),
                "eu.isas.peptideshaker.cmd.PeptideShakerCLI",
                "-reference", "instanovo_test",
                "-identification_files", identificationFiles,
                "-spectrum_files", mgf.getAbsolutePath(),
                "-id_params", idParams.getAbsolutePath(),
                "-use_log_folder", "0",
                "-out", out.getAbsolutePath()
        );
        processBuilder.redirectErrorStream(true);

        Process process = processBuilder.start();
        String output = new String(process.getInputStream().readAllBytes());
        boolean finished = process.waitFor(5, TimeUnit.MINUTES);

        if (!finished) {
            process.destroyForcibly();
        }

        Assert.assertTrue("PeptideShaker CLI did not finish in time:\n" + output, finished);
        Assert.assertEquals("PeptideShaker CLI exited with an error:\n" + output, 0, process.exitValue());
        Assert.assertTrue("The de novo (no FASTA) branch was not taken:\n" + output, output.contains("de novo only"));
        Assert.assertTrue("No PeptideShaker project was created:\n" + output, out.exists() && out.length() > 0);
    }

    /**
     * Returns a file for the given test resource.
     *
     * @param name the resource name
     *
     * @return the resource file
     */
    private static File getResource(String name) {

        java.net.URL url = PeptideShakerInstaNovoCLITest.class.getClassLoader().getResource(name);

        if (url == null) {
            throw new IllegalStateException("Test resource not found: " + name);
        }

        return new File(url.getFile());
    }
}
