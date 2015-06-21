package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLOntology;

public class CountFunctionalDataPropertyAxiomsMetric extends BaseMetric {

    public CountFunctionalDataPropertyAxiomsMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Integer getValue() {
	return ontology.getAxiomCount(AxiomType.FUNCTIONAL_DATA_PROPERTY, true);
    }

    @Override
    public String toString() {
	return "Functional data property axioms count";
    }

}
