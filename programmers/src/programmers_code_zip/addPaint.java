package programmers_code_zip;

public class addPaint {
    static int solution(int n, int m, int[] section) {
        int answer = 0;
        int max = 0;

        for(int i = 0; i < section.length; i++){
            if(section[i] < max) { // max 값보다 작으면 실행 아니면 멈춤 
                continue;
            }
            answer++;
            max = section[i] + m;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 4;
        int m = 1;
        int[] array = {1,2,3,4};

        int x = solution(n,m,array);
        System.out.println(x);
    }
}
