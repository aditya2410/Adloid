/**
 * Create HTML table row.
 *
 * \param text (str) HTML code to be placed inside the row.
 */
 function tr(text) {
    return '<tr>' + text + '</tr>';
}

/**
 * Create HTML table cell element.
 *
 * \param text (str) The text to be placed inside the cell.
 */
function td(text) {
    return '<td>' + text + '</td>';
}

/**
 * Create HTML table row element.
 *
 * \param key (str) text into the key cell.
 * \param value (str) text into the value cell.
 */
function row(key, value) {
    return $(
        tr(
            td(key) +
            td(value)));
}
$(document).ready(function() {
    
    var emailId = $('#emailId');
    

    $('#getForm').on('submit', function(event) {
        var data = {
            emailId: emailId.val(),
        };

        /*
         * Persist the new key-value pair.         * Clear the inputs.
         * Set keyboard focus to key input: ready to start typing.
         */
        $.get('/user?emailId='+emailId.val() , function(data) {
            var attr,
            mainTable = $('#mainTable tbody');
            
            mainTable.empty();
            // alert(data.constructor)
            // console.log(Object.keys(data).length === 0);
            if(Object.keys(data).length === 0){
                
                $("#alert").show();
                setTimeout(function() { $("#alert").hide(); }, 10000);
            }else{
                for (attr in data) {
                    if (data.hasOwnProperty(attr)) {
                        mainTable.append(row(attr, data[attr]));
                    }
                }
            }
            
            emailId.focus();
            
        });
        
        
        // $("#alert").fadeIn(3000);
       
        /* Prevent HTTP form submit */
        event.preventDefault();
        
       

    });
    

    /* Focus keyboard input into key input; ready to start typing */
    keyInput.focus();
});
