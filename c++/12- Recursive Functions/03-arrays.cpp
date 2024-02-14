#include <iostream>
using namespace std;

// just used as a utility
void print_array(int arr[], int len)
{
  for (int i = 0; i < len; i++)
    cout << arr[i] << " ";
}

int arr_max(int arr[], int len)
{
  if (len == 1)
    return arr[0];

  int sub_result = arr_max(arr, len - 1);
  return max(sub_result, arr[len - 1]);
}

int sum(int arr[], int len)
{
  if (len == 0)
    return 0;

  return arr[len - 1] + sum(arr, len - 1);
}

// *NOTE: Review this solution. I just could solve it with an external(global) variable that I was updating with every call
double array_avg(int arr[], int len)
{
  if (len == 0)
    return 0;

  double sub_result = array_avg(arr, len - 1) * (len - 1);
  return (sub_result + arr[len - 1]) / len;
}

void array_increment(int arr[], int len)
{
  if (len == 0)
    return;

  arr[len - 1] += 1;
  return array_increment(arr, len - 1);
}

int array_accumulation(int arr[], int len)
{
  if (len == 1)
    return arr[0];

  arr[len - 1] += array_accumulation(arr, len - 1);
  return arr[len - 1];
}

int array_left_max(int arr[], int len)
{
  if (len == 1)
    return arr[0];

  int sub_max = array_left_max(arr, len - 1);
  arr[len - 1] = max(sub_max, arr[len - 1]);
  return arr[len - 1];
}

// This is the instructor solution. I couldn't solve this one.
void array_right_max(int arr[], int len)
{
  if (len == 1)
    return;

  array_right_max(arr + 1, len - 1); // arr+1 shifts the array to the right
  arr[0] = max(arr[0], arr[1]);
}

// return the sum of the last N elements
int suffix_sum(int arr[], int len, int n)
{
  if (n == 0 || len == 0)
    return 0;

  int sub = suffix_sum(arr, len - 1, n - 1);
  return arr[len - 1] + sub;
}

// return the sum of the first N elements
int prefix_sum(int arr[], int len, int n)
{
  if (n == 0 || len == 0)
    return 0;

  if (len == 1)
    return arr[0];

  int sub = prefix_sum(arr + 1, len - 1, n - 1);
  return sub + arr[0];
}

// my solution - takes array & array length
bool is_palindrome(char arr[], int len, int i = 0)
{
  if (len == 1 || len - 1 == i)
    return true;

  bool is = arr[i] == arr[len - 1];
  if (!is)
    return false;

  return is_palindrome(arr, len - 1, i + 1);
}

// another solution without an excessive parameter
bool is_palindrome_v2(char arr[], int end)
{

  if (end <= 0)
    return true;

  if (arr[0] != arr[end])
    return false;
  return is_palindrome_v2(arr + 1, end - 2);
}

bool is_prefix(string main, string prefix, int start_pos = 0)
{

  if (start_pos == prefix.size() || prefix == "")
    return true;

  if (main[start_pos] != prefix[start_pos])
    return false;

  return is_prefix(main, prefix, start_pos + 1);
}

// I had a bad solution before this instructor answer
bool is_prime(int n, int current_num = 3)
{
  if (n == 2) // special even that is prime
    return true;
  if (n <= 1 || n % 2 == 0) // all even numbers except for 2 are not prime
    return false;

  if (n == current_num)
    return true;
  if (n % current_num == 0) // prime numbers aren't a factor of any numbers except for 1 and itself

    return false;
  return is_prime(n, current_num + 1);
}

int count_primes(int start, int end)
{

  if (start > end)
    return 0;

  int sub_count = count_primes(start + 1, end);

  if (is_prime(start))
    sub_count = sub_count + 1;
  return sub_count;
}

int grid_sum(int arr[100][100], int row, int col, int i = 0, int j = 0, int sum = 0)
{

  // origin (0,0)
  if (i == 0 && j == 0)
    sum = arr[0][0];

  // base case
  if (i + 1 >= row && col + 1 >= j)
    return sum;

  int max_num = 0;

  int next_i = i, next_j = j;

  // He solved the next 3 conditions with a loop using 2 direction arrays di, dj. I just avoid loops in assignments for recursion solutions

  // right
  if (i < row && arr[i + 1][j] > max_num)
  {
    max_num = arr[i + 1][j];
    next_i = i + 1;
  }

  // down
  if (j < col && arr[i][j + 1] > max_num)
  {

    max_num = arr[i][j + 1];
    next_i = i;
    next_j = j + 1;
  }
  // right-down
  if (j < col && i < row && arr[i + 1][j + 1] > max_num)
  {
    max_num = arr[i + 1][j + 1];
    next_i = i + 1;
    next_j = j + 1;
  }

  return grid_sum(arr, row, col, next_i, next_j, sum + max_num);
}

int fibonacci(int n)
{
  if (n <= 1)
    return 1;
  /*
   Dynamic_Programming
   - To make this performant, create an array that stores old values in and check if the value exist, return it, unless   calculate the value and store it in the arr
   - For Instance:

    fib(int n, int arr[100])
    {
      if arr is not initialized
        fill the arr from 0 -> 100 with zeros

      int fib_n_minus_1 = 0;
      int fib_n_minus_2 = 0;
      if(arr[n-1] == 0)   arr[n-1] = fibonacci(n - 1);
        fib_n_minus_1 = arr[n-1];
      if(arr[n-2] == 0)   arr[n-2] = fibonacci(n - 2);
        fib_n_minus_2 = arr[n-2];
      return fib_n_minus_1 + fib_n_minus_2;}
    */
  return fibonacci(n - 1) + fibonacci(n - 2);
}

int main()
{
  // char arr[5]{'a', 'b', 'r', 'b', 'a'};
  // int arr2[6]{1, 3, 5, 7, 4, 2};

  // cout << is_palindrome(arr, 5);
  // cout << is_palindrome_v2(arr, 4);
  // cout << is_prefix("", "");
  // print_array(arr2, 6);
  // cout << count_primes(10, 200);

  // int multi_arr[3][200] = {
  //     {1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
  // cout << grid_sum(multi_arr, 3, 3, 0, 0);

  cout << fibonacci(6);
  cout
      << endl;
}
