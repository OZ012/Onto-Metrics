package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.OWLOntology;

public class CountLogicalAxiomsMetric extends BaseMetric {

    public CountLogicalAxiomsMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Integer getValue() {
	int count = 0;
	for (OWLOntology owlOntology : ontology.getImportsClosure()) {
	    count = count + owlOntology.getLogicalAxiomCount();
	}
	return count;
    }

    @Override
    public String toString() {
	return "Logical axioms count";
    }

}
