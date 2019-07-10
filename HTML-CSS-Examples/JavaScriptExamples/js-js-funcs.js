// simple function declaration
var basicFunc = function() {
    console.log('This is a simple function.');
}

//the above is equivalent to...
function basicFunc() {
    console.log('This is an even simpler function.');
}

//Invocation Forms
/*
 * Every function has access to a 'this' property.
 * The value of 'this' is determined at runtime, based on
 * the way the function was invoked.
 */

function func(){
    //this.aname = 'Jessica';
    console.log('this = ');
    console.log(this);
}

console.log('Function invocation form: ');
func(); // this is function invocation form. 

console.log('Constructor invocation form:');
var someObj = new func();
someObj.name = 'someObj';

console.log('Method invocation form:');
someObj.method = func;
someObj.method();


//Closure
/*
 * How javascript does encapsulation.
 */

function outerFunc() {
    var privateVariable = "Hello";
    function innerFunc(){
        //inner function has access to everything in outerfunc
        console.log(privateVariable);
    }
    return innerFunc;
}
//console.log(privateVariable);//not accessible

var innerFunc2 = outerFunc();
innerFunc2();

//practical closure example
function makeSizer(size){
    return function(){
        document.body.style.fontSize = size + 'px';
    }
}
//the purpose of the above method is to allow us to create
//multiple functions that will change the body font size
//to a particular size.

var size12 = makeSizer(12);
var size14 = makeSizer(14);
var size16 = makeSizer(16);

//attach the functions we just created to event handlers.
document.getElementById('size-12').onclick = size12;
document.getElementById('size-14').onclick = size14;
document.getElementById('size-16').onclick = size16;


//IIFE
/*
 * Immediately Invoked Function Expressions
 *  also called Self-Executing Anonymous Functions.
 * 
 * Variables defined within the IIFE cannot be accessed outside of it.
 */
(function () {
     console.log('The function has been invoked!');
})();

