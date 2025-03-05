class Solution {
    public String intToRoman(int num) {
        int M = 1000, D = 500, C = 100, L = 50, X = 10, V = 5, I = 1;
        String s = "";
        
        if (num >= 1000) {
            for (int i = 1; i <= num / 1000; i++) s += 'M';
            num = num % 1000;
        }

        if (num >= 900) {
            s += "CM";
            num = num % 100;
        }
        
        if (num >= 500) {
            s += "D";
            for (int i = 1; i <= (num - 500) / 100; i++) {
                s += "C";
            }
            num = num % 100;
        }
        
        if (num >= 400) {
            s += "CD";
            num = num % 100;
        }
        
        if (num >= 100) {
            for (int i = 1; i <= num / 100; i++) {
                s += "C";
            }
            num = num % 100;
        }
        
        if (num >= 90) {
            s += "XC";
            num = num % 10;
        }
        
        if (num >= 50) {
            s += "L";
            for (int i = 1; i <= (num - 50) / 10; i++) {
                s += "X";
            }
            num = num % 10;
        }
        
        if (num >= 40) {
            s += "XL";
            num = num % 10;
        }
        
        if (num >= 10) {
            for (int i = 1; i <= num / 10; i++) {
                s += "X";
            }
            num = num % 10;
        }
        
        if (num >= 9) {
            s += "IX";
            num = 0;
        }
        
        if (num >= 5) {
            s += "V";
            for (int i = 1; i <= (num - 5); i++) {
                s += "I";
            }
            num = 0;
        }
        
        if (num >= 4) {
            s += "IV";
            num = 0;
        }
        
        if (num >= 1) {
            for (int i = 1; i <= num; i++) {
                s += "I";
            }
        }
        
        return s;
    }
}
