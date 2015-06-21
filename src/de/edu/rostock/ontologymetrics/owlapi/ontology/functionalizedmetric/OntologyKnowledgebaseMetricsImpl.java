package de.edu.rostock.ontologymetrics.owlapi.ontology.functionalizedmetric;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntology;

public class OntologyKnowledgebaseMetricsImpl extends
	OntologySchemaKnowledgeBaseMetricsImpl implements
	OntologyKnowledgebaseMetrics {

    public OntologyKnowledgebaseMetricsImpl(OWLOntology pOntology) {
	super(pOntology);
    }

    public float getClassRichness() {
	float countClassHasIndividual = 0;
	float countTotalClasses = countTotalClasses();

	// avoid a division by zero
	if (countTotalClasses == 0) {
	    return 0;
	} else {
	    for (OWLClass owlClass : ontology.getClassesInSignature()) {
		if (!owlClass.getIndividuals(ontology).isEmpty()) {
		    countClassHasIndividual++;
		}
	    }
	    return countClassHasIndividual / countTotalClasses;
	}

    }

    public float getAveragePopulation() {
	float countTotalIndividuals = countTotalIndividuals();
	float countTotalClasses = countTotalClasses();

	// avoid a division by zero
	if (countTotalClasses == 0) {
	    return 0;
	} else {
	    return countTotalIndividuals / countTotalClasses;
	}
    }

    public float getCohesion() {
	// TODO Auto-generated method stub
	return 0;
    }

    /**
     * Return the ontology metrics as a human-readable <code>String</code>.
     */
    @Override
    public String toString() {
	StringBuilder output = new StringBuilder();
	if (ontology != null) {
	    output.append("\nKnowledgebase Metrics\nInstances: ")
		    .append(countIndividuals()).append("\nTotal Instances: ")
		    .append(countTotalIndividuals())
		    .append("\nClass Richness: ").append(getClassRichness())
		    .append("\nAverage Population: ")
		    .append(getAveragePopulation())
		    .append("\nInstance Coverage: ")
		    .append(getInstanceCoverage()).append("\n");
	}
	return output.toString();
    }

    /*
     * additional metrics
     */

    @Override
    public float getInstanceCoverage() {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public float getTreeBalance() {
	// TODO Auto-generated method stub
	return 0;
    }

}
