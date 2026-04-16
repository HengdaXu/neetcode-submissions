class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
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

        int index = 0;
        while (!q.isEmpty()){
            int curr = q.poll();
            res[index++] = curr;
            for (int next: post[curr]){
                if (--indegree[next] == 0){
                    q.offer(next);
                }
            }
        }

        return (index == numCourses) ? res : new int[]{};
    }
}
