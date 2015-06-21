package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.schemaknowledgebasemetric.classmetrics;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLOntology;

import de.edu.rostock.ontologymetrics.owlapi.ontology.OntologyUtility;

public class CountClassChildrenMetric extends ClassMetrics {

    public CountClassChildrenMetric(OWLOntology pOntology, IRI pIri) {
	super(pOntology, pIri);
    }

    @Override
    public Integer getValue() {
	// TODO testing
	int subClasses = 0;

	OWLClass cls = OntologyUtility.getClass(ontology, iri);

	if (cls != null) {
	    subClasses = cls.getSubClasses(ontology).size();
	    if (subClasses > 0) {
		for (OWLClassExpression subClass : cls.getSubClasses(ontology)) {
		    subClasses = subClasses
			    + new CountClassChildrenMetric(ontology, subClass
				    .asOWLClass().getIRI()).getValue();
		}
	    }
	}

	return subClasses;
    }

    @Override
    public String toString() {
	return "Class children count";
    }

}
