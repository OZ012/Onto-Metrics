package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.schemaknowledgebasemetric.schemametric;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLDataProperty;

import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountTotalClassesMetric;

public class AttributeClassRatio extends SchemaMetric {
    public AttributeClassRatio(OWLOntology pOntology) {
	super(pOntology);
	
    }
    
    public Float getValue() {
    	float classes = new CountTotalClassesMetric(ontology).getValue();
    	float classesWithAttributes = 0;
    	
    	for (OWLClass cls : ontology.getClassesInSignature(true)) {
    		for (OWLDataProperty dataProperty : cls
    			    .getDataPropertiesInSignature()) {
    			if (dataProperty.isOWLDataProperty() ^ dataProperty.isOWLObjectProperty()) {
    				classesWithAttributes = classesWithAttributes + 1;
    			}
    			
    		}
    	}
		if (classes == 0) {
		    return 0f;
		}
    	return classesWithAttributes/classes;
}

    
    
    public String toString() {
	return "Attribute Class Ratio";
    }
	
}
