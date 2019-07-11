function getPokemon() {
    //1. create XMLHttpRequest object
    let xhr = new XMLHttpRequest();

    //2. define onreadystatechange function
    xhr.onreadystatechange = () => {
        console.log(xhr.readyState);
        /*
         * 0 - request not initialized
         * 1 - server connection established
         * 2 - request recieved
         * 3 - server processing request
         * 4 - response is ready (but the status code could be anything)
         */
        if(xhr.readyState === 4 && xhr.status === 200){
            console.log(xhr.response);
            let pokemon = JSON.parse(xhr.response);
            console.log(pokemon);
            document.getElementById('name').innerText = pokemon.name;
            document.getElementById('id').innerText = pokemon.id;
            document.getElementById('height').innerText = pokemon.height;
        }
    };

    //3. open the request
    xhr.open('GET', 'https://pokeapi.co/api/v2/pokemon/1');
    
    //4. send the request !!!!!!!!!!!!!
    xhr.send();
}

document.addEventListener('DOMContentLoaded', getPokemon);