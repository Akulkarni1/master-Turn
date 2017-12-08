import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/* read a multiple line text file and write the 'N' longest lines to the output console,
 *  where the file to be read is specified as command line aruguments.
 *  The program should read an input file. 
 *  The first line should contain the value of the number 'N' followed by multiple lines. 
 * 'N' should be a valid positive integer.
 * 
 */
public class MaxCharInDescApp {
	public static void main(String[] args) {
		BufferedReader br = null;
		String filepath = args[0];
		int topList = 0;
		Set<Entries> liset = new TreeSet<Entries>();
		try {
			br = new BufferedReader(new FileReader(new File(filepath)));
			String line = br.readLine();
			topList = Integer.parseInt(line.trim());
			while ((line = br.readLine()) != null) {
				line = line.trim();
				if (!"".equals(line)) {
					liset.add(new Entries(line.length(), line));
				}
			}
			int count = 0;
			for (Entries ent : liset) {
				System.out.println(ent.line);
				if (++count == topList) {
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static class Entries {
		Integer length;
		String line;

		public Entries(Integer l, String line) {
			length = l;
			this.line = line;
		}
	}

	public static class MyComp implements Comparator<Entries> {

		@Override
		public int compare(Entries e1, Entries e2) {
			if (e2.length > e1.length) {
				return 1;
			} else {
				return -1;
			}
		}

	}
}
