class DataTypes {
    boo: boolean;
    //varName: dataType;
    age: number;
    name: string;
    myPetArray: string[];//or myPetArray: Array<string>;
    //tuple
    private mySiblings: [string, number][]; //[name, birthOrder]
    favoriteColor: Color;
    notSureYet: any;
    nothingEver: void;
    readonly birthState: string;

    //parameter properties, allow you to create and initialize a member in one place.
    constructor (readonly birthday: [string, number, number], state: string, sibs: [string, number][]){
        //birthday: [month, day, year]
        this.birthState = state;
        this.mySiblings = sibs;
    }

}

enum Color {Red, Green, Blue}

let myDataObj: DataTypes = new DataTypes(['March', 1, 1900], 'California', [['Bri', 2], ['Earnest', 3]]);
console.log(myDataObj);