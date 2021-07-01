$(document).ready(function() {
    
    var emailId = $('#emailId'),
        name = $('#name'),
        occupation = $('#occupation'),
        age = $('#age');

    $('#addForm').on('submit', function(event) {
        var data = {
            emailId: emailId.val(),
            name: name.val(),
            occupation: occupation.val(),
            age: age.val()
        };

        /*
         * Persist the new key-value pair.         * Clear the inputs.
         * Set keyboard focus to key input: ready to start typing.
         */
        $.post('/add', data, function() {
            name.val('');
            emailId.val('');
            age.val('');
            occupation.val('');
            keyInput.focus();
            
        });
        $("#alert").show();
        setTimeout(function() { $("#alert").hide(); }, 1000);
        // 
        // $("#alert").fadeIn(3000);
       
        /* Prevent HTTP form submit */
        event.preventDefault();
        
       

    });
    

    /* Focus keyboard input into key input; ready to start typing */
    keyInput.focus();
});
