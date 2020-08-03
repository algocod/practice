package aug2020;
import java.util.*;

public class MostFreqEle {

    //public HashMap<String,Pair> hmp = new HashMap<>();
    //public TreeSet<Pair> order = new TreeSet<>();
    
    public HashMap<String,LinkNode> keyAdrs = new HashMap<>();
    public LinkNode head = null;
    public LinkNode tail = null;
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MostFreqEle obj = new MostFreqEle();
		//obj.inc("hello"); test case 1
		/* Test case 2
		["inc","inc","inc","inc","inc","inc","dec", "dec","getMinKey","dec","getMaxKey","getMinKey"]
		[["a"],["b"],["b"],["c"],["c"],["c"],["b"],["b"],	[],		  ["a"],	[],			[]]
		*/
		/*
		obj.inc("a"); 
		obj.inc("b");obj.inc("b");
		obj.inc("c");obj.inc("c");obj.inc("c");
		obj.dec("b");obj.dec("b");
		System.out.println("Minnnnnnnnnnnnnn"+obj.getMinKey());
		obj.dec("a");
		System.out.println("Maxxxxxxxxxxxxxx"+obj.getMaxKey());
		System.out.println("Minnnnnnnnnnnnnn"+obj.getMinKey());
		*/
		/*
		 ["AllOne","inc",	"inc",	"inc",		"dec",	"inc",		"inc",	"getMaxKey"]
[[],			["hello"],["world"],["hello"],["world"],["hello"],["leet"],		[]]
		 * */
	/* Test case 12 
		obj.inc("hello");
		obj.inc("world");
		obj.inc("hello");
		obj.dec("world");
		obj.inc("hello");
		obj.inc("leet");
		System.out.println("Maxxxxxxxxxxxxxx"+obj.getMaxKey());
*/
		// Test case 4
/* 
["AllOne","inc","inc","getMaxKey","getMinKey","inc","getMaxKey","getMinKey"]
[[],["hello"],["hello"],[],[],["leet"],[],[]]
		*/
		obj.inc("hello");
		obj.inc("hello");
		System.out.println("Maxxxxxxxxxxxxxx"+obj.getMaxKey());
		System.out.println("Minnnnnnnnnnnnnn"+obj.getMinKey());
		obj.inc("leet");
		System.out.println("Maxxxxxxxxxxxxxx"+obj.getMaxKey());
		System.out.println("Minnnnnnnnnnnnnn"+obj.getMinKey());
		obj.inc("leet");
	}
    
    /** Initialize your data structure here. */
    public MostFreqEle() {
        head = new LinkNode(0,null,null);
        tail = new LinkNode(-1,null,head);
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        // doesnt exist
        if(!keyAdrs.containsKey(key))
        {
            int f = 1;
            if(head.next.freq==f)
            {
                LinkNode p = head.next;
                p.add(key);
                keyAdrs.put(key,p);
            }
            else
            {
                LinkNode nxt = head.next;
                LinkNode prev = head;
                LinkNode l = new LinkNode(f,nxt,prev);
                l.add(key);
                keyAdrs.put(key,l);
                
            }
        }
        else
        {
            LinkNode l = keyAdrs.get(key);
            int f = l.freq;
            f= f+1;
            l.rem(key);
            if(l.next.freq==f)
            {
                LinkNode p = l.next;
                p.add(key);
                keyAdrs.put(key,p);
            }
            else
            {
                
                LinkNode prev = l;
                LinkNode next = l.next;
                LinkNode p = new LinkNode(f,next,prev);
                p.add(key);
                keyAdrs.put(key,p);
            }
            
            if(l.st.size()==0)
            {
                clean(l);
            }
            
        }
    }
    
    
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(!keyAdrs.containsKey(key))
            return;
       
        LinkNode currl = keyAdrs.get(key);
        int currf = currl.freq;
        if(currf==1)
        {
            keyAdrs.remove(key);
            currl.rem(key);
            
            if(currl.st.size()==0)
            {
                clean(currl);
            }
        }
        else
        {
            int f  = currf-1;
            currl.rem(key);
            LinkNode less = currl.prev;
            if(less.freq!=f)
            {
                LinkNode prev = currl.prev;
                LinkNode next = currl;
                LinkNode l = new LinkNode(f,next,prev);
                l.add(key);
                keyAdrs.put(key,l);
            }
            else
            {
                less.add(key);
                keyAdrs.put(key,less);

            }
            
            if(currl.st.size()==0)
            {
                clean(currl);
            }
            
            
            
        }
    }
    
    public void clean(LinkNode currl)
    {
        LinkNode nxt = currl.next;
        LinkNode pre = currl.prev;

        pre.next = nxt;
        nxt.prev = pre;
    }
     
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        
        if(tail!=null)
            return tail.prev.getEle();
        else
            return "";
        
        /*
        if(order.size()>0)
            return order.last().key;
        else
            return "";
            */
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
    	
        if(head.next!=null)
            return head.next.getEle();
        else
            return "";
        
        /*
        if(order.size()>0)
            return order.first().key;
        else
            return "";
        */
    }
    
    public class LinkNode
    {
        public LinkNode next = null;
        public LinkNode prev = null;
        public HashSet<String> st = new HashSet<>();
        public int freq = 0;
        
        public LinkNode(int f,LinkNode nxt , LinkNode pre)
        {
            this.freq = f;
            this.next = nxt;
            this.prev = pre;
            if(pre!=null)
                pre.next = this;
            if(nxt!=null)
            	nxt.prev = this;
        }
        
        public void add(String key)
        {
            st.add(key);
        }
        
        public void rem(String key)
        {
            st.remove(key);
        }
        
        public String getEle()
        {
            if(st.size()>0)
            return st.iterator().next();
            else
                return "";
        }
        
    }
    
    // Heap based logn performance.
    /*
    public class Pair implements Comparable
    {
        public String key = "";
        public Integer val = null;
        public Pair(String key, Integer val)
        {
            this.key = key;
            this.val = val;
        }
        
        public Integer getValue(){
            return this.val;
        }
        
        public String getKey()
        {
            return this.key;
        }
        @Override
        public int compareTo(Object next) {
        Pair orig = (Pair)next;
    if(val>orig.val){  
        return 1;  
    }else if(val<orig.val){  
        return -1;  
    }else{  
    return 0;  
    }
    }
        @Override
        public boolean equals(Object to)
        {
            Pair next = (Pair)to;
            if(next.key.equalsIgnoreCase(key))
            {
                
                return true;   
            }
            else
            {
                System.out.println("Different objects--"+ key+"---"+next.key);
                return false;
            }
                
        }
    public String toString()
    {
        return key+"__"+val;
    }
}
*/

}
