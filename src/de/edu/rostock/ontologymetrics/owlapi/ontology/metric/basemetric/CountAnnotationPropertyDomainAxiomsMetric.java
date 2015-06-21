package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLOntology;

public class CountAnnotationPropertyDomainAxiomsMetric extends BaseMetric {

    public CountAnnotationPropertyDomainAxiomsMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Integer getValue() {
	return ontology.getAxiomCount(AxiomType.ANNOTATION_PROPERTY_DOMAIN,
		true);
    }

    @Override
    public String toString() {
	return "Annotation property domain axioms count";
    }

    @Override
    public String getLabel() {
	return "Annotation axioms";
    }

}
