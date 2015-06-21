package de.edu.rostock.ontologymetrics.owlapi.ontology.functionalizedmetric;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLOntology;

public class OntologySchemaMetricsImpl extends
	OntologySchemaKnowledgeBaseMetricsImpl implements OntologySchemaMetrics {

    public OntologySchemaMetricsImpl(OWLOntology pOntology) {
	super(pOntology);
    }

    /*
     * schema metrics
     */

    @Override
    public float getSchemaRelationshipRichness() {
	// TODO logical axioms describe all relationships (arcs) in the
	// ontology?
	float countRelationships = countLogicalAxioms();
	float countSubClasses = countSubClassOfAxioms();

	// avoid a division by zero
	if (countRelationships + countSubClasses == 0) {
	    return 0;
	} else {
	    return countRelationships / (countSubClasses + countRelationships);
	}
    }

    /**
     * Return the average number of attributes per class.<br>
     * In the OWL 2 Structural Specification, an attribute is a functional data
     * property.
     */
    @Override
    public float getAttributeRichness() {
	// TODO how is an attribute declared? In OWL2 as a functional data
	// property, but other representation languages?
	float attributes = 0;
	float classes = countTotalClasses();

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
	    return 0;
	} else {
	    return attributes / classes;
	}

    }

    /**
     * Return the average number of subclasses per class.
     */
    @Override
    public float getSchemaInheritenceRichness() {
	float countSubClasses = countSubClassOfAxioms();
	float countClasses = countTotalClasses();

	// avoid a division by zero
	if (countClasses == 0) {
	    return 0;
	} else {
	    return countSubClasses / countClasses;
	}
    }

    @Override
    public float getTreeBalance() {
	// TODO Auto-generated method stub
	return 0;
    }

    /**
     * This method print the schema metrics of this ontology to console.
     */

    @Override
    public String toString() {
	StringBuilder output = new StringBuilder();
	if (ontology != null) {
	    output.append("\nSchema Metrics\nClasses: ").append(countClasses())
		    .append("\nTotal Classes: ").append(countTotalClasses())
		    .append("\nTotal Relationships: ")
		    .append(countLogicalAxioms())
		    .append("\nRelationship Richness: ")
		    .append(getSchemaRelationshipRichness())
		    .append("\nInheritence Richness: ")
		    .append(getSchemaInheritenceRichness())
		    .append("\nTree Balance: ")
		    .append("\nAttribute Richness: ")
		    .append(getAttributeRichness()).append("\n");

	}
	return output.toString();
    }

}
