class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();

        backtrack(0, s, list, ans);

        return ans;
    }

    private void backtrack(int start, String s,
                           List<String> list,
                           List<List<String>> ans) {

        // Base Case
        if (start == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }

        // Try every possible substring
        for (int end = start; end < s.length(); end++) {

            if (isPalindrome(s, start, end)) {

                list.add(s.substring(start, end + 1));

                backtrack(end + 1, s, list, ans);

                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {

        while (left < right) {

            if (s.charAt(left) != s.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }
}


/*Start from the first character (index = 0).
Try every possible substring starting from the current index.
First character only.
First two characters.
First three characters.
...until the end of the string.
Check whether the current substring is a palindrome.
If YES → add it to the current partition.
If NO → ignore it and try the next larger substring.
After adding a palindrome, recursively repeat the same process from the next index.
Continue until you reach the end of the string.
If the current index equals the string length → one complete partition is formed, so save it.
Return to the previous recursion level (backtrack).
Remove the last substring that was added.
Continue trying the remaining substrings from that same starting index.
Repeat this process until every possible palindrome partition has been explored.
*/
/*Start

↓

Choose a substring

↓

Is it a palindrome?

├── No
│     ↓
│  Try the next substring
│
└── Yes
      ↓
   Add to current partition
      ↓
   Recurse from the next index
      ↓
   Reached end of string?
      │
      ├── Yes → Save the partition
      │
      └── No → Continue exploring
      ↓
   Backtrack (remove last substring)
      ↓
Try the next substring

*/