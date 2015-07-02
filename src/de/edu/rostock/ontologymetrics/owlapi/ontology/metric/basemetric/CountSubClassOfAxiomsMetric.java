package de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric;

import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLOntology;

public class CountSubClassOfAxiomsMetric extends BaseMetric {

    public CountSubClassOfAxiomsMetric(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public Integer getValue() {
	return ontology.getAxiomCount(AxiomType.SUBCLASS_OF, true);
    }

    @Override
    public String toString() {
	return "SubClassOf axioms count";
    }

}
