#include <iostream>
using namespace std;

void is_prefix()
{
  string str, sub;
  cin >> str >> sub;
  if (sub.size() > str.size())
  {
    cout << "NO";
    return;
  }
  bool is = true;
  for (int i = 0; i < sub.size(); i++)
  {
    if (sub[i] != str[i])
    {
      is = false;
      break;
    }
  }
  cout << (is ? "YES " : "NO");
}

void is_suffix()
{
  string str, sub;
  cin >> str >> sub;

  if (sub.size() > str.size())
  {
    cout << "NO";
    return;
  }

  bool is = true;
  for (int i = 0; i < sub.size(); i++)
  {
    if (sub[i] != str[str.size() - sub.size() + i])
    {
      is = false;
      break;
    }
  }
  cout << (is ? "YES " : "NO");
}

void is_substring()
{
  string str, sub;
  cin >> str >> sub;

  bool is = false;
  for (int i = 0; i < str.size() - sub.size() + 1; i++)
  {
    if (str[i] == sub[0])
    {
      int s = 0;
      is = true;
      while (s < sub.size())
      {
        if (str[i + s] != sub[s])
        {
          is = false;
          break;
        }
        s++;
      }
      if (is)
        break;
    }
  }
  cout << (is ? "YES " : "NO");
}

void is_subsequent()
{
  string str, sub;
  cin >> str >> sub;

  bool is = false;
  int lastSearchIdx = -1;
  for (int i = 0; i < sub.size(); i++)
  {
    is = true;
    bool found_letter = false;
    for (int j = lastSearchIdx + 1; j < str.size(); j++)
    {
      if (str[j] == sub[i])
      {
        lastSearchIdx = j;
        found_letter = true;
        break;
      }
    }
    if (!found_letter)
    {
      is = false;
      break;
    }
  }
  cout << (is ? "YES " : "NO");
}

void convert_number()
{

  string str;
  cin >> str;
  int total = 0;

  int size = str.size();
  for (int i = 0; i < size; i++)
    total = total * 10 + (str[i] - '0');
  cout << total << " " << total * 3;
}

void grouping()
{
  string s;
  cin >> s;
  cout << s.size();
  for (int i = 0; i < s.size(); i++)
  {
    if (s[i] != s[i + 1] && i != s.size() - 1)
      cout << " ";
  }
}

void compressing()
{
  string s;
  cin >> s;

  s = s + "$";
  int count = 1;
  for (int i = 0; i < s.size() - 1; i++)
  {
    if (s[i] != s[i + 1])
    {
      cout << s[i] << count;
      count = 1;
      if (s[i + 1] != '$')
        cout << "_";
    }
    else
      count++;
  }
}

void compare_2_strings()
{
  string s1, s2;
  cin >> s1 >> s2;
  bool in_order = true;

  for (int i = 0; i < s1.size(); i++)
  {
    if (i >= s2.size() && s1[i - 1] == s2[i - 1])
    {
      in_order = false;
      break;
    }

    if (s1[i] < s2[i])
      break;
    if (s1[i] > s2[i])
    {
      in_order = false;
      break;
    }
  }

  cout << in_order;
}

// He solved it with 1 loop
void add5555()
{
  string s;
  cin >> s;
  int size = s.size();
  for (int i = 1; i < 5; i++)
  {
    int add = ('5' - '0') + (s[size - i] - '0');

    if (add < 10)
      s[size - i] = add + '0';
    else
    {
      s[size - i] = add - 10 + '0';
      int j = size - i - 1;
      while (j > -1)
      {
        add = (s[j] - '0' + 1);

        if (add < 10)
        {
          s[j] = s[j] + 1;
          break;
        }

        s[j] = add - 10 + '0';
        if (j == 0)
        {
          cout << 1;
          break;
        }
        j--;
      }
    }
  }

  cout << s;
}

int main()
{

  add5555();

  cout << "\n";

  return 0;
}
