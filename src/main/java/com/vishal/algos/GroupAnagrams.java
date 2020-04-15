package com.vishal.algos;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {

    public static void main(String[] str) {
        String[] strs= new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> resp = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i =0; i<strs.length; i++){
            String val = strs[i];
            String key = createKey(val);

            if(!map.containsKey(key))
                map.put(key, new ArrayList<>());

            map.get(key).add(val);
        }
        resp.addAll(map.values().stream().collect(Collectors.toList()));
        System.out.println(resp);
    }

    private static String createKey(String val) {
        char[] chars = new char[26];
        for(char c : val.toCharArray()) {
            chars[c-'a']++;
        }
        return new String(chars);
    }

    private static void old() {
        String[] strs= new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> group = new ArrayList<>();
        Set<String> checked = new HashSet<>();
        for(int i=0;i<strs.length;i++){
            String first = strs[i];
            if(!checked.add(first))
                continue;
            List<String> g = new ArrayList<>();
            int[] charInFirst = convertIntoCharArray(first);
            g.add(first);
            for(int j=i+1;j<strs.length;j++){
                String second = strs[j];
                if(second.length() != first.length())
                    continue;
                int[] charInSecond = convertIntoCharArray(second);
                Boolean exists = checkSame(charInFirst, charInSecond);
                if(exists) {
                    checked.add(second);
                    g.add(second);
                }
            }
            group.add(g);
        }
        System.out.println(group);
    }

    private static Boolean checkSame(int[] val, int[] val1) {
        for(int i=0;i<26;i++)
            if(val[i] != val1[i])
                return false;
        return true;
    }

    private static int[] convertIntoCharArray(String a) {
        int[] val = new int[26];
        for(char c : a.toCharArray()) {
            int v = c-'a';
            val[v] = val[v]+1;
        }
        return val;
    }

}
