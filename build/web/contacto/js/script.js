
function ValidarFuncion(){
	var seleccionado = document.getElementById("funcion");
	if(seleccionado.options[seleccionado.selectedIndex].value > 1){
		document.getElementById("valor2").style.display = 'none';
		document.getElementById("valor2L").style.display = 'none';					
		document.getElementById("valor3").style.display = 'none';		
		document.getElementById("valor3L").style.display = 'none';		
	}else{
		document.getElementById("valor2").style.display = 'Block';
		document.getElementById("valor2L").style.display ='Block';					
		document.getElementById("valor3").style.display = 'Block';		
		document.getElementById("valor3L").style.display ='Block';		
		
	}
	//var resultado = seleccionado.selectedIndex;
}
$( document ).ready(function() {
    if(sessionStorage.getItem("nombre") !== null){
        $(".sesion").html("<i class=\"fa fa-shopping-cart\" aria-hidden=\"true\"></i>" + "       " + sessionStorage.getItem("nombre"));
        $(".login").html("						<a href=\"\">\n" +
                "							<span>SALIR</span>\n" +
                "							Log out\n" +
                "						</a>\n" +
                "");
//        window.location.href = "../ingresar/ingresar.html";

        $(".fa-shopping-cart").click(function () {
        window.location.href = "../carrito/carrito.html";
        });
     
    }else{
    $(".sesion").html("");                
    }
});


$(".login").click(function() {
//    alert($( ".login").children().text().substring(8,13));
  if($( ".login").children().text().substring(8,13) == "SALIR"){
   sessionStorage.removeItem("nombre");
   sessionStorage.removeItem("usuarioId");
    $(".sesion").html("");        
    $(".login").html("						<a href=\"\">\n" +
    "							<span>INGRESAR</span>\n" +
    "							LOG IN\n" +
    "						</a>\n" +
    "");  
    }
});







function Realizar(){
		var valor1 = document.getElementById("valor1").value;
	var seleccionado = document.getElementById("funcion");
	//document.getElementById("msg-1").innerHTML = seleccionado.options[seleccionado.selectedIndex].value;
	var escogido = seleccionado.options[seleccionado.selectedIndex].value;
	var vlrResultado;
	if(escogido==1){
		valor1 = parseInt(document.getElementById("valor1").value);
		var valor2 = parseInt(document.getElementById("valor2").value);
		var valor3 = parseInt(document.getElementById("valor3").value);
//		document.getElementById("respuesta").innerHTML = (valor1+valor2+valor3);
		vlrResultado = nroMayor(valor1,valor2,valor3);
	}
	if(escogido==2){
		valor1 = parseInt(document.getElementById("valor1").value);
		vlrResultado = serie(valor1);
	}
	if(escogido==3){
		valor1 = parseInt(document.getElementById("valor1").value);
		vlrResultado = fibonacci(valor1);
	}
	if(escogido==4){
		valor1 = parseInt(document.getElementById("valor1").value);
		vlrResultado = primo(valor1);
		if(vlrResultado == false)
			vlrResultado ="FALSO"
	}
	if(escogido==5){
		valor1 = parseInt(document.getElementById("valor1").value);
		vlrResultado = Nprimo(valor1);
	}
	if(escogido==6){
		vlrResultado = Invertir(valor1);
	}
	if(escogido==7){
		valor1 = parseInt(document.getElementById("valor1").value);
		vlrResultado = factorial(valor1);
	}
	if(escogido==8){
		valor1 = parseInt(document.getElementById("valor1").value);
		vlrResultado = Binario(valor1);
	}
	
	if(typeof vlrResultado == "undefined") {
		vlrResultado = "Error en la forma tipeada, por favor ingrese los datos valores correctamente!"
	}
	if(vlrResultado){
	document.getElementById("respuesta").innerHTML = vlrResultado;		
	}else{
		document.getElementById("respuesta").innerHTML = "Error en la forma tipeada, por favor ingrese los datos valores correctamente!";	
	}
	
	
//	return nroMayor(valor1,valor2,valor3);
}

