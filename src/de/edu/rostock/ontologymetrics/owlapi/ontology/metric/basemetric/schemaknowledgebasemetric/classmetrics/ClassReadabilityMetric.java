package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.schemaknowledgebasemetric.classmetrics;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntology;

import de.edu.rostock.ontologymetrics.owlapi.ontology.OntologyUtility;

/**
 * Return the sum of the number attributes that are comments and the number of
 * attributes that are labels of the given class.
 */
public class ClassReadabilityMetric extends ClassMetrics {

    public ClassReadabilityMetric(OWLOntology pOntology, IRI pIri) {
	super(pOntology, pIri);
    }

    @Override
    public Integer getValue() {
	OWLClass cls = OntologyUtility.getClass(ontology, iri);
	int countAnnotations = 0;

	if (cls != null) {
	    for (OWLAnnotation annotation : cls.getAnnotations(ontology)) {
		if (annotation.getProperty().isLabel()
			|| annotation.getProperty().isComment()) {
		    countAnnotations++;
		}
	    }
	}

	return countAnnotations;
    }

    @Override
    public String toString() {
	return "Class readability";
    }

}
