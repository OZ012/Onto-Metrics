package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.OWLOntology;

public class CountTotalObjectPropertiesMetric extends BaseMetric {

    public CountTotalObjectPropertiesMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Integer getValue() {
	// the owl:TopObjectProperty is no needed class, so -1
	return ontology.getObjectPropertiesInSignature(true).size() - 1;
    }

    @Override
    public String toString() {
	return "Total object properties count";
    }

}
