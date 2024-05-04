#include <iostream>
#include <set>
using namespace std;

template <typename T>
void print(multiset<T> &s)
{
  for (T val : s)
    cout << val << " ";
  cout << "\n";
}

/* Multiset is a set that is ordered, but allows duplicate */
int main()
{
  multiset<string> students;
  students.insert("Ahmed");
  students.insert("Ola");
  students.insert("Ola");
  students.insert("Ali");
  students.insert("Mona");

  print(students); // Ahmed Ali Mona Ola Ola

  cout << students.count("Ahmed") << "\n";
  cout << students.count("Amin") << "\n";

  multiset<string>::iterator it = students.find("Ola");
  if (it != students.end())
    // This erases on of the duplicate items only
    students.erase(it); // Ahmed Ali Mona Ola

  print(students);
}