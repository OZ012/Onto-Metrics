package de.edu.rostock.ontologymetrics.owlapi.ontology;

import java.util.ArrayList;
import java.util.List;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;

import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.OntologyMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountAnnotationAssertionAxiomsMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountAnnotationAxiomsMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountAnnotationPropertyDomainAxiomsMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountAnnotationPropertyRangeAxiomsMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountAsymmetricObjectPropertyAxiomsMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountAxiomsMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountClassAssertionAxiomsMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountClassesMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountDataPropertiesMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountDataPropertyAssertionAxiomsMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountDataPropertyDomainAxiomsMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountDataPropertyRangeAxiomsMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountDifferentIndividualsAxiomsMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountDisjointClassesAxiomsMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountDisjointDataPropertiesAxiomsMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountDisjointObjectPropertiesAxiomsMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountEquivalentClassesAxiomsMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountEquivalentDataPropertiesAxiomsMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountEquivalentObjectPropertiesAxiomsMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountFunctionalDataPropertyAxiomsMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountFunctionalObjectPropertiesAxiomsMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountGCIMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountHiddenGCIMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountIndividualsMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountInverseFunctionalObjectPropertiesAxiomsMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountInverseObjectPropertiesAxiomsMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountIrreflexiveObjectPropertyAxiomsMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountLogicalAxiomsMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountNegativeDataPropertyAssertionAxiomsMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountNegativeObjectPropertyAssertionAxiomsMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountNumberOfClassesMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountNumberOfInstancesMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountNumberOfSubClassesMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountObjectPropertiesMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountObjectPropertyAssertionAxiomsMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountObjectPropertyDomainAxiomsMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountObjectPropertyRangeAxiomsMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountPropertiesMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountReflexiveObjectPropertyAxiomsMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountSameIndividualsAxiomsMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountSubClassOfAxiomsMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountSubDataPropertyOfAxiomsMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountSubObjectPropertyOfAxiomsMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountSubPropertyChainOfAxiomsMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountSymmetricObjectPropertyAxiomsMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountTotalClassesMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountTotalDataPropertiesMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountTotalIndividualsMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountTotalObjectPropertiesMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.CountTransitiveObjectPropertyAxiomsMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.graphbasemetric.graphmetric.AverageBreadthMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.graphbasemetric.graphmetric.AverageDepthMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.graphbasemetric.graphmetric.DensityMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.graphbasemetric.graphmetric.LogicalAdaquacyMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.graphbasemetric.graphmetric.ModularityMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.graphbasemetric.graphmetric.RatioOfLeafFanOutnessMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.graphbasemetric.graphmetric.RatioOfSiblingFanOutnessMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.graphbasemetric.graphmetric.TanglednessMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.schemaknowledgebasemetric.classmetrics.ClassConnectivityMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.schemaknowledgebasemetric.classmetrics.ClassFulnessMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.schemaknowledgebasemetric.classmetrics.ClassImportanceMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.schemaknowledgebasemetric.classmetrics.ClassInheritenceRichnessMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.schemaknowledgebasemetric.classmetrics.ClassReadabilityMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.schemaknowledgebasemetric.classmetrics.ClassRelationshipRichnessMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.schemaknowledgebasemetric.classmetrics.CountClassChildrenMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.schemaknowledgebasemetric.classmetrics.CountClassInstancesMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.schemaknowledgebasemetric.classmetrics.CountClassPropertiesMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.schemaknowledgebasemetric.knowledgebasemetric.AveragePopulationMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.schemaknowledgebasemetric.knowledgebasemetric.ClassRichnessMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.schemaknowledgebasemetric.knowledgebasemetric.CohesionMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.schemaknowledgebasemetric.knowledgebasemetric.InstanceCoverageMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.schemaknowledgebasemetric.knowledgebasemetric.TreeBalanceMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.schemaknowledgebasemetric.schemametric.AttributeRichnessMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.schemaknowledgebasemetric.schemametric.SchemaInheritenceRichnessMetric;
import de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.schemaknowledgebasemetric.schemametric.SchemaRelationshipRichnessMetric;

/**
 * This class represents the implementation of the interface
 * <code>OntologyMetrics</code>.
 * 
 */
public class OntologyMetricsImpl implements OntologyMetrics {

    private OWLOntology ontology;

    private IRI iri;

    public OntologyMetricsImpl(OWLOntology pOntology) {
	ontology = pOntology;
	iri = null;
    }

