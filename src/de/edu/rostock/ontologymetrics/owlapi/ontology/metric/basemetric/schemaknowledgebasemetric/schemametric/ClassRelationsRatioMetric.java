package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.schemaknowledgebasemetric.schemametric;

import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLOntology;

import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountSubClassOfAxiomsMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountTotalClassesMetric;

public class ClassRelationsRatioMetric extends SchemaMetric {
    public ClassRelationsRatioMetric(OWLOntology pOntology) {
	super(pOntology);
    }
    
    public Float getValue() {
    	float classes = new CountTotalClassesMetric(ontology).getValue();
    	float subClasses = new CountSubClassOfAxiomsMetric(ontology).getValue();
    	float objectPropertyCount = ontology.getObjectPropertiesInSignature(true).size() - 1;
    	float equivalentClasses = ontology.getAxiomCount(AxiomType.EQUIVALENT_CLASSES, true);
    	float disjointClasses = ontology.getAxiomCount(AxiomType.DISJOINT_CLASSES, true);
    	float classAssertion = ontology.getAxiomCount(AxiomType.CLASS_ASSERTION, true);
    	float sameIndividual = ontology.getAxiomCount(AxiomType.SAME_INDIVIDUAL, true);
    	float differentIndividual = ontology.getAxiomCount(AxiomType.DIFFERENT_INDIVIDUALS, true);
    	float relations = objectPropertyCount +  equivalentClasses + disjointClasses + classAssertion + sameIndividual + differentIndividual+subClasses;
    	if (relations==0) {
    		return 0f;
    	} else {
    		return classes/relations;
    	}    	
    }
    
    public String toString() {
	return "Class Relations Ratio";
    }
}
