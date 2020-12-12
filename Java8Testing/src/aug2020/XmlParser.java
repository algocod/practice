/*
 Stack based approach which looks much simpler to implement
// and code.
// The problem was Given a Tokenizer interface that returns Tokens
Which has <a , BEGIN> <b, BEGIN> <valueOfb , TEXT> <b,END><a, END>
// Parse the xml and return the root object.
// Design the Tree Node as well.
// Recursion looks tempting but Stack one is easier to implement.
=================================================================
<a>
    <b>
        <c> hello </c>
        <c> </c>
    </b>
    <d> value </d>
</a>

// The below methods will tackel Stack and Recursion based approaches
* */
import java.util.*;

public class XmlParser {
    public String[][] input = {{"a", "BEGIN"},
            {"b", "BEGIN"},
            {"c", "BEGIN"},
            {"Hello", "TEXT"},
            {"c", "END"},
            {"c", "BEGIN"},
            {"c", "END"},
            {"b", "END"},
            {"d", "BEGIN"},
            {"WHY", "TEXT"},
            {"d", "END"},
            {"a", "END"}
    };
    public int i = 0;
    public static void main(String[] args){
        XmlParser xp = new XmlParser();
        Node ans = xp.Stkp();
        prnt(ans);
        System.out.println("==========================");
        Node recans = xp.recp(null);
        prnt(recans);
    }

    public Node recp(Node n){
        if(i>=input.length) return n;
        while(i<input.length) {
            String type = input[i][1];
            String fval = input[i][0];
            if (type.equals("BEGIN")) {
                Node t = new Node(fval, "");
                if (n != null) {
                    n.child.add(t);
                } else
                    n = t;
                i++;
                recp(t);
                continue;
            } else if (type.equals("TEXT")) {
                n.value = fval;
            } else{
                i++;
                return n;
            }
            i++;
        }
        return n;
    }

    public static void prnt(Node np ){
        if(np==null) return ;
        System.out.println(np.tag+"--"+np.value);
        for(Node n : np.child)
            prnt(n);

    }
    public Node  Stkp(){
        Stack<Node> stk = new Stack<>();
        int i = 0, len = input.length;
        Node root = null;
        while(i<len){
            String type = input[i][1];
            String fval = input[i][0];
            if(type.equals("BEGIN")){
                Node t = new Node(fval,"");
                if(stk.size()>0){
                    stk.peek().child.add(t);
                }
                stk.push(t);
            }
            else if (type.equals("TEXT")){
                stk.peek().value = fval;
            }
            else
                root = stk.pop();
            i++;
        }

        return root;
    }



    public class Node{
        String tag = "";
        String value = "";
        List<Node> child = new LinkedList<>();

        public Node (String tag, String val){
            this.tag = tag;
            this.value = val;
        }
    }

}