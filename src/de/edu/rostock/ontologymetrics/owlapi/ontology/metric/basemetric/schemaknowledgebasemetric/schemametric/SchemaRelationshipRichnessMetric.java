package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.schemaknowledgebasemetric.schemametric;

import org.semanticweb.owlapi.model.AxiomType;
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
	float inheritedRelationships = new CountSubClassOfAxiomsMetric(ontology)
		.getValue();
	float objectPropertyCount = ontology.getObjectPropertiesInSignature(true).size() - 1;
	float equivalentClasses = ontology.getAxiomCount(AxiomType.EQUIVALENT_CLASSES, true);
	float disjointClasses = ontology.getAxiomCount(AxiomType.DISJOINT_CLASSES, true);
	float classAssertion = ontology.getAxiomCount(AxiomType.CLASS_ASSERTION, true);
	float sameIndividual = ontology.getAxiomCount(AxiomType.SAME_INDIVIDUAL, true);
	float differentIndividual = ontology.getAxiomCount(AxiomType.DIFFERENT_INDIVIDUALS, true);
	float nonInheritedRelationships = objectPropertyCount +  equivalentClasses + disjointClasses + classAssertion + sameIndividual + differentIndividual;

	// avoid a division by zero
	if (nonInheritedRelationships + inheritedRelationships == 0) {
	    return 0f;
	} else {
	    return nonInheritedRelationships / (nonInheritedRelationships + inheritedRelationships);
	}
    }

    @Override
    public String toString() {
	return "Schema relationship richness";
    }

}
