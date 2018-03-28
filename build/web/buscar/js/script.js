function ValidarFuncion() {
    var seleccionado = document.getElementById("funcion");
    if (seleccionado.options[seleccionado.selectedIndex].value > 1) {
        document.getElementById("valor2").style.display = 'none';
        document.getElementById("valor2L").style.display = 'none';
        document.getElementById("valor3").style.display = 'none';
        document.getElementById("valor3L").style.display = 'none';
    } else {
        document.getElementById("valor2").style.display = 'Block';
        document.getElementById("valor2L").style.display = 'Block';
        document.getElementById("valor3").style.display = 'Block';
        document.getElementById("valor3L").style.display = 'Block';

    }
    //var resultado = seleccionado.selectedIndex;
}


$(document).ready(function () {
    if (sessionStorage.getItem("nombre") !== null) {
//    $(".sesion").html();
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



    } else {
        $(".sesion").html("");
    }












    if (!localStorage.getItem("carrito"))
        localStorage.setItem("carrito", "{}");

});


$(".login").click(function () {
//    alert($( ".login").children().text().substring(8,13));
    if ($(".login").children().text().substring(8, 13) == "SALIR") {
        sessionStorage.removeItem("nombre");
        sessionStorage.removeItem("usuarioId");
//            if (!localStorage.getItem("carrito"))
        localStorage.removeItem("carrito");

        $(".sesion").html("");
        $(".login").html("						<a href=\"\">\n" +
                "							<span>INGRESAR</span>\n" +
                "							LOG IN\n" +
                "						</a>\n" +
                "");
    }
});






function AgregarAlCarrito(ProductoId) {
//        debugger;





    if (sessionStorage.getItem("nombre") !== null) {
//            debugger;
    } else {
        window.location.href = "../ingresar/ingresar.html";
        return;
    }








    var favoritos = JSON.parse(localStorage.getItem("carrito"));
//        var productoId = $(this).data("productoId");
//        if(favoritos[numeroProducto]){
//            delete favoritos[numeroProducto];
////            $(this).removeClass("glyphicon-star").addClass("glyphicon-star-empty");
//        }else{
    favoritos[ProductoId] = ProductoId;
//            $(this).removeClass("glyphicon-star-empty").addClass("glyphicon-star");
//        }
    localStorage.setItem("carrito", JSON.stringify(favoritos));


//    $("#agreg arAlCarrito"+ProductoId).css("Color","Blue");
    $("#agregarAlCarrito" + ProductoId).attr("onclick", "QuitarDelCarrito(" + ProductoId + "\)");
    $("#agregarAlCarrito" + ProductoId).html("Quitar del Carrito");
//    debugger;
}

function QuitarDelCarrito(ProductoId) {
//        debugger;
    var favoritos = JSON.parse(localStorage.getItem("carrito"));
//        var productoId = $(this).data("productoId");
//        if(favoritos[numeroProducto]){
//            delete favoritos[numeroProducto];
////            $(this).removeClass("glyphicon-star").addClass("glyphicon-star-empty");
//        }else{
    delete favoritos[ProductoId];
//            $(this).removeClass("glyphicon-star-empty").addClass("glyphicon-star");
//        }
    localStorage.setItem("carrito", JSON.stringify(favoritos));



//    $("#agregarAlCarrito"+ProductoId).css("Color","yellow");
//    $("#agregarAlCarrito"+ProductoId).css("color","blue");
    $("#agregarAlCarrito" + ProductoId).attr("onclick", "AgregarAlCarrito(" + ProductoId + "\)");
    $("#agregarAlCarrito" + ProductoId).html("Agregar al carrito");
//    debugger;
}


