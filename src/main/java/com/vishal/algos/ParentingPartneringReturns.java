package com.vishal.algos;

import java.util.*;
public class ParentingPartneringReturns {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        int number = 1;
        while(testCases-- > 0) {
            String answer = "";
            Set<String> cTime = new HashSet<>();
            Set<String> jTime = new HashSet<>();
            int activities = sc.nextInt();
            List<Time> time = new ArrayList<>();
            int activity = 1;
            while(activities-- > 0) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                time.add(new Time(start, true,activity ));
                time.add(new Time(end, false,activity ));
                activity++;
            }
            Collections.sort(time,
                    (Comparator<Time>) (o1, o2) -> o1.time == o2.time ? o1.activity - o2.activity : o1.time - o2.time);
            boolean cFree = true;
            boolean jFree = true;
            int cActivity = 0;
            int jActivity = 0;
            for(Time t : time) {
                if(cFree && t.start) {
                    answer += "C";
                    cActivity = t.activity;
                    cFree = false;
                }else if(jFree && t.start) {
                    answer += "J";
                    jActivity = t.activity;
                    jFree = false;
                }else if(!t.start && !cFree && t.activity == cActivity)
                    cFree = true;
                else if(!t.start && !jFree && t.activity == jActivity)
                    jFree = true;
                else if(!jFree && !cFree) {
                    answer = "IMPOSSIBLE";
                    break;
                }
            }
            System.out.println("Case #"+number++ +": "+
                    answer);
        }
    }


    private void old() {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        int number = 1;
        while(testCases-- > 0) {
            String answer = "";
            Set<String> cTime = new HashSet<>();
            Set<String> jTime = new HashSet<>();
            int activities = sc.nextInt();
            while(activities-- > 0) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                if(cTime.isEmpty()) {
                    cTime.add(start+","+end);
                    answer += "C";
                    continue;
                }
                boolean timeOverlap = false;
                for(String time : cTime) {
                    if(timeOverlap)
                        break;
                    String[] timeArr = time.split(",");
                    int s = Integer.parseInt(timeArr[0]);
                    int e = Integer.parseInt(timeArr[1]);
                    if((start > s && end < e) ||
                            (start < s && end > e) ||
                            (start < s && end > s && end < e) ||
                            (start > s && start < e && end > e))
                        timeOverlap = true;
                }

                if(!timeOverlap) {
                    cTime.add(start+","+end);
                    answer += "C";
                    continue;
                }

                timeOverlap = false;
                for(String time : jTime) {
                    if(timeOverlap)
                        break;
                    String[] timeArr = time.split(",");
                    int s = Integer.parseInt(timeArr[0]);
                    int e = Integer.parseInt(timeArr[1]);
                    if((start > s && end < e) ||
                            (start < s && end > e) ||
                            (start < s && end > s && end < e) ||
                            (start > s && start < e && end > e))
                        timeOverlap = true;
                }

                if(timeOverlap) {
                    answer = "IMPOSSIBLE";
                    break;
                }
                jTime.add(start+","+end);
                answer += "J";
            }
            System.out.println("Case #"+number++ +": "+
                    answer);
        }
    }
}

 class Time {
    Integer time;
    Boolean start;
    Integer activity;
    public Time(Integer time, Boolean start, Integer activity) {
        this.time = time;
        this.start = start;
        this.activity = activity;
    }
}
