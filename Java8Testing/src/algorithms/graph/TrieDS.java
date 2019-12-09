package algorithms.graph;

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
