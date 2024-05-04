#include <iostream>
#include <map>
using namespace std;

void print(const map<string, int> &mp)
{
  for (const pair<string, int> &item : mp)
    cout << item.first << "-" << item.second << " | ";
  cout << "\n";
}

/*
  Map: It's an array, but not zero-based index and the insertion order is not preserved sometimes
  It's an array of key-value pairs
*/
int main()
{
  map<string, int> mp;
  mp["Mahmoud"] = 10;
  mp["Bekheet"] = 12;
  mp["Mahmoud"] = 20; // This overrides the 10 value
  mp["mahmoud"] = 15; // notice, this is not the same as "Mahmoud"

  print(mp); // Bekheet-12 | Mahmoud-20 | mahmoud-15 |

  auto it = mp.find("Bekheet");

  if (it != mp.end())
    mp.erase(it);

  print(mp); // Mahmoud-20 | mahmoud-15 |

  cout << mp.count("Mahmoud") << "\n"; // 1

  cout << "===========\n";

  map<char, vector<int>> my_data;

  vector<int> x;
  x.push_back(1);
  x.push_back(2);
  x.push_back(3);

  my_data['A'] = x;
  x.push_back(4);

  cout << my_data['A'].size() << "\n"; // 3 (NOT 4)
  cout << x.size() << "\n";            // 4 (2 copies now: my_data['A'] and x)

  vector<int> x2 = my_data['A'];  // 3rd copy!
  vector<int> &x3 = my_data['A']; // SAME memory of my_data['A']

  my_data['A'].push_back(4);
  cout << x2.size() << "\n"; // 3
  cout << x3.size() << "\n"; // 4 // As it's the same memory of my_data['A']
}