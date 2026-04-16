public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];           // 入度数组
        List<List<Integer>> adj = new ArrayList<>();    // 邻接表（正向）
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // 构建正向图：b → a
        for (int[] pre : prerequisites) {
            int a = pre[0], b = pre[1];
            adj.get(b).add(a);   // 从 b 指向 a
            indegree[a]++;       // a 的入度 +1
        }

        // 初始化队列：入度为 0 的课程
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int finish = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            finish++;
            for (int nei : adj.get(node)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.add(nei);
                }
            }
        }

        return finish == numCourses;
    }
}
