<%@ page import="org.semanticweb.owlapi.model.IRI"%>
<%@ page import="de.edu.rostock.ontologymetrics.owlapi.ontology.metric.basemetric.schemaknowledgebasemetric.classmetrics.ClassMetrics"%>
<%@ page import="de.edu.rostock.ontologymetrics.owlapi.ontology.OntologyMetrics"%>
<%@ page import="java.util.*" %>
<%@ page import="de.edu.rostock.ontologymetrics.owlapi.ontology.metric.OntologyMetric" %>


<html>
<head>
	<title>Ontology Metrics</title>
</head>
<body>
	<h1>Result</h1>
<%
	//get parameters, attributes,...
String text = request.getParameter("text");
String iriString = (String) request.getAttribute("classmetric");
Boolean isURL = (Boolean) request.getAttribute("isurl");
OntologyMetrics metrics = (OntologyMetrics) request.getAttribute("metrics");
String url = (String) request.getAttribute("src"); // is url
List<String> namespaces = (List<String>) request.getAttribute("namespaces");


%>
<%	
	// print table
    
    String label = null;
    for (OntologyMetric metric : metrics.getAllMetrics()) {
		if (!metric.getLabel().equals(label)) {
		    // begin new table with header
		    out.print("</table><h3>" + metric.getLabel() + "</h3><table><tr>");
		    // is class metric?
		    if (metric instanceof ClassMetrics) {
				// apply IRI to class metric
				if (iriString != null) {
					ClassMetrics clsMetric = (ClassMetrics) metric;
					IRI iri = IRI.create(iriString);
					clsMetric.setIri(iri);
					System.out.println(iriString);
				}
				// create list of class IRIs
				StringBuilder str = new StringBuilder();
				str.append("<form action=\"ServletController\" name=\"classmetrics\"><p><select name=\"classmetric\" size=\"3\">");
				for (String namespace : namespaces) {
				    str.append("<option>");
				    str.append(namespace);
					str.append("</option>");
				}
				str.append("</select></p>");
				
				// button to compute
				str.append("<input type=\"submit\"></form>");
				
				// print
				out.print(str.toString());
		    }
		    
		    label = metric.getLabel();
		}
		
		out.print("<td>" + metric + ":</td>");
		out.print("<td>" + metric.getValue() + "</td>");
		out.print("</tr>");
	}
    out.print("</tr></table>");
%>
<body>
</html>