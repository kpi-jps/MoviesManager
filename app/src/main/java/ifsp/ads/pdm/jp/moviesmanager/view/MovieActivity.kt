package ifsp.ads.pdm.jp.moviesmanager.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import ifsp.ads.pdm.jp.moviesmanager.databinding.ActivityMovieBinding
import ifsp.ads.pdm.jp.moviesmanager.model.Constants.EXTRA_MOVIE
import ifsp.ads.pdm.jp.moviesmanager.model.Constants.EXTRA_UPDATE_OP
import ifsp.ads.pdm.jp.moviesmanager.model.Constants.EXTRA_VIEW_OP
import ifsp.ads.pdm.jp.moviesmanager.model.Constants.MSG_DURATION_VALUE
import ifsp.ads.pdm.jp.moviesmanager.model.Constants.MSG_RATE_OUT_OF_RANGE
import ifsp.ads.pdm.jp.moviesmanager.model.Constants.MSG_YEAR_RELEASE_VALUE
import ifsp.ads.pdm.jp.moviesmanager.model.entities.Movie

class MovieActivity : AppCompatActivity() {
    private val mab : ActivityMovieBinding by lazy {
        ActivityMovieBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mab.root)
        val receivedMovie = intent.getParcelableExtra<Movie>(EXTRA_MOVIE)
        val updateOp = intent.getBooleanExtra(EXTRA_UPDATE_OP, false)
        val viewOp = intent.getBooleanExtra(EXTRA_VIEW_OP, false)
        receivedMovie?.let { _receivedMovie ->
            with(mab) {
                with(_receivedMovie) {
                    movieNameEt.setText(movieName)
                    releaseYearEt.setText(releaseYear.toString())
                    movieStudioEt.setText(studio)
                    durationEt.setText(duration.toString())
                    if(rate == null) rateEt.setText("0")
                    else rateEt.setText(rate.toString())
                    if(watched == 0) watchedCb.isChecked = false
                    else watchedCb.isChecked = true
                    if(genreId != null) {
                        genreSp.setSelection(genreId!!)
                    }

                }
                if(updateOp) {
                    movieNameEt.isEnabled = false
                }
                if(viewOp) {
                    movieNameEt.isEnabled = false
                    releaseYearEt.isEnabled = false
                    movieStudioEt.isEnabled = false
                    durationEt.isEnabled = false
                    rateEt.isEnabled = false
                    watchedCb.isEnabled = false
                    saveMovieBt.visibility = View.GONE
                    genreSp.isEnabled = false
                }

            }
        }

        mab.saveMovieBt.setOnClickListener{
            if(mab.rateEt.text.toString().toDouble() > 10 ||
                mab.rateEt.text.toString().toDouble() < 0) {
                Toast.makeText(this, MSG_RATE_OUT_OF_RANGE, Toast.LENGTH_LONG).show()
            } else if(mab.durationEt.text.toString().toInt() <= 0) {
                Toast.makeText(this, MSG_DURATION_VALUE, Toast.LENGTH_LONG).show()
            } else if(mab.releaseYearEt.text.toString().toInt() <= 0) {
                Toast.makeText(this, MSG_YEAR_RELEASE_VALUE, Toast.LENGTH_LONG).show()
            }else {
                val movie = Movie(
                    movieName = mab.movieNameEt.text.toString(),
                    releaseYear = mab.releaseYearEt.text.toString().toInt(),
                    studio = mab.movieStudioEt.text.toString(),
                    duration = mab.durationEt.text.toString().toInt(),
                    rate =  (mab.rateEt.text.toString().toDouble()),
                    watched = if(mab.watchedCb.isChecked == true) 1 else 0,
                    genreId = mab.genreSp.selectedItemPosition
                )
                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_MOVIE, movie)
                resultIntent.putExtra(EXTRA_UPDATE_OP, updateOp)
                setResult(RESULT_OK, resultIntent)
                finish()
            }
        }
    }

}