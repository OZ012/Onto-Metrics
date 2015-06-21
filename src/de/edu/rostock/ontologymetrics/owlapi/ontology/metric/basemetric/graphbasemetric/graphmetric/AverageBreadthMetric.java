package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.graphbasemetric.graphmetric;

import java.util.Set;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntology;

import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.graphbasemetric.GraphBaseLevelsMetric;

public class AverageBreadthMetric extends GraphMetric {

    public AverageBreadthMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Float getValue() {
	int breadth = 0;
	Set<Set<OWLClass>> levels = new GraphBaseLevelsMetric(ontology)
		.getValue();
	for (Set<OWLClass> path : levels) {
	    breadth = breadth + path.size();
	}
	return (float) breadth / (float) levels.size();
    }

    @Override
    public String toString() {
	return "Average depth";
    }

}
