#include <iostream>
#include <map>
#include <vector>
using namespace std;

int main()
{
  map<string, vector<string>> mp;

  int n;
  cout << "\nHow many names to save? ";
  cin >> n;

  for (int i = 0; i < n; i++)
  {
    cout << "\nWhat's the name length?\n";

    int len;
    cin >> len;

    string curr_full_name = "";
    string sub_name;
    vector<string> names;

    cout << "Enter Full Name: ";

    for (int j = 0; j < len; j++)
    {
      cin >> sub_name;
      if (j)
        curr_full_name += " ";
      curr_full_name += sub_name;
      names.push_back(curr_full_name);
    }

    for (const auto &name : names)
      mp[name].push_back(curr_full_name);
  }

  cout << "\nEnter Queries Number\n";

  int q;
  cin >> q;
  while (q--)
  {

    cout << "\nHow many words in your query?\n";

    int len;
    cin >> len;

    string curr_full_name = "";
    string str;

    cout << "\nWhat's the name to search?\n";

    for (int j = 0; j < len; j++)
    {
      cin >> str;
      if (j)
        curr_full_name += " ";
      curr_full_name += str;
    }

    if (mp.count(curr_full_name))
    {
      for (auto str : mp[curr_full_name])
        cout << str << "\n";
    }
    else
    {
      cout << "No such sub-full name\n";
    }
  }
}