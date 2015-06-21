package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLOntology;

public class CountTransitiveObjectPropertyAxiomsMetric extends BaseMetric {

    public CountTransitiveObjectPropertyAxiomsMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Integer getValue() {
	return ontology.getAxiomCount(AxiomType.TRANSITIVE_OBJECT_PROPERTY,
		true);
    }

    @Override
    public String toString() {
	return "Transitive object property axioms count";
    }

}
