function mostrar(row) {
	swal({
        title: 'Realizar una oferta',
        html:'<div class="form-group has-info">' +
        '<input id="input-field" type="text" class="form-control" />' +
        '</div>',
        showCancelButton: true,
        confirmButtonText: 'Ofertar',
        cancelButtonText: 'Cancelar',
        confirmButtonClass: 'btn btn-info',
        cancelButtonClass: 'btn btn-danger',
        buttonsStyling: false
    }).then(function(result) {
    		var input = $('#input-field').val();
    		console.log(input);
    		document.getElementById("frm:target").value = input;
    		var exect = document.getElementById("frm:tbl:"+ row +":btnGA");
    		exect.click();
    		swal({
                title: "Listo",
                text: "Oferta Realizada!",
                buttonsStyling: false,
                confirmButtonClass: "btn btn-success",
                type: "success"
            })
    }).catch(swal.noop)
}

function saveAl(row) {
	swal({
        title: 'Escribir Reporte',
        html:'<div class="form-group">' +
        '<input id="input-field" type="text" class="form-control" />' +
        '</div>',
        showCancelButton: true,
        confirmButtonText: 'Guardar',
        cancelButtonText: 'Cancelar',
        confirmButtonClass: 'btn btn-info',
        cancelButtonClass: 'btn btn-danger',
        buttonsStyling: false
    }).then(function(result) {
    		var input = $('#input-field').val();
    		document.getElementById("frm:target").value = input;
    		var exect = document.getElementById("frm:tbl:"+row+":btnGA");
    		exect.click();
    		swal({
                title: "Listo",
                text: "Reporte Guardado!",
                buttonsStyling: false,
                confirmButtonClass: "btn btn-success",
                type: "success"
            })
    }).catch(swal.noop)
}

function deleteAl(row){
    swal({
        title: '¿Está seguro?',
        text: 'No podrás recuperar los datos!',
        type: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Eliminar',
        cancelButtonText: 'Cancelar',
        confirmButtonClass: "btn btn-success",
        cancelButtonClass: "btn btn-danger",
        buttonsStyling: false
    }).then(function() {
    		var exect = document.getElementById("frme:tble:"+row+":btnD");
		exect.click();
        swal({
            title: 'Eliminado!',
            text: 'Dato eliminado.',
            type: 'success',
            confirmButtonClass: "btn btn-success",
            buttonsStyling: false
        }).catch(swal.noop)
    }, function(dismiss) {
        // dismiss can be 'overlay', 'cancel', 'close', 'esc', 'timer'
        if (dismiss === 'cancel') {
            swal({
                title: 'Cancelado',
                text: 'Los datos están a salvo.',
                type: 'error',
                confirmButtonClass: "btn btn-info",
                buttonsStyling: false
            }).catch(swal.noop)
        }
    })

}