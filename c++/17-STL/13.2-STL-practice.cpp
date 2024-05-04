#include <iostream>
#include <set>
#include <vector>
using namespace std;

/*
  Problem:
    - Given N full-names as following:
      = Each full name starts with given K: # of words,
      = Then read K words
    - Then read Q queries, each query is a sub-full name
    Print all full names that start with the given sub-full name

    Example
    - Input:
      N=5 [5 full names]
      3 Mahmoud Mostafa Sayed  [k = 3]
      3 Ahmed Ali Clay [k = 3]
      2 Asmaa Mohamed [k = 2]
      2 Mahmoud Adel
      3 Ahmed Ali Elsayed
      2 Asmaa Ashraf Morsy [k = 2]

    - Input:
     Q = 2 [2 queries]
     2 Ahmed Ali => [Ahmed Ali Clay - Ahmed Ali Elsayed]
     1 Asmaa => [Asmaa Mohamed - Asmaa Ashraf Morsy]

*/

void print_name_in_vector(vector<string> &v)
{
  for (auto it = v.begin(); it < v.end(); it++)
    cout << *it << " ";
  cout << "\n";
}

void print_name_in_record(multiset<vector<string>> &names, vector<string> &name)
{
  bool found = true;
  auto it = names.begin();
  while (it != names.end())
  {
    auto record_name = *it;
    bool is_match = true;
    if (record_name.size() >= name.size())
    {
      for (int i = 0; i < name.size(); i++)
      {
        if (name[i] != record_name[i])
        {
          is_match = false;
          break;
        }
      }
      if (is_match)
        print_name_in_vector(record_name);
    }
    it++;
  }
}

/* There's a better solution in file 13.3-STL-practice.cpp. It uses map to store full-name possibilities of each word */
int main()
{

  int names_count, queries_count;
  cout << "\nHow many names to save? ";
  cin >> names_count;

  multiset<vector<string>> names;
  for (int i = 0; i < names_count; i++)
  {
    int name_length;
    cout << "\nWhat's the name No." << i + 1 << " length?\n";
    cin >> name_length;
    vector<string> full_name(name_length);
    string name;
    cout << "Enter Full Name: ";
    for (int j = 0; j < name_length; j++)
      cin >> full_name[j];
    names.insert(full_name);
  }

  cout << "\nEnter Queries Number\n";

  cin >> queries_count;
  for (int i = 0; i < queries_count; i++)
  {
    int name_count;
    cout << "\nHow many words in your query?\n";
    cin >> name_count;
    vector<string> name_to_search(name_count);
    cout << "\nWhat's the name to search?\n";
    for (int j = 0; j < name_count; j++)
    {
      cin >> name_to_search[j];
    }
    cout << "\n";
    print_name_in_record(names, name_to_search);
  }
}