package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.schemaknowledgebasemetric.classmetrics;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;

import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.schemaknowledgebasemetric.knowledgebasemetric.AveragePopulationMetric;

/**
 * Return the actual number of instances that belong to the subtree rooted at
 * <code>cls</code> divided by the expected number of instances that belong to
 * the subtree rooted at
 */
public class ClassFulnessMetric extends ClassMetrics {

    public ClassFulnessMetric(OWLOntology pOntology, IRI pIri) {
	super(pOntology, pIri);
    }

    @Override
    public Float getValue() {
	// TODO testing
	int numberOfSubClasses = new CountClassChildrenMetric(ontology, iri)
		.getValue();

	// avoid a division by zero
	int classInstances = new CountClassInstancesMetric(ontology, iri)
		.getValue();
	float actualNumberOfInstances = (float) classInstances
		/ (float) numberOfSubClasses;
	float expectedNumberOfInstances = new AveragePopulationMetric(ontology)
		.getValue();

	// avoid a division by zero
	if (expectedNumberOfInstances == 0f) {
	    return 0f;
	} else {
	    return actualNumberOfInstances / expectedNumberOfInstances;
	}
    }

    @Override
    public String toString() {
	return "Class fulness";
    }

}
