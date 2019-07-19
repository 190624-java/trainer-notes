var baseURL = 'http://localhost:8080/hero-app/';
var heroes = [];

document.getElementById("load").onclick = () => {
	console.log('clicked');
    let xhr = new XMLHttpRequest();
    xhr.open("GET", baseURL + "app/hero/all");
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4){
        	console.log(xhr.status);
            if(xhr.status === 200){
                let resp = JSON.parse(xhr.response);
                console.log(resp);
                resetTable();
                heroes = [];
                for(let hero of resp){
                    console.log(hero);
                    heroes.push(hero);
                }
                popTable();
            }
        }
    };
    xhr.send();
};

function popTable(){
    for(let hero of heroes){
        let newRow = document.createElement('tr');

        let idCol = document.createElement('td');
        idCol.innerText = hero.id;
        let nameCol = document.createElement('td');
        nameCol.innerText = hero.name;
        let levelCol = document.createElement('td');
        levelCol.innerText = hero.level;
        let classCol = document.createElement('td');
        classCol.innerText = hero.heroClass;

        newRow.appendChild(idCol);
        newRow.appendChild(nameCol);
        newRow.appendChild(levelCol);
        newRow.appendChild(classCol);
        document.getElementById('hero-table').appendChild(newRow);
    }
}

function resetTable(){
    let table = document.getElementById('hero-table');
    while(table.firstChild){
        table.removeChild(table.firstChild);
    }
}