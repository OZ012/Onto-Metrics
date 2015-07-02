package de.edu.rostock.ontologymetrics.owlapi.ontology;

import java.io.File;
import java.io.IOException;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

public interface OntologyMetricManager {

    public OWLOntology loadOntologyFromIRI(IRI pIRI)
	    throws OWLOntologyCreationException;

    public OWLOntology loadOntologyFromFile(File file)
	    throws OWLOntologyCreationException;

    public OWLOntology loadOntologyFromText(String text) throws IOException,
	    OWLOntologyCreationException;

    public void saveOntologyToFile(File file)
	    throws OWLOntologyStorageException;

    public OWLOntology getOntology();

    public OntologyMetrics getMetrics();

    public String getNamespace();

}
