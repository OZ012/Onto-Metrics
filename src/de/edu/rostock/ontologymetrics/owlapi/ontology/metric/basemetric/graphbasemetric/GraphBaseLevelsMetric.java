package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.graphbasemetric;

import java.util.HashSet;
import java.util.Set;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLOntology;

public class GraphBaseLevelsMetric extends GraphBaseMetric {

    public GraphBaseLevelsMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Set<Set<OWLClass>> getValue() {
	Set<Set<OWLClass>> levels = new HashSet<Set<OWLClass>>();
	Set<OWLClass> classRoots = new GraphBaseRootsMetric(ontology)
		.getValue();
	levels.add(classRoots);
	getLevel(levels, classRoots);
	return levels;
    }

    private void getLevel(Set<Set<OWLClass>> levels, Set<OWLClass> classes) {
	Set<OWLClass> level = new HashSet<OWLClass>();
	for (OWLClass owlClass : classes) {
	    for (OWLClassExpression subClass : owlClass.getSubClasses(ontology)) {
		level.add(subClass.asOWLClass());
	    }
	}
	if (!level.isEmpty()) {
	    levels.add(level);
	    getLevel(levels, level);
	}
    }

    @Override
    public String toString() {
	return "Class levels";
    }

}
