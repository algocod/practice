package addepar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashSet;
import java.util.PriorityQueue;

public class AddeparQuestion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inputDir = args[0];
		String outputFile = args[1];
		parseFile(inputDir,outputFile);
	}
	
	public  static void parseFile(String inputDir, String outputFile)
	{
		//String inputDir = "C:/Study/Interview/addepar";
		//String outputFile = "C:/Study/Interview/addepar/result.txt";
		HashSet<String> hst = new HashSet<>();
		
		File folder = new File(inputDir); 
		File[] listOfFiles = folder.listFiles();
		LinkNode[] lists = new LinkNode[listOfFiles.length];
		int i = 0;
		for (File file : listOfFiles) 
		{ 
			if (file.isFile()) 
			{ 
				LinkNode dummy = new LinkNode("dummy");
				LinkNode prev = dummy;
				String fname = file.getName();
				String fpath = file.getPath();
				System.out.println(fpath+"-----"+fname);
				try(BufferedReader br = new BufferedReader(new FileReader(file.getPath())))
				{
					String line = br.readLine();
					while(line!=null)
					{
						if(line!=null && line.trim()!=null && line.trim().length()>0)
						{
							String fline = line.trim();
							System.out.println(fline);
							if(hst.contains(fline))
							{
								System.out.println("already here----"+fline);
							}
							else
							{
								hst.add(fline);
								if(prev.val!="dummy" && prev.val.compareTo(fline)>0)
								{
									throw new Exception("NOT sorted in lexicographical order");
								}
								LinkNode node = new LinkNode(fline);
								prev.next = node;
								prev = node;
							}
							
						}
						line = br.readLine();
					}
				
				lists[i] = dummy.next;
				i++;
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
					System.exit(1);
				}
			} 
		}
		
		mergeSortedLL(lists,outputFile);

}
	
	public static void mergeSortedLL(LinkNode[] ll, String outputFile)
	{
		
        PriorityQueue<LinkNode> pq = new PriorityQueue<>( (a,b) -> a.val.compareTo(b.val));
        
        for(int i=0;i<ll.length;i++)
        {
            if(ll[i]!=null)
            	pq.offer(ll[i]);
                
        }
        
        Writer writer = null; 
		try { 
			
				writer = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(outputFile), "utf-8"));
				
			        
	        while(!pq.isEmpty())
	        {
	            LinkNode tmp = pq.poll();
	            //System.out.println("popping out min  "+ tmp.val);
	            if(tmp.next!=null)
	                pq.offer(tmp.next);
	            
	            writer.write(tmp.val);
	            writer.write(System.lineSeparator());
	            System.out.println(tmp.val);
	        }
	        
	    	writer.flush();
			writer.close();
		}
		catch (IOException ex) 
		{ 
			 
			System.out.println("Erggg-----Errors");
		}
		finally { 
			try {
				writer.close();
			}catch(Exception e)
			{
				
			}
		}
		
	}

static class LinkNode
{
    String val;
    LinkNode next;
    LinkNode(String x) { val = x; }
}

}
