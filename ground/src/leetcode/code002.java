package src.leetcode;

public class code002 {

    public String intToRoman(int num) {

        String[] lm = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] nu = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int temp = 1, flag = 0;
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            for (int i = flag; i < 13; i++) {
                if (num - nu[i] >= 0) {
                    num = num - nu[i];
                    sb.append(lm[i]);
                    flag = i;
                    break;
                }
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        code002 code002 = new code002();
        System.out.println(code002.intToRoman(1994));
    }
}

