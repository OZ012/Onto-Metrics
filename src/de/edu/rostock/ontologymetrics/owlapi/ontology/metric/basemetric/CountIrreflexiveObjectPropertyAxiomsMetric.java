package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLOntology;

public class CountIrreflexiveObjectPropertyAxiomsMetric extends BaseMetric {

    public CountIrreflexiveObjectPropertyAxiomsMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Integer getValue() {
	return ontology.getAxiomCount(AxiomType.IRREFLEXIVE_OBJECT_PROPERTY,
		true);
    }

    @Override
    public String toString() {
	return "Irreflexive object property axioms count";
    }

}
