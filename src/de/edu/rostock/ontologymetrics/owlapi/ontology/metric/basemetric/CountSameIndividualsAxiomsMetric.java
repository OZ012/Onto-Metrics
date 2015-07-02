package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLOntology;

public class CountSameIndividualsAxiomsMetric extends BaseMetric {

    public CountSameIndividualsAxiomsMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Integer getValue() {
	return ontology.getAxiomCount(AxiomType.SAME_INDIVIDUAL, true);
    }

    @Override
    public String toString() {
	return "Same individuals axioms count";
    }

}
