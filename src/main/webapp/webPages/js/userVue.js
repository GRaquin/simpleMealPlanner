function selectChange() {

    // On cache tous les champs de saisie
    hideInputsAndBr();

	// En fonction de l'action choisie, on affiche tel ou tel champs
	var opt = document.getElementById("listOfActions").value;
	switch (opt) {
	case "1":
	case "2":
	case "3":
		displaySpecificInput("mealName");
		displaySpecificInput("dynamicBr");
		break;

	case "4":
		displaySpecificInput("mealsCount");
		displaySpecificInput("dynamicBr");
		break;

	default:
	    hideInputsAndBr();
		break;
	}
}

function hideInputsAndBr() {

    // On cache tous les champs de saisie
    var inputs = document.getElementsByClassName("inputForm");
    for (var i = 0; i < inputs.length; i++) {
    	inputs[i].style.display = "none";
    }

    // On cache le saut de ligne dynamique
    var dynamicBr = document.getElementById("dynamicBr");
    dynamicBr.style.display = "none";
}

function displaySpecificInput(inputId) {

    // On affiche le champs demandé
    var input = document.getElementById(inputId);
    input.style.display = "block";
}