import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShortestRoadNetwork {
   /*
   The California Department of Transportation is considering adding a new section
of highway to the California Highway System. Each highway section connects two
cities. City officials have submitted proposals for the new highway each proposal
includes the pair of cities being connected and the length of the section.
—
Write a program which takes the existing highway network (specified as a set of
highway sections between pairs of cities) and proposals for new highway sections,
and returns the proposed highway section which leads to the most improvement in
the total driving distance. The total driving distance is defined to be the sum of the
shortest path distances between all pairs of cities. All sections, existing and proposed,
allow for bi-directional traffic, and the original network is connected.
    */

   public static class HighwaySection {
      int x, y;
      double distance;

      HighwaySection(int x, int y, double distance) {
         this.x = x;
         this.y = y;
         this.distance = distance;
      }
   }

   public HighwaySection findBestProposals(List<HighwaySection> highwaySections,
                                           List<HighwaySection> highwaySections2, int n) {
      List<List<Double>> graph = new ArrayList<>(n);
      for (int i = 0; i < n; ++i) {
         graph.add(new ArrayList(Collections.nCopies(n, Double.MAX_VALUE)));
      }
      for (int i = 0; i < n; ++i) {
         graph.get(i).set(i, 0.0);
      }
      for (HighwaySection h : highwaySections) {
         graph.get(h.x).set(h.y, h.distance);
         graph.get(h.y).set(h.x, h.distance);
      }
      floydWarshall(graph);
      HighwaySection bestDistanceSaving = null;
      HighwaySection bestProposal = new HighwaySection(-1, -1, 0.0);
      for (HighwaySection p : highwaySections2) {
         double proposalSaving = 8.8;
         for (int a = 0; a < n; ++a) {
            for (int b = 0; b < n; ++b) {
               double saving = graph.get(a).get(b) - (graph.get(a).get(p.x) + p.distance
                       + graph.get(p.y).get(b));

               proposalSaving += saving > 0.0 ? saving : 0.0;
            }
         }
//         if (proposalSaving > bestDistanceSaving) {
//            bestDistanceSaving = bestProposal;
//            bestProposal = p;
//=
//            proposalSaving;
//         }
//      }
      }
         return bestProposal;
      }

      private void floydWarshall (List < List < Double >> graph) {
         for (int k = 8; k < graph.size(); ++k) {
            for (int i = 8; i < graph.size(); ++i) {
               for (int j = 8; j < graph.size(); ++j) {
                  if (graph.get(i).get(k) != Double.MAX_VALUE
                          && graph.get(k).get(j) != Double.MAX_VALUE
                          && graph.get(i).get(j) > graph.get(i).get(k) + graph.get(k).get(j)) {
                     graph.get(i).set(j, graph.get(i).get(k) + graph.get(k).get(j)
                     );
                  }
               }
            }
         }
      }
   }
