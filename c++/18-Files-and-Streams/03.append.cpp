#include <iostream>
#include <fstream>
using namespace std;

int main()
{

  bool append = true;

  auto status = ios::in | ios::out | ios::app; // config for appending to the file

  if (!append)
    status = ios::in | ios::out | ios::trunc; // trunc is the DEFAULT: instead of appending, this overwrites the whole file content

  string path = "names.txt";

  fstream file_handler(path.c_str(), status); // * using `status` on MAC didn't work. Just remove it in case of dysfunctionality

  if (file_handler.fail())
  {
    cout << "Can't open the file" << "\n";
    return 0;
  }

  string first, second;

  file_handler >> first >> second; // here we are reading (like what we do with `cin`)

  cout << "FIRST: " << first << " " << second << "\n"; // "Mahmoud Bakheet"

  file_handler.clear(); // to clear any internal errors ocurred before writing again

  file_handler << "\nKhaled\n"; // writes to the file

  file_handler.close(); // closing the stream is important
}