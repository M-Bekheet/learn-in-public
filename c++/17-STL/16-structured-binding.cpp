#include <iostream>
#include <bits/stdc++.h>
using namespace std;

struct Employee
{
  string name;
  int salary;
};

pair my_global_pair{5, 6};

auto return_by_value()
{
  return my_global_pair;
}

auto &return_by_reference()
{
  return my_global_pair;
}

struct MyArray
{
  int salaries[3];
};

int main()
{
  /*
    Structured Binding is like destructing in JavaScript. You make variables of DS on the fly by reference or by value
   */

  cout << "***********" << "\n";
  cout << "***ARRAY***" << "\n";
  cout << "***********" << "\n";

  int arr[]{1, 8, 9, -10};

  // Binding a, b, c, d to their corresponding values in the array
  auto [a, b, c, d] = arr; // bind by value

  cout << b << "\n"; // 8
  b = 100;
  cout << arr[1] << "\n"; // 8

  auto &[k, l, m, n] = arr; // bind by reference
  cout << k << "\n";        // 1
  k = 900;
  cout << arr[0] << "\n"; // 900

  cout << "\n&&&&&&&&&&&&" << "\n";
  cout << "&&&STRUCT&&&" << "\n";
  cout << "&&&&&&&&&&&&" << "\n";

  Employee employee1{"Mostafa", 20};
  Employee employee2{"Salah", 60};
  auto [my_name, my_salary] = employee1;
  const auto &[his_name, his_salary] = employee2; // constant & bound by reference at the same time

  cout << employee2.name << "\n";
  cout << my_name << "\n";

  cout << "\n**********" << "\n";
  cout << "***PAIR***" << "\n";
  cout << "**********" << "\n";

  pair p(28, "Developer"); // The same as: pair<int, string> p{28, "Developer"};
  auto &[age, profession] = p;
  cout << profession << "\n";

  // auto &[n1, n2] = return_by_value(); // Compiler Error: You cannot bind by reference what is returned as a value not a reference

  auto &&[n0, m0] = return_by_value(); // && for return value ref (later discussed in semantic moves)

  auto &[n1, n2] = return_by_reference();
  cout << n1 << " " << n2 << "\n";

  auto [n3, n4] = return_by_value(); // waste of time & memory
  cout << n3 << " " << n4 << "\n";

  cout << "\n############" << "\n";
  cout << "###TUPLES###" << "\n";
  cout << "############" << "\n";

  tuple<char, int, string> t = make_tuple('C', 10, "Sophisticated");
  auto &[tup1, tup2, tup3] = t;
  cout << tup1 << "\n";

  // Direction Initialization
  auto [tup4, tup5, tup6] = tuple('S', 28, "Remarkable");
  cout << tup6 << "\n";

  cout << "\n*********" << "\n";
  cout << "***MAP***" << "\n";
  cout << "*********" << "\n";

  // Before C++11
  multimap<int, int> mp1;
  mp1.insert(pair<int, int>(1, 40));
  mp1.insert(pair<int, int>(1, 50));
  mp1.insert(pair<int, int>(3, 60));

  // Newer Way
  multimap<int, int> mp2{{1, 40}, {1, 50}, {3, 60}};

  for (const auto &[key, value] : mp2)
    cout << key << " " << value << "\n";

  // Return a pair of iterators. equal_range() returns a pair of start & end iterators

  cout << "The Iterator Way" << "\n";
  auto [it_start, it_end] = mp2.equal_range(true);
  for (auto it = it_start; it != it_end; ++it)
    cout << it->first << " " << it->second << "\n";

  cout << "\n*************" << "\n";
  cout << "**INSERTION**" << "\n";
  cout << "*************" << "\n";

  set<int> st{4, 20, 30, 30, 20};

  // Can't take a reference for a return by value
  auto [iter1, is_inserted] = st.insert(21);  // true
  auto [iter2, is_inserted2] = st.insert(30); // false

  if (auto [iter3, success] = st.insert(15); success)
    cout << "DONE SUCCESSFULLY" << "\n";

  cout << "\n############" << "\n";
  cout << "###MORE###" << "\n";
  cout << "############" << "\n";

  string input_str = "I am Mahmoud\nYour Guy for this code";

  for (auto [iss, line] = pair(istringstream(input_str), string{}); getline(iss, line);)
  {
    cout << line << "\n";
  }

  cout << "\n#######################" << "\n";
  cout
      << "###STRUCT WITH ARRAY###" << "\n";
  cout << "#######################" << "\n ";

  int arr2[]{1, 2, 3};
  // Compiler Error(CE): Invalid Conversion from int* to int
  // auto sal[4]{arr2};

  auto salariesPointer{arr2}; // this is a pointer

  MyArray my_arr{3, 4, 5};
  auto [actual_arr] = my_arr;
  cout << actual_arr[0] << "\n";
}
