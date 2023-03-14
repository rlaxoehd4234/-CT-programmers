package basic_algo;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Stack;

public class DFS_Stack {

    static final int MAX_N = 10;
    static int N,E;
    static int[][] Graph = new int[MAX_N][MAX_N];

    static void dfs(int node) {
       boolean[] visited = new boolean[MAX_N];

       Stack<Integer> mystack = new Stack<>();
       mystack.push(node);

       while(!mystack.empty()) {
           int curr = mystack.pop();

           if (visited[curr]) continue;

           visited[curr] = true;
           System.out.println(curr + " ");

           for (int next = 0; next < N; ++next) {

               if (!visited[next] && Graph[curr][next] != 0) {
                   mystack.push(next);
               }
           }
       }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        E = sc.nextInt();
        for(int i = 0; i < E; ++i){
            int u = sc.nextInt();
            int v = sc.nextInt();
            Graph[u][v] = Graph[v][u] = 1;
        }

        dfs(0);
    }
}
