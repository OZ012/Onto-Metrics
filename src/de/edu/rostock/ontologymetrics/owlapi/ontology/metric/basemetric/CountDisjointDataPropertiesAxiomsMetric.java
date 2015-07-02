package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLOntology;

public class CountDisjointDataPropertiesAxiomsMetric extends BaseMetric {

    public CountDisjointDataPropertiesAxiomsMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Integer getValue() {
	return ontology.getAxiomCount(AxiomType.DISJOINT_DATA_PROPERTIES, true);
    }

    @Override
    public String toString() {
	return "Disjoint data properties axioms count";
    }

}
