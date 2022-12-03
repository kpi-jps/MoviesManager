package ifsp.ads.pdm.jp.moviesmanager.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ifsp.ads.pdm.jp.moviesmanager.databinding.ActivityMovieBinding
import ifsp.ads.pdm.jp.moviesmanager.model.Constants.EXTRA_MOVIE
import ifsp.ads.pdm.jp.moviesmanager.model.entities.Movie

class MovieActivity : AppCompatActivity() {
    private val mab : ActivityMovieBinding by lazy {
        ActivityMovieBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mab.root)
        val receivedMovie = intent.getParcelableExtra<Movie>(EXTRA_MOVIE)
        receivedMovie?.let { _receivedMovie ->
            with(mab) {
                with(_receivedMovie) {
                    movieNameEt.setText(movieName)
                    !movieNameEt.isEnabled
                    releaseYearEt.setText(releaseYear.toString())
                    movieStudioEt.setText(studio)
                    durationEt.setText(duration.toString())
                    if(rate == 0) rateEt.setText("0")
                    else rateEt.setText(rate.toString())
                    if(watched == 0) !watchedCb.isChecked
                    else watchedCb.isChecked
                }
            }

        }
    }
}