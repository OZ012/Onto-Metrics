package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.schemaknowledgebasemetric.schemametric;

import org.semanticweb.owlapi.model.OWLOntology;

import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountLogicalAxiomsMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountSubClassOfAxiomsMetric;

public class SchemaRelationshipRichnessMetric extends SchemaMetric {

    public SchemaRelationshipRichnessMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Float getValue() {
	// TODO logical axioms describe all relationships (arcs) in the
	// ontology?
	float countRelationships = new CountLogicalAxiomsMetric(ontology)
		.getValue();
	float countSubClasses = new CountSubClassOfAxiomsMetric(ontology)
		.getValue();

	// avoid a division by zero
	if (countRelationships + countSubClasses == 0) {
	    return 0f;
	} else {
	    return countRelationships / (countSubClasses + countRelationships);
	}
    }

    @Override
    public String toString() {
	return "Schema relationship richness";
    }

}
