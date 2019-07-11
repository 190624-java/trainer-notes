/* The goal of this page is a user can submit information to the form and have their information added to the table */

function addToTable(newPerson){
    //Create necessary elements
    let newRow = document.createElement('tr');
    let fnCol = document.createElement('td');
    let lnCol = document.createElement('td');
    let fcCol = document.createElement('td');

    //add additional specifications for those elements
    fnCol.innerText = newPerson && newPerson.fname; //using the guard operator here prevents possible null pointer exception.
    lnCol.innerText = newPerson && newPerson.lname;
    fcCol.innerText = newPerson && newPerson.fcolor;

    //the following sets the favorite color column
    //to display with a background color matching the color
    //selected
    fcCol.style = 'color:white; font-weight: bolder; background-color:' + (fcCol.innerText || 'white');

    //nest td elements in tr element
    newRow.appendChild(fnCol);
    newRow.appendChild(lnCol);
    newRow.appendChild(fcCol);

    //insert the newRow element into the document.
    let table = document.getElementsByTagName('table').item(0);
    table.appendChild(newRow);
    console.log('A new row has been added to the table!');
}

function getFormInput() {
    let fname = document.getElementById('fn-input').value;
    let lname = document.getElementById('ln-input').value;
    let fcolor = document.getElementById('fc-input').value;

    let newPerson = { 
        fname: fname, 
        lname: lname, 
        fcolor: fcolor
    };

    return newPerson;
}

function resetForm() {
    document.getElementById('fn-input').value = '';
    document.getElementById('ln-input').value = '';
    document.getElementById('fc-input').value = '#000000';
}

(function () {
    let btn = document.getElementById('submit-btn');
    //btn.onclick or btn.addEventListener
    btn.addEventListener('click', () => {
        let newPerson = getFormInput();
        resetForm();
        addToTable(newPerson);
    }, false);
})();