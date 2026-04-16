class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        
        List<Integer>[] post = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++){
            post[i] = new ArrayList<>();
        }

        for (int[] pre: prerequisites){
            indegree[pre[0]]++;
            post[pre[1]].add(pre[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if (indegree[i] == 0) q.offer(i);
        }

        int courses = 0;
        while (!q.isEmpty()){
            int curr = q.poll();
            courses++;
            for (int c: post[curr]){
                if (--indegree[c] == 0){
                    q.offer(c);
                }
            }
        }
        return courses == numCourses;
    }
}
