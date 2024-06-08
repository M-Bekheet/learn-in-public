#include <iostream>
#include <sstream>
using namespace std;

int main()
{

  // istringstream: Instead of reading from a file stream, we're reading (extracting) from an exist string

  string str = "C++ 17 is fun";
  istringstream iss(str);

  string language;
  int version;

  iss >> language >> version;

  cout << language << "\n";
  cout << version << "\n";

  // ostringstream : To construct a string. Likely, this is used when the string is compound of many values.

  ostringstream oss;
  oss
      << "Java ";
  oss << 8;
  oss << " is pretty old\n";

  cout << oss.str();

  return 0;
}