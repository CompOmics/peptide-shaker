package eu.isas.peptideshaker.fileimport;

import com.compomics.util.experiment.identification.amino_acid_tags.Tag;
import com.compomics.util.experiment.identification.protein_inference.FastaMapper;
import com.compomics.util.experiment.identification.protein_inference.PeptideProteinMapping;
import com.compomics.util.experiment.io.biology.protein.ProteinDatabase;
import com.compomics.util.experiment.io.biology.protein.ProteinDetailsProvider;
import com.compomics.util.experiment.io.biology.protein.SequenceProvider;
import com.compomics.util.parameters.identification.advanced.SequenceMatchingParameters;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

/**
 * Empty sequence/protein provider used for de novo only projects imported
 * without a protein sequence database (FASTA). It exposes no proteins, so
 * peptides are left without protein mapping and no sequence is ever resolved.
 *
 * @author Jeroen Van Goey
 */
public class EmptySequenceProvider implements SequenceProvider, ProteinDetailsProvider, FastaMapper {

    @Override
    public Collection<String> getAccessions() {
        return Collections.emptySet();
    }

    @Override
    public HashSet<String> getDecoyAccessions() {
        return new HashSet<>(0);
    }

    @Override
    public String getSequence(String proteinAccession) {
        return null;
    }

    @Override
    public String getSubsequence(String accession, int start, int end) {
        return null;
    }

    @Override
    public String getHeaderAsString(String proteinAccession) {
        return null;
    }

    @Override
    public String getDescription(String accession) {
        return null;
    }

    @Override
    public String getSimpleDescription(String accession) {
        return null;
    }

    @Override
    public ProteinDatabase getProteinDatabase(String accession) {
        return ProteinDatabase.Unknown;
    }

    @Override
    public String getGeneName(String accession) {
        return null;
    }

    @Override
    public String getTaxonomy(String accession) {
        return null;
    }

    @Override
    public String getOrganismIdentifier(String accession) {
        return null;
    }

    @Override
    public Integer getProteinEvidence(String accession) {
        return null;
    }

    @Override
    public ArrayList<PeptideProteinMapping> getProteinMapping(String peptideSequence, SequenceMatchingParameters proteinInferencePreferences) {
        return new ArrayList<>(0);
    }

    @Override
    public ArrayList<PeptideProteinMapping> getProteinMapping(Tag tag, SequenceMatchingParameters sequenceMatchingPreferences) {
        return new ArrayList<>(0);
    }
}
