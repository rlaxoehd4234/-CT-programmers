package basic_algo;

import java.util.*;

public class BFS {
    static final int MAX_N = 10;
    static int N, E;
    static int[][] Graph = new int[MAX_N][MAX_N];


    static void bfs(int node){
        boolean[] visited = new boolean[MAX_N]; // 방문한 노드를 체크해야 함.

        Queue<Integer> queue = new LinkedList<>();
        visited[node] = true;
        queue.add(node);

        while(!queue.isEmpty()){
            int curr = queue.remove(); // 방문한 노드를 큐에서 제거하고
            System.out.println(curr + " "); // 최근 방문한 노드를 출력 함.

            for(int next = 0; next < N; ++next){
                if(!visited[next] && Graph[curr][next] != 0){ // false 가 아니고 간선이 아니라면 비지트 하고 큐에 추가 해준다.
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

