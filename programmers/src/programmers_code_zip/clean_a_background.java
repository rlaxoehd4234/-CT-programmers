package programmers_code_zip;

import java.util.Scanner;

public class clean_a_background {
    public int[] solution(String[] wallpaper){
        int minRow,minCol; // 가장 낮은 좌표값
        int maxRow,maxCol; // 가장 높은 좌표값

        minRow = minCol = Integer.MAX_VALUE; // 예상값보다 큰값 예외 처리를 위해서 선언함
        maxRow = maxCol = Integer.MIN_VALUE; // 예상값 보다 작은 값 예외 처리를 위해서 선언함

        int row = wallpaper.length; // wallpaper 의 row 값 행렬
        int col = wallpaper[0].length(); // wallpaper 의 col 값 행렬

        for(int r = 0; r < row; r++){ // 모든 배열을 traverse 하면 된다.
            for(int c = 0; c< col; c++){
                if(wallpaper[r].charAt(c) == '#'){
                    minRow = Math.min(minRow,r);
                    minCol = Math.min(minCol,c);
                    maxRow = Math.max(maxRow,r);
                    maxCol = Math.max(maxCol,c);
                }
            }
        }

    return new int[]{minRow,minCol,maxRow+1,maxCol+1};
    }
}
