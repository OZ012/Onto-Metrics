package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLOntology;

public class CountDataPropertyDomainAxiomsMetric extends BaseMetric {

    public CountDataPropertyDomainAxiomsMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Integer getValue() {
	return ontology.getAxiomCount(AxiomType.DATA_PROPERTY_DOMAIN, true);
    }

    @Override
    public String toString() {
	return "Data property domain axioms count";
    }

}
