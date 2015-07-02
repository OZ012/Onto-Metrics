package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLOntology;

public class CountClassAssertionAxiomsMetric extends BaseMetric {

    public CountClassAssertionAxiomsMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Integer getValue() {
	return ontology.getAxiomCount(AxiomType.CLASS_ASSERTION, true);
    }

    @Override
    public String toString() {
	return "Class assertion axioms count";
    }

}
