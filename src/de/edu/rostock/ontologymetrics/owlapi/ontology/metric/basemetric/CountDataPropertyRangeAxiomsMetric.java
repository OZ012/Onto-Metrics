package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLOntology;

public class CountDataPropertyRangeAxiomsMetric extends BaseMetric {

    public CountDataPropertyRangeAxiomsMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Integer getValue() {
	return ontology.getAxiomCount(AxiomType.DATA_PROPERTY_RANGE, true);
    }

    @Override
    public String toString() {
	return "Data Property range axioms count";
    }

}