function testDrive(obj) {
//    alert(obj);
//        open('#','','top=300,left=300,width=300,height=300') ;
//?cid=username&pwd=password
//
//

//    if (sessionStorage.getItem("nombre") !== null) {
//        var varstr = "   <BR>     <form id=\"" +"F"+ obj + "\" >        \n"
//                    + "        <input id=\"date\" type=\"date\"  value=\"2017-06-01\">\n"
//                    + "        <input id=\"hora\" type=\"time\" name=\"hora\" value=\"14:00:00\" min=\"14:00:00\" max=\"19:00:00\" step=\"1\">\n <BR>"
//                    + "        <input  type=button onClick=\"confirmar("+ obj +");\" value=\"Confirmar\">\n "
//                    + "        <input  type=button onClick=\"cancelar("+ obj +");\" value=\"Cancel\">\n"
//                    + "        </form>\n"
//                    + "";
//        $("#E"+ obj).append(varstr);
//    } else {
//        window.location.href = "../ingresar/ingresar.html";
//    }

    if (sessionStorage.getItem("nombre") !== null) {
//            debugger;
        if ($("#F" + obj + "").length) {
//"#myDiv"
        } else { // en caso que no exista
//            var prueba 
            var varstr = "        <form id=\"" + "F" + obj + "\" >   <BR>     \n"
                    + "        <input id=\"date\" type=\"date\"  value=\"2017-06-01\">\n"
                    + " <select id=\"hora\"> " +
                    "  <option value=\"2\">2 p.m.</option> " +
                    "  <option value=\"3\">3 p.m.</option> " +
                    "  <option value=\"4\">4 p.m.</option> " +
                    "  <option value=\"5\">5 p.m.</option> " +
                    "  <option value=\"6\">6 p.m.</option> " +
                    "</select> "
                    + "        <input  type=button onClick=\"confirmar(" + obj + ");\" value=\"Confirmar\">\n "
                    + "        <input  type=button onClick=\"cancelar(" + obj + ");\" value=\"Cancel\">\n"
                    + "        </form>\n"
                    + "";
            $("#E" + obj).append(varstr);
        }
    } else {
        window.location.href = "../ingresar/ingresar.html";
    }
}
function confirmar(obj) {
//    alert(obj);  // aqui deberia hacer la validacion para confirmar el test Drive
    // obtener todos los valores dados
    var fecha = $("#F" + obj + " #date").val();
//   alert("confirmando con: "+ obj);
//    var seleccionado = document.getElementById("hora");
    var hora = $("#F" + obj + " #hora option:selected").text();
//    var hora = seleccionado.options[seleccionado.selectedIndex].value;
    var cliente = sessionStorage.getItem("usuarioId");
//   var hora =  $("#F" + obj +" #hora").val();
//    alert(fecha);
//    alert(hora);
//    alert(cliente);
    var horario = new Object();
    horario.fecha = fecha;
    horario.hora = hora;
    horario.id = obj; // Id del producto que va a realizar el test-drive
    horario.cliente = cliente; // Id del producto que va a realizar el test-drive
//    debugger;
    jQuery.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'type': 'POST',
        'url': "../api/pedido/RegistrarTestDrive" + "/" + "?q=" + (new Date()).getTime(),
        'data': JSON.stringify(horario),
        'dataType': 'json',
        'success': respuesta
    });
//            
    //    var hora = 
}


function respuesta(valor) { // 1 bien 2 no bien
    var nume = valor.nro
    if (nume > 1) { // perfect 
        alert("Horario Ocupado");
        //   $("#respuesta").html("Todo Ok");    
    } else { // problem
        alert("Su Test-Drive Fue programado Correctamente");
    }
}



function cancelar(obj) {
//    alert(obj);  // aqui deberia Ocultar la señalizacion del Test Drive
//        $("#F"+ obj).slideUp();
    $("#F" + obj).slideUp("normal", function () {
        $(this).remove();
    });

}


