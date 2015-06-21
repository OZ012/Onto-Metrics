package de.edu.rostock.ontologymetrics.owlapi.ontology.metric;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;

public abstract class OntologyMetric {

    protected OWLOntology ontology;

    protected String label;

    public OntologyMetric(OWLOntology pOntology) {
	if (pOntology != null) {
	    ontology = pOntology;
	} else {
	    OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
	    try {
		ontology = manager.createOntology();
	    } catch (OWLOntologyCreationException e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	    }
	}
    }

    public abstract Object getValue();

    public abstract String getLabel();

    // getter $ setter

    public OWLOntology getOntology() {
	return ontology;
    }

}
