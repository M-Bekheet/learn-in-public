#include <iostream>
using namespace std;

void printGrid(char grid[9][9], int n)
{
  for (int i = 0; i < n; i++)
  {
    for (int j = 0; j < n; j++)
    {
      cout << (grid[i][j] == 'x' ? "x\t" : grid[i][j] == 'o' ? "o\t"
                                                             : "\t");
    }
    cout << endl;
  }
}

bool checkPosition(int i, int j, int n, char grid[9][9])
{
  if (i >= n || j >= n || i < 0 || j < 0) // out of boundary
    return false;

  bool hasRole = grid[i][j] == 'x' || grid[i][j] == 'o';
  return !hasRole;
}

bool checkWinning(int n, char role, char grid[9][9])
{
  bool won = true;
  printGrid(grid, n);
  bool leftDiagonal = true;
  bool rightDiagonal = true;
  int hzEquals = 0;
  int vEquals = 0;

  // check diagonals

  // check rows
  for (int i = 0; i < n; i++)
  {
    bool hzWon = true;
    bool vlWon = true;
    for (int j = 0; j < n; j++)
    {
      // diagonals
      if (i == j)
      {
        if (grid[i][i] != role)
          leftDiagonal = false;
        if (grid[i][n - i - 1] != role)
          rightDiagonal = false;
      }

      if (grid[i][j] != role)
        hzWon = false;

      if (grid[j][i] != role)
        vlWon = false;
    }
    if (hzWon || vlWon)
      return true;
  }
  return leftDiagonal || rightDiagonal;
}

// *This is a simpler solution and it's not longer. Review the doctor solution is it's confusing, but important
int main()
{
  int n;
  cin >> n;
  char grid[9][9];
  bool done = false;
  char role = 'x';
  int counter = 0;

  while (!done)
  {
    if (counter == n * n)
    {
      cout << "Tie";
      break;
    }
    cout << "Player " << role << " turn. Enter empty location (r, c): ";

    int r, c;
    cin >> r >> c;

    int i = r - 1, j = c - 1;
    bool empty = checkPosition(i, j, n, grid);
    if (!empty)
    {
      cout << "Invalid Input. Try again\n";
      continue;
    }

    grid[i][j] = role;
    counter++;

    bool won = checkWinning(n, role, grid);
    if (won)
    {
      cout << "Player " << role << " won";
      break;
    }
    role = role == 'x' ? 'o' : 'x';
  }

  cout << endl;
  return 0;
}