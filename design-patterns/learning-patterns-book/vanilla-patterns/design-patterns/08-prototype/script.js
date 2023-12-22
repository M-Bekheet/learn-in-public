/* 

The prototype chain identifies the properties that the object has and what chain it inherits its properties if exist

The prototype chain itself has a __proto__ object which inherits from its parent in the prototype chain. This is accessed through what's called `Delegation`

Delegation: When you try to access a property and it's not found in the current object prototype, JS will try to find it in its parents that it inherits from. 

We can access properties such as toString(), toLowerCase() in normal variables because of its prototype chain delegation.

*NOTE: __proto__ is used to access the prototype of an `instance`, while prototype is used on the constructor itself

*/

class Dog {
  name;
  constructor(name) {
    this.name = name;
  }

  bark() {
    return "Woof";
  }
}
//adding a prototype to Dog object(class)
Dog.prototype.play = () => {
  return "Playing";
};

const daisy = new Dog("Daisy");
const max = new Dog("Max");
const spot = new Dog("Spot");

console.log(daisy.bark());
console.log(max.play());
console.log(spot.__proto__);

console.log("The same prototype?", Dog.prototype === spot.__proto__);
console.log("\n\n-------------\n\n");

const myName = "Mahmoud";
console.log(myName.__proto__);
// String delegation example. Notice how we access toUpperCase method which we haven't identified ourselves
console.log(myName.toUpperCase());

console.log("\n\n-------------\n\n");

// Class delegation example
class SuperDog extends Dog {
  fly() {
    return "Flying";
  }
}

const jack = new SuperDog("Jack");
console.log(
  "Super dog called",
  jack.name,
  "has Dog constructor properties too"
);
console.log(jack.bark());
console.log(jack.fly());

console.log("\n\n-------------\n\n");

/* Object.create() example */

const Human = {
  sayHello() {
    console.log("Hello");
  },
  sleep: () => {
    console.log("ZZZZ");
  },
};

const mahmoud = Object.create(Human);

console.log("Direct properties on mahmoud", Object.keys(mahmoud));
console.log(
  "Properties on mahmoud's prototype:",
  Object.keys(mahmoud.__proto__)
);
