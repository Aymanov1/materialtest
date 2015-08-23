package materialtest.vivz.AreYouHealthy.extras;

import com.android.volley.RequestQueue;

import org.json.JSONObject;

import java.util.ArrayList;

import materialtest.vivz.AreYouHealthy.database.DBMovies;
import materialtest.vivz.AreYouHealthy.json.Endpoints;
import materialtest.vivz.AreYouHealthy.json.Parser;
import materialtest.vivz.AreYouHealthy.json.Requestor;
import materialtest.vivz.AreYouHealthy.materialtest.MyApplication;
import materialtest.vivz.AreYouHealthy.pojo.Movie;

/**
 * Created by Windows on 02-03-2015.
 */
public class MovieUtils {
    public static ArrayList<Movie> loadBoxOfficeMovies(RequestQueue requestQueue) {
        JSONObject response = Requestor.requestMoviesJSON(requestQueue, Endpoints.getRequestUrlBoxOfficeMovies(30));
        ArrayList<Movie> listMovies = Parser.parseMoviesJSON(response);
        MyApplication.getWritableDatabase().insertMovies(DBMovies.BOX_OFFICE, listMovies, true);
        return listMovies;
    }

    public static ArrayList<Movie> loadUpcomingMovies(RequestQueue requestQueue) {
        JSONObject response = Requestor.requestMoviesJSON(requestQueue, Endpoints.getRequestUrlUpcomingMovies(30));
        ArrayList<Movie> listMovies = Parser.parseMoviesJSON(response);
        MyApplication.getWritableDatabase().insertMovies(DBMovies.UPCOMING, listMovies, true);
        return listMovies;
    }
}
