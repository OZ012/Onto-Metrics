package de.edu.rostock.ontologymetrics.owlapi.ontology.functionalizedmetric;


public interface OntologyClassMetrics {

    /**
     * Return the number of instances that belong to the subtree rooted at
     * <code>cls</code> divided by the total number of instances.
     */
    public float getImportance();

    public float getFulness();

    public float getClassInheritenceRichness();

    public float getClassRelationshipRichness();

    public int getConnectivity();

    public int getReadability();

}