/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
function navegar(url) {
    try {
        if (typeof _checkeoCambiosHabilitado == 'undefined' || _checkeoCambiosHabilitado == false)
                cargando();
        window.location.href=url;
    } catch (e) {}
}

    function submitForm(url) {

            // en caso de que hayan componentes optionTransferSelect,
            // se deben seleccionar todos los options de los select para hacer el submit.

            var myForm = document.getElementsByTagName("form")[0];

            myForm.action = url;
            try { //- Hack para el IE6
                
              myForm.submit();
            } catch (e) {}
	}

