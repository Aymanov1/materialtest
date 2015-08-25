package materialtest.vivz.slidenerd.services;

import java.util.ArrayList;

import materialtest.vivz.slidenerd.callbacks.BoxOfficeMoviesLoadedListener;
import materialtest.vivz.slidenerd.pojo.Movie;
import me.tatarka.support.job.JobParameters;
import me.tatarka.support.job.JobService;

/**
 * Created by Windows on 23-02-2015.
 */
public class ServiceMoviesBoxOffice extends JobService implements BoxOfficeMoviesLoadedListener {
    private JobParameters jobParameters;

    @Override
    public boolean onStartJob(JobParameters jobParameters) {


        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {

        return false;
    }


    @Override
    public void onBoxOfficeMoviesLoaded(ArrayList<Movie> listMovies) {

        jobFinished(jobParameters, false);
    }
}