function filtrar() {
    var marca = document.getElementById("marca");
    var marcaLit = marca.options[marca.selectedIndex].value;
    var x = document.getElementById("modelo");
    var option = document.createElement("option");
    option.text = marcaLit;
    // x.add(option);
    // x.pop();
    var val = 0;

    if (marcaLit == "Alfa Romeo") {
        var val = ["Todos", "155", "156", "159", "164", "145", "147", "146", "Gtv", "Spider", "166", "Gt", "Crosswagon", "Brera", "90", "75", "33", "Giulietta", "Sprint", "Mito", "Q5", ]
    }
    if (marcaLit == "Audi") {
        var val = ["Todos", "80", "A4", "A6", "S6", "Coupe", "S2", "Rs2", "A8", "Cabriolet", "S8", "A3", "S4", "Tt", "S3", "Allroad Quattro", "Rs4", "A2", "Rs6", "Q7", "R8", "A5", "S5", "V8", "200", "100", "90", "Tts", "Q5", "A4 Allroad Quattro", "Tt Rs", "Rs5", "A1", "A7", "Rs3", "Q3", "A6 Allroad Quattro", "S7", "Sq5"]
    }
    if (marcaLit == "Bentley") {
        var val = ["Todos", "Brooklands", "Turbo", "Continental", "Azure", "Arnage", "Continental Gt", "Continental Flying Spur", "Turbo R", "Mulsanne", "Eight", "Continental Gtc", "Continental Supersports"]
    }
    if (marcaLit == "Bmw") {
        var val = ["Todos", "Serie 3", "Serie 5", "Compact", "Serie 7", "Serie 8", "Z3", "Z4", "Z8", "X5", "Serie 6", "X3", "Serie 1", "Z1", "X6", "X1", "Seville", "Sts", "El Dorado", "Cts", "Xlr", "Srx", "Escalade", "Bls"]
    }
    if (marcaLit == "Cadillac") {
        var val = ["Todos", "Seville", "Sts", "El Dorado", "Cts", "Xlr", "Srx", "Escalade", "Bls", ]
    }
    if (marcaLit == "Dodge") {
        var val = ["Todos", "Viper", "Caliber", "Nitro", "Avenger", "Caliber", "Journey"]
    }
    if (marcaLit == "Ferrari") {
        var val = ["Todos", "F355", "360", "F430", "F512 M", "550 Maranello", "575m Maranello", "599", "456", "456m", "612", "F50", "Enzo", "Superamerica", "430", "348", "Testarossa", "512", "355", "F40", "412", "Mondial", "328", "California", "458", "Ff"]
    }
    if (marcaLit == "Hyundai") {
        var val = ["Todos", "Lantra", "Sonata", "Elantra", "Accent", "Scoupe", "Coupe", "Atos", "H1", "Atos Prime", "Xg", "Trajet", "Santa Fe", "Terracan", "Matrix", "Getz", "Tucson", "I30", "Pony", "Grandeur", "I10", "I800", "Sonata Fl", "Ix55", "I20", "Ix35", "Ix20", "Genesis", "I40", "Veloster", ]
    }
    if (marcaLit == "Infiniti") {
        var val = ["Todos", "G", "Ex", "Fx", "M"]
    }
    if (marcaLit == "Jaguar") {
        var val = ["Todos", "Serie Xj", "Serie Xk", "Xj", "Stype", "Xf", "Xtype"]
    }
    if (marcaLit == "Jeep") {
        var val = ["Todos", "Wrangler", "Cherokee", "Grand Cherokee", "Commander", "Compass", "Wrangler Unlimited", "Patriot", "Patriot"]
    }
    if (marcaLit == "Lamborghini") {
        var val = ["Todos", "Gallardo", "Murcielago", "Aventador"]
    }
    if (marcaLit == "Land-rover") {
        var val = ["Todos", "Range Rover", "Defender", "Discovery", "Freelander", "Range Rover Sport", "Discovery 4", "Range Rover Evoque"]
    }
    if (marcaLit == "Lexus") {
        var val = ["Todos", "Ls400", "Ls430", "Gs300", "Is200", "Rx300", "Gs430", "Gs460", "Sc430", "Is300", "Is250", "Rx400h", "Is220d", "Rx350", "Gs450h", "Ls460", "Ls600h", "Ls", "Gs", "Is", "Sc", "Rx", "Ct"]
    }
    if (marcaLit == "Maserati") {
        var val = ["Todos", "Ghibli", "Shamal", "Quattroporte", "3200 Gt", "Coupe", "Spyder", "Gransport", "Granturismo", "430", "Biturbo", "228", "224", "Grancabrio"]
    }
    if (marcaLit == "Mercedes-benz") {
        var val = ["Todos", "Clase C", "Clase E", "Clase Sl", "Clase S", "Clase Cl", "Clase G", "Clase Slk", "Clase V", "Viano", "Clase Clk", "Clase A", "Clase M", "Vaneo", "Slklasse", "Slr Mclaren", "Clase Cls", "Clase R", "Clase Gl", "Clase B", "100d", "140d", "180d", "Sprinter", "Vito", "Transporter", "280", "220", "200", "190", "600", "400", "Clase Sl R129", "300", "500", "420", "260", "230", "Clase Clc", "Clase Glk", "Sls Amg"]
    }
    if (marcaLit == "Pontiac") {
        var val = ["Todos", "Trans Sport", "Firebird", "Trans Am"]
    }
    if (marcaLit == "Porsche") {
        var val = ["Todos", "911", "Boxster", "Cayenne", "Carrera Gt", "Cayman", "928", "968", "944", "924", "Panamera", "918"]
    }
    if (marcaLit == "Rolls-royce") {
        var val = ["Todos", "Siver Dawn", "Silver Spur", "Park Ward", "Silver Seraph", "Corniche", "Phantom", "Touring", "Silvier"]

    }





    document.getElementById('modelo').options.length = 0;

    for (var i = 0; i <= val.length - 1; i++) {
        var opt = document.createElement("option");
        opt.text = val[i];
        opt.value = val[i];
        x.add(opt);             
    }




}

