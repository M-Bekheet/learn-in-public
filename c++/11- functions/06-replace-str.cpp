#include <iostream>
using namespace std;

bool starts_with(string input, string pattern, int pos)
{
  if (input.size() - pos < pattern.size())
    return false;
  for (int i = 0; i < pattern.size(); i++)
    if (input.at(i + pos) != pattern.at(i))
      return false;
  return true;
}

string replace_str(string input, string pattern, string to)
{
  string result = "";
  for (int i = 0; i < input.size(); i++)
  {
    if (starts_with(input, pattern, i))
    {
      result += to;
      i += pattern.size() - 1;
    }
    else
      result += input.at(i);
  }
  return result;
}
int main()
{
  string input, pattern, to;
  cin >> input >> pattern >> to;
  cout << replace_str(input, pattern, to) << "\n";
}