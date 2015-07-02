package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLOntology;

public class CountEquivalentObjectPropertiesAxiomsMetric extends BaseMetric {

    public CountEquivalentObjectPropertiesAxiomsMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Integer getValue() {
	return ontology.getAxiomCount(AxiomType.EQUIVALENT_OBJECT_PROPERTIES,
		true);
    }

    @Override
    public String toString() {
	return "Equivalent object properties axioms count";
    }

}
