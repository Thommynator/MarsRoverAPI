// button events
let roverButtons = document.getElementsByName('rover-button');
roverButtons.forEach(button => {
    button.addEventListener('click', () =>  {
        document.getElementById('selected-rover').value =  button.value;

        // deselect all buttons:
        document.getElementsByName('rover-button').forEach(b => {
            b.classList.add('btn-primary');
            b.classList.remove('btn-secondary');
        });

        // select only the clicked one
        button.classList.add('btn-secondary');
    });
});