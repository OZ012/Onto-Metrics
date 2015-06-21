package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.OWLOntology;

public class CountHiddenGCIMetric extends BaseMetric {

    public CountHiddenGCIMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Integer getValue() {
	// TODO
	return 0;
    }

    @Override
    public String toString() {
	return "Hidden GCI count";
    }

}
