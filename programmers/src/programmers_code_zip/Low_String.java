package programmers_code_zip;

public class Low_String {
    static int solution(String t, String p) {
        int answer = 0;
        for(int i = 0; i <t.length()-p.length()+1; i++){
            long x = Long.parseLong(t.substring(i,i+p.length()));
            long y = Long.parseLong(p);
            if(x <= y) answer++;

        }

        return answer;
    }

    public static void main(String[] args) {
        String i = "10212312312312222303";
        String p = "15";
        int x = solution(i,p);
        System.out.println(x);
    }
}
