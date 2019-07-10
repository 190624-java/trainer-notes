/*
 * DOM - Document Object Model
 *      - a hierarchical model of all the nodes in an HTML page.
 *      - every element, attribute, and piece of text is represented by an HTML node in the DOM
 *      => there are different TYPES of nodes.
 *      - we are mainly going to focus on element nodes.
 *      - this is how JS can access and manipulate the HTML page.
 *  - every html tag (element) in the page is represented by a JavaScript object.
 * 
 * DOM Selection
 *  - there are a few different ways we can retrieve elements,
 * but first, it's important to know, that we use the 
 * DOCUMENT object to retrieve the elements.
 * 
 * Ways to retrieve elements:
 *  - document.getElementById(id);
 *  - document.getElementsByName(name);
 *  - document.getElementsByTagName(name);
 *  - document.getElementsByTagNameNS(nsURI, tagName);
 *  - document.getElementsByClassName(class_name);
 *  - document.querySelector(css_selector); 
 *          returns the first element that has that selector
 *  - document.querySelectorAll(css_selector);
 *          returns all elements that match the selector
 */ 

 //console.log(document);

 var p1Element = document.getElementById('p1');
 console.log(p1Element);
 var purplePElements = document.getElementsByClassName('purple-p');
 console.log(purplePElements);

 // look into traversing the DOM (getting from one element to another)
var root = document.getElementsByTagName('html').item(0);
var head = root.firstElementChild;
/*console.log('first element child:');
console.log(head);
console.log('first child:');
console.log(root.firstChild);*/
var body = head.nextElementSibling;
console.log(body);
console.log(body.parentElement);

//DOM Manipulation
//updating content within an element
var heading1 = document.getElementById('h1');
function changeHeading(new_text){
    //heading1.innerHTML = new_text;
    heading1.innerText = new_text;
}

//using innerHTML
//leaves you vulnerable to XSS (Cross-site scripting)
//whenever you want to change the content of an element
//based on user input, use .textContent instead of .innerHTML

var button = document.getElementById('btn1');
button.setAttribute('disabled', 'true');
button.setAttribute('type', 'submit');

//adding and removing elements
var newP = document.createElement('p');
newP.innerText = "I'm a new paragraph element!";
document.getElementById('div1').appendChild(newP);

document.getElementById('div1').removeChild(newP);

var purpleElements = document.getElementsByClassName('purple-p');
for(let i = 0; i < purpleElements.length; i++){
    purpleElements.item(i).setAttribute('style', 'color: purple');
}

