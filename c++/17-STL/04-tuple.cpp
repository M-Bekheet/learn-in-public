#include <iostream>
#include <stack>
using namespace std;

int main()
{
  /*
    - tuple is a generalization of `pair` as it holds many items at the same time.
    - You can think of it as an array of different types
   */

         tuple<string, char, int> t1;
      t1 = make_tuple("Mahmoud", 'S', 1);

  // Get Position
  cout << get<0>(t1) << endl; // Mahmoud
  cout << get<2>(t1) << endl; // 1

  // Set Postion
  get<0>(t1) = "Ahmed";
  cout << get<0>(t1) << endl; // Khaled

  tuple<string, char, int> t2;
  t2 = make_tuple("Ahmed", 'Z', 3);

  cout << boolalpha;
  // Comparison is comparing properties one by one. In this example it will compare strings first (Ahmed & Ahmed) then char ('S' & 'Z') and it will be done before reaching the 3rd property as 'Z' > 'S'
  cout << "Comparison between t1 & t2: " << (t1 >= t2) << endl;

  // tie: unpacks the tuple values into separate variables. Like Destructuring an array in JavaScript
  string name;
  char tier;
  int rank;

  tie(name, tier, rank) = t1;
  cout << name << " " << tier << " " << rank << endl;

  tuple<string, char, int> t3;
  t3 = make_tuple("Adel", 'N', 4);

  // Concatenation
  auto people = tuple_cat(t2, t3); // Output: ("Ahmed", 'Z', 3, "Adel", 'N', 4)
  cout << get<4>(people) << endl;  // 'N'
}