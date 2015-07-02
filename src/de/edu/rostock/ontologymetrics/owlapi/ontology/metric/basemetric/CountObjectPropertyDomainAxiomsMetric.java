package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLOntology;

public class CountObjectPropertyDomainAxiomsMetric extends BaseMetric {

    public CountObjectPropertyDomainAxiomsMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Integer getValue() {
	return ontology.getAxiomCount(AxiomType.OBJECT_PROPERTY_DOMAIN, true);
    }

    @Override
    public String toString() {
	return "Object property domain axioms count";
    }

}
