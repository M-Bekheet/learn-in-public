#include <iostream>
using namespace std;

// get min 3 numbers of an array. TThere is 2 provided solutions and one of them is better than this, but it's similar to one of the 2 provided solutions
void min_3()
{
  int n;
  cin >> n;

  int arr[2000];
  for (int i = 0; i < n; i++)
  {
    cin >> arr[i];
  }

  // set beginning 3 min values based on idx 0 => 2
  int min, min2, min3;
  if (arr[0] > arr[1])
  {
    if (arr[0] > arr[2])
    {
      min = arr[0];
      min2 = arr[2] > arr[1] ? arr[2] : arr[1];
      min3 = arr[2] > arr[1] ? arr[1] : arr[2];
    }
    else
    {
      min = arr[2];
      min2 = arr[0];
      min3 = arr[1];
    }
  }
  else
  { // 1 > 0
    if (arr[1] > arr[2])
    {
      min = arr[1];
      min2 = arr[0] > arr[2] ? arr[0] : arr[2];
      min3 = arr[0] > arr[2] ? arr[2] : arr[0];
    }
    else
    {
      min = arr[2];
      min2 = arr[0] > arr[1] ? arr[0] : arr[1];
      min3 = arr[0] > arr[1] ? arr[1] : arr[0];
    }
  }

  // loop and update the min values
  for (int i = 3; i < n; i++)
  {
    if (arr[i] < min3)
    {
      min3 = arr[i];
    }
    else if (arr[i] < min2)
      min2 = arr[i];

    else if (arr[i] < min)
      min = arr[i];
  }

  cout << min3 << " " << min2 << " " << min;
}

// unsorted unique numbers
void unique_numbers()
{
  int n;
  cin >> n;

  int arr[901];
  for (int i = 0; i < n; i++)
  {
    cin >> arr[i];
  }

  int freq[901]{0};

  for (int i = 0; i < n; i++)
  {
    ++freq[arr[i]];
    if (freq[arr[i]] == 1)
      cout << arr[i] << " ";
  }
}

// sort using freq arr. this is good for small arrays
void sort_num()
{
  int freq[501] = {0};
  int arr[901];

  int n;
  cin >> n;
  for (int i = 0; i < n; i++)
    cin >> arr[i];

  for (int i = 0; i < n; i++)
    ++freq[arr[i]];

  for (int i = 0; i < 500; i++)
  {
    while (freq[i])
    {
      cout << i << " ";
      freq[i]--;
    }
  }
}

// sequence that matches certain conditions
void recaman_sequence()
{
  int arr[201]{0};
  int n;
  int tmp;
  cin >> n;
  arr[0] = 0;
  if (n == 0)
    cout << 0 << endl;
  else
  {
    for (int i = 1; i <= n; i++)
    {
      tmp = arr[i - 1] - (i - 1) - 1;
      if (tmp > 0)
      {
        int j = i;
        bool found = 0;
        while (j >= 0)
        {
          if (arr[j] == tmp)
          {
            arr[i] = arr[i - 1] + i;
            found = 1;
            break;
          }
          j--;
        }

        if (!found)
        {
          arr[i] = tmp;
        }
      }
      else
      {
        arr[i] = arr[i - 1] + i;
      }
    }
  }

  cout << arr[n] << "\n";
}

// get max window summation. window: sub array
// a very better solution using the a cumulative sum array is in tutorials
void max_sliding_window()
{
  int k;
  int n;
  cin >> k >> n;
  int arr[200]{0};
  for (int i = 0; i < n; i++)
    cin >> arr[i];

  // sum of each window
  int sum[200]{0};

  int max = -1;
  int max_idx = -1;

  for (int i = 1; i <= n; i++)
  {
    int tmp = k;
    while (tmp > 0)
    {
      sum[i] += arr[i + tmp - k + 1];
      tmp--;
    }
    if (sum[i] > max || max_idx == -1)
    {
      max = sum[i];
      max_idx = i - 1;
    }
  }

  cout << max_idx << " " << max_idx + k - 1 << " " << max << " \n";
}

// count increasing windows
void increasing_windows()
{
  int n;
  cin >> n;
  int arr[200];
  for (int i = 0; i < n; i++)
    cin >> arr[i];

  int total = 0;
  int max_span = n;
  int new_arr[200]{0};

  while (n > 1)
  {

    int increasing_count = 1;
    int first_idx = -1;
    int last_idx = n - 1;

    // find the longest window count. Its total = sum of( 1, 2, ..., increasing_count ) = (count/2)(1+count)
    for (int i = 0; i < n - 1; i++)
    {
      int tmp = i;
      int current_increasing_count = 1;
      while (tmp < n - 1)
      {
        if (arr[tmp] < arr[tmp + 1])
        {
          current_increasing_count++;
          tmp++;
        }
        else
        {
          break;
        }
      }
      if (current_increasing_count > increasing_count)
      {
        first_idx = i;
        last_idx = i + current_increasing_count - 1;
        increasing_count = current_increasing_count;
      }
    }

    total += (increasing_count / 2.0) * (1 + increasing_count);

    // remove counted items from the arr
    int last_pushed_idx = -1;
    for (int i = 0; i < n; i++)
    {
      // ignore counted items
      if (i > last_idx || i < first_idx)
      {
        new_arr[last_pushed_idx + 1] = arr[i];
        last_pushed_idx++;
      }
    }
    // means that there are still remaining items in the arr
    if (last_pushed_idx > 0)
    {
      n = last_pushed_idx + 1;
      for (int i = 0; i < n; i++)
      {
        arr[i] = new_arr[i];
      }
    }
    else
      break;
  }
  cout << total << " ";
}

void josephus()
{
  int n, k;
  cin >> n >> k;
  int arr[200];
  for (int i = 0; i < n; i++)
  {
    arr[i] = i + 1;
  }

  int remaining = n;

  for (int i = 0; remaining > 0; i += k)
  {
    if (arr[i + k - 1] != -1)
    {
      cout << "\nval: " << i + k - 1 << endl;
      cout << arr[i + k - 1] << " ";
      arr[i + k - 1] = -1;
      remaining--;
    }

    if (i + k >= n - 1)
      i = 0;
  }
}

int main()
{
  josephus();

  cout << "\n";
  return 0;
}
