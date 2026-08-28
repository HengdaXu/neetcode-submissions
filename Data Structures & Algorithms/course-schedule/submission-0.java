class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // b - > a
        int[] indegree = new int[numCourses];
        HashMap<Integer, List<Integer>> neigh = new HashMap<>();

        for (int i = 0; i < numCourses; i++){
            neigh.put(i, new ArrayList<>());
        }
        for (int[] pre: prerequisites){
            indegree[pre[0]]++;
            neigh.get(pre[1]).add(pre[0]);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++){
            if (indegree[i] == 0) queue.offer(i);
        }

        int taken = 0;
        while (!queue.isEmpty()){
            int course = queue.poll();
            taken++;
            System.out.println(course);
            for (int nei: neigh.get(course)){
                indegree[nei]--;
                if (indegree[nei] == 0) queue.offer(nei);
            }
        }

        return taken == numCourses;
    }
}
