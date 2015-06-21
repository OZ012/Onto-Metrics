package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.schemaknowledgebasemetric.classmetrics;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;

import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.schemaknowledgebasemetric.SchemaKnowledgeBaseMetric;

public abstract class ClassMetrics extends SchemaKnowledgeBaseMetric {

    protected IRI iri;

    public ClassMetrics(OWLOntology pOntology, IRI pIri) {
	super(pOntology);
	iri = pIri;
    }

    @Override
    public String getLabel() {
	return "Class metrics";
    }

    public IRI getIri() {
	return iri;
    }

    public void setIri(IRI pIri) {
	iri = pIri;
    }

}
