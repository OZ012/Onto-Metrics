package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.OWLOntology;

public class CountTotalIndividualsMetric extends BaseMetric {

    public CountTotalIndividualsMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Integer getValue() {
	return ontology.getIndividualsInSignature(true).size();
    }

    @Override
    public String toString() {
	return "Total individuals count";
    }

}
