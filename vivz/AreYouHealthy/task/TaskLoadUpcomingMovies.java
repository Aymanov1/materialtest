package materialtest.vivz.AreYouHealthy.task;

import android.os.AsyncTask;

import com.android.volley.RequestQueue;

import java.util.ArrayList;

import materialtest.vivz.AreYouHealthy.callbacks.UpcomingMoviesLoadedListener;
import materialtest.vivz.AreYouHealthy.extras.MovieUtils;
import materialtest.vivz.AreYouHealthy.network.VolleySingleton;
import materialtest.vivz.AreYouHealthy.pojo.Movie;

/**
 * Created by Windows on 02-03-2015.
 */
public class TaskLoadUpcomingMovies extends AsyncTask<Void, Void, ArrayList<Movie>> {
    private UpcomingMoviesLoadedListener myComponent;
    private VolleySingleton volleySingleton;
    private RequestQueue requestQueue;


    public TaskLoadUpcomingMovies(UpcomingMoviesLoadedListener myComponent) {

        this.myComponent = myComponent;
        volleySingleton = VolleySingleton.getInstance();
        requestQueue = volleySingleton.getRequestQueue();
    }


    @Override
    protected ArrayList<Movie> doInBackground(Void... params) {

        ArrayList<Movie> listMovies = MovieUtils.loadUpcomingMovies(requestQueue);
        return listMovies;
    }

    @Override
    protected void onPostExecute(ArrayList<Movie> listMovies) {
        if (myComponent != null) {
            myComponent.onUpcomingMoviesLoaded(listMovies);
        }
    }
}
