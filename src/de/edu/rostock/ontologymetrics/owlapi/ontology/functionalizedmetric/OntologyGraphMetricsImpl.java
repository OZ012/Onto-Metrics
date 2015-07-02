package de.edu.rostock.ontologymetrics.owlapi.ontology.functionalizedmetric;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntology;

public class OntologyGraphMetricsImpl extends OntologyGraphBaseMetricsImpl
	implements OntologyGraphMetrics {

    public OntologyGraphMetricsImpl(OWLOntology pOntology) {
	super(pOntology);
    }

    @Override
    public float getAverageDepth() {
	int depth = 0;
	Set<List<OWLClass>> paths = getPaths();
	for (List<OWLClass> path : paths) {
	    depth = depth + path.size();
	}
	return (float) depth / (float) paths.size();
    }

    @Override
    public float getAverageBreadth() {
	int breadth = 0;
	Set<Set<OWLClass>> levels = getLevels();
	for (Set<OWLClass> path : levels) {
	    breadth = breadth + path.size();
	}
	return (float) breadth / (float) levels.size();
    }

    @Override
    public float getTangledness() {
	Set<OWLClass> tangledClasses = new HashSet<OWLClass>();
	for (OWLClass cls : ontology.getClassesInSignature(true)) {
	    if (cls.getSubClasses(ontology).size() > 1) {
		tangledClasses.add(cls);
	    }
	}
	return (float) countTotalClasses() / (float) tangledClasses.size();
    }

    @Override
    public float getRatioOfLeafFanOutness() {
	return (float) getLeaves().size() / (float) countTotalClasses();
    }

    @Override
    public float getRatioOfSiblingFanOutness() {
	int countSiblings = 0;
	for (Set<OWLClass> sibling : getSiblings()) {
	    countSiblings = countSiblings + sibling.size();
	}
	return 1 - ((float) countSiblings / (float) countTotalClasses());
    }

    @Override
    public float getDensity() {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public float getModularity() {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public float getLogicalAdaquacy() {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public String toString() {
	StringBuilder str = new StringBuilder();
	str.append("\n\nGraph metrics").append("\nAverage depth: ")
		.append(getAverageDepth()).append("\nAverage breadth: ")
		.append(getAverageBreadth()).append("\nTangledness: ")
		.append(getTangledness()).append("\nLeaf fan-outness: ")
		.append(getRatioOfLeafFanOutness())
		.append("\nSibling fan-outness: ")
		.append(getRatioOfSiblingFanOutness());
	return str.toString();
    }

}
