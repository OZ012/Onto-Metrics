package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLOntology;

public class CountAnnotationPropertyRangeAxiomsMetric extends BaseMetric {

    public CountAnnotationPropertyRangeAxiomsMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Integer getValue() {
	return ontology
		.getAxiomCount(AxiomType.ANNOTATION_PROPERTY_RANGE, true);
    }

    @Override
    public String toString() {
	return "Annotation property range axioms count";
    }

    @Override
    public String getLabel() {
	return "Annotation axioms";
    }

}
