class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> pre = new ArrayList<>();
        for (int i = 0; i < numCourses; i++){
            pre.add(new ArrayList<>());
        }

        for (int[] course: prerequisites){
            indegree[course[1]]++;
            pre.get(course[0]).add(course[1]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if (indegree[i] == 0) q.offer(i);
        }

        int finish = 0;
        while (!q.isEmpty()){
            int c = q.poll();
            finish++;
            for (int nei: pre.get(c)){
                if (--indegree[nei] == 0) q.offer(nei);
            }
        }
        return finish == numCourses;
    }
}
