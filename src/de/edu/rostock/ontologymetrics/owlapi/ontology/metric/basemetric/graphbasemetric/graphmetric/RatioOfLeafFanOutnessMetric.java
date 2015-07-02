package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.graphbasemetric.graphmetric;

import java.util.Set;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntology;

import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountTotalClassesMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.graphbasemetric.GraphBaseLeavesMetric;

public class RatioOfLeafFanOutnessMetric extends GraphMetric {

    public RatioOfLeafFanOutnessMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Float getValue() {
	Set<OWLClass> leaves = new GraphBaseLeavesMetric(ontology).getValue();
	Integer totalClasses = new CountTotalClassesMetric(ontology).getValue();
	return (float) leaves.size() / (float) totalClasses;
    }

    @Override
    public String toString() {
	return "Ratio of leaf fan-outness";
    }
}
