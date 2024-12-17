import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

class Items {
    int value, weight;

    public Items(int value, int weight) 
    {
        this.value = value;
        this.weight = weight;
    }
}

public class GreedyKnapsackProblem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter size of the Items: ");
        int n = input.nextInt();
        Items[] items = new Items[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the weight of the Item: " + (i + 1));
            int w = input.nextInt();
            System.out.println("Enter the profit of the Item: " + (i + 1));
            int p = input.nextInt();
            items[i] = new Items(p, w);
        }
        int totalWeight = input.nextInt();

        int maxProfit = greedyKnapsackProblem(items, totalWeight);
        System.out.println("Maximum profit is : " + maxProfit);

        input.close();
    }
    public static int greedyKnapsackProblem(Items[] items, int totalWeight)
    {
        if(totalWeight == 0)
        {
            return 0;
        }

        Arrays.sort(items, new Comparator<Items>() {
            
            public int compare(Items i1, Items i2)
            {
                double result1 = (double) i1.value / i1.weight;
                double result2 = (double) i2.value / i2.weight;

                return Double.compare(result2, result1);
            }
        });

        int maxProfit = 0;
        for(Items item : items)
        {
            if(totalWeight >= item.weight)
            {
                maxProfit += item.value;
                totalWeight -= item.weight;
            }
        }
        return maxProfit;
    }
}
