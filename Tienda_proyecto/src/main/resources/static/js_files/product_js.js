
// ----------------------------- SUCCESS VALIDATION ---------------------------------------------

if(FindGetValue("successCreate") != null){
	 Swal.fire('!Registro creado con exito!','','success')
	 .then((result) => {
	 	location.assign(`/products/index`);
	 });
}

if(FindGetValue("successUpdate") != null){
	 Swal.fire('!Registro actualizado con exito!','','success')
	 .then((result) => {
	 	location.assign(`/products/index`);
	 });
}

if(FindGetValue("successDelete") != null){
	 Swal.fire('!Registro eliminado con exito!','','success')
	 .then((result) => {
	 	location.assign(`/products/index`);
	 });
}


// ----------------------------- EVENTS ---------------------------------------------

$("#Cat_Id").dropdown();


// ----------------------------- CRUD METHODS ---------------------------------------------
function createProduct(){
	validateArrayForm = [
        { validateMessage: "Ingrese un nombre de producto", Jqueryinput: $("#Pro_Descripcion") },
        { validateMessage: "Seleccione una categoria", Jqueryinput: $("#Cat_Id") },
        { validateMessage: "Ingrese un precio de compra", Jqueryinput: $("#Pro_Precio_Compra") },
        { validateMessage: "Ingrese un precio de venta", Jqueryinput: $("#Pro_Precio_Venta") }
    ];

    // retorna bool 
    const ValidateFormStatus = ValidateForm(validateArrayForm);
    
    if(ValidateFormStatus){
		$("#frmCreateProduct").submit();
	}
}