    /*
     * getter $ setter
     */

    public OWLOntology getOntology() {
	return ontology;
    }

    public void setOntology(OWLOntology pOntology) {
	ontology = pOntology;
    }

    public void setIRI(IRI pIRI) {
	iri = pIRI;
    }

    public IRI getIRI() {
	return iri;
    }

    /*
     * metrics
     */

    public List<OntologyMetric> getAllMetrics() {
	List<OntologyMetric> metrics = new ArrayList<OntologyMetric>();
	metrics.addAll(getAllBaseMetrics());
	metrics.addAll(getAllSchemaMetrics());
	metrics.addAll(getAllKnowledgebaseMetrics());
	metrics.addAll(getAllClassMetrics(null));
	metrics.addAll(getAllGraphMetrics());

	return metrics;
    }

    public List<OntologyMetric> getAllQualityMetrics() {
	List<OntologyMetric> metrics = new ArrayList<OntologyMetric>();
	metrics.addAll(getAllSchemaMetrics());
	metrics.addAll(getAllKnowledgebaseMetrics());
	metrics.addAll(getAllClassMetrics(null));
	metrics.addAll(getAllGraphMetrics());

	return metrics;
    }

    /*
     * base metrics
     */

    public List<OntologyMetric> getAllBaseMetrics() {
	List<OntologyMetric> baseMetrics = new ArrayList<OntologyMetric>();

	baseMetrics.add(getAxiomsMetric());
	baseMetrics.add(getLogicalAxiomsMetric());
	baseMetrics.add(getClassesMetric());
	baseMetrics.add(getTotalClassesMetric());
	baseMetrics.add(getObjectPropertiesMetric());
	baseMetrics.add(getTotalObjectPropertiesMetric());
	baseMetrics.add(getDataPropertiesMetric());
	baseMetrics.add(getTotalDataPropertiesMetric());
	baseMetrics.add(getPropertiesMetric());
	baseMetrics.add(getIndividualsMetric());
	baseMetrics.add(getTotalIndividualsMetric());
	baseMetrics.add(getAnnotationAxiomsMetric());
	baseMetrics.add(getSubClassOfAxiomsMetric());
	baseMetrics.add(getEquivalentClassesAxiomsMetric());
	baseMetrics.add(getDisjointClassesAxiomsMetric());
	baseMetrics.add(getGCIMetric());
	baseMetrics.add(getHiddenGCIMetric());
	baseMetrics.add(getSubObjectPropertyOfAxiomsMetric());
	baseMetrics.add(getEquivalentObjectPropertiesAxiomsMetric());
	baseMetrics.add(getInverseObjectPropertiesAxiomsMetric());
	baseMetrics.add(getDisjointObjectPropertiesAxiomsMetric());
	baseMetrics.add(getFunctionalObjectPropertiesAxiomsMetric());
	baseMetrics.add(getInverseFunctionalObjectPropertiesAxiomsMetric());
	baseMetrics.add(getTransitiveObjectPropertyAxiomsMetric());
	baseMetrics.add(getSymmetricObjectPropertyAxiomsMetric());
	baseMetrics.add(getAsymmetricObjectPropertyAxiomsMetric());
	baseMetrics.add(getReflexiveObjectPropertyAxiomsMetric());
	baseMetrics.add(getIrreflexiveObjectPropertyAxiomsMetric());
	baseMetrics.add(getObjectPropertyDomainAxiomsMetric());
	baseMetrics.add(getObjectPropertyRangeAxiomsMetric());
	baseMetrics.add(getSubPropertyChainOfAxiomsMetric());
	baseMetrics.add(getSubDataPropertyOfAxiomsMetric());
	baseMetrics.add(getEquivalentDataPropertesAxiomsMetric());
	baseMetrics.add(getDisjointDataPropertiesAxiomsMetric());
	baseMetrics.add(getFunctionalDataPropertyAxiomsMetric());
	baseMetrics.add(getDataPropertyDomainAxiomsMetric());
	baseMetrics.add(getDataPropertyRangeAxiomsMetric());
	baseMetrics.add(getClassAssertionAxiomsMetric());
	baseMetrics.add(getObjectPropertyAssertionAxiomsMetric());
	baseMetrics.add(getDataPropertyAssertionAxiomsMetric());
	baseMetrics.add(getNegativeObjectPropertyAssertionAxiomsMetric());
	baseMetrics.add(getNegativeDataPropertyAssertionAxiomsMetric());
	baseMetrics.add(getSameIndividualsAxiomsMetric());
	baseMetrics.add(getDifferentIndividualsAxiomsMetric());
	baseMetrics.add(getAnnotationAssertionAxiomsMetric());
	baseMetrics.add(getAnnotationPropertyDomainAxiomsMetric());
	baseMetrics.add(getAnnotationPropertyRangeAxiomsMetric());

	return baseMetrics;
    }

