package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.OWLOntology;

public class CountTotalDataPropertiesMetric extends BaseMetric {

    public CountTotalDataPropertiesMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Integer getValue() {
	// the owl:TopDataProperty is no needed class, so -1
	return ontology.getDataPropertiesInSignature(true).size() - 1;
    }

    @Override
    public String toString() {
	return "Total data properties count";
    }

}
