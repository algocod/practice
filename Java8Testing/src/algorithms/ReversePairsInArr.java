package algorithms;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class ReversePairsInArr {

	public static void main(String[] args) {
		int[] input = { 1, 3, 2, 3, 1 };
		// int[] input =
		// {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
		TreeMap<Integer, LinkedList<String>> tmp = new TreeMap<>();
		tmp.computeIfAbsent(5, k -> new LinkedList<>()).add("abc");
		
		double db = 2.0;
		double ch = 1.0;
		double diff = db-ch;
		int d = (int) (diff*100);
			
		int cnt = new ReversePairsInArr().reversePairs(input);
		System.out.println(cnt);
	}

	public int reversePairs(int[] nums) {
		TreeMap<Long, Integer> tmp = new TreeMap<>();

		for (int i = 0; i < nums.length; i++) {
			long key = nums[i];
			key = key * 2;
			tmp.put(key, tmp.getOrDefault(key, 0) + 1);
		}
		int tc = 0;
		for (int i = 0; i < nums.length; i++) {
			long key = nums[i];
			key = key * 2;
			int freq = tmp.get(key);
			if (freq == 1)
				tmp.remove(key);
			else
				tmp.put(key, freq - 1);
			tc += getNum(tmp, nums[i]);
		}

		return tc;
	}

	public int getNum(TreeMap<Long, Integer> ts, int num) {
		int cnt = 0;
		for (Map.Entry<Long, Integer> mpe : ts.entrySet()) {
			long val = mpe.getKey();
			if (num > val)
				cnt = cnt + mpe.getValue();
			else
				break;
		}
		return cnt;
	}

}
