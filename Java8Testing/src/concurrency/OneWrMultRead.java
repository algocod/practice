import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * This example is to demonstrate when there are multiple inputs like TradeIds or LongURL coming in but you want to process them only once . If its only processed then just return the tinyurl generated back
 * Else if its first time then generate the tinyURL.
 * putIfAbsent is atomic operation and works quite good with multi threads hence no need of locking.
 */
public class OneWrMultRead {
    ConcurrentHashMap<String,ThreadState> hmp = new ConcurrentHashMap<>();
    public AtomicInteger count = new AtomicInteger(0);

    public ThreadState getTinyId(String key){
        hmp.putIfAbsent(key,new ThreadState(count.getAndIncrement(),key));
        return hmp.get(key);
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        OneWrMultRead onr = new OneWrMultRead();
        ExecutorService svc = Executors.newCachedThreadPool();
        String[] input = {"google.com/chk","amazon.com/chk","facebook.com/photos"};
        List<Callable<ThreadState>> lcl = new ArrayList<>();
        for(int i=0;i<3000;i++){
            final int j =i%3;
            Callable<ThreadState> cl = new Callable<ThreadState>() {
                @Override
                public ThreadState call() throws Exception {
                    return onr.getTinyId(input[j]);
                }
            };
            lcl.add(cl);
        }

        List<Future<ThreadState>> ans = svc.invokeAll(lcl);
        HashMap<String, HashSet<Integer>> chkResult = new HashMap<>();
        for(Future<ThreadState> fst : ans){
            chkResult.computeIfAbsent(fst.get().tinyUrl, k -> new HashSet<Integer>()).add(fst.get().state);
            //System.out.println(fst.get().tinyUrl+"-----"+fst.get().state);
        }
        System.out.println(chkResult);
        svc.shutdown();
    }

}
