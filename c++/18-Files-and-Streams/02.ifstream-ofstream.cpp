#include <iostream>
#include <fstream>
using namespace std;

int main()
{
  ifstream fin("read_file.txt");

  if (fin.fail())
  {
    cout << "Can't open the file" << "\n";
    return 0;
  }

  int x, y;
  fin >> x >> y;

  cout << x + y;

  fin.close(); // closes the stream

  ofstream fout("my_output.txt");
  if (fout.fail())
  {
    cout << "Can't open the output file\n";
    return 0;
  }

  fout << x + y;
  fout.close();

  return 0;
}