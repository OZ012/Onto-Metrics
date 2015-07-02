package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLOntology;

public class CountDisjointClassesAxiomsMetric extends BaseMetric {

    public CountDisjointClassesAxiomsMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Integer getValue() {
	return ontology.getAxiomCount(AxiomType.DISJOINT_CLASSES, true);
    }

    @Override
    public String toString() {
	return "Disjoint classes axioms count";
    }

}
