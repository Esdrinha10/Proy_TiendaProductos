
// ----------------------------- SUCCESS VALIDATION ---------------------------------------------

if(FindGetValue("successCreate") != null){
	 Swal.fire('!Registro creado con exito!','','success')
	 .then((result) => {
	 	location.assign(`/categories/index`);
	 });
}

if(FindGetValue("successUpdate") != null){
	 Swal.fire('!Registro actualizado con exito!','','success')
	 .then((result) => {
	 	location.assign(`/categories/index`);
	 });
}

if(FindGetValue("successDelete") != null){
	 Swal.fire('!Registro eliminado con exito!','','success')
	 .then((result) => {
	 	location.assign(`/categories/index`);
	 });
}

// ----------------------------- EVENTS ---------------------------------------------

$("#btnCreateCategory").click(function(){
	$("#mdlSaveCategory").modal("show");
	$("#mdlSaveCategory #Cat_Id").val("");
	$("#mdlSaveCategory #Cat_Descripcion").val("");
	$("#mdlSaveCategory #tittle").html("Crear categoria");
	$("#frmSaveCategory").prop("action","/categories/save");
});

$("#mdlSaveCategory #btnSave").click(saveCategory);


// ----------------------------- CRUD METHODS ---------------------------------------------
function saveCategory(){
	validateArrayForm = [
        { validateMessage: "Ingrese un nombre a la descripcion", Jqueryinput: $("#Cat_Descripcion") },
    ];

    // retorna bool 
    const ValidateFormStatus = ValidateForm(validateArrayForm);
    
    if(ValidateFormStatus){
		$("#frmSaveCategory").submit();
	}
}


function editCategory(id){
	const request = ajaxRequest(`/categories/getCategories?id=${id}`);
	const category = request[0];
	
	$("#frmSaveCategory").prop("action","/categories/update");
	$("#mdlSaveCategory #Cat_Id").val(category.cat_Id);
	$("#mdlSaveCategory #Cat_Descripcion").val(category.cat_Descripcion);
	$("#mdlSaveCategory").modal("show");
	$("#mdlSaveCategory #tittle").html("Actualizar categoria");
	
}

function deleteCategory(id){
	sweetAlertconfirm(
		title = "Estas Seguro?", 
		message = "Se eliminara este registro de forma permanente", 
		type = "warning", 
		successfunction = () => { 
			location.assign(`/categories/delete/${id}`);
		}
	);
}

