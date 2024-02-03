#include <iostream>
using namespace std;

int read_arr(int arr[])
{
  cout << "Enter the array length\n";
  int n;
  cin >> n;
  for (int i = 0; i < n; i++)
  {
    cin >> arr[i];
  }
  return n;
}

bool is_palindrome(int arr[], int n)
{
  for (int i = 0; i <= n / 2; i++)
  {
    if (arr[i] != arr[n - i - 1])
      return false;
  }
  return true;
}

int main()
{
  while (true)
  {

    int arr[100];
    int n = read_arr(arr);
    cout << is_palindrome(arr, n) << "\n";
  }
}