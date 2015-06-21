package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLOntology;

public class CountFunctionalObjectPropertiesAxiomsMetric extends BaseMetric {

    public CountFunctionalObjectPropertiesAxiomsMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Integer getValue() {
	return ontology.getAxiomCount(AxiomType.FUNCTIONAL_OBJECT_PROPERTY,
		true);
    }

    @Override
    public String toString() {
	return "Functional object properties axioms count";
    }

}
