import java.util.*;

class longestpath{

    //class pair ra tarif mikonim
    private static class pair{
        public int x, y;

        public pair (int a, int b)
        {
            x = a;
            y = b;

        }
    }

    public static void main(String[] args) {
        //tedad house va street ra az karbar migirim
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int s = sc.nextInt();

        Vector<Vector<pair>> answer = new Vector<>();


        for(int i = 0; i < h + 1 ; i = i + 1)
        {
            answer.add(new Vector<pair>());
        }

        for (int j = 0 ; j < s ; j++)
        {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            answer.get(num1).add(new pair(num2, 1));
        }
        //javab ra print mikonim
        System.out.print(longestCable(answer, h));
    }

    static int max_num = Integer.MIN_VALUE;

    private static int longestCable(Vector<Vector<pair>> ans, int start)
    {
        for (int i = 1; i <= start; i++ )
        {
            boolean[] walked = new boolean[start + 1];
            dfs(ans, i, 0, walked );
        }

        return max_num;
    }

    private static void dfs(Vector<Vector<pair>> ans, int first, int last, boolean[] walked) {
        int number = 0 ;
        walked[first] = true;
        pair exp;

        int n =  ans.get(first).size();

        for(int i = 0; i < n ; i++)
        {
            exp = ans.get(first).get(i);

            if (!walked[exp.x])
            {

                number = last + exp.y;

                dfs(ans, exp.x, number, walked);

            }
            if (max_num < number)
            {
                max_num = number;

            }


            number = 0;
        }
    }


}

