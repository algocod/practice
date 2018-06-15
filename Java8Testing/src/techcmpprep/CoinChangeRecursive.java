package techcmpprep;

import java.util.Arrays;

public class CoinChangeRecursive 
{
	
	public static void main(String[] args)
	{
		int[] arr = {25,10,5,1};
		int sum = 27;
		
		int num = canChange(sum, arr,0);
		
	}
	
	public static int canChange(int money , int[] coinList , int index)
	{
		if(money==0)
			return 1;
		if(index >=coinList.length)
			return 0;
		
		int ways = 0;
		int amountWithCoins = 0;
		
		while (amountWithCoins<=money)
		{
			int remaining = money - amountWithCoins;
			ways = ways + canChange(remaining, coinList, index+1);
			amountWithCoins += coinList[index];
		}
		
		return ways;
	}

}
