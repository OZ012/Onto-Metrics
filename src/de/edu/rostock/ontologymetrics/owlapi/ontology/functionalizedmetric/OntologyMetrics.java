package de.edu.rostock.ontologymetrics.owlapi.ontology.functionalizedmetric;

import org.semanticweb.owlapi.model.OWLOntology;

/**
 * This is the interface for OntologyManager
 * 
 * @author Author: Marcel Ihlo<br>
 *         The University Of Rostock<br>
 *         Department of Information Systems
 */
public class OntologyMetrics {

    protected OWLOntology ontology;

    public OntologyMetrics(OWLOntology pOntology) {
	if (pOntology != null) {
	    ontology = pOntology;
	} else {
	    // TODO
	}
    }

    public OWLOntology getOntology() {
	return ontology;
    }

    public void setOntology(OWLOntology pOntology) {
	if (pOntology != null) {
	    ontology = pOntology;
	}
    }

    @Override
    public String toString() {
	if (this instanceof OntologyBaseMetrics) {
	    return ((OntologyBaseMetrics) this).toString();
	} else if (this instanceof OntologySchemaMetrics) {
	    return ((OntologySchemaMetrics) this).toString();
	} else if (this instanceof OntologyKnowledgebaseMetrics) {
	    return ((OntologyKnowledgebaseMetrics) this).toString();
	} else if (this instanceof OntologyClassMetrics) {
	    return ((OntologyClassMetrics) this).toString();
	} else if (this instanceof OntologyGraphMetrics) {
	    return ((OntologyGraphMetrics) this).toString();
	} else {
	    return null;
	}
    }

}
