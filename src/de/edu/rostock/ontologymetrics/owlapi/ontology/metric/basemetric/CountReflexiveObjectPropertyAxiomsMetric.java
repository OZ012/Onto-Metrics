package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLOntology;

public class CountReflexiveObjectPropertyAxiomsMetric extends BaseMetric {

    public CountReflexiveObjectPropertyAxiomsMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Integer getValue() {
	return ontology
		.getAxiomCount(AxiomType.REFLEXIVE_OBJECT_PROPERTY, true);
    }

    @Override
    public String toString() {
	return "Reflexive object property axioms count";
    }

}
