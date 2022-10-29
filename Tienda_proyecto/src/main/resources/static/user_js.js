alert("hola mundo");

function deleteUser(id){
	Swal.fire({
	  title: 'Estas Seguro?',
	  text: "Se eliminara este registro de forma permanente",
	  icon: 'warning',
	  showCancelButton: true,
	  confirmButtonColor: '#3085d6',
	  cancelButtonColor: '#d33',
	  confirmButtonText: 'Si, Eliminar!'
	}).then((result) => {
	  if (result.OK) {
		  
	  	$.ajax({
		  url: `users/delete/${id}`,
		  success: ()=>{
			   Swal.fire('Eliminado!','Archivo eliminado con exito!','success');
			   location.href="/users/index";
		  }
		});
	  }
	})
}