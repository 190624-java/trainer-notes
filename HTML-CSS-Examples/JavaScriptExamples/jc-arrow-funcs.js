/*
 * Arrow functions do not have their own "this".
 * So, they are NOT good to use for constructors or methods.
 *      (They CANNOT be used as constructors.)
 * Basic Syntax
 *  (param1, param2, ..., paramN) => { statements }
 * If no parameters
 *  () => { statements }
 */

 //concise
 var func = x => x * x;
    //no need for curly braces, because theres only one statement.
    //and that statement is an expression that should be returned.
console.log(func(2));

//the block version of the above function:
var func = (x) => {
    return x * x;//an explicit return statement is needed
}

//if you want to be able to return an object literal
var func2 = () => ({foo: 1});
var func3 = () => {
    return {foo: 1};
};

var noSpace = (

) => { //these must be on the same line.

};

