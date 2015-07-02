package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLOntology;

public class CountObjectPropertyAssertionAxiomsMetric extends BaseMetric {

    public CountObjectPropertyAssertionAxiomsMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Integer getValue() {
	return ontology
		.getAxiomCount(AxiomType.OBJECT_PROPERTY_ASSERTION, true);
    }

    @Override
    public String toString() {
	return "Object property assertion axioms count";
    }

}
