class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<Integer>[] neighbour = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++){
            neighbour[i] = new ArrayList<>();
        }

        for (int[] pre: prerequisites){
            indegree[pre[0]]++;
            neighbour[pre[1]].add(pre[0]);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++){
            if (indegree[i] == 0) queue.offer(i);
        }

        int[] res = new int[numCourses];
        int taken = 0;
        while (!queue.isEmpty()){
            int course = queue.poll();
            res[taken++] = course;
            for (int nei: neighbour[course]){
                indegree[nei]--;
                if (indegree[nei] == 0) queue.offer(nei);
            }
        }

        return (taken == numCourses) ? res : new int[]{};
    }
}
