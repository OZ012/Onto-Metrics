package de.edu.rostock.ontologymetrics.owlapi.ontology;

import java.util.Set;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntology;

public class OntologyUtility {

    /**
     * Return an <code>OWLClass</code> corresponding to the given IRI.
     * 
     * @param iri
     * @return If the given IRI is not available or the object is no
     *         <code>OWLClass</code>, this method return <code>null</code>.
     */
    public static OWLClass getClass(OWLOntology ontology, IRI iri) {
	OWLClass clazz = null;

	if (ontology != null) {
	    for (OWLClass cls : ontology.getClassesInSignature(true)) {
		if (cls.getIRI() != null && cls.getIRI().equals(iri)) {
		    clazz = cls;
		    break;
		}
	    }
	}

	return clazz;
    }

    public static void printClassHierarchy(OWLOntology ontology) {
	if (ontology != null) {
	    printClassHierarchyRecursive(ontology,
		    ontology.getClassesInSignature(true), 0);
	}
    }

    public static void printClassHierarchyRecursive(OWLOntology ontology,
	    Set<OWLClass> subClasses, int level) {
	if (subClasses != null) {

	    for (OWLClass subClass : subClasses) {
		for (int i = 0; i < level; i++) {
		    System.out.print("\t");
		}
		System.out.println(subClass.getIRI().getFragment());
		if (!subClass.getSubClasses(ontology).isEmpty()) {
		    printClassHierarchyRecursive(ontology,
			    subClass.getClassesInSignature(), level + 1);
		}
	    }
	}
    }

}
