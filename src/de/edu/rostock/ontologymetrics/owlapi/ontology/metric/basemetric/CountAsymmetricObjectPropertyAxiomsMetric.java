package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLOntology;

public class CountAsymmetricObjectPropertyAxiomsMetric extends BaseMetric {

    public CountAsymmetricObjectPropertyAxiomsMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Integer getValue() {
	return ontology.getAxiomCount(AxiomType.ASYMMETRIC_OBJECT_PROPERTY,
		true);
    }

    @Override
    public String toString() {
	return "Asymmetric object property axioms count";
    }

}
