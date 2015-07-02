package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLOntology;

public class CountEquivalentClassesAxiomsMetric extends BaseMetric {

    public CountEquivalentClassesAxiomsMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Integer getValue() {
	return ontology.getAxiomCount(AxiomType.EQUIVALENT_CLASSES, true);
    }

    @Override
    public String toString() {
	return "Equivalent classes axioms count";
    }

}
