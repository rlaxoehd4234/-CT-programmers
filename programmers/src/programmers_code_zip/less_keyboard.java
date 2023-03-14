package programmers_code_zip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class less_keyboard {
    static int[] solution(String[] keymap, String[] targets){

        HashMap<Character, Integer> hm = new HashMap<>();
        int[] result = new int[targets.length]; // 카운트를 올려줘야 함.

        for(String key : keymap){
            for(int i = 0; i<key.length(); i++){
                char c = key.charAt(i);
                if(!hm.containsKey(c) || i<hm.get(c)){ // c 값을 포함하지 않고 있거나, i 값이 작은 경우에 해시맵에 푸시
                    hm.put(c,i+1);
                }
            }
        }

        for(int i = 0; i< targets.length; i ++){
            int cnt = 0;
            for(int j = 0; j<targets[i].length(); j ++){
                char c = targets[i].charAt(j);
                if(!hm.containsKey(c)){
                    cnt = 0;
                    break;
                }else {
                    cnt += hm.get(c);
                }
            }
            result[i] = cnt == 0? -1 :cnt;
        }
        return result;


    }


    public static void main(String[] args) throws IOException {
        String [] arr = new String[2];
        String [] target = new String[2];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i< arr.length; i++){
            arr[i] = st.nextToken();
        }

        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i<arr.length; i++){
            target[i] = st.nextToken();
        }

        solution(arr, target);

    }
}
