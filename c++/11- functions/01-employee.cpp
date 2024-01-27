#include <iostream>
using namespace std;

const int MAX = 10000;
string names[MAX]{};
int ages[MAX]{};
int salaries[MAX]{};
char genders[MAX]{};
int counter = 0;

void add_employee()
{
  cout << "Enter name: ";
  cin >> names[counter];
  cout << "Enter age: ";
  cin >> ages[counter];
  cout << "Enter salary: ";
  cin >> salaries[counter];
  cout << "Enter gender: ";
  cin >> genders[counter];
  counter++;
  cout << "\n****************\n";
}

void print_employees()
{
  for (int i = 0; i < counter; i++)
  {
    if (ages[i] != -1)
      cout << names[i] << " " << ages[i] << " " << salaries[i] << " " << genders[i] << "\n";
  }
  cout << "\n****************\n";
}

void delete_by_age()
{
  int start, end;
  cin >> start >> end;
  for (int i = 0; i < counter; i++)
  {
    if (ages[i] >= start && ages[i] <= end)
      ages[i] = -1;
  }
}

void update_salary()
{
  string name;
  int salary;
  cin >> name >> salary;
  for (int i = 0; i < counter; i++)
  {
    if (names[i] == name)
    {
      salaries[i] = salary;
      break;
    }
  }
}

int main()
{
  while (true)
  {
    cout << "\nEnter your choice\n";
    cout << "1) Add a new employee\n";
    cout << "2) Print all employees\n";
    cout << "3) Delete by age\n";
    cout << "4) Update salary by name\n\n";

    int choice;
    cin >> choice;

    if (!(choice >= 1 && choice <= 4))
    {
      cout << "Invalid choice.\n";
      break;
    }

    switch (choice)
    {
    case 1:
    {
      add_employee();

      break;
    }
    case 2:
    {
      print_employees();
      break;
    }
    case 3:
    {
      delete_by_age();
      break;
    }
    case 4:
    {
      update_salary();

      break;
    }
    default:
      cout << "Wrong choice\n";
      break;
    }
    if (!(choice >= 1 && choice <= 4))
      break;
  }
}
