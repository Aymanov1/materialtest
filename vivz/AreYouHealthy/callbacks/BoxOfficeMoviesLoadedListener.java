package materialtest.vivz.AreYouHealthy.callbacks;

import java.util.ArrayList;

import materialtest.vivz.AreYouHealthy.pojo.Movie;

/**
 * Created by Windows on 02-03-2015.
 */
public interface BoxOfficeMoviesLoadedListener {
    public void onBoxOfficeMoviesLoaded(ArrayList<Movie> listMovies);
}
