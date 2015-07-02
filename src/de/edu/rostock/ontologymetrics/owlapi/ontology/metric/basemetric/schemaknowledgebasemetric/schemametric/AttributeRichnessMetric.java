package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.schemaknowledgebasemetric.schemametric;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLOntology;

import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountTotalClassesMetric;

/**
 * Return the average number of attributes per class.<br>
 * In the OWL 2 Structural Specification, an attribute is declared as a
 * functional data property.
 */
public class AttributeRichnessMetric extends SchemaMetric {

    public AttributeRichnessMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Float getValue() {
	// TODO how is an attribute declared? In OWL as a functional data
	// property, but other representation languages?
	float attributes = 0;
	float classes = new CountTotalClassesMetric(ontology).getValue();

	for (OWLClass cls : ontology.getClassesInSignature(true)) {
	    for (OWLDataProperty dataProperty : cls
		    .getDataPropertiesInSignature()) {
		if (dataProperty.isFunctional(ontology.getImports())) {
		    attributes = attributes + 1;
		}
	    }
	}

	// avoid a division by zero
	if (classes == 0) {
	    return 0f;
	} else {
	    return attributes / classes;
	}
    }

    @Override
    public String toString() {
	return "Attribute richness";
    }

}
