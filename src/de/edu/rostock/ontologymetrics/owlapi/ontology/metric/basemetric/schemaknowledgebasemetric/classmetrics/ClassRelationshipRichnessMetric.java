package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.schemaknowledgebasemetric.classmetrics;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;

public class ClassRelationshipRichnessMetric extends ClassMetrics {

    public ClassRelationshipRichnessMetric(OWLOntology pOntology, IRI pIri) {
	super(pOntology, pIri);
    }

    @Override
    public Float getValue() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public String toString() {
	return "Class relationship richness";
    }

}
