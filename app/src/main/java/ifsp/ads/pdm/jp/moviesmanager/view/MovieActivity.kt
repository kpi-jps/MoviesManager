package ifsp.ads.pdm.jp.moviesmanager.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ifsp.ads.pdm.jp.moviesmanager.databinding.ActivityMovieBinding

class MovieActivity : AppCompatActivity() {
    private val mab : ActivityMovieBinding by lazy {
        ActivityMovieBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mab.root)
    }
}