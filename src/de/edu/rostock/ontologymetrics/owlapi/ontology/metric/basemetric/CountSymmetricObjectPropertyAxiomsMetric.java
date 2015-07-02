package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLOntology;

public class CountSymmetricObjectPropertyAxiomsMetric extends BaseMetric {

    public CountSymmetricObjectPropertyAxiomsMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Integer getValue() {
	return ontology
		.getAxiomCount(AxiomType.SYMMETRIC_OBJECT_PROPERTY, true);
    }

    @Override
    public String toString() {
	return "Symmetric object property axioms count";
    }

}
