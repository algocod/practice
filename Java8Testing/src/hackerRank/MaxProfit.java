package hackerRank;

import java.util.Scanner;

public class MaxProfit {
	
	/** Stock prices coming in every n minutes but the algo trader has a way to know it before hand. The logic is to maximize the profit out of it .
	 * only can buy 1 or sell whatever is there. 
2
4
1 98 1 100
200
	 * @param args
	 */

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCaseNum = in.nextInt();
		for (int i = 0 ; i<testCaseNum;i++)
		{
			int minTick = in.nextInt();
			int[] priceTick = new int[minTick];
			
			for(int j = 0; j<minTick;j++)
			{
				priceTick[j]=in.nextInt();
			}
			
			int[] profitPerTick = new int[minTick];
			int profMin = 0;
			for(int k =0;k<minTick-1;k++)
			{
				int pf = 0;
				for(int p =k+1;p<minTick;p++)
				{
					pf = priceTick[p]-priceTick[k];
					if(pf>0)
					{
						if (pf>profitPerTick[k])
							profitPerTick[k] = pf;
					}
						
				}
			}
			int totalProfit = 0;
			for(int m =0; m<profitPerTick.length;m++)
			{
				totalProfit = totalProfit+profitPerTick[m];
			}
			System.out.println(totalProfit);
			
			priceTick = new int[]{7,1,5,3,6,4};
			maxProfit(priceTick);
		}
		
	}
	
	// The key here is to understand that one can only hold one security at a time so to maximize profit , one has to buy and sell at every increase in price.
	// 
	public static int maxProfit(int[] prices) 
    {
        int total = 0;
    for (int i=0; i< prices.length-1; i++) {
        if (prices[i+1]>prices[i]) total += prices[i+1]-prices[i];
    }
    
    return total;
    }

}
