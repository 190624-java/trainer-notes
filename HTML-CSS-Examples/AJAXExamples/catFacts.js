document.getElementById('btn-new-fact').addEventListener('click', getNewFact);

document.getElementById('btn-clear-facts').addEventListener('click', () => {
    document.getElementById('newFactCard').innerHTML = `<h4 class="card-title">New</h4>
    <h5 class="card-subtitle mb-2 text-muted">Cat Facts</h5>`;
    document.getElementById('favFactCard').innerHTML = `<h4 class="card-title">Favorite</h4>
    <h5 class="card-subtitle mb-2 text-muted">Cat Facts</h5>`;
});

function getNewFact() {
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'https://cors-anywhere.herokuapp.com/https://cat-fact.herokuapp.com/facts/random', true);
    xhr.setRequestHeader("Access-Control-Allow-Origin", "*");
    xhr.onreadystatechange = function(){
        if (xhr.readyState === 4 && xhr.status === 200) {
            let resp = JSON.parse(xhr.response);
            addNewFactHTML(resp.text);
        }
    };
    xhr.send();
}

function addNewFactHTML(fact) {
    let newFactElement = document.createElement('p');
    newFactElement.className = 'card-text';
    newFactElement.innerHTML = `<span id="optionSpan">
    <i name="remove" class="fas fa-minus-circle"></i>
    <i name="favorite" class="fas fa-heart"></i>
    </span>`;
    let factSpan = document.createElement('span');
    factSpan.innerText = fact;
    newFactElement.appendChild(factSpan);

    document.getElementById('newFactCard').appendChild(newFactElement);
}

document.getElementById('newFactCard').addEventListener('click', (e) => {
    let src = e.target;
    //console.log('name of src: ' + src.getAttribute('name'));
    if(src.getAttribute('name') == 'remove'){
        let factElements = src.parentElement.parentElement;
        document.getElementById('newFactCard').removeChild(factElements);
    } else if(src.getAttribute('name') == 'favorite'){
        let fact = src.parentElement.nextElementSibling.innerText;
        let factElements = src.parentElement.parentElement;
        document.getElementById('newFactCard').removeChild(factElements);
        addFactToFav(fact);
    }
});

function addFactToFav(fact) {
    let newFactElement = document.createElement('p');
    newFactElement.className = 'card-text';
    newFactElement.innerHTML = `<span id="iconSpan">
    <i name="favorite" class="red fas fa-heart"></i>
    </span>`;
    let factSpan = document.createElement('span');
    factSpan.innerText = fact;
    newFactElement.appendChild(factSpan);

    document.getElementById('favFactCard').appendChild(newFactElement);
}