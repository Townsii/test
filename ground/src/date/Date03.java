import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (getSet(s, i, j))
                    ans = Math.max(ans, j - i);

            }

        }
        return ans;
    }

    public boolean getSet(String s, int start, int end) {
        HashSet<Character> set = new HashSet<>();
        for (int i = start; i <= end; i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);


        }
        return true;
    }
}