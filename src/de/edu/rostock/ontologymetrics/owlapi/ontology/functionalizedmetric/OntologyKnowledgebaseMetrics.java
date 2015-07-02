package de.edu.rostock.ontologymetrics.owlapi.ontology.functionalizedmetric;

public interface OntologyKnowledgebaseMetrics {
    /**
     * Return the ratio of the number of classes used in the base divided by the
     * number of classes defined in the ontology schema.
     */
    public float getClassRichness();

    /**
     * Return the number of instances of the knowledgebase divided by the number
     * of classes defined in the ontology schema.
     */
    public float getAveragePopulation();

    public float getCohesion();

    public float getInstanceCoverage();

    public float getTreeBalance();
}
