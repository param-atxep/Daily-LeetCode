class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (num * 9 < sum) {
            return "";
        }
        int nineCount = sum / 9;
        int remainder = sum % 9;
        StringBuilder result = new StringBuilder("9".repeat(nineCount));
       if (remainder > 0) {
            result.append(remainder);
        }

        result.append("0".repeat(num - result.length()));

        return result.toString();
    }
}