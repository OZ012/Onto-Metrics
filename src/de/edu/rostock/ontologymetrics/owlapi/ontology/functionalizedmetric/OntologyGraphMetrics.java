package de.edu.rostock.ontologymetrics.owlapi.ontology.functionalizedmetric;

public interface OntologyGraphMetrics {

    public float getAverageDepth();

    public float getAverageBreadth();

    public float getTangledness();

    /**
     * "dispersion"
     */
    public float getRatioOfLeafFanOutness();

    /**
     * "internal dispersion"
     */
    public float getRatioOfSiblingFanOutness();

    public float getDensity();

    public float getModularity();

    public float getLogicalAdaquacy();

}
