package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.schemaknowledgebasemetric.classmetrics;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntology;

import de.edu.rostock.ontologymetrics.owlapi.ontology.OntologyUtility;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountTotalIndividualsMetric;

public class ClassImportanceMetric extends ClassMetrics {

    public ClassImportanceMetric(OWLOntology pOntology, IRI iri) {
	super(pOntology, iri);
    }

    @Override
    public Float getValue() {
	int countTotalInstances = new CountTotalIndividualsMetric(ontology)
		.getValue();
	OWLClass cls = OntologyUtility.getClass(ontology, iri);
	int countInstances = countTotalInstancesOf(cls);

	// avoid a division by zero
	if (countTotalInstances == 0) {
	    return 0f;
	} else {
	    return (float) countInstances / (float) countTotalInstances;
	}
    }

    @Override
    public String toString() {
	return "Class importance";
    }

}
