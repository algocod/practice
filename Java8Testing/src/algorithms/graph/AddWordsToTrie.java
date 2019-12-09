package algorithms.graph;

public class AddWordsToTrie {

	public static void main(String[] args) {

		String[] arr = {"oath","pea","eat","rain","oat","oatssss"};
		TrieDS base = new TrieDS(null);
		for(String str : arr)
		{
			addToTrie(str.toCharArray(), 0, base);
		}
		String find = "oatssss";// gives true means substring is also true.
		boolean isP = find(base,find.toCharArray(),0);
		System.out.println(isP);
	}
	
	public static void addToTrie(char[] arr , int index, TrieDS tds)
	{
		if(index>=arr.length)
		{
			tds.word = new String(arr);
			return;
		}
			
		char ch = arr[index];
		if(tds.arr[ch-'a']==null)
		{
			TrieDS tmp = new TrieDS(ch);
			tds.arr[ch-'a'] = tmp;
		}
		
		addToTrie(arr, index+1, tds.arr[ch-'a']);
	}
	
	public static boolean find(TrieDS base, char[] arr, int index)
	{
		if(base.word!=null && new String(arr).equals(base.word))
			return true;
		
		if(index>=arr.length)
			return false;
	
		char ch = arr[index];
		if(base.arr[ch-'a']==null)
			return false;
		else
			return find(base.arr[ch-'a'], arr, index+1);
	}

}
