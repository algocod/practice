package algorithms.graph;
/**
 * THe key here is while doing DFS from a cell , visit it , and then look for all combinations from that point.
 * Once all recursion have taken place , set the cell value back or make it visited false.
 * This key step is to allow for other combinations to consider this cell in their answer. 
 * @author hemant
 *
 	[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
	"ABCCED"
	True
 */
public class FindWordsIn2DArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public boolean exist(char[][] board, String word) {
	    for(int i = 0; i < board.length; i++)
	        for(int j = 0; j < board[0].length; j++){
	            if(exist(board, i, j, word, 0))
	                return true;
	        }
	    return false;
	}
	private boolean exist(char[][] board, int i, int j, String word, int ind){
	    if(ind == word.length()) return true;
	    if(i > board.length-1 || i <0 || j<0 || j >board[0].length-1 || board[i][j]!=word.charAt(ind))
	        return false;
	    board[i][j]='*';
	    boolean result =    exist(board, i-1, j, word, ind+1) ||
	                        exist(board, i, j-1, word, ind+1) ||
	                        exist(board, i, j+1, word, ind+1) ||
	                        exist(board, i+1, j, word, ind+1);
	    board[i][j] = word.charAt(ind);
	    return result;
	}
}
