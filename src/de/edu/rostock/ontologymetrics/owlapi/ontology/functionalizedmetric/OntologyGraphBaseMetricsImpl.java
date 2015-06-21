package de.edu.rostock.ontologymetrics.owlapi.ontology.functionalizedmetric;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLOntology;

public class OntologyGraphBaseMetricsImpl extends OntologyBaseMetricsImpl {

    public OntologyGraphBaseMetricsImpl(OWLOntology pOntology) {
	super(pOntology);
    }

    /**
     * Return the rooted node of an ontology.
     * 
     * @return The thing class
     */
    public OWLClass getThing() {
	OWLClass result = null;
	for (OWLClass cls : ontology.getClassesInSignature()) {
	    if (cls.isOWLThing()) {
		result = cls;
		break;
	    }
	}

	return result;
    }

    /**
     * Return a set of classes which are rooted in this ontology.
     */
    public Set<OWLClass> getRootedClasses() {
	Set<OWLClass> result = new HashSet<OWLClass>();
	for (OWLClass owlClass : ontology.getClassesInSignature(true)) {
	    if (owlClass.getSuperClasses(ontology).isEmpty()
		    && !owlClass.isOWLThing()) {
		result.add(owlClass);
	    }
	}
	return result;
    }

    public Set<OWLClass> getLeaves() {
	Set<OWLClass> result = new HashSet<OWLClass>();
	for (OWLClass owlClass : ontology.getClassesInSignature(true)) {
	    if (owlClass.getSubClasses(ontology).isEmpty()
		    && !owlClass.isOWLThing()) {
		result.add(owlClass);
	    }
	}
	return result;
    }

    public Set<Set<OWLClass>> getSiblings() {
	Set<OWLClass> rootedNodes = getRootedClasses();
	Set<Set<OWLClass>> result = new HashSet<Set<OWLClass>>();

	result.add(rootedNodes);
	getSibling(result, rootedNodes);

	return result;
    }

    public void getSibling(Set<Set<OWLClass>> siblings, Set<OWLClass> classes) {
	// iterate root classes
	for (OWLClass cls : classes) {
	    Set<OWLClass> subClasses = new HashSet<OWLClass>();

	    // convert class expressions to classes
	    for (OWLClassExpression subClass : cls.getSubClasses(ontology)) {
		subClasses.add(subClass.asOWLClass());
	    }
	    // only one sub class has no siblings but can be a parent of
	    // siblings
	    if (subClasses.size() > 1) {
		siblings.add(subClasses);
	    }
	    if (subClasses.size() > 0) {
		getSibling(siblings, subClasses);
	    }
	}
    }

    public Set<List<OWLClass>> getPaths() {
	Set<List<OWLClass>> result = new HashSet<List<OWLClass>>();

	for (OWLClass rootedClass : getRootedClasses()) {
	    List<OWLClass> path = new ArrayList<OWLClass>();
	    getPath(result, path, rootedClass);
	}

	return result;
    }

    public void getPath(Set<List<OWLClass>> paths, List<OWLClass> path,
	    OWLClass cls) {
	List<OWLClass> result = path;
	if (cls != null) {
	    // class is a leaf?
	    if (getLeaves().contains(cls)) {
		result.add(cls);
		paths.add(result);
	    } else {
		// iterate sub classes
		for (OWLClassExpression subClass : cls.getSubClasses(ontology)) {
		    // create a new instance of path
		    List<OWLClass> nextPath = new ArrayList<OWLClass>();
		    for (OWLClass node : path) {
			nextPath.add(node);
		    }
		    nextPath.add(cls);

		    // next round...
		    getPath(paths, nextPath, subClass.asOWLClass());
		}

	    }
	}
    }

    public Set<Set<OWLClass>> getLevels() {
	Set<Set<OWLClass>> levels = new HashSet<Set<OWLClass>>();
	levels.add(getRootedClasses());
	getLevel(levels, getRootedClasses());
	return levels;
    }

    public void getLevel(Set<Set<OWLClass>> levels, Set<OWLClass> classes) {
	Set<OWLClass> level = new HashSet<OWLClass>();
	for (OWLClass owlClass : classes) {
	    for (OWLClassExpression subClass : owlClass.getSubClasses(ontology)) {
		level.add(subClass.asOWLClass());
	    }
	}
	if (!level.isEmpty()) {
	    levels.add(level);
	    getLevel(levels, level);
	}
    }

    public Set<Set<OWLClass>> getModuls() {
	// TODO Auto-generated method stub
	return null;
    }

}
