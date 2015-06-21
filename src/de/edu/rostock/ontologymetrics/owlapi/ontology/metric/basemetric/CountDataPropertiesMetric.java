package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.OWLOntology;

public class CountDataPropertiesMetric extends BaseMetric {

    public CountDataPropertiesMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Integer getValue() {
	// the owl:TopDataProperty is no needed class, so -1
	return ontology.getDataPropertiesInSignature().size() - 1;
    }

    @Override
    public String toString() {
	return "Data properties count";
    }

}
