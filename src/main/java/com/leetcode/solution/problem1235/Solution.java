package com.leetcode.solution.problem1235;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Solution {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Job> jobs = new LinkedList<>();

        for (int i = 0; i < startTime.length; ++i) {
            Job job = new Job();
            job.startTime = startTime[i];
            job.endTime = endTime[i];
            job.profit = profit[i];
            jobs.add(job);
        }

        jobs.sort(Comparator.comparingInt(j -> j.endTime));

        for (Job job : jobs) {

        }

        return 0;
    }

    public class Job {
        public int startTime;

        public int endTime;

        public int profit;
    }
}
