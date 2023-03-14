package basic_algo;

import java.util.Scanner;
import java.util.Stack;

public class DFS_Flood_Fill {
    static final int MAX_N = 10;
    static int N;
    static int[][]D = {{-1,0},{1,0},{0,-1},{0,1}};
    static int[][]Board = new int[MAX_N][MAX_N];
    static class Point{
        Point(int r, int c){ row = r; col = c;}
        int row, col;
    }

    static void dfs(int sRow, int sCol, int color){
        boolean[][] Visited = new boolean[MAX_N][MAX_N]; // 방문한 필드를 체크해주기 위한 배열
        Stack<Point> mystack = new Stack<>(); // LIFO 방식으로 운영됨
        mystack.push(new Point(sRow,sCol)); // 시작점을 먼저 stack 에 push 해야 함.

        while(!mystack.empty()){
            Point curr = mystack.pop(); // 깊이 우선 탐색에서는 들어왔던 node 를 먼저 pop 해줘야 함.
            if(Visited[curr.row][curr.col]) continue; // 탐색한 node 면 진행
            Visited[curr.row][curr.col]=true; // 탐색된 노드에 표시
            Board[curr.row][curr.col] = color; // 0 인 node 에 색칠

            for(int i =0; i<4; ++i){
                int nr = curr.row + D[i][0], nc = curr.col + D[i][1]; // 양 옆의 배열에 색칠해 줌.
                if(nr <0 || nr > N-1 || nc < 0 || nc >N-1) continue; // 배열 밖 예외처리
                if(Visited[nr][nc]) continue;; // 방문한 배열은 pass
                if(Board[nr][nc] == 1) continue; // node pass
                mystack.push(new Point(nr, nc));
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for(int i =0; i <N; ++i)
            for(int j = 0; j < N; ++j)
                Board[i][j] = sc.nextInt();

        int sRow = sc.nextInt(), sCol = sc.nextInt();
        int color = sc.nextInt();
        dfs(sRow,sCol, color);
        for( int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                System.out.print(Board[i][j] + " ");
            }
            System.out.println();
        }

    }
}
