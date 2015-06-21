package de.edu.rostock.ontologymetrics.owlapi.ontology.functionalizedmetric;

import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLOntology;

public class OntologyBaseMetricsImpl extends OntologyMetrics implements
	OntologyBaseMetrics {

    public OntologyBaseMetricsImpl(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public String toString() {
	StringBuilder output = new StringBuilder();
	output.append("\nBase Metrics\nAxioms: ").append(countAxioms())
		.append("\nLogical axiom count: ").append(countLogicalAxioms())
		.append("\nClass count: ").append(countClasses())
		.append("\nTotal class count: ").append(countTotalClasses())
		.append("\nObject property count: ")
		.append(countObjectProperties())
		.append("\nTotal object property count: ")
		.append(countTotalObjectProperties())
		.append("\nData property count: ")
		.append(countDataProperties())
		.append("\nTotal data property count: ")
		.append(countTotalDataProperties())
		.append("\nIndividual count: ").append(countIndividuals())
		.append("\nTotal individual count: ")
		.append(countTotalIndividuals()).append("\nDL expressivity: ")
		.append(getDlExpressivity()).append("\n\nClass axioms")
		.append("\nSubClassOf axioms count: ")
		.append(countSubClassOfAxioms())
		.append("\nEquivalentClasses axioms count: ")
		.append(countEquivalentClassesAxioms())
		.append("\nDisjointClasses axioms count: ")
		.append(countDisjointClassesAxioms()).append("\nGCI count: ")
		.append(countGCI()).append("\nHidden GCI count: ")
		.append(countHiddenGCI()).append("\n\nObject property axioms")
		.append("\nSubObjectPropertyOf axioms count: ")
		.append(countSubObjectPropertyOfAxioms())
		.append("\nEquivalentObjectProperties axioms count: ")
		.append(countEquivalentObjectPropertiesAxioms())
		.append("\nInverseObjectProperties axioms count: ")
		.append(countInverseObjectPropertiesAxioms())
		.append("\nDisjointObjectProperties axioms count: ")
		.append(countDisjointObjectPropertiesAxioms())
		.append("\nFunctionalObjectProperty axioms count: ")
		.append(countFunctionalObjectPropertiesAxioms())
		.append("\nInverseFunctionalObjectProperty axioms count: ")
		.append(countInverseFunctionalObjectPropertyAxioms())
		.append("\nTransitiveObjectProperty axioms count: ")
		.append(countTransitiveObjectPropertyAxioms())
		.append("\nSymmetricObjectProperty axioms count: ")
		.append(countSymmetricObjectPropertyAxioms())
		.append("\nAsymmetricObjectProperty axioms count: ")
		.append(countAsymmetricObjectPropertyAxioms())
		.append("\nReflexiveObjectProperty axioms count: ")
		.append(countReflexiveObjectPropertyAxioms())
		.append("\nIrrefexiveObjectProperty axioms count: ")
		.append(countIrrefexiveObjectPropertyAxioms())
		.append("\nObjectPropertyDomain axioms count: ")
		.append(countObjectPropertyDomainAxioms())
		.append("\nObjectPropertyRange axioms count: ")
		.append(countObjectPropertyRangeAxioms())
		.append("\nSubPropertyChainOf axioms count: ")
		.append(countSubPropertyChainOfAxioms())
		.append("\n\nData property axioms")
		.append("\nSubDataPropertyOf axioms count: ")
		.append(countSubDataPropertyOfAxioms())
		.append("\nEquivalentDataProperties axioms count: ")
		.append(countEquivalentDataPropertiesAxioms())
		.append("\nDisjointDataProperties axioms count: ")
		.append(countDisjointDataPropertiesAxioms())
		.append("\nFunctionalDataProperty axioms count: ")
		.append(countFunctionalDataPropertyAxioms())
		.append("\nDataPropertyDomain axioms count: ")
		.append(countDataPropertyDomainAxioms())
		.append("\nDataPropertyRange axioms count: ")
		.append(countDataPropertyRangeAxioms())
		.append("\n\nIndividual axioms")
		.append("\nClassAssertion axioms count: ")
		.append(countClassAssertionAxioms())
		.append("\nObjectPropertyAssertion axioms count: ")
		.append(countObjectPropertyAssertionAxioms())
		.append("\nDataPropertyAssertion axioms count: ")
		.append(countDataPropertyAssertionAxioms())
		.append("\nNegativeObjectPropertyAssertion axioms count: ")
		.append(countNegativeObjectPropertyAssertionAxioms())
		.append("\nNegativeDataPropertyAssertion axioms count: ")
		.append(countNegativeDataPropertyAssertionAxioms())
		.append("\nSameIndividual axioms count: ")
		.append(countSameIndividualsAxioms())
		.append("\nDifferentIndividuals axioms count: ")
		.append(countDifferentIndividualsAxioms())
		.append("\n\nAnnotation axioms")
		.append("\nAnnotationAssertion axioms count: ")
		.append(countAnnotionAssertionAxioms())
		.append("\nAnnotationPropertyDomain axioms count: ")
		.append(countAnnotationPropertyDomainAxioms())
		.append("\nAnnotationPropertyRangeOf axioms count: ")
		.append(countAnnotationPropertyRangeOfAxioms()).append("\n");

	return output.toString();
    }

    /**
     * Return the number of instances that belong to the subtree rooted at
     * <code>cls</code>.
     * 
     * @param cls
     * @return The number of instances that belong to the subtree rooted at
     *         <code>cls</code>.
     */
    public int getNumberOfInstances(OWLClass cls) {
	int instances = 0;

	if (cls != null) {
	    instances = cls.getIndividuals(ontology).size();
	    if (!cls.getSubClasses(ontology).isEmpty()) {
		for (OWLClassExpression subClass : cls.getSubClasses(ontology)) {
		    instances = instances
			    + getNumberOfInstances(subClass.asOWLClass());
		}
	    }
	}

	return instances;

    }

    /**
     * Return the number of subclasses in the subtree rooted at <code>cls</code>
     * .
     * 
     * @param cls
     * @return
     */
    public int getNumberOfSubClasses(OWLClass cls) {
	// TODO testing
	int subClasses = 0;

	if (cls != null) {
	    subClasses = cls.getSubClasses(ontology).size();
	    if (subClasses > 0) {
		for (OWLClassExpression subClass : cls.getSubClasses(ontology)) {
		    subClasses = subClasses
			    + getNumberOfSubClasses(subClass.asOWLClass());
		}
	    }
	}

	return subClasses;
    }

    public int getNumberOfClasses(OWLClass cls) {
	// TODO testing
	int countClasses = 0;

	if (cls != null) {
	    countClasses++;
	    if (!cls.getSubClasses(ontology).isEmpty()) {
		for (OWLClassExpression subClass : cls.getSubClasses(ontology
			.getImportsClosure())) {
		    countClasses = countClasses
			    + getNumberOfClasses(subClass.asOWLClass());
		}
	    }
	}

	return countClasses;
    }

    /*
     * ontology metrics
     */
    @Override
    public int countAxioms() {
	int count = 0;
	for (OWLOntology owlOntology : ontology.getImportsClosure()) {
	    count = count + owlOntology.getAxiomCount();
	}
	return count;
    }

    @Override
    public int countLogicalAxioms() {
	int count = 0;
	for (OWLOntology owlOntology : ontology.getImportsClosure()) {
	    count = count + owlOntology.getLogicalAxiomCount();
	}
	return count;
    }

    @Override
    public int countClasses() {
	// the owl:Thing is no needed class, so -1
	return ontology.getClassesInSignature().size() - 1;
    }

    @Override
    public int countTotalClasses() {
	// the owl:Thing is no needed class, so -1
	return ontology.getClassesInSignature(true).size() - 1;
    }

    @Override
    public int countObjectProperties() {
	// the owl:ObjectProperty is no needed class, so -1
	return ontology.getObjectPropertiesInSignature().size() - 1;
    }

    @Override
    public int countTotalObjectProperties() {
	// the owl:TopObjectProperty is no needed class, so -1
	return ontology.getObjectPropertiesInSignature(true).size() - 1;
    }

    @Override
    public int countDataProperties() {
	// the owl:TopDataProperty is no needed class, so -1
	return ontology.getDataPropertiesInSignature().size() - 1;
    }

    @Override
    public int countTotalDataProperties() {
	// the owl:TopDataProperty is no needed class, so -1
	return ontology.getDataPropertiesInSignature(true).size() - 1;
    }

    @Override
    public int countIndividuals() {
	return ontology.getIndividualsInSignature().size();
    }

    @Override
    public int countTotalIndividuals() {
	return ontology.getIndividualsInSignature(true).size();
    }

    @Override
    public int countInstances() {
	return ontology.getIndividualsInSignature().size();
    }

    @Override
    public int countTotalInstances() {
	return ontology.getIndividualsInSignature(true).size();
    }

    @Override
    public int countAnnotationAxioms() {
	return ontology.getAnnotations().size();
    }

    @Override
    public String getDlExpressivity() {
	// TODO Auto-generated method stub
	return null;
    }

    /*
     * classes
     */
    @Override
    public int countSubClassOfAxioms() {
	return ontology.getAxiomCount(AxiomType.SUBCLASS_OF, true);
    }

    @Override
    public int countEquivalentClassesAxioms() {
	return ontology.getAxiomCount(AxiomType.EQUIVALENT_CLASSES, true);
    }

    @Override
    public int countDisjointClassesAxioms() {
	return ontology.getAxiomCount(AxiomType.DISJOINT_CLASSES, true);
    }

    @Override
    public int countGCI() {
	// TODO
	return 0;
    }

    @Override
    public int countHiddenGCI() {
	// TODO
	return 0;
    }

    /*
     * data property
     */
    @Override
    public int countSubDataPropertyOfAxioms() {
	return ontology.getAxiomCount(AxiomType.SUB_DATA_PROPERTY, true);
    }

    @Override
    public int countEquivalentDataPropertiesAxioms() {
	return ontology.getAxiomCount(AxiomType.EQUIVALENT_DATA_PROPERTIES,
		true);
    }

    @Override
    public int countDisjointDataPropertiesAxioms() {
	return ontology.getAxiomCount(AxiomType.DISJOINT_DATA_PROPERTIES, true);
    }

    @Override
    public int countDataPropertyDomainAxioms() {
	return ontology.getAxiomCount(AxiomType.DATA_PROPERTY_DOMAIN, true);
    }

    @Override
    public int countDataPropertyRangeAxioms() {
	return ontology.getAxiomCount(AxiomType.DATA_PROPERTY_RANGE, true);
    }

    @Override
    public int countFunctionalDataPropertyAxioms() {
	return ontology.getAxiomCount(AxiomType.FUNCTIONAL_DATA_PROPERTY, true);
    }

    // individuals
    @Override
    public int countClassAssertionAxioms() {
	return ontology.getAxiomCount(AxiomType.CLASS_ASSERTION, true);
    }

    @Override
    public int countObjectPropertyAssertionAxioms() {
	return ontology
		.getAxiomCount(AxiomType.OBJECT_PROPERTY_ASSERTION, true);
    }

    @Override
    public int countDataPropertyAssertionAxioms() {
	return ontology.getAxiomCount(AxiomType.DATA_PROPERTY_ASSERTION, true);
    }

    @Override
    public int countNegativeObjectPropertyAssertionAxioms() {
	return ontology.getAxiomCount(
		AxiomType.NEGATIVE_OBJECT_PROPERTY_ASSERTION, true);
    }

    @Override
    public int countNegativeDataPropertyAssertionAxioms() {
	return ontology.getAxiomCount(
		AxiomType.NEGATIVE_DATA_PROPERTY_ASSERTION, true);
    }

    @Override
    public int countDifferentIndividualsAxioms() {
	return ontology.getAxiomCount(AxiomType.DIFFERENT_INDIVIDUALS, true);
    }

    @Override
    public int countSameIndividualsAxioms() {
	return ontology.getAxiomCount(AxiomType.SAME_INDIVIDUAL, true);
    }

    /*
     * object property
     */
    @Override
    public int countSubObjectPropertyOfAxioms() {
	return ontology.getAxiomCount(AxiomType.SUB_OBJECT_PROPERTY, true);
    }

    @Override
    public int countEquivalentObjectPropertiesAxioms() {
	return ontology.getAxiomCount(AxiomType.EQUIVALENT_OBJECT_PROPERTIES,
		true);
    }

    @Override
    public int countInverseObjectPropertiesAxioms() {
	return ontology
		.getAxiomCount(AxiomType.INVERSE_OBJECT_PROPERTIES, true);
    }

    @Override
    public int countDisjointObjectPropertiesAxioms() {
	return ontology.getAxiomCount(AxiomType.DISJOINT_OBJECT_PROPERTIES,
		true);
    }

    @Override
    public int countFunctionalObjectPropertiesAxioms() {
	return ontology.getAxiomCount(AxiomType.FUNCTIONAL_OBJECT_PROPERTY,
		true);
    }

    @Override
    public int countInverseFunctionalObjectPropertyAxioms() {
	return ontology.getAxiomCount(
		AxiomType.INVERSE_FUNCTIONAL_OBJECT_PROPERTY, true);
    }

    @Override
    public int countTransitiveObjectPropertyAxioms() {
	return ontology.getAxiomCount(AxiomType.TRANSITIVE_OBJECT_PROPERTY,
		true);
    }

    @Override
    public int countIrrefexiveObjectPropertyAxioms() {
	return ontology.getAxiomCount(AxiomType.IRREFLEXIVE_OBJECT_PROPERTY,
		true);
    }

    @Override
    public int countReflexiveObjectPropertyAxioms() {
	return ontology
		.getAxiomCount(AxiomType.REFLEXIVE_OBJECT_PROPERTY, true);
    }

    @Override
    public int countSymmetricObjectPropertyAxioms() {
	return ontology
		.getAxiomCount(AxiomType.SYMMETRIC_OBJECT_PROPERTY, true);
    }

    @Override
    public int countAsymmetricObjectPropertyAxioms() {
	return ontology.getAxiomCount(AxiomType.ASYMMETRIC_OBJECT_PROPERTY,
		true);
    }

    @Override
    public int countObjectPropertyDomainAxioms() {
	return ontology.getAxiomCount(AxiomType.OBJECT_PROPERTY_DOMAIN, true);
    }

    @Override
    public int countObjectPropertyRangeAxioms() {
	return ontology.getAxiomCount(AxiomType.OBJECT_PROPERTY_RANGE, true);
    }

    @Override
    public int countSubPropertyChainOfAxioms() {
	return ontology.getAxiomCount(AxiomType.SUB_PROPERTY_CHAIN_OF, true);
    }

    /*
     * annotations
     */
    @Override
    public int countAnnotionAssertionAxioms() {
	return ontology.getAxiomCount(AxiomType.ANNOTATION_ASSERTION, true);
    }

    @Override
    public int countAnnotationPropertyDomainAxioms() {
	return ontology.getAxiomCount(AxiomType.ANNOTATION_PROPERTY_DOMAIN,
		true);
    }

    @Override
    public int countAnnotationPropertyRangeOfAxioms() {
	return ontology
		.getAxiomCount(AxiomType.ANNOTATION_PROPERTY_RANGE, true);
    }

    @Override
    public int countProperties() {
	return countObjectProperties() + countDataProperties();
    }

}
