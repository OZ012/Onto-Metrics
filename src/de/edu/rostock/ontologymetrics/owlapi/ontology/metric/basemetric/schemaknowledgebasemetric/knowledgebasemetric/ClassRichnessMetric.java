package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.schemaknowledgebasemetric.knowledgebasemetric;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntology;

import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountTotalClassesMetric;

public class ClassRichnessMetric extends KnowledgebaseMetric {

    public ClassRichnessMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Float getValue() {
	float countClassHasIndividual = 0;
	int totalClasses = new CountTotalClassesMetric(ontology).getValue();
	float countTotalClasses = totalClasses;

	// avoid a division by zero
	if (countTotalClasses == 0) {
	    return 0f;
	} else {
	    for (OWLClass owlClass : ontology.getClassesInSignature()) {
		if (!owlClass.getIndividuals(ontology).isEmpty()) {
		    countClassHasIndividual++;
		}
	    }
	    return (float) countClassHasIndividual / (float) countTotalClasses;
	}
    }

    @Override
    public String toString() {
	return "Class richness";
    }

}
