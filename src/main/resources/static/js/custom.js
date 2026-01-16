/**
 * Obtiene el año actual para mostrarlo en el pie de página.
 * Actualiza el elemento con ID 'displayYear'.
 */
function getYear() {
    var currentDate = new Date();
    var currentYear = currentDate.getFullYear();
    document.querySelector("#displayYear").innerHTML = currentYear;
}

getYear();