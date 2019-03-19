class IntegerToRoman {
    public String intToRoman(int num) {
        int[] integers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M","CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            for (int i = 0; i < integers.length; i++){
                int digit = num / integers[i];
                num = num % integers[i];
                for (int j = 0; j < digit; j++) {
                    sb.append(romans[i]);
                }
            }
        }
        return sb.toString();
    }
}