import java.util.ArrayList;
import java.util.List;

/*
the remote valleys of Papua New Guinea, one of the last uncharted
places in the world. You come across a tribe that does not have money instead it
relies on the barter system. A total of n commodities are traded and the exchange
rates are specified by a 2D array. For example, three sheep can be exchanged for
seven goats and four goats can be exchanged for 200 pounds of wheat.
Transaction costs are zero, exchange rates do not fluctuate, fractional quantities of
items can be sold, and the exchange rate between each pair of commodities is finite.
Table 4.4 on Page 35 shows exchange rates for currency trades, which is similar in
spirit to the current problem.
—
—
Design an efficient algorithm to determine whether there exists an arbitrage a way
to start with a single unit of some commodity C and convert it back to more than one
unit of C through a sequence of exchanges.
 */
public class Arbitage {

   public static boolean isArbitageExist(List<List<Double>> graph) {
      for (List<Double> edgeList : graph) {
         for (int i = 0; i < edgeList.size(); i++) {
            edgeList.set(i, -Math.log10(edgeList.get(i)));
         }
      }
      return bellmanFord(graph, 0);
   }

   private static boolean bellmanFord(List<List<Double>> graph, int source) {
      List<Double> disToSource = new ArrayList<>();
      disToSource.set(source, 0.0);
      for (int times = 1; times < graph.size(); ++times) {
         boolean haveUpdate = false;
         for (int i = 0; i < graph.size(); i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
               if (disToSource.get(i) != Double.MAX_VALUE && disToSource.get(j) > disToSource.get(i) + graph.get(i).get(j)) {
                  haveUpdate = true;
                  disToSource.set(j, disToSource.get(i) + graph.get(i).get(j));
               }
            }
         }
         if (!haveUpdate)
            return false;
      }
      for (int i = 0; i < graph.size(); ++i) {
         for (int j = 0; j < graph.get(i).size(); ++j) {
            if (disToSource.get(i) != Double.MAX_VALUE
                    && disToSource.get(i) > disToSource.get(i) + graph.get(i).get(j)
            ) {
               return true;
            }
         }
      }
      return
              false;
   }
}
