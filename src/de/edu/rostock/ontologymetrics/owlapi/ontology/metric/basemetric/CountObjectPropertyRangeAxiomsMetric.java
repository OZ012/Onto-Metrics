package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLOntology;

public class CountObjectPropertyRangeAxiomsMetric extends BaseMetric {

    public CountObjectPropertyRangeAxiomsMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Integer getValue() {
	return ontology.getAxiomCount(AxiomType.OBJECT_PROPERTY_RANGE, true);
    }

    @Override
    public String toString() {
	return "Object property range axioms count";
    }

}
