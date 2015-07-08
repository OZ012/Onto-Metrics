package de.edu.rostock.ontologymetrics.owlapi.ontology;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
//import org.apache.log4j.Logger;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class OntologyMetricManagerImpl implements OntologyMetricManager {

    // ALL | DEBUG | INFO | WARN | ERROR | FATAL | OFF:
    private Logger logger = Logger.getLogger(this.getClass());

    protected OWLOntologyManager manager;

    protected OntologyMetrics metrics;

    public OntologyMetricManagerImpl() {
	manager = OWLManager.createOWLOntologyManager();
	metrics = new OntologyMetricsImpl(null);
    }

    /**
     * 
     */
    public OWLOntology loadOntologyFromIRI(IRI pIRI)
	    throws OWLOntologyCreationException {
	OWLOntology ontology = null;
	if (pIRI != null) {
	    ontology = manager.loadOntologyFromOntologyDocument(pIRI);
	    metrics.setOntology(ontology);
	    metrics.setIRI(null);
	}
	logger.info("load ontology successfully done");
	return ontology;
    }

    /**
     * 
     */
    public OWLOntology loadOntologyFromFile(File file)
	    throws OWLOntologyCreationException {
	// TODO
	OWLOntology ontology = null;
	if (file != null) {
	    ontology = manager.loadOntologyFromOntologyDocument(file);
	    metrics.setOntology(ontology);
	    // logger.info("load ontology successfully done");
	}
	return ontology;
    }

    
    
    private static Connection connection; 
	private static final String DB_PATH = "/tmp/" + "ontology.db";

	static {
    	try {
        	Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
        }
	}
        
	private void initDBConnection() {		//connect to the database
    	try {
        	if (connection != null)
            	return;
            connection = DriverManager.getConnection("jdbc:sqlite:" + DB_PATH);
        } catch (SQLException e) {
        	throw new RuntimeException(e);
        }

        Runtime.getRuntime().addShutdownHook(new Thread() {		//and close the connection
        	public void run() {
            	try {
                	if (!connection.isClosed() && connection != null) {
                    	connection.close();
                    }
                } catch (SQLException e) {
                	e.printStackTrace();
                }
            }
        });
	}

	private void handleDB(String i) {		//handle the statements
    	String j = i;
    	try {
        	Statement stmt = connection.createStatement();
            //stmt.executeUpdate("INSERT INTO ontologies (ids, dateiname) VALUES('','" + j +"')");
            stmt.execute("INSERT INTO ontologies (ids, dateiname) VALUES('', '"+ j +"')");
            connection.close();
        } catch (SQLException e) {
        	e.printStackTrace();
        }
    }
    
    
    
    
    public OWLOntology loadOntologyFromText(String text) throws IOException,
	    OWLOntologyCreationException {
	// TODO file need a specified path
	// initialize
    	File file = new File(File.separator + "tmp/tmp.rdf"); //Hier Pfad ändern
    	FileWriter writer = new FileWriter(file, false);

    	writer.write(text);
    	writer.flush();
    	writer.close();
    	file.createNewFile();
    	

    	Date dNow = new Date( );			//getting and formatting the 
        	SimpleDateFormat ft = 			//current date and time
        	new SimpleDateFormat ("yyyy-MM-dd_hh-mm-ss-SS");

        String i = "/tmp/"+ft.format(dNow)+".rdf"; //writing it into path and filename

        File file2 = new File(File.separator + i);		//i = pathname
    	FileWriter writer2 = new FileWriter(file2, false);

    	writer2.write(text);
    	writer2.flush();
    	writer2.close();
    	file2.createNewFile();
    	
    	initDBConnection();
        handleDB(i);
	
	return loadOntologyFromFile(file);
    
    }

    public void saveOntologyToFile(File file)
	    throws OWLOntologyStorageException {
	// TODO
    		manager.saveOntology(null, IRI.create(file));
    	}

    // getter $ setter

    public OWLOntology getOntology() {
    	return metrics.getOntology();
    }

    public OntologyMetrics getMetrics() {
    	return metrics;
    }

    public String getNamespace() {
    	if (metrics.getIRI() != null) {
    		return metrics.getIRI().getNamespace();
    	} else {
    		return null;
    	}
    }

   
}
