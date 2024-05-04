#include <iostream>
#include <set>
using namespace std;

// Looping
void print(set<string> &s)
{
  for (string val : s)
    cout << val << " ";
  cout << "\n";
}

int main()
{
  // Set: a collection of Sorted & Unique elements
  set<string> developer;
  developer.insert("Mahmoud");
  developer.insert("Khaled");
  developer.insert("Abdallah");
  developer.insert("Abdallah"); // added before

  print(developer);

  // Check if item is exist: a bit slower performant way
  cout
      << developer.count("Mahmoud") << "\n"; // 1

  // Check if item is exist: faster way
  set<string>::iterator it = developer.find("Mahmoud");

  if (it != developer.end()) // Found
    developer.erase(it);     // removed this element

  print(developer);
}