class LexiPermuImpl {
	public static int[] smallerCountRight(int[] x) {
		int[] smaller = new int[x.length];
		for (int i = 0; i < x.length; i++) {
			for (int j = i + 1; j < x.length; j++) {
				if (x[j] <= x[i]) {
					smaller[i]++;
				}
			}
		}
		return smaller;
	}

	public int permRank(int[] x) {
		int[] smallerCount = countSmallerOnRightwithMerge(x);
		int[] factorial = new int[x.length];
		factorial[0] = 1;
		factorial[1] = 1;
		for (int i = 2; i < x.length; i++) {
			factorial[i] = i * factorial[i - 1];
		}
		int rank = 1;
		for (int i = 0; i < x.length; i++) {
			rank += smallerCount[i] * factorial[x.length - i - 1];
		}
		return rank;
	}

	public static int[] countSmallerOnRightwithMerge(int a[]) {
		int n = a.length;
		int[] rank = new int[n];
		int[] count = new int[n];
		for (int i = 0; i < n; i++) {
			rank[i] = i;
		}
		countSmallerOnRightWithMerge(a, rank, 0, n - 1, count);
		return count;

	}

	private static void countSmallerOnRightWithMerge(int[] a, int[] rank, int i, int j, int[] count) {
		if (a.length == 1) {
			return;
		}
		if (i < j) {
			int q = (i + j) / 2;
			countSmallerOnRightWithMerge(a, rank, i, j, count);
			countSmallerOnRightWithMerge(a, rank, q + 1, j, count);
			mergeToCountSmallerOnRight(a, rank, i, q, j, count);
		}
	}

	private static void mergeToCountSmallerOnRight(int[] a, int[] rank, int p, int q, int r, int[] count) {
		int n = r - p + 1;
		int i = p;
		int j = q + 1;
		int mid = q;
		int k = 0;
		int mergeRank[] = new int[n];
		int smallerCount = 0;
		while (i <= mid && j <= r) {
			if (a[rank[i]] < a[rank[j]]) {
				count[rank[i]] += smallerCount;
				mergeRank[k++] = rank[i++];
			} else {
				smallerCount++;
				mergeRank[k++] = rank[j++];
			}
		}
		while (i <= mid) {
			count[rank[i]] += r - q;
			mergeRank[k++] = rank[i++];

		}
		while (j <= r) {
			mergeRank[k++] = rank[j++];
		}
		System.arraycopy(mergeRank, 0, rank, p, n);
	}

}

public class LexiPermuApp {

}
