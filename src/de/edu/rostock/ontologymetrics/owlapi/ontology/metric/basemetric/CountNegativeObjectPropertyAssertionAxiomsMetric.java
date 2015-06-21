package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLOntology;

public class CountNegativeObjectPropertyAssertionAxiomsMetric extends
	BaseMetric {

    public CountNegativeObjectPropertyAssertionAxiomsMetric(
	    OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Integer getValue() {
	return ontology.getAxiomCount(
		AxiomType.NEGATIVE_OBJECT_PROPERTY_ASSERTION, true);
    }

    @Override
    public String toString() {
	return "Negative object property assertion axioms count";
    }

}
