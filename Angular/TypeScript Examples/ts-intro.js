class DataTypes {
    //parameter properties, allow you to create and initialize a member in one place.
    constructor(birthday, state, sibs) {
        this.birthday = birthday;
        //birthday: [month, day, year]
        this.birthState = state;
        this.mySiblings = sibs;
    }
}
var Color;
(function (Color) {
    Color[Color["Red"] = 0] = "Red";
    Color[Color["Green"] = 1] = "Green";
    Color[Color["Blue"] = 2] = "Blue";
})(Color || (Color = {}));
let myDataObj = new DataTypes(['March', 1, 1900], 'California', [['Bri', 2], ['Earnest', 3]]);
console.log(myDataObj);
