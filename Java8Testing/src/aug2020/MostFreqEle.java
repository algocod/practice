package aug2020;
import java.util.*;

public class MostFreqEle {

    //public HashMap<String,Pair> hmp = new HashMap<>();
    //public TreeSet<Pair> order = new TreeSet<>();
    
    public HashMap<String,LinkNode> keyAdrs = new HashMap<>();
    public HashMap<Integer,LinkNode> fAdrs = new HashMap<>();
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
		obj.inc("hello");
		obj.inc("world");
		obj.inc("hello");
		obj.dec("world");
		obj.inc("hello");
		obj.inc("leet");
		System.out.println("Maxxxxxxxxxxxxxx"+obj.getMaxKey());

	}
    
    /** Initialize your data structure here. */
    public MostFreqEle() {
        head = new LinkNode(0,null,null);
        tail = new LinkNode(-1,null,head);
        fAdrs.put(0,head);
        fAdrs.put(-1,tail);
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        // doesnt exist
        if(!keyAdrs.containsKey(key))
        {
           // System.out.println("Key being sent--"+key);
            int f = 1;
            if(fAdrs.containsKey(f))
            {
                LinkNode p = fAdrs.get(f);
                p.add(key);
                keyAdrs.put(key,p);
            }
            else
            {
                //System.out.println("Node being added--");
                LinkNode nxt = fAdrs.get(0).next;
                LinkNode prev = fAdrs.get(0);
                LinkNode l = new LinkNode(f,nxt,prev);
                l.add(key);
                fAdrs.put(f,l);
                keyAdrs.put(key,l);
               // printL(l);
                
            }
        }
        else
        {
            LinkNode l = keyAdrs.get(key);
            int f = l.freq;
            f= f+1;
            l.rem(key);
            System.out.println("Node being added--"+key);
            if(fAdrs.containsKey(f))
            {
                LinkNode p = fAdrs.get(f);
                System.out.println("new freq node --"+p.freq);
                p.add(key);
                keyAdrs.put(key,p);
            }
            else
            {
                
                LinkNode prev = fAdrs.getOrDefault(f-1,fAdrs.get(0));
                LinkNode next = fAdrs.getOrDefault(f+1,fAdrs.get(-1));
                LinkNode p = new LinkNode(f,next,prev);
                p.add(key);
                fAdrs.put(f,p);
                keyAdrs.put(key,p);
               // printL(p);
            }
            
            if(l.st.size()==0)
            {
                System.out.println("Node being removed--"+key);
                fAdrs.remove(l.freq);
                LinkNode nxt = l.next;
                LinkNode pre = l.prev;
                pre.next = nxt;
                nxt.prev = pre;
            }
            
        }
        
        
        /*
        System.out.println("Key being sent--"+key);
        if(hmp.containsKey(key))
        {
            Pair ex = hmp.get(key);
            System.out.println("Key being found--"+ex.key);
            ex.val = ex.val+1;
             order.add(ex);
        }
        else
        {
            
            System.out.println("First time entry --"+key);
            Pair ex = new Pair(key,1);
            hmp.put(key,ex);
            System.out.println(order);
            order.add(ex);
            System.out.println(order);
        }
        
       
        //if(key.equalsIgnoreCase("b"))
        //System.out.println(order);
        */
    }
    
    public void printL(LinkNode l)
    {
    	/*
        LinkNode tmp = l;
        System.out.println("forward");
        while(l!=null)
        {
            System.out.println("this is the freq of node "+l.freq);
            System.out.println("this is the content of node "+l.st);
            
            l= l.next;
        }
        tmp = tmp.prev;
        System.out.println("backward");
        while(tmp!=null)
        {
            System.out.println("this is the freq of node "+tmp.freq);
            System.out.println("this is the content of node "+tmp.st);
            tmp= tmp.prev;
        }
        */
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(!keyAdrs.containsKey(key))
            return;
       
        LinkNode currl = keyAdrs.get(key);
        int currf = currl.freq;
        System.out.println("Node being reduced--"+key);
        System.out.println("Freq  being reduced--"+currf);
        if(currf==1)
        {
            keyAdrs.remove(key);
            currl.rem(key);
            
            if(currl.st.size()==0)
            {
                fAdrs.remove(currl.freq);
                LinkNode nxt = currl.next;
                LinkNode pre = currl.prev;
                pre.next = nxt;
                if(nxt!=null)
                {
                    nxt.prev = pre;
                }
            }
        }
        else
        {
            int f  = currf-1;
            currl.rem(key);
            LinkNode less = fAdrs.getOrDefault(f,null);
            if(less==null)
            {
                System.out.println("Node being added for missing freq--"+f);
                LinkNode prev = currl.prev;
                LinkNode next = currl;
                LinkNode l = new LinkNode(f,next,prev);
                l.add(key);
                System.out.println("Node  added for missing freq--"+l);
                fAdrs.put(f,l);
                keyAdrs.put(key,l);
                //printL(l);
            }
            else
            {
                less.add(key);
                keyAdrs.put(key,less);
            }
            
            if(currl.st.size()==0)
            {
                System.out.println("Remove empty freq nodes  -"+currf);
                fAdrs.remove(currf);
                LinkNode nxt = currl.next;
                LinkNode pre = currl.prev;
                 System.out.println("pre node -"+pre); // null
                
                pre.next = nxt;
                
                if(nxt!=null)
                {
                    nxt.prev = pre;
                }
               // printL(pre);
                System.out.println("All good-");
            }
            
            
            
        }
        /*
        Pair ex = hmp.getOrDefault(key, new Pair(key,0));
        ex.val = ex.val-1;
        if(ex.val==0)
        {
          hmp.remove(key);
          order.remove(ex);
        }
        */
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        System.out.println("From the max method  -");
        printL(head);
        printL(tail);
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
        System.out.println("From the min method  -");
        printL(head);
        printL(tail);
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
