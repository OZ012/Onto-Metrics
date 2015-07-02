package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.graphbasemetric.graphmetric;

import org.semanticweb.owlapi.model.OWLOntology;

import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.graphbasemetric.GraphBaseMetric;

abstract class GraphMetric extends GraphBaseMetric {

    public GraphMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Object getValue() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public String toString() {
	return "Graph metric";
    }

}
