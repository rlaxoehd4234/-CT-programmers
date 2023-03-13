package basic_algo;

import java.util.*;

public class BFS {
    static final int MAX_N = 10;
    static int N, E;
    static int[][] Graph = new int[MAX_N][MAX_N];


    static void bfs(int node){
        boolean[] visited = new boolean[MAX_N]; // 방문한 노드를 체크해야 함.

        Queue<Integer> queue = new LinkedList<>(); // 노드를 담아주는 큐 (선입선출 컬렉션)
        visited[node] = true; // 시작점은 방문 후에 시작하기에 true 로 변경해준다.
        queue.add(node); // 큐에 시작점을 추가한다.

        while(!queue.isEmpty()){
            int curr = queue.remove(); // 방문한 노드를 큐에서 제거하고
            System.out.println(curr + " "); // 최근 방문한 노드를 출력 함.

            for(int next = 0; next < N; ++next){
                if(!visited[next] && Graph[curr][next] != 0){
                    visited[next] = true;
                    queue.add(next); // queue 에 추가해주고 나중에 제거한다.
                }
            }
        }

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        E = sc.nextInt();

        for (int i = 0; i < E; ++i) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            Graph[u][v] = Graph[v][u] = 1;
        }
        bfs(0);
    }

}

