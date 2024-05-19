#include <iostream>
#include <stack>
#include <queue>
#include <vector>
#include <set>
#include <map>

using namespace std;

// Utils

void print_stack(stack<char> s)
{
  while (!s.empty())
  {
    cout << s.top() << " ";
    s.pop();
  }
  cout << "\n";
}

void print_queue(queue<int> q)
{
  while (!q.empty())
  {
    cout << q.front() << " ";
    q.pop();
  }
  cout << "\n";
}

// 6 Medium Challenges

// Implement a function that reverses a queue. Use a stack for this purpose.
void reverse_queue(queue<int> &q)
{
  stack<int> s;
  while (!q.empty())
    s.push(q.front()),
        q.pop();
  while (!s.empty())
    q.push(s.top()),
        s.pop();
}

// Implement a struct that acts as a stack, but relies on a queue internally.
// Review the `push` solution, it was kinda tricky
struct OurStack
{
  queue<int> q;

  // Imagine you have a queue like this: {3, 2, 1} and you need to push(7) to be => {7, 3, 2, 1} as in a real stack
  // To do this, you push 7 to the queue to be: {3, 2, 1, 7}
  // And you loop from 0-index to n: take the element from index and push it back in the queue & pop it from the front
  // So the steps will look like this:
  // {7, 3, 2, 1} => {3, 2, 1, 7} => {2, 1, 7, 3} => {1, 7, 3, 2} => {7, 3, 2, 1}
  // You take from the front and move it to the back for n-1 of the original queue size
  void push(int val)
  {
    int s = q.size();
    q.push(val);
    while (s--)
      q.push(q.front()), q.pop();
  }
  void pop()
  {
    if (!q.empty())
      q.pop();
  }
  int top()
  {
    return q.front();
  }
  bool empty()
  {
    return q.empty();
  }
};

// Reverse a number using a stack
int reverse_num(int num)
{
  stack<int> s;

  while (num)
  {
    s.push(num % 10), num /= 10;
  }

  int factor = 1;
  while (!s.empty())
  {
    num = num + factor * s.top();
    factor *= 10;
    s.pop();
  }

  return num;
}

// Print all words that start with a given prefix. Output should be in the SAME order of the inputs. All words are UNIQUE
void print_words_by_prefix()
{
  cout << "How many words to save?\n";
  int n;
  cin >> n;

  cout << "Enter your words:\n";

  string word;
  map<string, vector<string>> mp;
  for (int i = 0; i < n; i++)
  {
    cin >> word;
    for (int j = 0; j < word.size(); j++)
      mp[word.substr(0, j + 1)].push_back(word);
  }
  cout << "\nWhat is the prefix? ";
  string prefix;
  cin >> prefix;

  if (!mp[prefix].empty())
    for (const auto v : mp[prefix])
      cout << v << " ";
  cout << endl;
}

// Print all words that start with a given prefix. Output should be in the SAME order of the inputs. All inputs are NOT UNIQUE, but the ouput must be UNIQUE
void print_words_by_prefix_2()
{
  cout << "How many words to save?\n";
  int n;
  cin >> n;
  string word;

  cout << "Enter your words:\n";
  map<string, set<string>> mp;
  for (int i = 0; i < n; i++)
  {
    cin >> word;
    for (int j = 0; j < word.size(); j++)
    {
      mp[word.substr(0, j + 1)].insert(word);
    }
  }

  cout << "\nWhat is the prefix? ";
  string prefix;
  cin >> prefix;

  if (!mp[prefix].empty())
    for (auto val : mp[prefix])
      cout << val << " ";
  cout << "\n";
}

// Using a stack, remove adjacent duplicates from a string. e.g "abbaca" => remove bb => "aaca" => remove "aa" => final result = "ca"
string remove_adjacent_duplicates(string s)
{
  stack<char> st;
  for (int i = 0; i < s.size(); i++)
    st.push(s[i]);

  string new_string = "";
  string final_str = "";
  string last = "";
  bool changed = false;

  while (st.size() >= 2 && !changed)
  {
    last = string(1, st.top());
    st.pop();

    if (last != string(1, st.top()))
      new_string += last;
    else
    {
      changed = true;
      st.pop();
    }
  }
  if (changed)
  {
    while (!st.empty())
    {
      new_string += st.top();
      st.pop();
    }

    for (int i = new_string.size() - 1; i >= 0; i--)
      final_str += new_string[i];
    return remove_adjacent_duplicates(final_str);
  }

  if (st.size())
    new_string += st.top();

  string final_string = "";
  // Reverse the string
  for (int i = new_string.size() - 1; i >= 0; i--)
    final_string += new_string[i];
  return final_string;
}

int main()
{
  queue<int> q1({3, 5, -1, 4});

  // cout << boolalpha;

  // reverse_queue(q1);
  // print_queue(q1);

  // cout << "==========\n";
  // OurStack s;
  // s.push(1);
  // s.push(2);
  // s.push(3);
  // while (!s.empty())
  //   cout << s.top() << " ", s.pop();

  cout << reverse_num(1010) << endl;
  // cout << 123 % 10;
  // print_words_by_prefix();

  // cout << remove_adjacent_duplicates("aca") << "\n";
  cout << "\n";
}