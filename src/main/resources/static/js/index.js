// button events
let roverButtons = document.getElementsByName('rover-button');
roverButtons.forEach(button => {
    button.addEventListener('click', () =>  {
        document.getElementById('rover').value =  button.value;

        // deselect all buttons:
        document.getElementsByName('rover-button').forEach(b => {
            b.classList.add('btn-primary');
            b.classList.remove('btn-secondary');
        });

        // select only the clicked one
        button.classList.add('btn-secondary');


        // update cameras when rover button is clicked
        updateCameraSelection(button.value);
    });
});


function updateCameraSelection(rover) {
    $.get("cameras-for/" + rover).done(function(fragment) { // get from controller
        $("#camera-selection").replaceWith(fragment); // update snippet of page
    });
}