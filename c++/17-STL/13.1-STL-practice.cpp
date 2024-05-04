#include <iostream>
#include <map>
#include <stack>
using namespace std;

/*
  Problem: Given a string containing only these characters '(', ')','{','}', '[', and ']'
  The string should be valid if:
    - Open brackets must be closed by the same type of brackets
    - Open brackets must be closed in the correct order

  Examples:
   valid: (), ()(), (()()), {}{}, (((()))), ([]), ()[]{}, {[]}
   Invalid: (], ()), (][), (], ([)]
 */

// map<char, int> update_cumulative_signal(string &s, char c) {}

bool MY_SOLUTION_is_valid(string s)
{
  map<char, int> opening;
  opening['('] = 0;
  opening['{'] = 0;
  opening['['] = 0;

  map<char, int> closing;
  closing[')'] = 0,
  closing['}'] = 0,
  closing[']'] = 0;

  stack<char> characters_to_close;
  for (char &c : s)
  {
    bool should_open = opening.find(c) != opening.end();
    if (should_open) // should open
    {
      char closing_char = c == '(' ? ')' : c == '{' ? '}'
                                                    : ']';
      opening[c] += 1;
      characters_to_close.push(closing_char);
    }
    else
    {
      char opening_char = c == ')' ? '(' : c == '}' ? '{'
                                                    : '[';

      if (characters_to_close.size() == 0 || opening[opening_char] <= 0)
        return false;

      char char_to_close = characters_to_close.top();

      if (!char_to_close || c != char_to_close)
        return false;

      characters_to_close.pop();
      opening[opening_char] -= 1;
      closing[c] = closing[c] + 1;
    }
    if (closing[c] < 0)
      return false;
  }

  return opening['('] == 0 && opening['{'] == 0 && opening['['] == 0;
}

// This solution is better. It creates a stack called open_parentheses and pushes the open brackets to it. If the loop's ch is a closing one, it pops out from the stack if the last element is the ch's opening one. Otherwise, return false
bool is_valid(string s)
{

  map<char, char> mp;
  mp[')'] = '(';
  mp['}'] = '{';
  mp[']'] = '[';

  stack<char> open_parentheses;

  for (const char ch : s)
  {
    if (mp[ch])
    { // closing
      if (open_parentheses.empty())
        return false;
      char open = mp[ch];
      if (open != open_parentheses.top())
        return false;
      open_parentheses.pop();
    }
    else // opening
      open_parentheses.push(ch);
  }
  return open_parentheses.empty() == true;
}

int main()
{
  cout << boolalpha;
  // Truthy Tests
  cout << is_valid("()") << "\n";
  cout << is_valid("()()") << "\n";
  cout << is_valid("(()())") << "\n";
  cout << is_valid("{}{}") << "\n";
  cout << is_valid("(((())))") << "\n";
  cout << is_valid("([])") << "\n";
  cout << is_valid("()[]{}") << "\n";
  cout << is_valid("{[]}") << "\n";
  cout << is_valid("()([])") << "\n";
  cout << "===========\n";
  // Falsy Tests
  cout << is_valid("())") << "\n";
  cout << is_valid("{[]") << "\n";
  cout << is_valid("(])") << "\n";
  cout << is_valid("(][)") << "\n";
  cout << is_valid("(])") << "\n";
  cout << is_valid("([)]") << "\n";
}