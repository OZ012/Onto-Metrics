package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLOntology;

public class CountDisjointObjectPropertiesAxiomsMetric extends BaseMetric {

    public CountDisjointObjectPropertiesAxiomsMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Integer getValue() {
	return ontology.getAxiomCount(AxiomType.DISJOINT_OBJECT_PROPERTIES,
		true);
    }

    @Override
    public String toString() {
	return "Disjoint object properties axioms count";
    }

}
