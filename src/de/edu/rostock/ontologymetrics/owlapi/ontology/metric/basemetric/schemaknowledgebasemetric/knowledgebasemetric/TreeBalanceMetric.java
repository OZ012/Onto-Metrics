package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.schemaknowledgebasemetric.knowledgebasemetric;

import org.semanticweb.owlapi.model.OWLOntology;

public class TreeBalanceMetric extends KnowledgebaseMetric {

    public TreeBalanceMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Object getValue() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public String toString() {
	return "Tree balance";
    }

}
