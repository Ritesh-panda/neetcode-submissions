
class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int k = s1.length();

        if (k > s2.length()) return false;

        char[] ch = s1.toCharArray();
        Arrays.sort(ch);

        char[] ch2 = new char[k];

        for (int l = 0; l <= s2.length() - k; l++) {

            for (int j = 0; j < k; j++) {
                ch2[j] = s2.charAt(l + j);
            }

            Arrays.sort(ch2);

            if (Arrays.equals(ch, ch2)) {
                return true;
            }
        }

        return false;
    }
}