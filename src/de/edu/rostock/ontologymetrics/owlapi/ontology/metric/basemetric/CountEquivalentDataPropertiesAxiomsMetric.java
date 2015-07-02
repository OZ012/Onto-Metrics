package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLOntology;

public class CountEquivalentDataPropertiesAxiomsMetric extends BaseMetric {

    public CountEquivalentDataPropertiesAxiomsMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Integer getValue() {
	return ontology.getAxiomCount(AxiomType.EQUIVALENT_DATA_PROPERTIES,
		true);
    }

    @Override
    public String toString() {
	return "Equivalent data properties axioms count";
    }

}
