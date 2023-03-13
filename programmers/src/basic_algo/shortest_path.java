package basic_algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class shortest_path {
    static final int MAX_N = 10;
    static int[][] D = {{-1,0},{1,0},{0,-1},{0,1}}; // DELTA ARRAY;
    static int N;
    static int[][] Board = new int[MAX_N][MAX_N];

    static class Point{
        Point(int r, int c, int d){
            row = r; col = c; dist = d;
        }
        int row, col, dist;
    }
    static int bfs(int sRow, int sCol, int dRow, int dCol){
        boolean[][] visited = new boolean[MAX_N][MAX_N];
        Queue<Point> queue = new LinkedList<>();
        visited[sRow][sCol] = true;
        queue.add(new Point(sRow, sCol, 0));

        while(!queue.isEmpty()){
            Point curr = queue.remove();

            if(curr.row == dRow && curr.col == dCol)
                return curr.dist;

            for(int i = 0; i < 4; ++ i){
                int nr = curr.row + D[i][0] , nc = curr.col + D[i][1];
                if(nr < 0 || nr > N-1 || nc < 0 || nc > N-1) continue; // 범위 밖을 벗어나는 경우
                if(visited[nr][nc]) continue; //방문 했던 곳인 경우
                if(Board[nr][nc] == 1) continue; // 노드에 도착하는 경우
                visited[nr][nc] = true; // 아닌 경우에는 방문 표시를 해주고 큐에 add 를 해준다.
                queue.add(new Point(nr,nc,curr.dist+1));
            }


        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for(int i = 0; i < N; ++i)
            for(int j = 0; j < N; ++j)
                Board[i][j] = sc.nextInt();

        int sRow, sCol, dRow, dCol;
        sRow = sc.nextInt();
        sCol = sc.nextInt();
        dRow = sc.nextInt();
        dCol = sc.nextInt();
        System.out.println(bfs(sRow,sCol,dRow,dCol));

    }
}