    /*
     * base metrics
     */
    public OntologyMetric getAnnotationAssertionAxiomsMetric() {
	return new CountAnnotationAssertionAxiomsMetric(ontology);
    }

    public OntologyMetric getAnnotationAxiomsMetric() {
	return new CountAnnotationAxiomsMetric(ontology);
    }

    public OntologyMetric getAnnotationPropertyDomainAxiomsMetric() {
	return new CountAnnotationPropertyDomainAxiomsMetric(ontology);
    }

    public OntologyMetric getAnnotationPropertyRangeAxiomsMetric() {
	return new CountAnnotationPropertyRangeAxiomsMetric(ontology);
    }

    public OntologyMetric getAsymmetricObjectPropertyAxiomsMetric() {
	return new CountAsymmetricObjectPropertyAxiomsMetric(ontology);
    }

    public OntologyMetric getAxiomsMetric() {
	return new CountAxiomsMetric(ontology);
    }

    public OntologyMetric getClassAssertionAxiomsMetric() {
	return new CountClassAssertionAxiomsMetric(ontology);
    }

    public OntologyMetric getClassesMetric() {
	return new CountClassesMetric(ontology);
    }

    public OntologyMetric getDataPropertiesMetric() {
	return new CountDataPropertiesMetric(ontology);
    }

    public OntologyMetric getDataPropertyAssertionAxiomsMetric() {
	return new CountDataPropertyAssertionAxiomsMetric(ontology);
    }

    public OntologyMetric getDataPropertyDomainAxiomsMetric() {
	return new CountDataPropertyDomainAxiomsMetric(ontology);
    }

    public OntologyMetric getDataPropertyRangeAxiomsMetric() {
	return new CountDataPropertyRangeAxiomsMetric(ontology);
    }

    public OntologyMetric getDifferentIndividualsAxiomsMetric() {
	return new CountDifferentIndividualsAxiomsMetric(ontology);
    }

    public OntologyMetric getDisjointClassesAxiomsMetric() {
	return new CountDisjointClassesAxiomsMetric(ontology);
    }

    public OntologyMetric getDisjointDataPropertiesAxiomsMetric() {
	return new CountDisjointDataPropertiesAxiomsMetric(ontology);
    }

    public OntologyMetric getDisjointObjectPropertiesAxiomsMetric() {
	return new CountDisjointObjectPropertiesAxiomsMetric(ontology);
    }

    public OntologyMetric getEquivalentClassesAxiomsMetric() {
	return new CountEquivalentClassesAxiomsMetric(ontology);
    }

    public OntologyMetric getEquivalentDataPropertesAxiomsMetric() {
	return new CountEquivalentDataPropertiesAxiomsMetric(ontology);
    }

    public OntologyMetric getEquivalentObjectPropertiesAxiomsMetric() {
	return new CountEquivalentObjectPropertiesAxiomsMetric(ontology);
    }

    public OntologyMetric getFunctionalDataPropertyAxiomsMetric() {
	return new CountFunctionalDataPropertyAxiomsMetric(ontology);
    }

    public OntologyMetric getFunctionalObjectPropertiesAxiomsMetric() {
	return new CountFunctionalObjectPropertiesAxiomsMetric(ontology);
    }

    public OntologyMetric getGCIMetric() {
	return new CountGCIMetric(ontology);
    }

    public OntologyMetric getHiddenGCIMetric() {
	return new CountHiddenGCIMetric(ontology);
    }

    public OntologyMetric getIndividualsMetric() {
	return new CountIndividualsMetric(ontology);
    }

    public OntologyMetric getInverseFunctionalObjectPropertiesAxiomsMetric() {
	return new CountInverseFunctionalObjectPropertiesAxiomsMetric(ontology);
    }

    public OntologyMetric getInverseObjectPropertiesAxiomsMetric() {
	return new CountInverseObjectPropertiesAxiomsMetric(ontology);
    }

    public OntologyMetric getIrreflexiveObjectPropertyAxiomsMetric() {
	return new CountIrreflexiveObjectPropertyAxiomsMetric(ontology);
    }

