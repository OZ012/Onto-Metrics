package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.graphbasemetric.graphmetric;

import java.util.Set;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntology;

import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.graphbasemetric.GraphBasePathsMetric;

public class AverageDepthMetric extends GraphMetric {

    public AverageDepthMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Float getValue() {
	int depth = 0;
	Set<Set<OWLClass>> paths = new GraphBasePathsMetric(ontology)
		.getValue();
	for (Set<OWLClass> path : paths) {
	    depth = depth + path.size();
	}
	return (float) depth / (float) paths.size();
    }

    @Override
    public String toString() {
	return "Average breadth";
    }

}
