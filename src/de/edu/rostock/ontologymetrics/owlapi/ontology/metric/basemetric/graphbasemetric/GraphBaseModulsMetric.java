package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.graphbasemetric;

import java.util.Set;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntology;

public class GraphBaseModulsMetric extends GraphBaseMetric {

    public GraphBaseModulsMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Set<Set<OWLClass>> getValue() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public String toString() {
	return "Class moduls";
    }

}
