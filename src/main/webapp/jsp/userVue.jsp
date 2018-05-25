<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
        <link rel="stylesheet" type="text/CSS" href="userVue.css"/>
        <script type="text/javascript" src="userVue.js"></script>
        <title>Meal Planner</title>
    </head>
    <body>
        <div id="container">
        	<h1 id="title">Meal Planner</h1>
        	<form action="toto" method="post" id="formulaire">
        		<div id="divDynamicList">
        			<select name="selectOption" id="dynamicList">
        				<option value="0" class="elmtFilter">Choisir une action</option>
        				<option value="1" class="elmtFilter">Create a new meal</option>
        				<option value="2" class="elmtFilter">Delete a meal</option>
        				<option value="3" class="elmtFilter">Edit a meal</option>
        				<option value="4" class="elmtFilter">Create a Meal Planl</option>
        			</select>
        		</div>

        		<div id="continueButton">
        		    <input type="submit" value="Continue" class="button"/>
        		</div>
        	</form>
        </div>
    </body>
</html>