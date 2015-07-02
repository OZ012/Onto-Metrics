package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.graphbasemetric;

import java.util.HashSet;
import java.util.Set;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLOntology;

public class GraphBaseSiblingsMetric extends GraphBaseMetric {

    public GraphBaseSiblingsMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Set<Set<OWLClass>> getValue() {
	Set<OWLClass> rootedNodes = new GraphBaseRootsMetric(ontology).getValue();
	Set<Set<OWLClass>> result = new HashSet<Set<OWLClass>>();

	result.add(rootedNodes);
	getSibling(result, rootedNodes);

	return result;
    }

    private void getSibling(Set<Set<OWLClass>> siblings, Set<OWLClass> classes) {
	// iterate root classes
	for (OWLClass cls : classes) {
	    Set<OWLClass> subClasses = new HashSet<OWLClass>();

	    // convert class expressions to classes
	    for (OWLClassExpression subClass : cls.getSubClasses(ontology)) {
		subClasses.add(subClass.asOWLClass());
	    }
	    // only one sub class has no siblings but can be a parent of
	    // siblings
	    if (subClasses.size() > 1) {
		siblings.add(subClasses);
	    }
	    if (subClasses.size() > 0) {
		getSibling(siblings, subClasses);
	    }
	}
    }

    @Override
    public String toString() {
	return "Class siblings";
    }

}
