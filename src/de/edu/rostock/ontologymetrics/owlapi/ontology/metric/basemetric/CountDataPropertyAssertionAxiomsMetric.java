package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLOntology;

public class CountDataPropertyAssertionAxiomsMetric extends BaseMetric {

    public CountDataPropertyAssertionAxiomsMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Integer getValue() {
	return ontology.getAxiomCount(AxiomType.DATA_PROPERTY_ASSERTION, true);
    }

    @Override
    public String toString() {
	return "Data property assertion axioms count";
    }

}
