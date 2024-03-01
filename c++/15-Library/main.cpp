#include <iostream>
#include <algorithm>
using namespace std;

const int MAX_USERS{200}, MAX_BOOKS{200};
/* Utility */
int case_insensitive_match(string s1, string s2)
{
  // convert s1 and s2 into lower case strings
  transform(s1.begin(), s1.end(), s1.begin(), ::tolower);
  transform(s2.begin(), s2.end(), s2.begin(), ::tolower);
  if (strncmp(s1.c_str(), s2.c_str(), s2.size()) == 0)
    return 1; // The strings are same
  return 0;   // not matched
}
struct Book
{
  int id;
  string name;
  int quantity;
};

struct User
{
  int id;
  string name;
  Book books[MAX_BOOKS]{};
  int total_books = 0;

  void add_book(Book book)
  {
    for (int i = 0; i < total_books; i++)
    {
      if (books[i].id == book.id)
        return;
    }
    books[total_books] = book;
    total_books++;
  }

  int remove_book(Book book)
  {
    int book_index = -1;
    for (int i = 0; i < total_books; i++)
    {
      if (books[i].id == book.id)
      {
        book_index = i;
        break;
      }
    }
    if (book_index == -1)
      return -1;

    if (book_index <= total_books - 1)
    {
      for (int i = book_index; i < total_books; i++)
        books[i] = books[i + 1];
    }

    total_books--;
    return book_index;
  }

  bool has_book(string book_name)
  {
    for (int i = 0; i < total_books; i++)
    {
      if (books[i].name == book_name)
        return true;
    }
    return false;
  }

  void print()
  {
    string books_ids{};
    for (int i = 0; i < total_books; i++)
      books_ids += to_string(books[i].id) + " ";
    cout << "user " << name << " id " << id << " borrowed books ids: " << books_ids << "\n";
  }
};

int compare_books_by_id(Book book1, Book book2) { return book1.id < book2.id; }
int compare_books_by_name(Book book1, Book book2) { return book1.name < book2.name; }

struct Library
{
  User users[MAX_USERS]{};
  Book books[MAX_BOOKS]{};
  int total_books, total_users;

  Library()
  {
    total_books = 0;
    total_users = 0;
  }

  void add_book(Book book)
  {
    books[total_books++] = book;
  }

  void add_user(User user)
  {
    users[total_users++] = user;
  }

  void borrow_book(string username, string book_name)
  {
    int found_book_index = -1;
    for (int i = 0; i < total_books; i++)
    {
      if (books[i].name == book_name)
      {
        found_book_index = i;
        break;
      }
    }
    if (found_book_index < 0 || books[found_book_index].quantity <= 0)
      return;

    int found_user_index = -1;
    for (int i = 0; i < total_users; i++)
    {
      if (users[i].name == username)
      {
        found_user_index = i;
        break;
      }
    }
    if (found_user_index >= 0)
    {
      users[found_user_index].add_book(books[found_book_index]);
      books[found_book_index].quantity--;
    }
  }

  void return_book(string username, string book_name)
  {
    if (!book_exist(book_name))
    {
      cout << "Invalid Book Name.";
      return;
    }
    if (!user_exist(username))
    {
      cout << "Invalid Username.";
      return;
    }

    int user_index{-1};
    int book_index{-1};

    for (int i = 0; i < total_users; i++)
    {
      if (users[i].name == username)
      {
        user_index = i;
        break;
      }
    }

    for (int i = 0; i < total_books; i++)
    {
      if (books[i].name == book_name)
      {
        book_index = i;
        break;
      }
    }
    users[user_index].remove_book(books[book_index]);
    books[book_index]
        .quantity++;

    cout << "Returned Book\n";
  }

  void search_books_by_prefix(string prefix)
  {
    for (int i = 0; i < total_books; i++)
    {
      if (case_insensitive_match(books[i].name, prefix) == 1)
        cout << books[i].name << "\n";
    }
  }

  void print_who_borrowed_book_by_name(string book_name)
  {
    if (!book_exist(book_name))
    {
      cout << "Invalid book name.";
      return;
    }

    for (int i = 0; i < total_users; i++)
    {
      if (users[i].has_book(book_name))
        cout << users[i].name << "\n";
    }
  }

  void
  print_users()
  {
    for (int i = 0; i < total_users; i++)
      users[i].print();
  }

  void print_library_by_id()
  {
    sort(
        books,
        books + total_books, compare_books_by_id);
    print();
  }

  void print_library_by_name()
  {
    sort(books, books + total_books, compare_books_by_name);
    print();
  }

  bool book_exist(string book_name)
  {
    for (int i = 0; i < total_books; i++)
    {
      if (books[i].name == book_name)
        return true;
    }
    return false;
  }
  bool user_exist(string username)
  {
    for (int i = 0; i < total_users; i++)
    {
      if (users[i].name == username)
        return true;
    }
    return false;
  }

  void print()
  {
    for (int i = 0; i < total_books; i++)
    {
      Book book = books[i];
      cout << "id = " << book.id << " name = " << book.name << " total_quantity " << book.quantity << "\n";
    }
  }
};

int main()
{
  Library library{};
  bool done = false;
  while (!done)
  {
    cout << "\n\n#################\n\n";
    cout << "Library Menu;\n";
    cout << "1) add_book\n";
    cout << "2) search_books_by_prefix\n";
    cout << "3) print_who_borrowed_book_by_name\n";
    cout << "4) print_library_by_id\n";
    cout << "5) print_library_by_name\n";
    cout << "6) add_user\n";
    cout << "7) user_borrow_book\n";
    cout << "8) user_return_book\n";
    cout << "9) print_users\n";
    cout << "10) Exit\n";

    int choice;
    cin >> choice;

    switch (choice)
    {

    case 1:
    {
      Book book{};
      cout << "Enter book info: id & name & total quantity: ";
      cin >> book.id >> book.name >> book.quantity;
      library.add_book(book);
      cout << "Books Count: " << library.total_books;
      break;
    }

    case 2:
    {

      cout << "Enter book name prefix: ";
      string prefix{};
      cin >> prefix;
      library.search_books_by_prefix(prefix);
      break;
    }

    case 3:
    {
      cout << "Enter book name: ";
      string book_name;
      cin >> book_name;
      library.print_who_borrowed_book_by_name(book_name);
      break;
    }

    case 4:
      library.print_library_by_id();
      break;

    case 5:
      library.print_library_by_name();
      break;

    case 6:
    {
      User user{};
      cout << "Enter use name & national id: ";
      cin >> user.name >> user.id;
      library.add_user(user);
      break;
    }

    case 7:
    {
      cout << "Enter user name and book name: ";
      string username, book_name;
      cin >> username >> book_name;
      library.borrow_book(username, book_name);
      break;
    }

    case 8:
    {
      cout << "Enter user name and book name: ";
      string username, book_name;
      cin >> username >> book_name;
      library.return_book(username, book_name);
      break;
    }

    case 9:
      library.print_users();
      break;

    case 10:
      done = true;
      break;

    default:
      cout << "Invalid Input";
      break;
    }
  }
}