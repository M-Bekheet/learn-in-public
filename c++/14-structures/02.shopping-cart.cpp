#include <iostream>
using namespace std;

struct item
{
  string name;
  double price;
};

struct card
{
  item items[200]{};
  int len{};

  void add(item new_item)
  {
    items[len++] = new_item;
  }

  int remove(item target_item)
  {
    int index = -1;
    for (int i = 0; i < len; i++)
    {
      if (items[i].name == target_item.name)
      {
        index = i;
        break;
      }
    }

    if (index >= 0 && index != len - 1)
    {
      for (int i = index; i < len - 1; i++)
      {
        items[i] = items[i + 1];
      }
    }
    if (index >= 0)
      len--;
    return index;
  }

  void print()
  {
    for (int i = 0; i < len; i++)
      cout << items[i].name << " ";

    cout << "\n";
  }
};

int main()
{
  card shopping_card;
  item i_1{
      "chicken",
      180};
  item i_2{
      "meat",
      320.5};

  shopping_card.add(i_1);
  shopping_card.add(i_2);
  shopping_card.remove(i_2);
  shopping_card.print();
}