    public OntologyMetric getLogicalAxiomsMetric() {
	return new CountLogicalAxiomsMetric(ontology);
    }

    public OntologyMetric getNegativeDataPropertyAssertionAxiomsMetric() {
	return new CountNegativeDataPropertyAssertionAxiomsMetric(ontology);
    }

    public OntologyMetric getNegativeObjectPropertyAssertionAxiomsMetric() {
	return new CountNegativeObjectPropertyAssertionAxiomsMetric(ontology);
    }

    public OntologyMetric getNumberOfClassesMetric() {
	return new CountNumberOfClassesMetric(ontology);
    }

    public OntologyMetric getNumberOfInstancesMetric() {
	return new CountNumberOfInstancesMetric(ontology);
    }

    public OntologyMetric getNumberOfSubClassesMetric() {
	return new CountNumberOfSubClassesMetric(ontology);
    }

    public OntologyMetric getObjectPropertiesMetric() {
	return new CountObjectPropertiesMetric(ontology);
    }

    public OntologyMetric getObjectPropertyAssertionAxiomsMetric() {
	return new CountObjectPropertyAssertionAxiomsMetric(ontology);
    }

    public OntologyMetric getObjectPropertyDomainAxiomsMetric() {
	return new CountObjectPropertyDomainAxiomsMetric(ontology);
    }

    public OntologyMetric getObjectPropertyRangeAxiomsMetric() {
	return new CountObjectPropertyRangeAxiomsMetric(ontology);
    }

    public OntologyMetric getPropertiesMetric() {
	return new CountPropertiesMetric(ontology);
    }

    public OntologyMetric getReflexiveObjectPropertyAxiomsMetric() {
	return new CountReflexiveObjectPropertyAxiomsMetric(ontology);
    }

    public OntologyMetric getSameIndividualsAxiomsMetric() {
	return new CountSameIndividualsAxiomsMetric(ontology);
    }

    public OntologyMetric getSubClassOfAxiomsMetric() {
	return new CountSubClassOfAxiomsMetric(ontology);
    }

    public OntologyMetric getSubDataPropertyOfAxiomsMetric() {
	return new CountSubDataPropertyOfAxiomsMetric(ontology);
    }

    public OntologyMetric getSubObjectPropertyOfAxiomsMetric() {
	return new CountSubObjectPropertyOfAxiomsMetric(ontology);
    }

    public OntologyMetric getSubPropertyChainOfAxiomsMetric() {
	return new CountSubPropertyChainOfAxiomsMetric(ontology);
    }

    public OntologyMetric getSymmetricObjectPropertyAxiomsMetric() {
	return new CountSymmetricObjectPropertyAxiomsMetric(ontology);
    }

    public OntologyMetric getTotalClassesMetric() {
	return new CountTotalClassesMetric(ontology);
    }

    public OntologyMetric getTotalDataPropertiesMetric() {
	return new CountTotalDataPropertiesMetric(ontology);
    }

    public OntologyMetric getTotalIndividualsMetric() {
	return new CountTotalIndividualsMetric(ontology);
    }

    public OntologyMetric getTotalObjectPropertiesMetric() {
	return new CountTotalObjectPropertiesMetric(ontology);
    }

    public OntologyMetric getTransitiveObjectPropertyAxiomsMetric() {
	return new CountTransitiveObjectPropertyAxiomsMetric(ontology);
    }

    /*
     * graph metrics
     */

    public List<OntologyMetric> getAllGraphMetrics() {
	List<OntologyMetric> graphMetrics = new ArrayList<OntologyMetric>();
	graphMetrics.add(getAverageBreadthMetric());
	graphMetrics.add(getAverageDepthMetric());
	graphMetrics.add(getDensityMetric());
	graphMetrics.add(getLogicalAdaquacy());
	graphMetrics.add(getModularityMetric());
	graphMetrics.add(getRatioOfLeafFanOutness());
	graphMetrics.add(getRatioOfSiblingFanOutness());
	graphMetrics.add(getTanglednessMetric());

	return graphMetrics;
    }

    public OntologyMetric getAverageDepthMetric() {
	return new AverageDepthMetric(ontology);
    }

    public OntologyMetric getAverageBreadthMetric() {
	return new AverageBreadthMetric(ontology);
    }

    public OntologyMetric getTanglednessMetric() {
	return new TanglednessMetric(ontology);
    }

    public OntologyMetric getDensityMetric() {
	return new DensityMetric(ontology);
    }

