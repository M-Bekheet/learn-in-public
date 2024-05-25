#include <iostream>
#include <stack>
using namespace std;

/*

  Good Question - Review it.

  You are asked to use a stack.
  Given a balanced parenthesis string s, calculate the score of the string based on the following criteria:
  - () has score of 1
  - AB has score A + B, where A and B are balanced parenthesis
  - (A) has score of 2 * A where A is a balanced parenthesis
  - Examples:
    - () => 1
    - (()) => 2 [2 * (1)]
    - ()() => 2 [1 + 1]
    - (()()) => 4 [2 * (1 + 1)]
    - (()(())) => 6
    - ()(()(())) => 7
*/

/*
Solution Explanation:
  Consider: (()(()))
  We know any valid sub-expression can be replaced with its value. Let's find smallest ones

  ( () ( () )) ==> ( 1+ ( () )) ==> ( 1 ( 1 )) ==> (1 + 2) ==> (3) ==> 6
  We see that subexpressions () with value 1 and (()) with value 2 are part of a bigger expression (()(()))

  We can write inefficient code to keep finding internal small expressions, but can we do it smarter?

  Thinking in processing left to write: we either
  - have ( to indicate a new subexpression that will have ) in future
  - or ) to indicate there is a subexpression that is done now

  Stack can help us to do that
  - We find (, we add 0: it represents the initial sum of the internal subexpressions
  - We find ), we finish a subexpression value and accumulate to its parent

  It might now be easy to get the idea, but its solution can be a similar thinking style in other stack problems

 */

int scoreOfParentheses(string str)
{
  // Each integer represents total sum added to this parent Parentheses
  stack<int> st;

  // temp value to help us
  st.push(0);

  for (auto c : str)
  {
    if (c == '(')
    {
      st.push(0); // new parenthesis: current sum = 0
    }
    else
    {
      // An expression will be closed now [ if ch = ')' ] or later
      // Find its value: either 1 for empty () or 2 * its sub-expressions
      // Add the expression sum to its parent current sum
      int last = st.top();
      st.pop();

      if (last == 0)
        last = 1; // case ()
      else
        last *= 2; // case (A). Get current sum and multiply

      // Assume we have expression E that is (CHD)
      // where C, H, D are valid-subexpressions with values 5, 10, 4
      // then E is (5+10+4) = (19) = 38
      // Every time we finish an expression, we add its value to its parent

      // get the parent and update its sum with a finished sub-expression
      int parent_par = st.top() + last; // new total sum
      st.pop();
      st.push(parent_par);
    }
  }
  return st.top();
}
int main()
{
  cout << scoreOfParentheses("()") << "\n";         // 1
  cout << scoreOfParentheses("()()") << "\n";       // 2
  cout << scoreOfParentheses("(()())") << "\n";     // 4
  cout << scoreOfParentheses("((()()))") << "\n";   // 8
  cout << scoreOfParentheses("()((()()))") << "\n"; // 9
}