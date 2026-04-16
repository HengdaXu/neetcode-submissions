class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> pre = new ArrayList<>();
        for (int i = 0; i < numCourses; i++){
            pre.add(new ArrayList<>());
        }

        for (int[] req: prerequisites){
            indegree[req[1]]++;
            pre.get(req[0]).add(req[1]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if (indegree[i] == 0) q.offer(i);
        }

        int[] res = new int[numCourses];
        int finish = 0;
        while (!q.isEmpty()){
            int curr = q.poll();
            res[numCourses - finish - 1] = curr;
            finish++;
            for (int nei: pre.get(curr)){
                if (--indegree[nei] == 0) q.offer(nei);
            }
        }

        return (finish == numCourses) ? res : new int[]{};
    }
}
