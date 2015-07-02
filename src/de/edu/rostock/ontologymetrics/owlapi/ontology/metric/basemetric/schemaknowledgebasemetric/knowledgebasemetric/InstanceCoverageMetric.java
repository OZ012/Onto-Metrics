package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.schemaknowledgebasemetric.knowledgebasemetric;

import org.semanticweb.owlapi.model.OWLOntology;

public class InstanceCoverageMetric extends KnowledgebaseMetric {

    public InstanceCoverageMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Object getValue() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public String toString() {
	return "Instance coverage";
    }

}
