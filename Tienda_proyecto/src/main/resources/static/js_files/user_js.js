
function deleteUser(id){
	sweetAlertconfirm(
		title = "Estas Seguro?", 
		message = "Se eliminara este registro de forma permanente", 
		type = "warning", 
		successfunction = () => { 
			$.ajax({
				method: "GET",
			    url: `/users/delete/${id}`,
			    success: ()=>{
				     Swal.fire('Eliminado!','Archivo eliminado con exito!','success');
				     location.href="/users/index";
				}
			});
		}
	);
}


function createUser(){
	validateArrayForm = [
        { validateMessage: "Ingrese un nombre de usuario", Jqueryinput: $("#Usu_Usuario") },
        { validateMessage: "Ingrese una contraseña valida", Jqueryinput: $("#Usu_Clave") },
        { validateMessage: "Ingrese un nombre.", Jqueryinput: $("#Usu_Nombre") },
        { validateMessage: "Ingrese un apellido", Jqueryinput: $("#Usu_Apellidos") }
    ];

    // retorna bool 
    const ValidateFormStatus = ValidateForm(validateArrayForm);
    
    if(ValidateFormStatus){
		$("#frmCreateUser").submit();
	}
}

