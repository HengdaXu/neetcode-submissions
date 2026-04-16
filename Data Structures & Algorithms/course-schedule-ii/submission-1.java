class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> pre = new ArrayList<>();
        for (int i = 0; i < numCourses; i++){
            pre.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        for (int[] p: prerequisites){
            indegree[p[1]]++;
            pre.get(p[0]).add(p[1]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if (indegree[i] == 0) q.offer(i);
        }

        int total = 0;
        int[] c = new int[numCourses];
        while (!q.isEmpty()){
            int course = q.poll();
            c[numCourses - total - 1] = course; 
            total++;
            for (int post: pre.get(course)){
                if (--indegree[post] == 0){
                    q.offer(post);
                }
            }
        }

        return (total == numCourses) ? c : new int[0];
        
    }
}
