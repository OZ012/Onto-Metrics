package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.OWLOntology;

public class CountAnnotationAxiomsMetric extends BaseMetric {

    public CountAnnotationAxiomsMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Integer getValue() {
	return ontology.getAnnotations().size() - 1;
    }

    @Override
    public String toString() {
	return "Annotation axioms count";
    }

}
