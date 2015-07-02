package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.graphbasemetric;

import java.util.HashSet;
import java.util.Set;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLOntology;

public class GraphBasePathsMetric extends GraphBaseMetric {

    public GraphBasePathsMetric(OWLOntology pOntology) {
	super(pOntology);
	// TODO Auto-generated constructor stub
    }

    @Override
    public Set<Set<OWLClass>> getValue() {
	Set<Set<OWLClass>> result = new HashSet<Set<OWLClass>>();
	Set<OWLClass> classRoots = new GraphBaseRootsMetric(ontology).getValue();

	for (OWLClass rootedClass : classRoots) {
	    Set<OWLClass> path = new HashSet<OWLClass>();
	    getPath(result, path, rootedClass);
	}

	return result;
    }

    private void getPath(Set<Set<OWLClass>> paths, Set<OWLClass> path,
	    OWLClass cls) {
	Set<OWLClass> result = path;
	if (cls != null) {
	    // class is a leaf?
	    Set<OWLClass> leaves = new GraphBaseLeavesMetric(ontology).getValue();
	    if (leaves.contains(cls)) {
		result.add(cls);
		paths.add(result);
	    } else {
		// iterate sub classes
		for (OWLClassExpression subClass : cls.getSubClasses(ontology)) {
		    // create a new instance of path
		    Set<OWLClass> nextPath = new HashSet<OWLClass>();
		    for (OWLClass node : path) {
			nextPath.add(node);
		    }
		    nextPath.add(cls);

		    // next round...
		    getPath(paths, nextPath, subClass.asOWLClass());
		}

	    }
	}
    }

    @Override
    public String toString() {
	return "Class paths";
    }

}
