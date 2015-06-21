package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.OWLOntology;

public class CountClassesMetric extends BaseMetric {

    public CountClassesMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Integer getValue() {
	// the owl:Thing is no needed class, so -1
	return ontology.getClassesInSignature().size() - 1;
    }

    @Override
    public String toString() {
	return "Class count";
    }

}
