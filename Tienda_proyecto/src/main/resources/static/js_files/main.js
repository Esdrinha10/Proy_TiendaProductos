$("#grdData").DataTable({
	responsive: true,
    language: {
        "url": "https://cdn.datatables.net/plug-ins/1.10.21/i18n/Spanish.json"
    }
});

function ValidateForm(inputArray = [], reset = false) {
    var Validate = [];

    if (reset) {
        const parent = $(item.Jqueryinput).parents(".field")[0];
        $.each(inputArray, function (i, item) {

            $(parent).find("span.labelvalidator").remove();
            $(parent).removeClass("error");
            $(item.Jqueryinput).val("");

        });

        return true;
    } else {
        //recorre cada input en array
        $.each(inputArray, function (i, item) {

            var parent = $(item.Jqueryinput).parents(".field")[0];
            var empty = false;
            //crea span item
            var labelvalidator = document.createElement("span");
            labelvalidator.className = "labelvalidator";
            labelvalidator.innerText = item.validateMessage;

            //valida tipo de inpur y si esta vacio 
            if (item.check == true) { //check box o radio button
                parent = $(item.Jqueryinput).parents(".checkButton_container")[0];

                if ($(item.Jqueryinput).find(":checked").length == 0) {
                    empty = true;
                }
            }
            else if (item.file == true) { //input file
                if ($(item.Jqueryinput).prop("files")[0] == undefined || $(item.Jqueryinput).prop("files")[0] == null) {
                    empty = true;
                }
            }
            else { //inputs(text,number...), selects
                if ($(item.Jqueryinput).val() == 0 || $(item.Jqueryinput).val() == null) {
                    empty = true;
                }
            }

            //ajecuta funcionalidad de label
            if (empty) {
                if ($(parent).find("span.labelvalidator").length == 0) {
                    $(parent).append(labelvalidator);
                }

                $(parent).addClass("error");

                //añade item de status sobre el input actual
                Validate.push(
                    { item: item.Jqueryinput, status: false }
                );

            } else {
                //si valor de input esta llena remueve spam de error
                $(parent).find("span.labelvalidator").remove();
                $(parent).removeClass("error");

                //añade item de status sobre el input actual
                Validate.push(
                    { item: item.Jqueryinput, status: true }
                );
            }

        });

        //filtra status items en false
        var statusFilter = jQuery.grep(Validate, function (item, i) {
            return item.status == false;
        });

        if (statusFilter.length == 0) {
            return true;
        }

        return false;
    }

}
    
    
//---------------------------------- SWEET ALERT -----------------------------------------
function sweetAlertconfirm(title = "An error ocurred", message = "", type = "error", successfunction = () => { alert("prueba"); }) {
    Swal.fire({
        title: title,
        text: message,
        icon: type,
        showCancelButton: true,
        confirmButtonColor: '#c8102f',
        cancelButtonColor: '#6c757d',
        confirmButtonText: 'Confirmar',
        cancelButtonText: 'Cancelar',
    }).then((result) => {
        if (result.isConfirmed) {
            successfunction();
        }
    })
}