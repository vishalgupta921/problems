package com.vishal.algos;

public class PerformStringShifts {

    public static void main(String[] args) {
        int[][] shift = new int[2][2];
        shift[0][0] = 0;
        shift[0][1] = 1;
        shift[1][0] = 1;
        shift[1][1] = 2;
        stringShift("abc", shift);

    }

    private static String stringShift(String s, int[][] shift) {
        Integer rightOperation = 0;
        Integer leftOperation = 0;
        for(int i =0; i< shift.length; i++) {
            if(shift[i][0] == 0)
                leftOperation += shift[i][1];
            else
                rightOperation += shift[i][1];
        }
        String s1 = "";
        leftOperation = leftOperation > s.length() ? leftOperation%s.length() : leftOperation;
        rightOperation = rightOperation > s.length() ? rightOperation%s.length() : rightOperation;
        Integer operation = leftOperation-rightOperation;
        if(operation > 0) { // left operation needs to be done
            s1 = s.substring(0, operation);

        }else if(operation < 0) { // right operation needs to be done
            s1 = s.substring(0, s.length()-Math.negateExact(operation));
        }
        s.replaceFirst(s1, "");
        s = s+s1;
        return s;
    }
}
