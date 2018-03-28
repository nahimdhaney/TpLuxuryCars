
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
});


$(".login").click(function () {
//    alert($( ".login").children().text().substring(8,13));
    if ($(".login").children().text().substring(8, 13) == "SALIR") {
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
