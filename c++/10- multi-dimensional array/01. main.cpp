#include <iostream>
using namespace std;

void find_neighbors()
{
  int arr[5][5];
  int count = 0;
  for (int i = 0; i < 5; i++)
  {
    for (int j = 0; j < 5; j++)
    {
      arr[i][j] = count;
      count++;
    }
  }

  // d, r,u,l
  int di[]{1, 0, -1, 0};
  int dj[]{0, 1, 0, -1};

  int k, m;
  cin >> k >> m;

  for (int i = 0; i < 4; i++)
  {
    cout << k + di[i] << " ";
    cout << m + dj[i] << "\n";
  }
}

void find_last_max_pos()
{
  int arr[100][100];
  int k, m;
  cin >> k >> m;

  for (int i = 0; i < k; i++)
    for (int j = 0; j < m; j++)
      cin >> arr[i][j];

  int lastPosX = -1;
  int lastPosY = -1;
  for (int i = 0; i < k; i++)
  {
    for (int j = 0; j < m; j++)
    {
      if (arr[i][j] >= arr[lastPosX][lastPosY])
      {
        lastPosX = i;
        lastPosY = j;
      }
    }
  }

  cout << "found at: " << lastPosX << " " << lastPosY << ". Max: " << arr[lastPosX][lastPosY];
}

void special_print()
{
  int arr[100][100];
  int k, m;
  cin >> k >> m;

  for (int i = 0; i < k; i++)
    for (int j = 0; j < m; j++)
      cin >> arr[i][j];

  int l_diagonal = 0;
  int r_diagonal = 0;
  int final_row_sum = 0;
  int final_col_sum = 0;
  for (int j = 0; j <= m; j++)
  {
    l_diagonal += arr[j][j];
    r_diagonal += arr[j][m - j - 1];
    final_row_sum += arr[k - 1][j];
  }

  for (int i = 0; i < k; i++)
    final_col_sum += arr[i][m - 1];

  cout << "left diagonal sum: " << l_diagonal << "\n";
  cout << "right diagonal sum: " << r_diagonal << "\n";
  cout << "final row sum: " << final_row_sum << "\n";
  cout << "final column sum: " << final_col_sum << "\n";
}

void swap_columns()
{
  int rows, cols;
  cin >> rows >> cols;
  int arr[100][100];
  for (int i = 0; i < rows; i++)
    for (int j = 0; j < cols; j++)
      cin >> arr[i][j];

  int c1, c2;
  cin >> c1 >> c2;
  int tmp;
  for (int i = 0; i < rows; i++)
  {
    tmp = arr[i][c1];
    arr[i][c1] = arr[i][c2];
    arr[i][c2] = tmp;
  }

  for (int i = 0; i < rows; i++)
  {
    for (int j = 0; j < cols; j++)
      cout << arr[i][j] << " ";
    cout << "\n";
  }
}

void greedy_robot()
{
  int rows, cols;
  cin >> rows >> cols;
  int arr[100][100];
  for (int i = 0; i < rows; i++)
    for (int j = 0; j < cols; j++)
      cin >> arr[i][j];

  int sum = arr[0][0];
  arr[0][0] = 0;
  // right ,down, downRight
  int di[] = {1, 0, 1};
  int dj[] = {0, 1, 1};
  cout << endl;

  int lastY = 0;
  int tempY = 0;
  for (int i = 0; i < rows; i++)
  {
    int temp_max = INT_MIN;
    for (int k = 0; k < 3; k++)
    {
      int x = i + di[k];
      int y = lastY + dj[k];

      if (x > -1 && x < rows && y > -1 && y < cols && arr[x][y] > temp_max && arr[x][y] != 0)
      {
        temp_max = arr[x][y];
        tempY = y;
        arr[x][y] = 0;
        if (x == i)
          i--;
      }
    }
    lastY = tempY;
    if (temp_max != INT_MIN)
      sum += temp_max;
    cout << sum << " \n";
  }
}

void flatten_array()
{

  // 2D to 1D:
  // int rows, cols, i, j;
  // cin >> rows >> cols >> i >> j;
  // cout << "index: " << i * rows + j;

  cout << "\n**********\n";

  // 1D to 2D
  int rows, cols, idx;
  cin >> rows >> cols >> idx;

  if (rows != 0 && cols != 0)
  {
    int j = idx % cols;
    int i = (idx - j) / rows;
    cout << "(" << i << "," << j << ")\n";
  }
}

void smaller_row()
{
  int n, m;
  cin >> n >> m;

  int arr[100][100];
  for (int i = 0; i < n; i++)
    for (int j = 0; j < m; j++)
      cin >> arr[i][j];

  int queries;
  cin >> queries;
  int r1, r2;
  while (--queries)
  {
    cin >> r1 >> r2;
    bool smaller = true;
    for (int i = 0; i < m; i++)
    {
      if (arr[r1 - 1][i] > arr[r2 - 1][i])
      {
        smaller = false;
        break;
      }
    }
    if (smaller)
      cout << "YES\n";
    else
      cout << "NO\n";
    queries--;
  }
}

void triangular_matrix()
{
  int n;
  cin >> n;
  int arr[100][100];
  for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++)
      cin >> arr[i][j];

  int upperSum = 0;
  int lowerSum = 0;
  for (int i = 0; i < n; i++)
  {
    for (int j = 0; j < n; j++)
    {
      if (j >= i)
        upperSum += arr[i][j];
      if (j <= i)
        lowerSum += arr[i][j];
    }
  }

  cout << upperSum << " " << lowerSum;
}

void transpose()
{
  int n, m;
  cin >> n >> m;
  int arr[100][100];
  for (int i = 0; i < n; i++)
    for (int j = 0; j < m; j++)
      cin >> arr[i][j];

  int T[100][100];
  for (int i = 0; i < n; i++)
    for (int j = 0; j < m; j++)
      T[j][i] = arr[i][j];

  for (int i = 0; i < m; i++)
  {
    for (int j = 0; j < n; j++)
    {
      cout << T[i][j] << " ";
    }
    cout << endl;
  }
}

bool is_prime(int n)
{
  int main_primes[]{2, 3, 5, 7};
  bool is_prime = true;
  for (int i = 0; i < 4; i++)
  {
    if (n == main_primes[i])
      return true;
    if (n % main_primes[i] == 0)
      return false;
  }
  return is_prime;
}

void count_primes()
{
  int rows, cols;
  cin >> rows >> cols;
  int arr[100][100];
  for (int i = 0; i < rows; i++)
    for (int j = 0; j < cols; j++)
      cin >> arr[i][j];

  int queries;
  cin >> queries;
  while (queries--)
  {
    int primes = 0;

    int i, j, r, c;
    cin >> i >> j >> r >> c;
    for (int m = i; m < r; m++)
    {
      for (int n = j; n < c; n++)
      {

        if (is_prime(arr[n][m]))
        {
          cout << arr[n][m] << " : is prime\n";
          primes++;
        }
        else
          cout << arr[n][m] << "\n";
      }
    }
    cout << primes << "\n";
  }
}

int main()
{
  count_primes();

  cout << endl;
}