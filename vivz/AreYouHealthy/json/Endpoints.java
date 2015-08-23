package materialtest.vivz.AreYouHealthy.json;

import materialtest.vivz.AreYouHealthy.materialtest.MyApplication;
import materialtest.vivz.AreYouHealthy.extras.UrlEndpoints;

/**
 * Created by Windows on 02-03-2015.
 */
public class Endpoints {
    public static String getRequestUrlBoxOfficeMovies(int limit) {

        return UrlEndpoints.URL_BOX_OFFICE
                + UrlEndpoints.URL_CHAR_QUESTION
                + UrlEndpoints.URL_PARAM_API_KEY + MyApplication.API_KEY_ROTTEN_TOMATOES
                + UrlEndpoints.URL_CHAR_AMEPERSAND
                + UrlEndpoints.URL_PARAM_LIMIT + limit;
    }

    public static String getRequestUrlUpcomingMovies(int limit) {

        return UrlEndpoints.URL_UPCOMING
                + UrlEndpoints.URL_CHAR_QUESTION
                + UrlEndpoints.URL_PARAM_API_KEY + MyApplication.API_KEY_ROTTEN_TOMATOES
                + UrlEndpoints.URL_CHAR_AMEPERSAND
                + UrlEndpoints.URL_PARAM_LIMIT + limit;
    }
}
