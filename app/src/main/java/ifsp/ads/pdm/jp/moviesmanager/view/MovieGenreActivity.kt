package ifsp.ads.pdm.jp.moviesmanager.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ifsp.ads.pdm.jp.moviesmanager.databinding.ActivityMovieGenreBinding

class MovieGenreActivity : AppCompatActivity() {
    private val amgb : ActivityMovieGenreBinding by lazy {
        ActivityMovieGenreBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amgb.root)
    }
}