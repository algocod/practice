package priorityQ;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Input: numOfSubFiles = 4, files = [20, 4, 8, 2]
Output: 54
Example 2:

Input: numOfSubFiles = 6, files = [1, 2, 5, 10, 35, 89]
Output: 224
Example 3:

Input: numOfSubFiles = 4, files = [2, 2, 3, 3]
Output: 20
 * @author hemant
 *
 */
public class MergeFiles2AtaTime {

	public static void main(String[] args) {

		List<Integer> li = new ArrayList<>();
		int[] input = {20,4,8,2};
		for(int a : input)
			li.add(a);
		System.out.println(minimumTime(li.size(), li));
	}

	public static int minimumTime(int numOfSubFiles, List<Integer> files) {
	    PriorityQueue<Integer> mergeQueue = new PriorityQueue<>(files);

	    int time = 0;
	    while(mergeQueue.size() != 1) {
	        // merge always the smallest two files
	        int mergedFile = mergeQueue.poll() + mergeQueue.poll();
	        time += mergedFile;
	        mergeQueue.add(mergedFile);
	    }
	    return time;
	}
	
}
