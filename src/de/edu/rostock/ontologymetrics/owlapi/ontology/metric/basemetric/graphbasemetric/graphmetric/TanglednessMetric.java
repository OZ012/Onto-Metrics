package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.graphbasemetric.graphmetric;

import java.util.HashSet;
import java.util.Set;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntology;

import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountTotalClassesMetric;

public class TanglednessMetric extends GraphMetric {

    public TanglednessMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Float getValue() {
	Set<OWLClass> tangledClasses = new HashSet<OWLClass>();
	for (OWLClass cls : ontology.getClassesInSignature(true)) {
	    if (cls.getSubClasses(ontology).size() > 1) {
		tangledClasses.add(cls);
	    }
	}
	return (float) new CountTotalClassesMetric(ontology).getValue()
		/ (float) tangledClasses.size();
    }

    @Override
    public String toString() {
	return "Tangledness";
    }

}
