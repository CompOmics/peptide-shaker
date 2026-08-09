package eu.isas.peptideshaker.test.preferences;

import eu.isas.peptideshaker.preferences.ProjectDetails;
import junit.framework.TestCase;
import org.junit.Assert;

/**
 * Tests project details.
 *
 * @author CompOmics
 */
public class ProjectDetailsTest extends TestCase {

    /**
     * Tests no-FASTA project details.
     */
    public void testNoFastaProjectDetails() {

        ProjectDetails projectDetails = new ProjectDetails();
        projectDetails.setFastaFile(null);

        Assert.assertNull(projectDetails.getFastaFile());
    }
}
