package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLOntology;

public class CountInverseObjectPropertiesAxiomsMetric extends BaseMetric {

    public CountInverseObjectPropertiesAxiomsMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Integer getValue() {
	return ontology
		.getAxiomCount(AxiomType.INVERSE_OBJECT_PROPERTIES, true);
    }

    @Override
    public String toString() {
	return "Inverse object properties axioms count";
    }

}
