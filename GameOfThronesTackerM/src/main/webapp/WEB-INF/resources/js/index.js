// This is the javascript page to manage index.html and writer.html
// We focus on calling the Spring controllers on form submits


$(document).ready(function () {
    // Initialize tabs
    $('.menu .item')
        .tab()
        ;

    // Set tab action to move to respective tab on click
    $('.ui .item').on('click', function () {
        $('.ui .item').removeClass('active');
        $(this).addClass('active');
    });

    $(".killButton").click(function () {
        var $killName = $(this).closest("tr")   // Finds the closest row <tr> 
            .find(".cn")     // Gets a descendent with class="nr"
            .text();         // Retrieves the text within <td>

            window.location.href = '$(contextPath)/killchar/' + killName;
    });


});



function submitChar() {
    var cName = $(charName).val();
    window.location.href = '$(contextPath)/charcall/' + cName;
}

function submitHouse() {
    var hName = $(houseName).val();
    window.location.href = '$(contextPath)/housecall/' + hName;
}

function submitFaction() {
    var fName = $(factionName).val();
    window.location.href = '$(contextPath)/factioncall/' + fName;
}

function submitCreateChar() {
    var newCName = $(cName).val();
    var newCTitle = $(cTitle).val();
    var newCStatus = $(cStatus).val();
    var newCReligion = $(cReligion).val();
    window.location.href = '$(contextPath)/createcharcall/'+ newCName + "/" + newCTitle + "/" + newCStatus + "/" + newCReligion;
}
