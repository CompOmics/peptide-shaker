package eu.isas.peptideshaker.test.fileimport;

import eu.isas.peptideshaker.cmd.PeptideShakerCLIInputBean;
import eu.isas.peptideshaker.fileimport.IdentificationFileUtils;
import java.io.File;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.junit.Assert;

/**
 * Tests PeptideShaker InstaNovo identification file discovery.
 *
 * @author CompOmics
 */
public class InstaNovoIdentificationFileUtilsTest extends TestCase {

    /**
     * Tests supported InstaNovo result file names.
     */
    public void testSupportedInstaNovoFileNames() {

        Assert.assertTrue(IdentificationFileUtils.isInstaNovoIdentificationFile("sample.instanovo.csv"));
        Assert.assertTrue(IdentificationFileUtils.isInstaNovoIdentificationFile("sample.instanovoplus.csv"));
        Assert.assertTrue(IdentificationFileUtils.isInstaNovoIdentificationFile("sample.instanovo.refined.csv"));

        Assert.assertTrue(IdentificationFileUtils.isGzippedInstaNovoIdentificationFile("sample.instanovo.csv.gz"));
        Assert.assertTrue(IdentificationFileUtils.isGzippedInstaNovoIdentificationFile("sample.instanovoplus.csv.gz"));
        Assert.assertTrue(IdentificationFileUtils.isGzippedInstaNovoIdentificationFile("sample.instanovo.refined.csv.gz"));

        Assert.assertTrue(IdentificationFileUtils.isSupportedIdentificationFile("sample.instanovo.csv"));
        Assert.assertTrue(IdentificationFileUtils.isSupportedIdentificationFile("sample.instanovoplus.csv"));
        Assert.assertTrue(IdentificationFileUtils.isSupportedIdentificationFile("sample.instanovo.refined.csv"));
        Assert.assertTrue(IdentificationFileUtils.isSupportedIdentificationFile("sample.instanovo.csv.gz"));
        Assert.assertTrue(IdentificationFileUtils.isSupportedIdentificationFile("sample.instanovoplus.csv.gz"));
        Assert.assertTrue(IdentificationFileUtils.isSupportedIdentificationFile("sample.instanovo.refined.csv.gz"));

        Assert.assertTrue(IdentificationFileUtils.isSupportedStirredIdentificationFile("sample.instanovo.csv"));
        Assert.assertTrue(IdentificationFileUtils.isSupportedStirredIdentificationFile("sample.instanovoplus.csv"));
        Assert.assertTrue(IdentificationFileUtils.isSupportedStirredIdentificationFile("sample.instanovo.refined.csv"));
        Assert.assertTrue(IdentificationFileUtils.isSupportedStirredIdentificationFile("sample.instanovo.csv.gz"));
        Assert.assertTrue(IdentificationFileUtils.isSupportedStirredIdentificationFile("sample.instanovoplus.csv.gz"));
        Assert.assertTrue(IdentificationFileUtils.isSupportedStirredIdentificationFile("sample.instanovo.refined.csv.gz"));

        Assert.assertFalse(IdentificationFileUtils.isSupportedIdentificationFile("sample.instanovo.tsv"));
        Assert.assertFalse(IdentificationFileUtils.isSupportedIdentificationFile("sample.instanovoplus.txt"));
        Assert.assertFalse(IdentificationFileUtils.isSupportedStirredIdentificationFile("sample.novor.csv"));
        Assert.assertFalse(IdentificationFileUtils.isSupportedStirredIdentificationFile("sample.pnovo.txt"));
        Assert.assertFalse(IdentificationFileUtils.isSupportedStirredIdentificationFile("sample.tags"));
    }

    /**
     * Tests the PeptideShakerCLI file expansion path used before import.
     *
     * @throws Exception if an exception occurs
     */
    public void testCliIdentificationFileExpansion() throws Exception {

        File folder = createFolder("peptideshaker-instanovo");
        File instaNovo = createFile(folder, "sample.instanovo.csv");
        File instaNovoPlus = createFile(folder, "sample.instanovoplus.csv");
        File refined = createFile(folder, "sample.instanovo.refined.csv");

        ArrayList<File> files = PeptideShakerCLIInputBean.getIdentificationFiles(folder.getAbsolutePath());

        Assert.assertTrue(files.contains(instaNovo));
        Assert.assertTrue(files.contains(instaNovoPlus));
        Assert.assertTrue(files.contains(refined));
    }

    /**
     * Creates a temporary file.
     *
     * @param folder the parent folder
     * @param name the file name
     *
     * @return the file
     *
     * @throws Exception if an exception occurs
     */
    private File createFile(File folder, String name) throws Exception {

        File file = new File(folder, name);
        file.createNewFile();
        file.deleteOnExit();

        return file;
    }

    /**
     * Creates a temporary folder.
     *
     * @param prefix the prefix
     *
     * @return the folder
     *
     * @throws Exception if an exception occurs
     */
    private File createFolder(String prefix) throws Exception {

        File folder = File.createTempFile(prefix, "");
        folder.delete();
        folder.mkdirs();
        folder.deleteOnExit();

        return folder;
    }
}
