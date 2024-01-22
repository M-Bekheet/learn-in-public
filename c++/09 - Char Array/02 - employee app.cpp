#include <iostream>
using namespace std;

int main()
{
  string names[200]{};
  int ages[200]{};
  int salaries[200]{};
  char genders[200]{};
  int count = 0;
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
      cout << "Enter name: ";
      cin >> names[count];
      cout << "Enter age: ";
      cin >> ages[count];
      cout << "Enter salary: ";
      cin >> salaries[count];
      cout << "Enter gender: ";
      cin >> genders[count];
      count++;
      cout << "\n****************\n";

      break;
    }
    case 2:
    {
      for (int i = 0; i < count; i++)
      {
        if (ages[i] != -1)
          cout << names[i] << " " << ages[i] << " " << salaries[i] << " " << genders[i] << "\n";
      }
      cout << "\n****************\n";

      break;
    }
    case 3:
    {
      int start, end;
      cin >> start >> end;
      for (int i = 0; i < count; i++)
      {
        if (ages[i] >= start && ages[i] <= end)
          ages[i] = -1;
      }

      break;
    }
    case 4:
    {
      string name;
      int salary;
      cin >> name >> salary;
      for (int i = 0; i < count; i++)
      {
        if (names[i] == name)
        {
          salaries[i] = salary;
          break;
        }
      }

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