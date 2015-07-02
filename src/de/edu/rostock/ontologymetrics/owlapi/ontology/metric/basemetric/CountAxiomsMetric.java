package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.OWLOntology;

public class CountAxiomsMetric extends BaseMetric {

    public CountAxiomsMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Integer getValue() {
	int count = 0;
	for (OWLOntology owlOntology : ontology.getImportsClosure()) {
	    count = count + owlOntology.getAxiomCount();
	}
	return count;
    }

    @Override
    public String toString() {
	return "Axioms count";
    }

}
