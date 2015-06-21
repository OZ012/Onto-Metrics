<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Ontology Metrics</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style/main.css">
</head>
<body>
	<div><!-- begin header -->
		<img src="img/unirostock240.png" alt="University of Rostock"/>
	</div><!-- end header -->
	
	
	<div><!-- begin main section -->
	<form action="ServletController" method="POST">
		<div id="src">
			<h1>Ontology Metrics</h1>
			<div>
				<p>Enter a URL or text.</p>
				<textarea name="text" rows="8" cols="48"></textarea>
			</div>
		</div>
		
		
		<div id="metrics"><!-- begin selecting metrics -->
			<!-- checkboxes to selecting metrics
			<p>Wählen Sie die Metriken aus, die Sie berechnen lassen möchten.</p>
			
			<p>
			<input type="checkbox" name="metric" value="base" checked="checked">Basismetriken<br>
			Basismetriken geben einen allgemeinen Überblick über...
			</p>
			
    		<input type="checkbox" name="metric" value="schema">Schema-Metriken<br>
    		<input type="checkbox" name="metric" value="knowledge">Knowledgebase-Metriken<br>
    		<input type="checkbox" name="metric" value="class">Klassen-Metriken<br>
    		<input type="checkbox" name="metric" value="graph">Graphen-Metriken
    		 -->
    	</div><!-- end selecting metrics -->
    	
    	<!-- submit button -->
    	<div id="submit">
			<input type="submit">
		</div>
	</form>
	</div><!-- end main section -->
	
	<!-- footer -->
	<div id="footer">
	<p>Powered by the <a href="http://owlapi.sourceforge.net/">OWL API</a></p>
	</div>
</body>
</html>