package aug2020;

import java.util.*;

public class LFUCache {

	public int max = 0;
	public int tc = 0;
	public LinkNode head = null;
	public LinkNode tail = null;
	public HashMap<Integer, LinkNode> keyMap = new HashMap<>();

	public LFUCache(int capacity) {
		max = capacity;
		head = new LinkNode(0, null, null);
		tail = new LinkNode(-1, null, head);
	}

	public static void main(String[] args) {
		/*
		 * ["LFUCache","put","put","get","put","get","get","put","get","get","get"]
		 * [[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]
		 */
		/*
		 * LFUCache lfu = new LFUCache(2); lfu.put(1,1); lfu.put(2, 2); lfu.get(1);
		 * lfu.put(3,3); lfu.get(2); lfu.get(3); lfu.put(4, 4);
		 * lfu.get(1);lfu.get(3);lfu.get(4);
		 */
		/*
		 * ["LFUCache","put","put","put","put","get"] [[2],[3,1],[2,1],[2,2],[4,4],[2]]
		 **/

		/*
		 * LFUCache lfu = new LFUCache(2); lfu.put(3,1); lfu.put(2, 1); lfu.put(2, 2);
		 * lfu.put(4, 4); System.out.println(lfu.get(2));
		 */

		/*
		 * ["LFUCache","put","get"] [[0],[0,0],[0]]
		 */
		/*
		 * LFUCache lfu = new LFUCache(0); lfu.put(0,0); System.out.println(lfu.get(0));
		 */

		/*
		 * ["LFUCache","put","put","get","put","put","get"]
		 * [[2],[2,1],[2,2],[2],[1,1],[4,1],[2]]
		 */

		LFUCache lfu = new LFUCache(2);
		lfu.put(2, 1);
		lfu.put(2, 2);
		System.out.println(lfu.get(2));
		lfu.put(1, 1);
		lfu.put(4, 1);
		System.out.println(lfu.get(2));

	}

	public int get(int key) {
		// doesnt exist
		if (!keyMap.containsKey(key) || max < 1) {
			return -1;
		} else {
			LinkNode l = keyMap.get(key);
			int f = l.freq;
			f = f + 1;
			int val = l.rem(key);
			if (l.next.freq == f) {
				LinkNode p = l.next;
				p.add(key, val);
				keyMap.put(key, p);
			} else {

				LinkNode prev = l;
				LinkNode next = l.next;
				LinkNode p = new LinkNode(f, next, prev);
				p.add(key, val);
				keyMap.put(key, p);
			}

			if (l.cache.size() == 0) {
				clean(l);
			}

			return val;
		}
	}

	public void put(int key, int value) {
		// doesnt exist
		if (!keyMap.containsKey(key))
			tc++;
		if (tc > max) {
			LinkNode rem = head.next;
			rem.evict();
			tc--;
		}
		if (!keyMap.containsKey(key)) {
			int f = 1;
			if (head.next.freq == f) {
				LinkNode p = head.next;
				p.add(key, value);
				keyMap.put(key, p);
			} else {
				LinkNode nxt = head.next;
				LinkNode prev = head;
				LinkNode l = new LinkNode(f, nxt, prev);
				l.add(key, value);
				keyMap.put(key, l);

			}
		} else {
			LinkNode l = keyMap.get(key);
			int f = l.freq;
			f = f + 1;
			l.rem(key);
			if (l.next.freq == f) {
				LinkNode p = l.next;
				p.add(key, value);
				keyMap.put(key, p);
			} else {

				LinkNode prev = l;
				LinkNode next = l.next;
				LinkNode p = new LinkNode(f, next, prev);
				p.add(key, value);
				keyMap.put(key, p);
			}

			if (l.cache.size() == 0) {
				clean(l);
			}

		}

	}

	public void clean(LinkNode currl) {
		LinkNode nxt = currl.next;
		LinkNode pre = currl.prev;

		pre.next = nxt;
		nxt.prev = pre;
	}

	public class LinkNode {
		public LinkNode next = null;
		public LinkNode prev = null;
		public LinkedList<Integer> ll = new LinkedList<>();
		public HashMap<Integer, Integer> cache = new HashMap<>();
		public int freq = 0;

		public LinkNode(int f, LinkNode nxt, LinkNode pre) {
			this.freq = f;
			this.next = nxt;
			this.prev = pre;
			if (pre != null)
				pre.next = this;
			if (nxt != null)
				nxt.prev = this;
		}

		public void add(int key, int val) {
			ll.offer(key);
			cache.put(key, val);
		}

		public int rem(int k) {
			ll.remove(new Integer(k));
			int val = cache.get(k);
			cache.remove(k);
			return val;
		}

		public void evict() {
			if (ll.size() < 1 || keyMap.size() < 1)
				return;
			int k = ll.pollFirst();
			cache.remove(k);
			keyMap.remove(k);
		}

	}

}
