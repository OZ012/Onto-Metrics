package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLOntology;

public class CountInverseFunctionalObjectPropertiesAxiomsMetric extends
	BaseMetric {

    public CountInverseFunctionalObjectPropertiesAxiomsMetric(
	    OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Integer getValue() {
	return ontology.getAxiomCount(
		AxiomType.INVERSE_FUNCTIONAL_OBJECT_PROPERTY, true);
    }

    @Override
    public String toString() {
	return "Inverse functional object properties axioms count";
    }

}
