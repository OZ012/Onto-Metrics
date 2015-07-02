package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.schemaknowledgebasemetric.classmetrics;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;

import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountClassesMetric;

/**
 * Return the average number of subclasses per class in the subtree rooted at
 * the given class of IRI.
 */
public class ClassInheritenceRichnessMetric extends ClassMetrics {

    public ClassInheritenceRichnessMetric(OWLOntology pOntology, IRI pIri) {
	super(pOntology, pIri);
    }

    @Override
    public Float getValue() {
	// TODO testing
	int countClasses = new CountClassesMetric(ontology).getValue();
	int countSubClasses = new CountClassChildrenMetric(ontology, iri)
		.getValue();

	// avoid a division by zero
	if (countSubClasses == 0) {
	    return 0f;
	} else {
	    return (float) countClasses / (float) countSubClasses;
	}
    }

    @Override
    public String toString() {
	return "Class inheritence richness";
    }

}
