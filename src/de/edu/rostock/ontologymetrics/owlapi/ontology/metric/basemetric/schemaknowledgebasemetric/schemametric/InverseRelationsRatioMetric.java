package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.schemaknowledgebasemetric.schemametric;

import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLOntology;

public class InverseRelationsRatioMetric extends SchemaMetric {
	
	
	public InverseRelationsRatioMetric(OWLOntology pOntology) {
		super(pOntology);
	    }
		
	    public Float getValue() {
	    	float objectpropertycount = ontology.getObjectPropertiesInSignature(true).size() - 1;
	    	float inverseobjectproperties = ontology.getAxiomCount(AxiomType.INVERSE_OBJECT_PROPERTIES, true);
	    	float inversefunctionalproperties = ontology.getAxiomCount(AxiomType.INVERSE_FUNCTIONAL_OBJECT_PROPERTY, true);
	    	float functionaldatapropertycount = ontology.getAxiomCount(AxiomType.FUNCTIONAL_DATA_PROPERTY, true);
	    	if (objectpropertycount+functionaldatapropertycount==0) {
	    		return 0f;	    		
	    	} else {
	    	return (inverseobjectproperties+inversefunctionalproperties)/(objectpropertycount+functionaldatapropertycount);
	    	}
	    }
	
    public String toString() {
	return "Inverse Relations Ratio";
    }
}
