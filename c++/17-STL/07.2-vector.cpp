#include <iostream>
#include <vector>
using namespace std;

void print(vector<vector<int>> &v2d)
{
  for (auto &row : v2d)
  {
    for (auto &col : row)
      cout << col << " ";
    cout << endl;
  }
  cout << "=================\n";
}

// Multi-Dimensional Vectors
int main()
{
  vector<string> matrix{"Mahmoud", "A.", "Bekheet"}; // 2D: string is an array of char

  int rows = matrix.size(); // 3
  for (int i = 0; i < rows; i++)
    cout << matrix[i].size() << " "; // 7 2 7

  cout << "\n=================\n";

  vector<int> row(5, 2);           // 1D
  vector<vector<int>> v2d(3, row); // 2D: Vector of Vectors

  print(v2d);

  int rows_count = v2d.size();
  int cols_count = v2d[0].size(); // This is correct if all columns have the size size

  v2d[0][0] = 12;
  v2d[1].push_back(9);
  v2d[1].push_back(15);
  v2d[2].erase(v2d[2].begin());
  print(v2d);

  vector<vector<vector<int>>> v3d(5, vector<vector<int>>(2, vector<int>(8, 12))); // vector of depth 5(0 to 4) that has 2 rows each row has 8 integer columns filled with 12

  for (int i = 0; i < v3d.size(); i++)
  {
    cout << "Depth: " << i << endl;
    print(v3d[i]);
  }
}