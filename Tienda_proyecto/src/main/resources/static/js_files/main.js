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


//---------------------------------- HTTPs HELPERS -----------------------------------------

function FindGetValue(Get_KeyName="") {
    var Get_KeyValue = null;

    // get url search content after "?" 
    //example: www.url?get_var=5
    //return : get_var=5
    var url_query = location.search.substring(1);

    //split vars and get in array
    var gets_vars = url_query.split("&");

    for (var i = 0; i < gets_vars.length; i++) {
        //divide la key from the value in item
        var var_key = gets_vars[i].split("=");

        // if key is equal to query key return value key
        if (var_key[0] == Get_KeyName) {
            //get value key
            Get_KeyValue = var_key[1];
            break;
        }
    }

    //return value key
    return Get_KeyValue;
}


function ajaxRequest(url, data = null, method = "GET") {

    var dataResponse = null;
    var HTTPError = {
        message: '',
        code: 0,
        success: false,
        data: null
    }
    
    if(data != null){
		data = JSON.stringify(data);
	}

    $.ajax({
        url: url,
        data: JSON.stringify(data),
        method: method,
        dataType: "json",
        headers: {
            'Content-Type': 'application/json'
        },
        async: false,
        success: function (response) {
            dataResponse = response;
        },
        error: function (jqXHR, exception) {
            HTTPError.code = jqXHR.status;
            HTTPError.data = jqXHR;
            HTTPError.message += "Request http Error: " + url + ", Exception: ";

            // http errors 
            if (jqXHR.status === 0) {
                HTTPError.message += 'Not connect.\n Verify Network.';
            } else if (jqXHR.status == 404) {
                HTTPError.message += 'Requested page not found. [404]';
            } else if (jqXHR.status == 500) {
                HTTPError.message += 'Internal Server Error [500].';
            } else if (jqXHR.status == 401) {
                HTTPError.message += 'Unauthorized Server Action [401].';
            }

            // exception errors
            else if (exception === 'parsererror') {
                HTTPError.message += 'Requested JSON parse failed.';
            } else if (exception === 'timeout') {
                HTTPError.message += 'Time out error.';
            } else if (exception === 'abort') {
                HTTPError.message += 'Ajax request aborted.';
            } else {
                HTTPError.message += jqXHR.responseText;
            }
            dataResponse = HTTPError;
            console.log(HTTPError);
        }
    });

    return dataResponse;
}