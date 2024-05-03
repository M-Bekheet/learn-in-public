#include <iostream>
// #include <bits/stdc++.h> // Covers all you need from the language. It might not be working based on your compiler
using namespace std;

int main()
{
  string s = "Life is full of surprises";
  cout << s.substr(8) << endl;    // full of surprises
  cout << s.substr(5, 2) << endl; // is
  // cout << s.substr(99) << endl; // Error: out_of_range
  cout << s.find("full") << endl;      // 8 >> index of the beginning of the word
  cout << s.find("Lala") << endl;      // 18446744073709551615. It's the value of s.npos >> which actually yields to -1. Check this https://stackoverflow.com/questions/40608111/why-is-18446744073709551615-1-true
  cout << (int)s.find("Lala") << endl; // -1 >> Better cast it to integer to get -1

  // Functions that search for CHARACTERS
  string s2 = "abcdcrc";
  cout << (int)s2.find_last_of("cd") << endl;  // 6 >> finds the last index of any of the passed characters (No need to be grouped together);
  cout << s2.find_first_of("cd") << endl;      // 2
  cout << s2.find_first_not_of("cdr") << endl; // 0 >> any first item that is not of such characters
  cout << s2.find_last_not_of("rc") << endl;   // 3

  cout << s2.replace(3, 4, "abc"); // abcabc
}