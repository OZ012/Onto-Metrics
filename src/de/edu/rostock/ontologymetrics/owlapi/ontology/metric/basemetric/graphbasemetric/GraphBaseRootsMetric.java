package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.graphbasemetric;

import java.util.HashSet;
import java.util.Set;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntology;

public class GraphBaseRootsMetric extends GraphBaseMetric {

    public GraphBaseRootsMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Set<OWLClass> getValue() {
	Set<OWLClass> result = new HashSet<OWLClass>();
	for (OWLClass owlClass : ontology.getClassesInSignature(true)) {
	    if (owlClass.getSuperClasses(ontology).isEmpty()
		    && !owlClass.isOWLThing()) {
		result.add(owlClass);
	    }
	}
	return result;
    }

    @Override
    public String toString() {
	return "Class roots";
    }

}
