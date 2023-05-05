public class Main {
    public static void main(String[] args) {
        String str = "babad";
        System.out.println(longestPalindromeSubstring(str));
    }

    public static String longestPalindromeSubstring(String s) {
        int n = s.length();
        String longest = "";

        for (int i = 0; i < n; i++) {
            String odd = expand(s, i, i);
            String even = expand(s, i, i+1);
            if (odd.length() > longest.length()) {
                longest = odd;
            }
            if (even.length() > longest.length()) {
                longest = even;
            }
        }
        return longest;
    }

    private static String expand(String str, int left, int right) {
        int n = str.length();
        while (left >= 0 && right < n && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return str.substring(left+1, right);
    }
}