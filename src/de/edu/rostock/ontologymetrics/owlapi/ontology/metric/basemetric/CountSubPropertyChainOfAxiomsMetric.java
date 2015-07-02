package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLOntology;

public class CountSubPropertyChainOfAxiomsMetric extends BaseMetric {

    public CountSubPropertyChainOfAxiomsMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Integer getValue() {
	return ontology.getAxiomCount(AxiomType.SUB_PROPERTY_CHAIN_OF, true);
    }

    @Override
    public String toString() {
	return "SubPropertyChainOf axioms count";
    }

}
