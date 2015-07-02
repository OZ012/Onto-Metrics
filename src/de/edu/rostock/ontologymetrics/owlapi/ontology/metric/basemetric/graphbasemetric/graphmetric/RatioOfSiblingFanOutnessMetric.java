package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.graphbasemetric.graphmetric;

import java.util.Set;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntology;

import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountTotalClassesMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.graphbasemetric.GraphBaseSiblingsMetric;

public class RatioOfSiblingFanOutnessMetric extends GraphMetric {

    public RatioOfSiblingFanOutnessMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Float getValue() {
	int countSiblings = 0;
	Set<Set<OWLClass>> siblings = new GraphBaseSiblingsMetric(ontology)
		.getValue();
	Integer totalClasses = new CountTotalClassesMetric(ontology).getValue();
	for (Set<OWLClass> sibling : siblings) {
	    countSiblings = countSiblings + sibling.size();
	}
	return 1 - ((float) countSiblings / (float) totalClasses);
    }

    @Override
    public String toString() {
	return "Ratio of sibling fan-outness";
    }

}
