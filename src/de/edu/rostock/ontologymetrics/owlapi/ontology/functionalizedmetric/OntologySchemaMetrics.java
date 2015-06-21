package de.edu.rostock.ontologymetrics.owlapi.ontology.functionalizedmetric;

public interface OntologySchemaMetrics {

    public float getSchemaRelationshipRichness();

    /**
     * Return the average number of attributes per class. An attribute can be a
     * literal or something in an ontology.
     */
    public float getAttributeRichness();

    public float getSchemaInheritenceRichness();

    public float getTreeBalance();

}