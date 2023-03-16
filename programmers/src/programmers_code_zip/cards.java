package programmers_code_zip;

public class cards {
    static String solution(String[] cards1, String[] cards2, String[] goal) {

        int cnt1 = 0;
        int cnt2 = 0;
        int i = 0;

        while (goal.length != i) {
            if ( cards1.length > cnt1 && goal[i].equals(cards1[cnt1]) ) {
                cnt1++;
            } else if (cards2.length > cnt2 && goal[i].equals(cards2[cnt2])) {
                cnt2++;
            } else return "No";
        i++;
        }

       return "Yes";
    }

    public static void main(String[] args) {
        String[] array1 = {"i","drink","water"};
        String[] array2 = {"want","to"};
        String[] array3 = {"i","want","to","drink","water"};

        String result = solution(array1,array2,array3);

        System.out.println(result);
    }
}
