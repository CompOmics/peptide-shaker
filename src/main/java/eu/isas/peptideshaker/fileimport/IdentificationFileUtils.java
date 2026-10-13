package eu.isas.peptideshaker.fileimport;

/**
 * Utility methods for identification result file names.
 *
 * @author CompOmics
 */
public class IdentificationFileUtils {

    /**
     * Empty private constructor.
     */
    private IdentificationFileUtils() {
    }

    /**
     * Returns true if the file name is a supported identification result file.
     *
     * @param fileName the file name
     *
     * @return true if the file name is a supported identification result file
     */
    public static boolean isSupportedIdentificationFile(String fileName) {

        String fileNameLowerCase = fileName.toLowerCase();

        return fileNameLowerCase.endsWith(".omx")
                || fileNameLowerCase.endsWith(".t.xml")
                || fileNameLowerCase.endsWith(".pep.xml")
                || fileNameLowerCase.endsWith(".dat")
                || fileNameLowerCase.endsWith(".mzid")
                || fileNameLowerCase.endsWith(".ms-amanda.csv")
                || fileNameLowerCase.endsWith(".res")
                || fileNameLowerCase.endsWith(".tide-search.target.txt")
                || fileNameLowerCase.endsWith(".tags")
                || fileNameLowerCase.endsWith(".pnovo.txt")
                || fileNameLowerCase.endsWith(".novor.csv")
                || isInstaNovoIdentificationFile(fileNameLowerCase)
                || fileNameLowerCase.endsWith(".coss.tsv")
                || fileNameLowerCase.endsWith(".sage.tsv")
                || fileNameLowerCase.endsWith(".psm")
                || fileNameLowerCase.endsWith(".omx.gz")
                || fileNameLowerCase.endsWith(".t.xml.gz")
                || fileNameLowerCase.endsWith(".pep.xml.gz")
                || fileNameLowerCase.endsWith(".mzid.gz")
                || fileNameLowerCase.endsWith(".ms-amanda.csv.gz")
                || fileNameLowerCase.endsWith(".res.gz")
                || fileNameLowerCase.endsWith(".tide-search.target.txt.gz")
                || fileNameLowerCase.endsWith(".tags.gz")
                || fileNameLowerCase.endsWith(".pnovo.txt.gz")
                || fileNameLowerCase.endsWith(".novor.csv.gz")
                || isGzippedInstaNovoIdentificationFile(fileNameLowerCase)
                || fileNameLowerCase.endsWith(".coss.tsv.gz")
                || fileNameLowerCase.endsWith(".sage.tsv.gz")
                || fileNameLowerCase.endsWith(".psm.gz");
    }

    /**
     * Returns true if the file name is a supported STIRred identification
     * result file.
     *
     * @param fileName the file name
     *
     * @return true if the file name is a supported STIRred identification
     * result file
     */
    public static boolean isSupportedStirredIdentificationFile(String fileName) {

        String fileNameLowerCase = fileName.toLowerCase();

        return fileNameLowerCase.endsWith(".omx")
                || fileNameLowerCase.endsWith(".t.xml")
                || fileNameLowerCase.endsWith(".pep.xml")
                || fileNameLowerCase.endsWith(".dat")
                || fileNameLowerCase.endsWith(".mzid")
                || fileNameLowerCase.endsWith(".ms-amanda.csv")
                || fileNameLowerCase.endsWith(".res")
                || fileNameLowerCase.endsWith(".tide-search.target.txt")
                || isInstaNovoIdentificationFile(fileNameLowerCase)
                || fileNameLowerCase.endsWith(".coss.tsv")
                || fileNameLowerCase.endsWith(".sage.tsv")
                || fileNameLowerCase.endsWith(".psm")
                || fileNameLowerCase.endsWith(".omx.gz")
                || fileNameLowerCase.endsWith(".t.xml.gz")
                || fileNameLowerCase.endsWith(".pep.xml.gz")
                || fileNameLowerCase.endsWith(".mzid.gz")
                || fileNameLowerCase.endsWith(".ms-amanda.csv.gz")
                || fileNameLowerCase.endsWith(".res.gz")
                || fileNameLowerCase.endsWith(".tide-search.target.txt.gz")
                || isGzippedInstaNovoIdentificationFile(fileNameLowerCase)
                || fileNameLowerCase.endsWith(".sage.tsv.gz")
                || fileNameLowerCase.endsWith(".psm.gz");
    }

    /**
     * Returns true if the file name is a supported InstaNovo identification
     * result file.
     *
     * @param fileName the file name
     *
     * @return true if the file name is a supported InstaNovo identification
     * result file
     */
    public static boolean isInstaNovoIdentificationFile(String fileName) {

        String fileNameLowerCase = fileName.toLowerCase();

        return fileNameLowerCase.endsWith(".instanovo.csv")
                || fileNameLowerCase.endsWith(".instanovoplus.csv")
                || fileNameLowerCase.endsWith(".instanovo.refined.csv");
    }

    /**
     * Returns true if the file name is a supported gzipped InstaNovo
     * identification result file.
     *
     * @param fileName the file name
     *
     * @return true if the file name is a supported gzipped InstaNovo
     * identification result file
     */
    public static boolean isGzippedInstaNovoIdentificationFile(String fileName) {

        String fileNameLowerCase = fileName.toLowerCase();

        return fileNameLowerCase.endsWith(".instanovo.csv.gz")
                || fileNameLowerCase.endsWith(".instanovoplus.csv.gz")
                || fileNameLowerCase.endsWith(".instanovo.refined.csv.gz");
    }
}
