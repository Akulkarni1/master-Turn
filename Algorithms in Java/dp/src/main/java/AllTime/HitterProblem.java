import java.util.*;

public class HitterProblem {
   /*
   n practice we may not
be interested in a majority token but all tokens whose count exceeds say 1% of the
total token count. It is fairly straightforward to show that it is impossible to compute
such tokens in a single pass when you have limited memory. However, if you are
allowed to pass through the sequence twice, it is possible to identify the common
tokens.
You are reading a sequence of strings separated by whitespace. You are allowed to
read the sequence twice. Devise an algorithm that uses 0(k) memory to identify the
words that occur more than | times, where n is the length of the sequence.
    */
   public static List<String> searchFrequentTimes(Iterable<String> input, int k) {
      String buffer = "";
      Map<String, Integer> hash = new HashMap<>();
      int n = 0;
      Iterator<String> sequence = input.iterator();
      while (sequence.hasNext()) {
         buffer = sequence.next();
         hash.put(buffer, hash.containsKey(buffer) ? hash.get(buffer) + 1 : 1);
         ++n;
         if (hash.size() == k) {
            List<String> delkeys = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : hash.entrySet()) {
               if (entry.getValue() - 1 == 0) {
                  delkeys.add(entry.getKey());
               }
            }
            for (String s : delkeys) {
               hash.remove(s);
            }
            for (Map.Entry<String, Integer> e : hash.entrySet()) {
               hash.put(e.getKey(), e.getValue() - 1);
            }
         }
      }
      for (String it : hash.keySet()) {
         hash.put(it, 0);
      }
      sequence = input.iterator();
      while (sequence.hasNext()) {
         buffer = sequence.next();
         Integer it = hash.get(buffer);
         if (it != null) {
            hash.put(buffer, it + 1);
         }
      }

      List<String> ret = new ArrayList<>();
      for (Map.Entry<String, Integer> it : hash.entrySet()) {
         if (n * 1.0 / k < (double) it.getValue()) {
            ret.add(it.getKey());
         }
      }
      return ret;
   }
}
