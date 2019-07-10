//Callback functions
/*
 * A function that is passed as an argument into another
 * function. That passed in function is then invoked within 
 * the outer function to complete some kind of action.
 */

 //synchronous callback (the callback function gets called immediately).
 function greeting(name){
     alert(`Hello ${name}!`);
 }

 function processUserInput(callback){
     var name = prompt('Please enter your name.');
     callback(name);
 }

 processUserInput(greeting);

 /* Another way to type the above example using arrow notation
  *
  * function processUserInput(callback){
  *    var name = prompt('Please enter your name.');
  *     callback(name);
  * }
  * 
  * processUserInput((name) => {alert(`Hello ${name}!`)});
  */