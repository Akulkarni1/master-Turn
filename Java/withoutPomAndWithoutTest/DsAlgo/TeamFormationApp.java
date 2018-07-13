import java.util.*;

class TeamFormationImpl {
	public void getT(int[] a) {
		HashSet t = new HashSet<Integer>();
		boolean[] bool = new boolean[a.length];
		for (int i = 0; i < a.length; i++) {
			bool[i] = false;
		}
		for (int i = 0; i < a.length; i++) {
			getTeams(a, a[i], bool);

		}
	}

	public void getTeams(int[] a, int t, boolean[] bool) {
		HashSet<Integer> s = new HashSet<Integer>();

		// for(int i =0;i<a.length;i++) {
		for (int j = 0; j < a.length; j++) {
			int temp = t;
			s.add(a[1]);
			if (temp - 1 == a[j] && bool[j] == false) {
				bool[j] = true;
				s.add(a[j]);
			}
			if (temp + 1 == a[j] && bool[j] == false) {
				bool[j] = true;
				s.add(a[j]);
			}
		}
		// }
		System.out.println(s);
	}

	static int solve(int[] skillArray) {
		if (skillArray.length > 0) {
			Arrays.sort(skillArray);

			Map<Integer, TreeMap<Integer, Integer>> trackingMap = new HashMap<>();

			for (int skill : skillArray) {
				TreeMap<Integer, Integer> countsMapPrev = trackingMap.get(skill - 1);
				TreeMap<Integer, Integer> countsMapCurr = trackingMap.get(skill);
				Integer count = null;

				if (countsMapPrev == null) {
					count = 1;
				} else {
					count = countsMapPrev.isEmpty() ? 0 : countsMapPrev.firstKey();

					if (!countsMapPrev.isEmpty() && countsMapPrev.get(count) > 1)
						countsMapPrev.put(count, countsMapPrev.get(count) - 1);
					else
						countsMapPrev.remove(count);

					count++;
				}

				if (countsMapCurr == null) {
					countsMapCurr = new TreeMap<>();
					countsMapCurr.put(count, 1);
				} else {
					int currCount = countsMapCurr.containsKey(count) ? countsMapCurr.get(count) : 0;
					countsMapCurr.put(count, ++currCount);
				}

				trackingMap.put(skill, countsMapCurr);
			}

			int smallestTeam = Integer.MAX_VALUE;

			for (TreeMap<Integer, Integer> countsMap : trackingMap.values()) {
				int count = countsMap.isEmpty() ? Integer.MAX_VALUE : countsMap.firstKey();

				if (count < smallestTeam)
					smallestTeam = count;
			}

			return smallestTeam;
		} else {
			return 0;
		}
	}
}

public class TeamFormationApp {
	public static void main(String[] args) {
		int[] a = { 7, 4, 5, 2, 3, -4, -3, -5 };
		System.out.println(new TeamFormationImpl().solve(a));
	}
}
