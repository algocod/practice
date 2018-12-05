package algorithms.strings;

/**
 * Input:
["a","a","b","b","c","c","c"]

Output:
Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

Explanation:
"aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".

Input:
["a"]

Output:
Return 1, and the first 1 characters of the input array should be: ["a"]

Explanation:
Nothing is replaced.
 

Example 3:

Input:
["a","b","b","b","b","b","b","b","b","b","b","b","b"]

Output:
Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].

Explanation:
Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
Notice each digit has it's own entry in the array.
 * @author hemant
 *
 */
public class CompressStrings {

	public static void main(String[] args) {

	}
	
    public int compress(char[] chars) 
    {
        StringBuffer sb = new StringBuffer();
        compS(chars,0,sb);
        //System.out.println(sb.toString());
        char[] ret = sb.toString().toCharArray();
        int i =0;
        for(Character c : ret)
        {
            chars[i] = c;
            i++;
        }
        return ret.length;
    }
    
    public void compS(char[] arr, int index,StringBuffer sb)
    {
        if(index>arr.length-1)
            return;
        if(index==arr.length-1)
        {
            sb.append(arr[index]);
            return;
        }
            
        
        char c = arr[index];
        int count = 0;
        while(index<arr.length && arr[index]==c)
        {
            count++;
            index++;
        }
        sb.append(c);
        if(count>1)
            sb.append(count);
        compS(arr,index,sb);
        
    }


}
