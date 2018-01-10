package Time;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.LinkedList;
import java.util.List;

class Movie {
	private int movieId;
	private float rating;
	private List<Movie> similarMovies;

	Movie(int movieId, float rating) {
		this.movieId = movieId;
		this.rating = rating;
		similarMovies = new ArrayList<Movie>();
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public List<Movie> getSimilarMovies() {
		return similarMovies;
	}

	public void setSimilarMovies(List<Movie> similarMovies) {
		this.similarMovies = similarMovies;
	}

	public void addSimilarMovies(Movie movie) {
		similarMovies.add(movie);
		movie.similarMovies.add(this);
	}

	public List<Movie> getSimilarMovie() {
		return similarMovies;

	}

	/*
	 * implement the function to get the top rated Movies in the network of Movies.
	 * reachable from the current movies . E.g A(Rating 1.2) , B(2.4) c(3.6)and
	 * D(4.8) In the above example edges represent similarity and the number is
	 * rating. GetMovieRecomendation(A,2) should return C and D(Sorting order does
	 * not matter). Get Movie recomendation (A,4) should return A,B,C,D. Note (A,1)
	 * should return only D.
	 * 
	 * 
	 */

	public static List<Movie> getMovieRecomendation(Movie movie, int numTopRated) {

		LinkedList<Movie> toBeVisited = new LinkedList<Movie>();

		BitSet visited = new BitSet();

		Movie[] top = new Movie[numTopRated];
		toBeVisited.addAll(movie.getSimilarMovie());
		Movie current;
		while (!toBeVisited.isEmpty()) {
			current = toBeVisited.removeFirst();
			if (!visited.get(current.getMovieId())) {
				visited.set(current.getMovieId());
				Movie topMovie;
				Movie reference = current;

				for (int i = 0; i < numTopRated; i++) {
					topMovie = top[i];

					if (topMovie == null) {
						top[i] = reference;
						break;
					} else if (topMovie.rating < reference.rating) {
						top[i] = reference;
						reference = topMovie;
					}
				}
			}
			for (Movie sibling : current.getSimilarMovies()) {
				if (!visited.get(sibling.getMovieId())) {
					toBeVisited.add(sibling);
				}
			}
		}
		return Arrays.asList(top);
	}

	public String toString() {
		return "Movie(" + movieId + "," + rating + ")";
	}
}

public class MovieApp {

}