function Realizar() {
    var valor1 = document.getElementById("valor1").value;
    var seleccionado = document.getElementById("funcion");
    //document.getElementById("msg-1").innerHTML = seleccionado.options[seleccionado.selectedIndex].value;
    var escogido = seleccionado.options[seleccionado.selectedIndex].value;
    var vlrResultado;
    if (escogido == 1) {
        valor1 = parseInt(document.getElementById("valor1").value);
        var valor2 = parseInt(document.getElementById("valor2").value);
        var valor3 = parseInt(document.getElementById("valor3").value);
//		document.getElementById("respuesta").innerHTML = (valor1+valor2+valor3);
        vlrResultado = nroMayor(valor1, valor2, valor3);
    }
    if (escogido == 2) {
        valor1 = parseInt(document.getElementById("valor1").value);
        vlrResultado = serie(valor1);
    }
    if (escogido == 3) {
        valor1 = parseInt(document.getElementById("valor1").value);
        vlrResultado = fibonacci(valor1);
    }
    if (escogido == 4) {
        valor1 = parseInt(document.getElementById("valor1").value);
        vlrResultado = primo(valor1);
        if (vlrResultado == false)
            vlrResultado = "FALSO"
    }
    if (escogido == 5) {
        valor1 = parseInt(document.getElementById("valor1").value);
        vlrResultado = Nprimo(valor1);
    }
    if (escogido == 6) {
        vlrResultado = Invertir(valor1);
    }
    if (escogido == 7) {
        valor1 = parseInt(document.getElementById("valor1").value);
        vlrResultado = factorial(valor1);
    }
    if (escogido == 8) {
        valor1 = parseInt(document.getElementById("valor1").value);
        vlrResultado = Binario(valor1);
    }

    if (typeof vlrResultado == "undefined") {
        vlrResultado = "Error en la forma tipeada, por favor ingrese los datos valores correctamente!"
    }
    if (vlrResultado) {
        document.getElementById("respuesta").innerHTML = vlrResultado;
    } else {
        document.getElementById("respuesta").innerHTML = "Error en la forma tipeada, por favor ingrese los datos valores correctamente!";
    }


//	return nroMayor(valor1,valor2,valor3);
}



