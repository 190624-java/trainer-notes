var baseURL = 'http://localhost:8080/servlets/';

document.getElementById("getAllPetsBtn").onclick = () => {
    //Ajax request
    //1. 
    let xhr = new XMLHttpRequest();
    //2.
    xhr.open('GET', baseURL + 'app/pet');
    //3.
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4){
            if(xhr.status === 200){
                let pets = JSON.parse(xhr.responseText);
                console.log(pets);
                for(let pet in pets){
                    addPetToTable(pets[pet]);
                }
            } else {
                console.log('Ajax request responded with HTTP status code ' + xhr.status);
            }
        }
    }
    //4.
    xhr.send();
};

function addPetToTable(pet){
    let newRow = document.createElement('tr');
    let idCol = document.createElement('td');
    let nameCol = document.createElement('td');
    let typeCol = document.createElement('td');

    idCol.innerText = pet["id"];
    nameCol.innerText = pet.name;
    typeCol.innerText = pet.type;

    newRow.appendChild(idCol);
    newRow.appendChild(nameCol);
    newRow.appendChild(typeCol);

    document.getElementById('pet-table').appendChild(newRow);
}