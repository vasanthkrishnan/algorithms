import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

class Items {
    int value;
    int weight;

    public Items(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class FractionalKnapsackProbele {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the no. of items: ");
        int n = input.nextInt();

        Items[] items = new Items[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the weight of the item: " + (i + 1));
            int w = input.nextInt();
            System.out.println("Enter the Profit of the item: " + (i + 1));
            int p = input.nextInt();

            items[i] = new Items(p, w);
        }

        System.out.println("Enter the Total Weight: ");
        int totalWeight = input.nextInt();

        double maxProfit = findMaxProfit(items, totalWeight);
        System.out.println("The maximum Profit is : " + maxProfit);

        input.close();
    }

    static double findMaxProfit(Items[] items, int totalWeight) 
    {
        if(totalWeight == 0) 
        {
            return 0.0;
        }

        Arrays.sort(items, new Comparator<Items>() {
            public int compare(Items i1, Items i2)
            {
                double result1 = (double) i1.value / i1.weight;
                double result2 = (double) i2.value / i2.weight;

                return Double.compare(result2, result1);
            }
        });

        double maxProfit = 0.0;

        for(Items item : items)
        {
            if(totalWeight >= item.weight)
            {
                totalWeight -= item.weight;
                maxProfit += item.value;
            }
            else
            {
                maxProfit += (double) item.value * totalWeight / item.weight;
                break;
            }
        }
        return maxProfit;
    }
}
