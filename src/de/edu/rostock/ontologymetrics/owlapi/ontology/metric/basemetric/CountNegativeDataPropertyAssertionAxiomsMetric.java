package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLOntology;

public class CountNegativeDataPropertyAssertionAxiomsMetric extends BaseMetric {

    public CountNegativeDataPropertyAssertionAxiomsMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Integer getValue() {
	return ontology.getAxiomCount(
		AxiomType.NEGATIVE_DATA_PROPERTY_ASSERTION, true);
    }

    @Override
    public String toString() {
	return "Negative data property assertion axioms count";
    }

}
