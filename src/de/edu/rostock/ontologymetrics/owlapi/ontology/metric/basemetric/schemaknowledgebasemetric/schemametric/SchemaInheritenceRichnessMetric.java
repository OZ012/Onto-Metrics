package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.schemaknowledgebasemetric.schemametric;

import org.semanticweb.owlapi.model.OWLOntology;

import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountSubClassOfAxiomsMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountTotalClassesMetric;

/**
 * Return the average number of subclasses per class.
 */
public class SchemaInheritenceRichnessMetric extends SchemaMetric {

    public SchemaInheritenceRichnessMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Object getValue() {
	float countSubClasses = new CountSubClassOfAxiomsMetric(ontology)
		.getValue();
	float countClasses = new CountTotalClassesMetric(ontology).getValue();

	// avoid a division by zero
	if (countClasses == 0) {
	    return 0;
	} else {
	    return countSubClasses / countClasses;
	}
    }

    @Override
    public String toString() {
	return "Schema inheritence richness";
    }

}
