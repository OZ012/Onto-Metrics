package de.edu.rostock.ontologymetrics.owlapi.ontology;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;
//import org.apache.log4j.Logger;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

public class OntologyMetricManagerImpl implements OntologyMetricManager {

    // ALL | DEBUG | INFO | WARN | ERROR | FATAL | OFF:
    private Logger logger = Logger.getLogger(this.getClass());

    protected OWLOntologyManager manager;

    protected OntologyMetrics metrics;

    public OntologyMetricManagerImpl() {
	manager = OWLManager.createOWLOntologyManager();
	metrics = new OntologyMetricsImpl(null);
    }

    /**
     * 
     */
    public OWLOntology loadOntologyFromIRI(IRI pIRI)
	    throws OWLOntologyCreationException {
	OWLOntology ontology = null;
	if (pIRI != null) {
	    ontology = manager.loadOntologyFromOntologyDocument(pIRI);
	    metrics.setOntology(ontology);
	    metrics.setIRI(null);
	}
	logger.info("load ontology successfully done");
	return ontology;
    }

    /**
     * 
     */
    public OWLOntology loadOntologyFromFile(File file)
	    throws OWLOntologyCreationException {
	// TODO
	OWLOntology ontology = null;
	if (file != null) {
	    ontology = manager.loadOntologyFromOntologyDocument(file);
	    metrics.setOntology(ontology);
	    // logger.info("load ontology successfully done");
	}
	return ontology;
    }

    public OWLOntology loadOntologyFromText(String text) throws IOException,
	    OWLOntologyCreationException {
	// TODO file need a specified path
	// initialize
	File file = new File(File.separator + "tmp.rdf");
	FileWriter writer = new FileWriter(file, false);

	writer.write(text);
	writer.flush();
	writer.close();
	file.createNewFile();

	return loadOntologyFromFile(file);
    }

    public void saveOntologyToFile(File file)
	    throws OWLOntologyStorageException {
	// TODO
	manager.saveOntology(null, IRI.create(file));
    }

    // getter $ setter

    public OWLOntology getOntology() {
	return metrics.getOntology();
    }

    public OntologyMetrics getMetrics() {
	return metrics;
    }

    public String getNamespace() {
	if (metrics.getIRI() != null) {
	    return metrics.getIRI().getNamespace();
	} else {
	    return null;
	}
    }

}
