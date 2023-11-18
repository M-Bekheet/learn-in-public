/* 
  Factory Pattern:
    - A function is a factory function when it returns a new object without the use of the new keyword!
    - It can be useful if we’re creating relatively complex and configurable objects
    - in many cases it may be more memory efficient to create new instances of a class instead of new objects each time.
*/

interface IUser {
  firstName: string;
  lastName: string;
  age: number;
  email: string;
}

/*
 >> Factory using JS Arrow Function
*/
const createUser = ({ firstName, lastName, age, email }: IUser) => ({
  firstName,
  lastName,
  age,
  email,
  fullName() {
    return `${this.firstName} ${this.lastName}`;
  },

  identify() {
    return `My name is ${this.fullName()} and I'm ${
      this.age
    } years old. You can reach me at ${this.email}`;
  },
});

const johnDoe = createUser({
  firstName: "John",
  lastName: "Doe",
  age: 25,
  email: "johnDoe@email.com",
});

// console.log(johnDoe);
// console.log(johnDoe.fullName());
// console.log(johnDoe.identify());

/* 
 >> Factory using Class Constructor
*/
class User {
  constructor(
    public firstName: string,
    public lastName: string,
    public age: number,
    public email: string
  ) {}
  fullName() {
    return `${this.firstName} ${this.lastName}`;
  }
  identify() {
    return `My name is ${this.fullName()} and I'm ${
      this.age
    } years old. You can reach me at ${this.email}`;
  }
}

const jackMa = new User("Jack", "Ma", 55, "jackMa@mail.com");
console.log(jackMa);
console.log(jackMa.fullName());
console.log(jackMa.identify());
