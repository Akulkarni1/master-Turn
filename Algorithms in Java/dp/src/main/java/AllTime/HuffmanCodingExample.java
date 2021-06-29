import java.util.*;

public class HuffmanCodingExample {
   class CharFrequency {
      char aChar;
      double freq;
      String code;
   }

   class BinaryTree implements Comparable<BinaryTree> {
      CharFrequency charFrequency;
      double aggregateFrequency;
      BinaryTree left, right;

      BinaryTree(CharFrequency charFrequency, double aggregateFrequency, BinaryTree left, BinaryTree right) {
         this.charFrequency = charFrequency;
         this.aggregateFrequency = aggregateFrequency;
         this.left = left;
         this.right = right;
      }

      public boolean equals(BinaryTree binaryTree) {
         if (binaryTree == null || !(binaryTree instanceof BinaryTree)) {
            return false;
         }
         return this == binaryTree ? true : aggregateFrequency == ((BinaryTree) binaryTree).aggregateFrequency;
      }

      @Override
      public int compareTo(BinaryTree binaryTree) {
         return Double.compare(aggregateFrequency, binaryTree.aggregateFrequency);
      }

      public int hashCode() {
         return Objects.hashCode(aggregateFrequency);
      }

      public Map<Character, String> huffmanCoding(List<CharFrequency> symbols) {
         PriorityQueue<BinaryTree> candidates = new PriorityQueue<>();
         for (CharFrequency s : symbols) {
            candidates.add(new BinaryTree(s, s.freq, null, null));
         }
         while (candidates.size() > 1) {
            BinaryTree left = candidates.remove();
            BinaryTree right = candidates.remove();
            candidates.add(new BinaryTree(null, left.aggregateFrequency + right.aggregateFrequency, left, right));
         }
         Map<Character, String> huffmanCoding = new HashMap<>();
         assignHuffmanCode(candidates.peek(), new StringBuilder(), huffmanCoding);
         return huffmanCoding;
      }

      private void assignHuffmanCode(BinaryTree tree, StringBuilder code, Map<Character, String> huffmanCoding) {
         if (tree != null) {
            if (tree.charFrequency != null) {
               huffmanCoding.put(tree.charFrequency.aChar, code.toString());

            } else {
               code.append('0');
               assignHuffmanCode(tree.left, code, huffmanCoding);
               code.setLength(code.length() - 1);
               code.append('1');
               assignHuffmanCode(tree.right, code, huffmanCoding);
            }
         }
      }
   }
}