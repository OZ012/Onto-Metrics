package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.schemaknowledgebasemetric.schemametric;

import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLOntology;

import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountTotalClassesMetric;

public class EquivalenceRatioMetric extends SchemaMetric {
	
    public EquivalenceRatioMetric(OWLOntology pOntology) {
	super(pOntology);
    }
	
	public Float getValue() {
		float classes = new CountTotalClassesMetric(ontology).getValue();
		float sameClasses = ontology.getAxiomCount(AxiomType.EQUIVALENT_CLASSES, true);
		
		if (classes==0) {
			return 0f;
		} else {
		return sameClasses/classes;
	}
	}
	
    public String toString() {
	return "Equivalence Ratio";
    }
}
