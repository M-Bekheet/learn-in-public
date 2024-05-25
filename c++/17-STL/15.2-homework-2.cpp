#include <iostream>
#include <bits/stdc++.h>
using namespace std;

/*
  Steroids Collision
  - You are given a list of steroids, each one has a value representing its size, and a sign representing its direction.
  - (+ve) means moving to the right, (-ve) means moving to the left.
  - If a steroid collides with another one, the one that is smaller in size will explode.
  - If they've the same size, both will explode.
  - Get the last remaining steroids.
  e.g [8, -8] => collision (8 is moving to the right => and -8 is moving to the left).
  e.g [-8, 8] => no collision (-8 is moving to the left, 8 is moving to the right).
  e.g [3, -5] => 3 explodes (smaller size)

  I solved it with recursion. There is slightly a similar solution here: https://github.com/kamyu104/LeetCode-Solutions/blob/master/C++/asteroid-collision.cpp
 */

vector<int> steroids_collision(vector<int> &s)
{
  vector<int> v;
  v.insert(v.begin(), s[0]);
  bool changed = false;
  for (int i = 1; i < s.size(); i++)
  {
    if (s[i] < 0 && !v.empty() && v.back() > 0)
    {
      if (v.back() > abs(s[i]))
        continue;
      changed = true;
      if (v.back() < abs(s[i]))
        v.pop_back(), v.insert(v.end(), s[i]);
      else
        v.pop_back();
    }
    else
      v.insert(v.end(), s[i]);
  }

  if (changed && v.size())
    return steroids_collision(v);

  return v;
}

int main()
{
  vector<int> steroids({5, 5, -8});
  auto v = steroids_collision(steroids);
  for (const auto &val : v)
    cout << val << " ";
  cout << "\n";
}