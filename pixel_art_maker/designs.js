// Select color input
// Select size input

// When size is submitted by the user, call makeGrid()
submit = document.querySelector("#submit");
submit.addEventListener('click', makeGrid, true);

function makeGrid(event) {
    event.preventDefault();
    const canvas1 = document.querySelector("#pixelCanvas");
    canvas1.remove();
    const designHeading = document.querySelector("#designCanvas");
    designHeading.appendChild(document.createElement('table'));
    designHeading.lastChild.setAttribute("id", "pixelCanvas");
    const canvas = document.querySelector("#pixelCanvas");
    const height = document.getElementById("inputHeight").value;
    const width = document.getElementById("inputWidth").value;
    for (var x = 1; x <= height; x++) {
        canvas.appendChild(document.createElement('tr'));
        for (var y = 1; y <= width; y++) {
            const tableRow = canvas.lastChild;
            tableRow.appendChild(document.createElement('td'));
            const tableCell = tableRow.lastChild;
            tableCell.addEventListener('click', function() {
                console.log("The cell was clicked");
                const color = document.getElementById("colorPicker").value;
                tableCell.style.backgroundColor = color;
            }, true);
        }
    }
};

   





// add an event listener to each cell
// listener should listen for a click and then execute a function to change
// the color to the color value from the color picker




// submit = document.querySelector("#submit");

// submit.addEventListener('click', function(event) {
//     event.preventDefault();
//     const canvas1 = document.querySelector("#pixelCanvas");
//     canvas1.remove();
//     const designHeading = document.querySelector("#designCanvas");
//     designHeading.appendChild(document.createElement('table'));
//     designHeading.lastChild.setAttribute("id", "pixelCanvas");
//     const canvas = document.querySelector("#pixelCanvas");
//     const height = document.getElementById("inputHeight").value;
//     const width = document.getElementById("inputWidth").value;
//     for (var x = 1; x <= height; x++) {
//         canvas.appendChild(document.createElement('tr'));
//         for (var y = 1; y <= width; y++) {
//             const tableRow = canvas.lastChild;
//             tableRow.appendChild(document.createElement('td'));
//             const tableCell = tableRow.lastChild;
//             tableCell.addEventListener('click', function() {
//                 console.log("The cell was clicked");
//                 const color = document.getElementById("colorPicker").value;
//                 tableCell.style.backgroundColor = color;
//             }, true);
//         }
//     };
// }, true);