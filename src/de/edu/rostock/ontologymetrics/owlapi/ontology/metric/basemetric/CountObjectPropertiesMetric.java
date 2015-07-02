package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.OWLOntology;

public class CountObjectPropertiesMetric extends BaseMetric {

    public CountObjectPropertiesMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Integer getValue() {
	// the owl:ObjectProperty is no needed class, so -1
	return ontology.getObjectPropertiesInSignature().size() - 1;
    }

    @Override
    public String toString() {
	return "Object properties count";
    }

}
