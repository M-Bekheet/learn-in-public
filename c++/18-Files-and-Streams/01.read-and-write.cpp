#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main()
{
  /* This way is not the most common way in production */

  // fropen(filename, access_mode, file_steam)
  // Opens file and applies a stream on it.
  freopen("read_file.txt", "rt", stdin);    // this reads inputs `stdin` from the file
  freopen("output_file.txt", "wt", stdout); // this outputs cout calls to the file
  int x, y;
  cin >> x >> y;
  cout << x * y;
  // cout << x;
}