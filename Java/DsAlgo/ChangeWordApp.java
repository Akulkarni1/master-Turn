/*
 * Change a word into another by changing only only one character at a time. 
 * All intermediate words should be contained in a dictionary.
 */
import java.util.*;

public class ChangeWordApp {

		public boolean isNavigable(final String src,final String dst,Set<String> dict) {
		
				if(src.length()!= dst.length()) {
					return false;
				}
				if(src.equals(dst)) {
					return true;
					
				}
				dict.remove(src);
				LinkedList<String> q = new LinkedList<String>();
				q.add(src);
				while(!q.isEmpty()) {
					String intermediate = q.remove();
					for(int i=0;i<intermediate.length();i++) {
						char[] candidateChars  = intermediate.toCharArray();
						for(char j='A';j<'Z';j++) {
							candidateChars [i]=j;
							String candidate = new String(candidateChars);

			                if (candidate.equals(dst)) {
			                    System.out.print("-->" + candidate);
			                    return true;
			                } else if (dict.contains(candidate)) {
			                    dict.remove(candidate);
			                    q.add(candidate);
			                    System.out.print("-->" + candidate);
			                }
			            }
			        }
			    }

			    return false;
		}
		public List<List<String>>wordLadderall(Set<String>dict, String src, String dst){
			if(src ==null||dst== null||dict==null||src.isEmpty()||dst.isEmpty()||dict.isEmpty()) {
				return Collections.EMPTY_LIST;
				
			}
			Queue<String> q= new ArrayDeque<String>();
			Map<String,String> parent = new HashMap<String, String>();
			Map<String,Integer> length = new HashMap<String,Integer>();
			int minlen= Integer.MIN_VALUE;
			List<List<String>>path = new ArrayList<>();
			Set<String>shortestPath = new HashSet<String>();
			q.add(src);
			length.put(src, 0);
			while(!q.isEmpty()) {
				String inter = q.poll();
				if(length.get(inter)>= minlen) {
					continue;
				}
				for(int i=0;i<inter.length();i++) {
					char[] candiarr = inter.toCharArray();
					for(char c = 'a'; c < 'z'; c++){
						candiarr[i] = c;
						String candidate = new String(candiarr);
						
						if(!length.containsKey(candidate)){
							length.put(candidate, Integer.MAX_VALUE);
						}
						if(length.get(inter)+1 > length.get(candidate)){
							continue;
						}
						if(candidate.equals(dst)){
							shortestPath.add(inter);
							minlen = Math.min(minlen, length.get(inter)+1);
						}
						else if(dict.contains(candidate)){
							parent.put(candidate, inter);
							length.put(candidate, length.get(inter)+1);
							q.add(candidate);
						}
				}
			}
			}
			for(String p : shortestPath){
				path.add(getPath(parent, p, src, dst));
			}
			
			return path;
		}
		
		private static List<String> getPath(Map<String, String> parentMap, String leaf, String src, String dst){
			List<String> path = new ArrayList<String>();
			
			String node = leaf;
			path.add(dst);
			path.add(0, leaf);
			while(parentMap.get(node) != null && parentMap.get(node) != src){
				node = parentMap.get(node);
				path.add(0, node);
			}
			path.add(0, src);
			
			return path;
		}
		public static void main(String[] args) {
			Set<String> dict = new HashSet<String>();
			dict.add("hot");
			dict.add("dot");
			dict.add("dog");
			dict.add("lot");
			dict.add("log");
			dict.add("lob");
			dict.add("cob");
			
		}
}
