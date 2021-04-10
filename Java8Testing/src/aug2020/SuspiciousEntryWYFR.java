/**
 * We are working on a security system for a badged-access room in our company's building.
 *
 * We want to find employees who badged into our secured room unusually often. We have an unordered list of names and entry times over
 * a single day. Access times are given as numbers up to four digits in length using 24-hour time, such as "800" or "2250".
 *
 * Write a function that finds anyone who badged into the room three or more times in a one-hour period. Your function should return each of the employees who fit that criteria,
 * plus the times that they badged in during the one-hour period. If there are multiple one-hour periods where this was true for an employee, just return the first one.
 */
import java.util.*;
import java.lang.Integer;
public class SuspiciousEntryWYFR {

    public static void main(String[] args){
    String[][] btimes = {
  {"Paul",     "1355"},
  {"Jennifer", "1910"},
  {"John",      "835"},
  {"John",      "830"},
  {"Paul",     "1315"},
  {"John",     "1615"},
  {"John",     "1640"},
  {"Paul",     "1405"},
  {"John",      "855"},
  {"John",      "930"},
  {"John",      "915"},
  {"John",      "730"},
  {"John",      "940"},
  {"Jennifer", "1335"},
  {"Jennifer",  "730"},
  {"John",     "1630"},
  {"Jennifer",    "5"}
    };

       HashMap<String,List<Integer>> res = new SuspiciousEntryWYFR().getNames(btimes);

        System.out.println(res);
    }

    public HashMap<String,List<Integer>> getNames(String[][] btimes){
        HashMap<String,List<Integer>> ans = new HashMap<>();
        HashMap<String,TreeMap<Integer,Integer>> alltimes = new HashMap<>();
        for(String[] empt: btimes){
         Integer ent = Integer.parseInt(empt[1]);
         String emp = empt[0];
         //int size = alltimes.get(emp)==null?1:alltimes.get(emp).size()+1;
         alltimes.computeIfAbsent(emp,k -> new TreeMap<Integer,Integer>()).put(ent,0);
        }
        for(Map.Entry<String,TreeMap<Integer,Integer>> mpe : alltimes.entrySet()) {
            TreeMap<Integer, Integer> curr = mpe.getValue();
            if (curr == null || curr.size() < 3) continue;
            int i=1;
            for(Map.Entry<Integer,Integer> mp: curr.entrySet()){
                mp.setValue(i);i++; // Assign a marker for the entry times so that its easy to use a TreeMap api like floorEntry
                // in a time series like 5:1, 1355:2,1410:3,1420:4,1435:5
                // take 5 , add 100 and get floorEntry(105) , with value lets say 2
                // curr value of 5 is 1  and floorEntry value is 2 and the target is to find where the difference is k that is 3 above problem statement.
                // 1355, floorEntry(1445)-> 1420
                // 1355:2 1420:4 , 4-2 +1 = 3 which fits the criteria hence 1355 will be an answer.
            }
        }

        for(Map.Entry<String,TreeMap<Integer,Integer>> mpe : alltimes.entrySet()){
            TreeMap<Integer,Integer> curr = mpe.getValue();
            List<Integer> lst = new LinkedList<Integer>();

            boolean found = false;
            int endv = -1;
           for(Map.Entry<Integer,Integer> mp: curr.entrySet()){
               int startv = mp.getKey();
               if(found && endv!=-1 && endv>=startv){
                   lst.add(startv);
                   continue;
               }
                if(found) continue;
               endv = startv+100;
               Map.Entry<Integer,Integer> end = curr.floorEntry(endv);
               if(end.getValue()-mp.getValue()+1>=3){
                   found = true;
                   lst.add(startv);

               }

           }
           if(lst.size()>0)
               ans.put(mpe.getKey(),lst);
        }

        return ans;
    }
}
