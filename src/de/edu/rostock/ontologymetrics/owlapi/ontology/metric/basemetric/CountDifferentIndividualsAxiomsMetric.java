package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLOntology;

public class CountDifferentIndividualsAxiomsMetric extends BaseMetric {

    public CountDifferentIndividualsAxiomsMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Integer getValue() {
	return ontology.getAxiomCount(AxiomType.DIFFERENT_INDIVIDUALS, true);
    }

    @Override
    public String toString() {
	return "Different individuals axioms count";
    }

}
