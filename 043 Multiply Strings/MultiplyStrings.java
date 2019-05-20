class MultiplyStringsœ {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] product = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + product[p2];
                product[p1] += sum / 10;
                product[p2] = sum % 10;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < m + n; i++) {
            if (res.length() == 0 && product[i] == 0) {
                continue;
            } 
            res.append(product[i]);
        }
        return res.length() == 0? "0": res.toString();
    }
}