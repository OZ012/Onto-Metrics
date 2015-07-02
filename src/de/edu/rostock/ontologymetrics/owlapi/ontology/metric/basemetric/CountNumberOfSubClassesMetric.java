package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.OWLOntology;

public class CountNumberOfSubClassesMetric extends BaseMetric {

    public CountNumberOfSubClassesMetric(OWLOntology pOntology) {
	super(pOntology);
	// TODO Auto-generated constructor stub
    }

    @Override
    public Integer getValue() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public String toString() {
	return "Number of subclasses";
    }

}