    public OntologyMetric getLogicalAdaquacy() {
	return new LogicalAdaquacyMetric(ontology);
    }

    public OntologyMetric getModularityMetric() {
	return new ModularityMetric(ontology);
    }

    public OntologyMetric getRatioOfLeafFanOutness() {
	return new RatioOfLeafFanOutnessMetric(ontology);
    }

    public OntologyMetric getRatioOfSiblingFanOutness() {
	return new RatioOfSiblingFanOutnessMetric(ontology);
    }

    /*
     * schema metrics
     */

    public List<OntologyMetric> getAllSchemaMetrics() {
	List<OntologyMetric> schemaMetric = new ArrayList<OntologyMetric>();
	schemaMetric.add(getAttributeRichnessMetric());
	schemaMetric.add(getSchemaInheritenceRichness());
	schemaMetric.add(getSchemaRelatioshipRichness());
	return schemaMetric;
    }

    public OntologyMetric getAttributeRichnessMetric() {
	return new AttributeRichnessMetric(ontology);
    }

    public OntologyMetric getSchemaInheritenceRichness() {
	return new SchemaInheritenceRichnessMetric(ontology);
    }

    public OntologyMetric getSchemaRelatioshipRichness() {
	return new SchemaRelationshipRichnessMetric(ontology);
    }

    /*
     * knowledgebase metrics
     */

    public List<OntologyMetric> getAllKnowledgebaseMetrics() {
	List<OntologyMetric> knowledgeMetric = new ArrayList<OntologyMetric>();
	knowledgeMetric.add(getAveragePopulationMetric());
	knowledgeMetric.add(getClassRichnessMetric());
	knowledgeMetric.add(getCohesionMetric());
	knowledgeMetric.add(getInstanceCoverageMetric());
	knowledgeMetric.add(getTreeBalanceMetric());
	return knowledgeMetric;
    }

    public OntologyMetric getAveragePopulationMetric() {
	return new AveragePopulationMetric(ontology);
    }

    public OntologyMetric getClassRichnessMetric() {
	return new ClassRichnessMetric(ontology);
    }

    public OntologyMetric getCohesionMetric() {
	return new CohesionMetric(ontology);
    }

    public OntologyMetric getInstanceCoverageMetric() {
	return new InstanceCoverageMetric(ontology);
    }

    public OntologyMetric getTreeBalanceMetric() {
	return new TreeBalanceMetric(ontology);
    }

    /*
     * class metrics
     */

    public List<OntologyMetric> getAllClassMetrics(IRI pIri) {
	List<OntologyMetric> classMetrics = new ArrayList<OntologyMetric>();
	classMetrics.add(getClassConnectivityMetric(pIri));
	classMetrics.add(getClassFulnessMetric(pIri));
	classMetrics.add(getClassImportanceMetric(pIri));
	classMetrics.add(getClassInheritenceRichness(pIri));
	classMetrics.add(getClassReadabilityMetric(pIri));
	classMetrics.add(getClassRelationshipRichness(pIri));
	classMetrics.add(getCountClassChildrenMetric(pIri));
	classMetrics.add(getCountClassInstancesMetric(pIri));
	classMetrics.add(getCountClassPropertiesMetric(pIri));

	return classMetrics;
    }

    public OntologyMetric getClassConnectivityMetric(IRI pIri) {
	return new ClassConnectivityMetric(ontology, pIri);
    }

    public OntologyMetric getClassFulnessMetric(IRI pIri) {
	return new ClassFulnessMetric(ontology, pIri);
    }

    public OntologyMetric getClassImportanceMetric(IRI pIri) {
	return new ClassImportanceMetric(ontology, pIri);
    }

    public OntologyMetric getClassInheritenceRichness(IRI pIri) {
	return new ClassInheritenceRichnessMetric(ontology, pIri);
    }

    public OntologyMetric getClassReadabilityMetric(IRI pIri) {
	return new ClassReadabilityMetric(ontology, pIri);
    }

    public OntologyMetric getClassRelationshipRichness(IRI pIri) {
	return new ClassRelationshipRichnessMetric(ontology, pIri);
    }

    public OntologyMetric getCountClassChildrenMetric(IRI pIri) {
	return new CountClassChildrenMetric(ontology, pIri);
    }

    public OntologyMetric getCountClassInstancesMetric(IRI pIri) {
	return new CountClassInstancesMetric(ontology, pIri);
    }

    public OntologyMetric getCountClassPropertiesMetric(IRI pIri) {
	return new CountClassPropertiesMetric(ontology, pIri);
    }

}