function mostrarContactos(lista) {
    var ListaString = lista;
//    var objetoJson = $.parseJSON(ListaString);
//    debugger;
    $(".descripcionAuto").css("display", "block");
    $(".descripcionAuto").empty();
    if (lista.length < 1) {
        $(".descripcionAuto").append("No se encontro resultados");
    } else {
        $(".descripcionAuto").append("Resultados: ");
    }



    for (var i in lista) {
        var obj = lista[i];

        var strAgregar = "onclick= \"AgregarAlCarrito(" + obj.productoId + ")\" >Agregar al Carrito</button>";
        var strQuitar = "onclick= \"QuitarDelCarrito(" + obj.productoId + ")\" >QuitarDel al Carrito</button>";
        var favoritos = JSON.parse(localStorage.getItem("carrito"));
        if (favoritos[obj.productoId])
            strAgregar = strQuitar
        var strVar = "";
        strVar += "					<li id=\"" + "E" + obj.productoId + "\" >";
        strVar += "						<img src=\"" + obj.imagen + "\" alt=\"Banner\" class=\"imagenes\"> ";
        strVar += "						<p class=\"parrafoBusqueda descripcionDelAuto\">";
        strVar += "							<strong> " + obj.nombre + " <\/strong> ";
        strVar += "						<\/p>	";
        strVar += "						<p class=\"parrafoBusqueda PrecioDelAuto\">";
        strVar += "							<strong> Precio: <\/strong> $ " + obj.precio + "";
        strVar += "						<\/p>	";
        strVar += "						<p class=\"parrafoBusqueda Kilometraje\">";
        strVar += "							<strong> Recorrido:<\/strong> " + obj.kilometros + " km";
        strVar += "						<\/p>	";
        strVar += "						<p class=\"parrafoBusqueda Lugar\">";
        strVar += "							<strong> En:<\/strong>  " + obj.anho + "";
        strVar += "						<\/p>	";
        strVar += "						<p class=\"parrafoBusqueda descripcionHablada\">";
        strVar += "							" + obj.descripcion + "";
        strVar += "						<\/p>	";
        strVar += "						<!-- <i class=\"fa fa-shopping-cart\" aria-hidden=\"true\"><\/i> -->";
        strVar += "						<form action=\"Busqueda.html\" method=\"POST\" class=\"formAgregar\">";
        strVar += "							<button id=\"testdrive\" onclick=\"testDrive(" + obj.productoId + ")\" type=\"button\">Programar Test Drive</button>";
        strVar += "							<button id=\"agregarAlCarrito" + obj.productoId + "\" type=\"button\" " + strAgregar;
        strVar += "						<\/form>							";
        strVar += "					<\/li>";
//             $(".Lista_Busqueda")               
        $(".Lista_Busqueda").append(strVar);
    }



}
//var a = 8;

function prueba() {
//    $(".descripcionHablada").html("PRUEBA DOS");
//    $.getJSON("../api/producto/?q=" +(new Date()).getTime(), null, mostrarContactos);
//    var jeson = {"one": "Singular sensation","two": "Beady little eyes","three": "Little birds pitch by my doorstep"}

//    $.getJSON("../api/producto/prueba2?q=" +(new Date()).getTime(), "JORGE HUGO" , mostrarContactos);

//    $.getJSON("api/producto/cat/5?q=" +(new Date()).getTime(), null, mostrarContactos);
}
function ejecutarQuery() {
//    $(".descripcionHablada").html("PRUEBA DOS");

    var seleccionadoM = $("#marca option:selected");
    var marca = seleccionadoM.val();
    var selecmodelo = $("#modelo option:selected");
    var modelo = selecmodelo.val();
    var selecdesde = $("#AñoMin option:selected");
    var desde = selecdesde.val();
    var selecthasta = $("#AñoMax option:selected");
    var hasta = selecthasta.val();
    var selecKmMin = $("#KilometrajeMin option:selected");
    var kmMin = selecKmMin.val();
    var selecKmMax = $("#KilometrajeMax option:selected");
    var kmMax = selecKmMax.val();
//        if(marca)
    if (typeof modelo === "undefined") {
        modelo = "Todos"
    }


    marca = marca.replace(/ /g, "_");
    modelo = modelo.replace(/ /g, "_");
    $(".Lista_Busqueda").empty();
    $.getJSON("../api/producto/Busqueda/" + marca + "/" + modelo + "/" + desde + "/" + hasta + "/" + kmMin + "/" + kmMax + "/" + "?q=" + (new Date()).getTime(), null, mostrarContactos);


    $.getJSON("../api/producto/Busqueda/" + marca + "/" + modelo + "/" + desde + "/" + hasta + "/" + kmMin + "/" + kmMax + "/" + "?q=" + (new Date()).getTime(), null, mostrarContactos);



}

$(document).ready(function () {
    prueba();
});


$("Buscar").click(function () {
    ejecutarQuery();
});