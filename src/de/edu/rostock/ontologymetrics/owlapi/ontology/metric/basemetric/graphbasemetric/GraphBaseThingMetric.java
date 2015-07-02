package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.graphbasemetric;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntology;

public class GraphBaseThingMetric extends GraphBaseMetric {

    public GraphBaseThingMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public OWLClass getValue() {
	OWLClass result = null;
	for (OWLClass cls : ontology.getClassesInSignature()) {
	    if (cls.isOWLThing()) {
		result = cls;
		break;
	    }
	}

	return result;
    }

    @Override
    public String toString() {
	return "Class thing";
    }

}
