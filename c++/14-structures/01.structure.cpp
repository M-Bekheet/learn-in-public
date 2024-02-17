#include <iostream>
using namespace std;

// Function check whether a number
// is prime or not
bool isPrime(int n)
{
  // Corner case
  if (n <= 1)
    return false;

  // Check from 2 to square root of n
  for (int i = 2; i <= sqrt(n); i++)
    if (n % i == 0)
      return false;

  return true;
}
struct employee
{
  string name;
  double salary;
  int age;
};

bool compare_salary(employee &a, employee &b) { return a.salary < b.salary; }
bool compare_age(employee &a, employee &b)
{
  return a.age < b.age;
}
bool compare_name_salary(employee &a, employee &b)
{
  if (a.name != b.name)
    return a.name < b.name;

  return a.salary < b.salary;
}

struct queue
{
  int arr[100]{};
  int len;

  queue()
  {
    len = 0;
  }
  void add_end(int value)
  {
    arr[len] = value;
    len++;
  }

  void add_front(int value)
  {
    for (int i = len + 1; i > 0; i--)
      arr[i] = arr[i - 1];
    arr[0] = value;
    len++;
  }

  int remove_front()
  {
    int front = arr[0];
    for (int i = 0; i < len; i++)
      arr[i] = arr[i + 1];
    len--;
    return front;
  }

  void print()
  {
    for (int i = 0; i < len; i++)
      cout << arr[i] << " ";
    cout << "\n";
  }
};

// Driver Code
int main()
{
  queue q;
  q.add_front(5);
  q.add_end(12);
  q.add_front(7);
  q.print();
  cout << q.remove_front() << "\n";
  q.print();
}