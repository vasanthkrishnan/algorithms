import java.util.Scanner;

public class KnapsackProblem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of the item: ");
        int n = input.nextInt();
        int[] weight = new int[n];
        int[] profit = new int[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the weight of item : " + (i + 1));
            weight[i] = input.nextInt();
            System.out.println("Enter the profit of item : " + (i + 1));
            profit[i] = input.nextInt();
        }
        System.out.println("Enter the Weight: ");
        int totalWeight = input.nextInt();

        int maxProfit = knapsackProblem(weight, profit, totalWeight);

        System.out.println("The maximum weight is : " + maxProfit);

        input.close();
    }
    public static int knapsackProblem(int[] weight, int[] profit, int totalWeight)
    {
        int n = weight.length;

        if(n == 0 || totalWeight == 0)
        {
            return 0;
        }

        int[][] dp = new int[n + 1][totalWeight + 1];

        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= totalWeight; j++)
            {
                if(weight[i - 1] <= j)
                {
                    dp[i][j] = Math.max(profit[i - 1] + dp[i - 1][j - weight[i - 1]], dp[i - 1][j]);
                }
                else
                {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][totalWeight];
    }
}