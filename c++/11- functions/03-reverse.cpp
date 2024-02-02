#include <iostream>
using namespace std;

string reverse_str(const string &str)
{
  string result = "";
  for (int i = str.size() - 1; i >= 0; i--)
  {
    result += str.at(i);
  }
  return result;
}

int main()
{
  cout << reverse_str("Ahmed");
}