package basic_algo;

import java.util.*;

public class BFS {
    static final int MAX_N = 10;
    static int N, E;
    static int[][] Graph = new int[MAX_N][MAX_N];


    static void bfs(int node){
        boolean[] visited = new boolean[MAX_N];

        Queue<Integer> queue = new LinkedList<>();
        visited[node] = true;
        queue.add(node);

        while(!queue.isEmpty()){
            int curr = queue.remove();
            System.out.println(curr + " ");

            for(int next = 0; next < N; ++next){
                if(!visited[next] && Graph[curr][next] != 0){
                    visited[next] = true;
                    queue.add(next);
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

