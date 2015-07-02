package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.schemaknowledgebasemetric.knowledgebasemetric;

import org.semanticweb.owlapi.model.OWLOntology;

import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountTotalClassesMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountTotalIndividualsMetric;

public class AveragePopulationMetric extends KnowledgebaseMetric {

    public AveragePopulationMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Float getValue() {

	float countTotalIndividuals = new CountTotalIndividualsMetric(ontology)
		.getValue();
	float countTotalClasses = new CountTotalClassesMetric(ontology)
		.getValue();

	// avoid a division by zero
	if (countTotalClasses == 0) {
	    return 0f;
	} else {
	    return countTotalIndividuals / countTotalClasses;
	}
    }

    @Override
    public String toString() {
	return "Average population";
    }

}
