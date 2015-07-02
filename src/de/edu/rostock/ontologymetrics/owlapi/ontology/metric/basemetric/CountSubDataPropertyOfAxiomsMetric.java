package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLOntology;

public class CountSubDataPropertyOfAxiomsMetric extends BaseMetric {

    public CountSubDataPropertyOfAxiomsMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Integer getValue() {
	return ontology.getAxiomCount(AxiomType.SUB_DATA_PROPERTY, true);
    }

    @Override
    public String toString() {
	return "SubDataPropertyOf axioms count";
    }

}
