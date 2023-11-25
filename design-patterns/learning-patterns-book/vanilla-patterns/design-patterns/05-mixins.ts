/* 
  Mixin pattern:
  - This pattern is helpful to add functionality to a class without using inheritance.
  - Mixin itself can `inherit` from other classes/objects. Example: `dogFunctionality` mixin inherits from `animalFunctionality` mixin.
  - Mixins common example is the `Window` object in the browser, which uses mixins such as `WindowOrWorkerGlobalScope` and `WindowEventHandlers`.
  - Modifying an object’s prototype is seen as bad practice, as it can lead to prototype pollution and a level of uncertainty regarding the origin of our functions.


  - React:
    => Mixins in the past were used in React.js
    => They were kinda of like custom react hooks today and used to add functionality to components, but they were harmful as they were causing name collisions. 
    => Mixins internal methods and properties were added to the component's prototype that use it, so if two mixins had the same method name, the last one would override the previous one. The same would happen if the component had that name as well.
    => Reference 1: https://www.benmvp.com/blog/react-custom-hooks-mixins/
    => Reference 2: https://reactjs.org/blog/2016/07/13/mixins-considered-harmful.html
*/

class Dog {
  constructor(public name: string) {}
}

// Mixin 1: Shared animal functionality
const animalFunctionality = {
  walk: () => console.log("Walking!"),
  eat: () => console.log("Eating!"),
};

// Mixin 2: Dog functionality
const dogFunctionality = {
  bark() {
    console.log("Woof!");
  },
  wagTail() {
    console.log("Wagging my tail!");
  },
  play() {
    console.log("Playing!");
  },
  // Inherited methods:
  walk() {
    super.walk();
  },
  eat() {
    super.eat();
  },
};

//Inherit Shared Animals Functionality
Object.assign(dogFunctionality, animalFunctionality);

// Add functionality mixin to Dog class
Object.assign(Dog.prototype, dogFunctionality);

const dog = new Dog("Rex") as Dog & typeof dogFunctionality;

console.log(dog.name);
dog.bark();
dog.play();
dog.wagTail();
dog.walk();
dog.eat();

const WindowOrWorkerGlobalScope = "";
