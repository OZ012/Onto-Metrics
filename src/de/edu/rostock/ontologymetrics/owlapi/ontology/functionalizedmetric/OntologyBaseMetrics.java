package de.edu.rostock.ontologymetrics.owlapi.ontology.functionalizedmetric;

import org.semanticweb.owlapi.model.OWLClass;

public interface OntologyBaseMetrics {

    /*
     * ontology axioms
     */

    public int countAxioms();

    /**
     * Return the number of classes in this ontology.
     * 
     * @return The number of classes
     */
    public int countClasses();

    /**
     * Return the number of classes in this ontology including the import
     * closure.
     */
    public int countTotalClasses();

    /**
     * Return the number of object properties in this ontology.
     */
    public int countObjectProperties();

    /**
     * Return the number of object properties in this ontology including the
     * imported ontologies.
     */
    public int countTotalObjectProperties();

    /**
     * Return the number of data properties in this ontology.
     */
    public int countDataProperties();

    /**
     * Return the number of data properties in this ontology including the
     * imported ontologies.
     */
    public int countTotalDataProperties();

    /**
     * Return the number of instances in this ontology. This method is
     * equivalent to <code>countInstances()</code>.
     */
    public int countIndividuals();

    /**
     * Return the number of instances in this ontology including imported
     * ontologies. This method is equivalent to
     * <code>countTotalInstances()</code>.
     */
    public int countTotalIndividuals();

    /**
     * Return the number of instances in this ontology. This method is
     * equivalent to <code>countIndividuals()</code>.
     */
    public int countInstances();

    /**
     * Return the number of instances in this ontology including imported
     * ontologies. This method is equivalent to
     * <code>countTotalIndividuals()</code>.
     */
    public int countTotalInstances();

    public int countLogicalAxioms();

    public int countAnnotationAxioms();

    public String getDlExpressivity();

    /*
     * class axioms
     */

    public int countSubClassOfAxioms();

    public int countEquivalentClassesAxioms();

    public int countDisjointClassesAxioms();

    public int countGCI();

    public int countHiddenGCI();

    /*
     * object property axioms
     */

    public int countSubObjectPropertyOfAxioms();

    public int countEquivalentObjectPropertiesAxioms();

    public int countInverseObjectPropertiesAxioms();

    public int countDisjointObjectPropertiesAxioms();

    public int countFunctionalObjectPropertiesAxioms();

    public int countInverseFunctionalObjectPropertyAxioms();

    public int countTransitiveObjectPropertyAxioms();

    public int countIrrefexiveObjectPropertyAxioms();

    public int countReflexiveObjectPropertyAxioms();

    public int countSymmetricObjectPropertyAxioms();

    public int countAsymmetricObjectPropertyAxioms();

    public int countObjectPropertyDomainAxioms();

    public int countObjectPropertyRangeAxioms();

    public int countSubPropertyChainOfAxioms();

    /*
     * data property axioms
     */

    public int countSubDataPropertyOfAxioms();

    public int countEquivalentDataPropertiesAxioms();

    public int countDisjointDataPropertiesAxioms();

    public int countDataPropertyDomainAxioms();

    public int countDataPropertyRangeAxioms();

    public int countFunctionalDataPropertyAxioms();

    /*
     * individual axioms
     */

    public int countClassAssertionAxioms();

    public int countObjectPropertyAssertionAxioms();

    public int countDataPropertyAssertionAxioms();

    public int countNegativeObjectPropertyAssertionAxioms();

    public int countNegativeDataPropertyAssertionAxioms();

    public int countDifferentIndividualsAxioms();

    public int countSameIndividualsAxioms();

    /*
     * annotation axioms
     */

    public int countAnnotionAssertionAxioms();

    public int countAnnotationPropertyDomainAxioms();

    public int countAnnotationPropertyRangeOfAxioms();

    /*
     * 
     */

    public int getNumberOfInstances(OWLClass cls);

    public int getNumberOfSubClasses(OWLClass cls);

    public int getNumberOfClasses(OWLClass cls);

    public int countProperties();

}
