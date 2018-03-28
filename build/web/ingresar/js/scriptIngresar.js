
//var a = 8;

function prueba(valor){ // 1 bien 2 no bien
    var nume = valor.usuarioId
    if(nume > 1){
 //   $("#respuesta").html("Todo Ok");    
        sessionStorage.setItem("usuarioId", nume);
        sessionStorage.setItem("nombre", valor.userName);
//        sessionStorage.getItem("usuarioId");
//        sessionStorage.removeItem("usuarioId");
        var url = "http://localhost:9090/LuxuryCars/index/index.html"; 
        $(location).attr('href',url);
    }else{
        $("#respuesta").html("Error al ingresar");        
    }
}
function ejecutarQuery(){
//    var myObject = new Object();
//myObject.name = "John";
//myObject.age = 12;
//myObject.pets = ["cat", "dog"];
    var nombreUsuario = $("#nombreUsuario").val();
    var contraseña = $("#contraseña").val();
    var usuario = new Object();
    usuario.usuarioId = 1;
    usuario.userName = nombreUsuario;
    usuario.password = contraseña;
//var valor = {"qty":999,"name":"iPad 3"};

jQuery.ajax({
    headers: { 
        'Accept': 'application/json',
        'Content-Type': 'application/json' 
    },
    'type': 'POST',
    'url': "../api/usuario/getUsuario"+"/"+"?q=" +(new Date()).getTime(),
    'data': JSON.stringify(usuario),
    'dataType': 'json',
    'success': prueba
    });

//   
//$.postJSON = function(url, data, callback) {
//    return jQuery.ajax({
//    headers: { 
//        'Accept': 'application/json',
//        'Content-Type': 'application/json' 
//    },
//    'type': 'POST',
//    'url': url,
//    'data': JSON.stringify(data),
//    'dataType': 'json',
//    'success': callback
//    });
//};

//       $.post(,usuario,prueba, 'json');
//    private String userName;
//    private String password;
//    private String direccion;
//    private String fechaIngreso;
//    private String NroTarjeta;
						  <!--<INPUT type="text" id="nombre">-->						  
						  <!--<INPUT type="text" id="Apellido">-->						  
						  <!--<INPUT type="text" id="nombreUsuario">-->						  
						  <!--<INPUT type="text" id="Tarjeta">-->						  
						  <!--<INPUT type="text" id="Direccion">-->						  
						  <!--<INPUT type="password" id="contraseña">-->						  
						  <!--<INPUT type="password" id="contraseña2">-->						  
				  
    
    
    
}
// $("button").click(function(){
//    $.post("demo_test.asp", function(data, status){
//        alert("Data: " + data + "\nStatus: " + status);
//    });
//}); 
