package algorithms.graph;
import java.util.*;
public class SearchInTrie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {
				{'o','a','a','n'},
				{'e','t','a','e'},
				{'i','h','k','r'},
				{'i','f','l','v'}
		};
		 String[] words = {"oath","pea","eat","rain"};
System.out.println( new SearchInTrie().findWords(board, words));
		       //Output: ["eat","oath"]
	}

	public List<String> findWords(char[][] board, String[] words) 
    {
        
        TrieDS base = new TrieDS(null);
		for(String str : words)
		{
			addToTrie(str.toCharArray(), 0, base);
		}
        List<String> ans = new ArrayList<>();
        for(int i =0;i<board.length;i++)
         {
                for(int j =0;j<board[0].length;j++)
                {
                    String init = "";
                    helperT(board, init, i , j, base,ans ) ;
                }
        }
        
        
return ans;               
    }
    
    public  void addToTrie(char[] arr , int index, TrieDS tds)
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
    
    public void helperT(char[][] board, String word, int i , int j, TrieDS tds, List<String> ans )
    {
        int len = board.length;
        int wid = board[0].length;
         if(i<0 || i>=len || j<0 || j>=wid || board[i][j]=='*')
            return ;
        char ch = board[i][j];
        if(tds.arr[ch-'a']==null)
            return;
        else
            tds = tds.arr[ch-'a'];
        if(tds.word!=null && tds.word.equals(word))
        {
            ans.add(word);
            tds.word = null;
            return;
        }
        word = word + ch;
        board[i][j] = '*';
        helperT(board,word,i+1,j,tds,ans);
        helperT(board,word,i-1,j,tds,ans);
        helperT(board,word,i,j+1,tds,ans);
        helperT(board,word,i,j-1,tds,ans);
        
        board[i][j] = ch;
    }
    public List<String> findWordsOld(char[][] board, String[] words) 
    {
     
        List<String> lst = new ArrayList<>();
        HashSet<String> found = new HashSet<>();
        for(String str : words)
        {
            for(int i =0;i<board.length;i++)
            {
                for(int j =0;j<board[0].length;j++)
                {
                    if(board[i][j]==str.charAt(0) && !found.contains(str))
                    {
                        boolean isP = helper(board,str,i,j);    
                        if(isP)
                        {
                            lst.add(str);
                            found.add(str);
                        }
                            
                    }
                    
                }
            }
        
    
        }
        
        return lst;
    }
   
     public boolean helper(char[][] board, String word, int i , int j )
    {
        int len = board.length;
        int wid = board[0].length;
        if(word==null || word=="" || word.length()<1)
            return true;
         if(i<0 || i>=len || j<0 || j>=wid || board[i][j]=='*')
            return false;
        
        boolean isP = false;
        char tmp = board[i][j];
        if(tmp!=word.charAt(0))
        {
            return false;
        }
        
        board[i][j] = '*';
        isP = isP || helper(board,word.substring(1),i+1,j);
        isP = isP || helper(board,word.substring(1),i-1,j);
        isP = isP || helper(board,word.substring(1),i,j+1);
        isP = isP || helper(board,word.substring(1),i,j-1);
        board[i][j] = tmp;
        return isP;
    }
    
public class TrieDS {

public Character prefix = null;
public String word = null;
// supports only small letters
public TrieDS[] arr = new TrieDS[26]; // it contains position based access like for a b c d e ....


public  TrieDS(Character c)
{
	this.prefix = c;
}

	
}
}