package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLOntology;

public class CountSubObjectPropertyOfAxiomsMetric extends BaseMetric {

    public CountSubObjectPropertyOfAxiomsMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Integer getValue() {
	return ontology.getAxiomCount(AxiomType.SUB_OBJECT_PROPERTY, true);
    }

    @Override
    public String toString() {
	return "SubObjectPropertyOf axioms count";
    }

}
