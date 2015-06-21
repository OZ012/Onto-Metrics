package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.schemaknowledgebasemetric;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLOntology;

import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.BaseMetric;

public abstract class SchemaKnowledgeBaseMetric extends BaseMetric {

    public SchemaKnowledgeBaseMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    protected int countTotalInstancesOf(OWLClass cls) {
	int count = 0;
	if (cls != null) {
	    count = cls.getIndividuals(ontology).size();
	    for (OWLClassExpression subClass : cls.getSubClasses(ontology)) {
		count = count + countTotalInstancesOf(subClass.asOWLClass());
	    }
	}
	return count;
    }

}
