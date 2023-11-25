/* 
  Flyweight pattern:
   - Mainly used to avoid creating a large number of objects that have the same properties.
   - Instead, we can create a single object that stores the common properties and pass it to the objects that need it.
   - In JavaScript, we can easily solve this problem through prototypal inheritance. Nowadays, hardware has GBs of RAM, which makes the flyweight pattern less important.
   */

// - For example, a library that has many copies of the same book. We will create a map of unique books and use it when a new copy is about to be added to the library.

/* Utils & Types */

class Book {
  constructor(
    public title: string,
    public author: string,
    public isbn: string
  ) {}
}

type Library = {
  title: string;
  author: string;
  isbn: string;
  availability: boolean;
  sales: number;
}[];

/* The Pattern */

const booksMap = new Map();

// a utility to ONLY add a book if it doesn't exist already
const createBook = (title: string, author: string, isbn: string): Book => {
  const existingBook = booksMap.get(isbn);
  if (existingBook) return existingBook;

  const book = new Book(title, author, isbn);
  booksMap.set(isbn, book);
  return book;
};

const library = <Library>[];

const addBook = (
  title: string,
  author: string,
  isbn: string,
  availability: boolean,
  sales: number
) => {
  const book = {
    ...createBook(title, author, isbn), // Flyweight pattern: use an existing book if it exists in the map OR create a new one
    sales,
    availability,
    isbn,
  };
  library.push(book);
  return book;
};

addBook("The Alchemist", "Paulo Coelho", "978-0062315007", true, 12);
addBook("1984", "George Orwell", "978-0451524935", true, 2);
addBook("1984", "George Orwell", "978-0451524935", true, 2);
addBook("1984", "George Orwell", "978-0451524935", false, 2);
addBook("1984", "George Orwell", "978-0451524935", true, 2);

console.log("--> Total amount of copies: ", library.length); // 5 books
console.log("--> Total amount of books: ", booksMap.size); // 2 books
