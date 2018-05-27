<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
        <link rel="stylesheet" type="text/CSS" href="webPages/css/userVue.css"/>
        <script type="text/javascript" src="webPages/js/userVue.js"></script>
        <title>Meal Planner</title>
    </head>
    <body>
        <div id="container">
        	<h1 id="title">Meal Planner</h1>
        	<form action="controllerServlet" method="post" id="formulaire">
        		<div id="divDynamicList">
        			<select name="selectOption" id="listOfActions" onchange="selectChange();">
        				<option value="0" class="elmtFilter">Choisir une action</option>
        				<option value="1" class="elmtFilter">Créer un repas</option>
        				<option value="2" class="elmtFilter">Supprimer un repas</option>
        				<option value="3" class="elmtFilter">Modifier un repas</option>
        				<option value="4" class="elmtFilter">Générer un planning de repas</option>
        			</select>
        		</div>

                <br/>

                <div class="inputForm" id="mealName">
                    Nom du repas : <input type="text" name="mealName">
                </div>

                <div class="inputForm" id="mealsCount">
                    Nombre de repas à planifier : <input type="number" name="mealsCount">
                </div>

                <br id="dynamicBr"/>

        		<div id="continueButton">
        		    <input type="submit" value="Valider" class="button"/>
        		</div>
        	</form>
        </div>
    </body>
</html>