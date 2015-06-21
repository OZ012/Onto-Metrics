package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.schemaknowledgebasemetric.classmetrics;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLOntology;

import de.edu.rostock.ontologymetrics.owlapi.ontology.OntologyUtility;

public class CountClassInstancesMetric extends ClassMetrics {

    public CountClassInstancesMetric(OWLOntology pOntology, IRI pIri) {
	super(pOntology, pIri);
    }

    @Override
    public Integer getValue() {
	int instances = 0;

	OWLClass cls = OntologyUtility.getClass(ontology, iri);

	if (cls != null) {
	    instances = cls.getIndividuals(ontology).size();
	    if (!cls.getSubClasses(ontology).isEmpty()) {
		for (OWLClassExpression subClass : cls.getSubClasses(ontology)) {
		    instances = instances
			    + new CountClassInstancesMetric(ontology, subClass
				    .asOWLClass().getIRI()).getValue();
		}
	    }
	}

	return instances;
    }

    @Override
    public String toString() {
	return "Class instances count";
    }

}
