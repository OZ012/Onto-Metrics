package de.edu.rostock.ontologymetrics.owlapi.ontology.functionalizedmetric;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntology;

import de.edu.rostock.ontologymetrics.owlapi.ontology.OntologyUtility;

public class OntologyClassMetricsImpl extends
	OntologySchemaKnowledgeBaseMetricsImpl implements OntologyClassMetrics {

    private IRI iri;
    private OWLClass cls;

    public OntologyClassMetricsImpl(OWLOntology pOntology, IRI iri) {
	super(pOntology);
	this.iri = iri;
	cls = OntologyUtility.getClass(pOntology, iri);
    }

    /**
     * Print the class metrics of this ontology to console.
     */
    @Override
    public String toString() {
	// TODO
	StringBuilder output = new StringBuilder();
	if (ontology != null && cls != null) {
	    output.append("\nClass Metrics ").append(iri.toQuotedString())
		    .append("\nImportance: ").append(getImportance())
		    .append("\nFulness: ").append(getFulness())
		    .append("\nInheritence Richness: ")
		    .append(getClassInheritenceRichness())
		    .append("\nRelationship Richness: ")
		    .append(getClassRelationshipRichness())
		    .append("\nConnectivity: ").append(getConnectivity())
		    .append("\nReadability: ").append(getReadability());
	}
	return output.toString();
    }

    @Override
    public float getImportance() {
	OWLClass cls = OntologyUtility.getClass(ontology, iri);
	int countTotalInstances = countTotalInstances();
	int countInstances = getNumberOfInstances(cls);

	// avoid a division by zero
	if (countTotalInstances == 0) {
	    return 0;
	} else {
	    return (float) countInstances / (float) countTotalIndividuals();
	}
    }

    @Override
    public float getClassRelationshipRichness() {
	// TODO Auto-generated method stub
	return 0;
    }

    /**
     * Return the actual number of instances that belong to the subtree rooted
     * at <code>cls</code> divided by the expected number of instances that
     * belong to the subtree rooted at
     */
    @Override
    public float getFulness() {
	// TODO testing
	OWLClass cls = OntologyUtility.getClass(ontology, iri);
	int numberOfSubClasses = getNumberOfSubClasses(cls);

	// avoid a division by zero
	float actualNumberOfInstances = (float) getNumberOfInstances(cls)
		/ (float) numberOfSubClasses;
	// float expectedNumberOfInstances = getAveragePopulation();
	float expectedNumberOfInstances = 0;

	// avoid a division by zero
	if (expectedNumberOfInstances == 0f) {
	    return 0f;
	} else {
	    return actualNumberOfInstances / expectedNumberOfInstances;
	}
    }

    /**
     * Return the average number of subclasses per class in the subtree rooted
     * at <code>cls</code>.
     */
    @Override
    public float getClassInheritenceRichness() {
	// TODO testing
	OWLClass cls = OntologyUtility.getClass(ontology, iri);
	int countClasses = getNumberOfClasses(cls);
	int countSubClasses = getNumberOfSubClasses(cls);

	// avoid a division by zero
	if (countSubClasses == 0) {
	    return 0;
	} else {
	    return (float) countClasses / (float) countSubClasses;
	}
    }

    @Override
    public int getConnectivity() {
	// TODO Auto-generated method stub
	return 0;
    }

    /**
     * Return the sum of the number attributes that are comments and the number
     * of attributes that are labels of <code>cls</code>.
     */
    @Override
    public int getReadability() {
	OWLClass cls = OntologyUtility.getClass(ontology, iri);
	int countAnnotations = 0;

	if (cls != null) {
	    for (OWLAnnotation annotation : cls.getAnnotations(ontology)) {
		if (annotation.getProperty().isLabel()
			|| annotation.getProperty().isComment()) {
		    countAnnotations++;
		}
	    }
	}

	return countAnnotations;
    }

}
