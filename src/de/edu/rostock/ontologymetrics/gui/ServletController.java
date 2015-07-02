package de.edu.rostock.ontologymetrics.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.semanticweb.owlapi.io.UnparsableOntologyException;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

import de.edu.rostock.ontologymetrics.owlapi.ontology.OntologyMetricManager;
import de.edu.rostock.ontologymetrics.owlapi.ontology.OntologyMetricManagerImpl;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class ServletController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    Logger logger = Logger.getLogger(this.getClass());

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletController() {
	super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {

	// sources
	String text = request.getParameter("text");
	String iriString = request.getParameter("classmetric");
	Boolean isURL = true;

	// create ontology metric manager
	OntologyMetricManager manager = new OntologyMetricManagerImpl();
	OWLOntology ontology = null;

	// validate source
	boolean isAvailable = false;
	IRI iri = null;
	if (text != null) {
	    // TODO exception handling
	    // try to create an ontology from url source
	    if (text.startsWith("http")) {
		try {
		    iri = IRI.create(text);
		    ontology = manager.loadOntologyFromIRI(iri);
		    isAvailable = true;
		} catch (OWLOntologyCreationException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    } else { // try to create an ontology from text source
		     // TODO exception handling
		try {
		    ontology = manager.loadOntologyFromText(text);
		    isAvailable = true;
		    isURL = false;
		} catch (UnparsableOntologyException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		    logger.error(e.getMessage());
		} catch (OWLOntologyCreationException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		    logger.error(e.getMessage());
		}
	    }

	}

	// create output for view from model

	// the results will be passed back (as an attribute) to the JSP view
	// (result.jsp)
	request.setAttribute("metrics", manager.getMetrics());
	request.setAttribute("isurl", isURL);
	request.setAttribute("status", isAvailable);
	request.setAttribute("namespaces", getNamespaces(manager.getOntology()));
	request.setAttribute("classmetric", iriString);

	if (iri != null) {
	    request.setAttribute("src", manager.getNamespace());
	}

	RequestDispatcher view = request.getRequestDispatcher("result.jsp");
	view.forward(request, response);
    }

    /**
     * Return a list of namespaces defined by the classes included in the given
     * ontology.
     * 
     * @param pOntology
     * @return
     */
    public List<String> getNamespaces(OWLOntology pOntology) {
	List<String> result = new ArrayList<String>();

	Set<OWLClass> classes = pOntology.getClassesInSignature(true);
	for (OWLClass cls : classes) {
	    if (!cls.asOWLClass().isOWLThing())
		result.add(cls.getIRI().getNamespace()
			+ cls.getIRI().getFragment());
	}

	return result;
    }

}
