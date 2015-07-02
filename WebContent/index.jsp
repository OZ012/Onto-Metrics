<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Ontology Metrics</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style/main.css">
</head>
<body>
	<div>
		<!-- begin header -->
		<img src="img/unirostock240.png" alt="University of Rostock" />
	</div>
	<!-- end header -->

	<header> <a href="../JSPWiki" target="_blank">Wiki</a> | <a
		href="http://ontometrics.freeforums.net/" target="_blank">Forum</a> </header>

	<div>
		<!-- begin main section -->
		<form action="ServletController" method="POST">
			<div id="src">
				<h1>Ontology Metrics</h1>
				<div>
					<textarea id="text" name="text" rows="16" cols="100">Enter a URL or text.</textarea>
				</div>
			</div>




			<div id="metrics">
				<!-- begin selecting metrics -->
				<!-- checkboxes to selecting metrics-->
				<p>
					<br>Wählen Sie die Metriken aus, die Sie berechnen lassen
					möchten.
				</p>

				<p>
					<input type="checkbox" name="metric" value="base" checked="checked">Basismetriken<br>
					<input type="checkbox" name="metric" value="schema">Schema-Metriken<br>
					<input type="checkbox" name="metric" value="knowledge">Knowledgebase-Metriken<br>
					<input type="checkbox" name="metric" value="class">Klassen-Metriken<br>
					<input type="checkbox" name="metric" value="graph">Graphen-Metriken

				
			</div>
			<!-- end selecting metrics -->

			<!-- submit button -->
			<div id="submit">
				<input type="submit">
			</div>
		</form>


		<p>
			Upload a *.rdf file:<br>
		</p>
		<form id="fileinput" name="fileupload" enctype="multipart/form-data"
			method="post">
			<fieldset>
				<input type="file" name="fileselect" id="fileselect"></input> <input
					id="uploadbutton" onclick="upload()" type="button"
					value="Upload" />
			</fieldset>
		</form>

		<script>
			function upload(evt) {

				//Retrieve the first (and only!) File from the FileList object
				 var input = document.getElementById('fileselect');
                 var f = input.files[0];
				if (f) {
					var r = new FileReader();
					r.onload = function(e) {
						var contents = e.target.result;
						document.getElementById('text').value = contents;
					}
					r.readAsText(f);
				} else {
					alert("Failed to load file");
				}
			}
			document.getElementById('uploadbutton').addEventListener('onclick',
                    upload, false);
		</script>


	</div>
	<!-- end main section -->

	<!-- footer -->
	<div id="footer">
		<p>
			Powered by the <a href="http://owlapi.sourceforge.net/">OWL API</a>
		</p>
	</div>

	<div id="impressum">
		<a href="http://www.informatik.uni-rostock.de/index.php?id=2171"
			target="_blank">Impressum</a>
	</div>
</body>
</html>