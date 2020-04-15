package com.vishal.algos;

public class ImplementIndexOf {

    public static void main(String[] args) {
        String haystack = "flow";
        String  needle = "flower";
        indexOf(haystack, needle);
    }

    private static int indexOf(String haystack, String needle) {
        if(needle.isEmpty())
            return 0;

        for(int i = 0; i+needle.length() <= haystack.length() ; i++)
        {
            if(haystack.substring(i, i+needle.length()).equals(needle))
                return i;
        }
        return -1;
    }

    private static int indexOfOld(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();
        if((hLen == 0 && nLen == 0) || nLen == 0)
            return 0;
        if(nLen > hLen || hLen == 0 )
            return -1;

        int searchUpto = hLen-nLen;
        char first = needle.charAt(0);
        for(int i= 0;i<=searchUpto; i++){
            if(haystack.charAt(i) != first) {
                while(++i <= searchUpto && haystack.charAt(i) != first);
            }

            if(i <= searchUpto) {
                int j = i+1;
                int last = j+nLen-1;
                for(int k = 1; j < last && haystack.charAt(j) == needle.charAt(k); j++, k++);
                if(j == last)
                    return i;
            }
        }
        return -1;
    }
}
