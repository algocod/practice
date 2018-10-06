package techcmpprep;
/**
 * Its a POJO to store num value has key and its frequency as freq
 * @author hemant
 *
 */
public class NumWithFreq 
{
	public Integer key;
	public Integer freq = 0;;
	
	public NumWithFreq(Integer key,Integer f)
	{
		this.key = key;
		this.freq = f;
	}
	
	public String toString()
	{
		return this.key.toString() +"---"+ this.freq.toString();
	}
	
	public void incrementAndSetFreq()
	{
		this.freq = this.freq +1;
	}

}
