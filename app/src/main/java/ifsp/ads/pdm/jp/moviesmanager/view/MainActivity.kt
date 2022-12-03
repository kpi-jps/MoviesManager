package ifsp.ads.pdm.jp.moviesmanager.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import ifsp.ads.pdm.jp.moviesmanager.adapter.MovieAdapter
import ifsp.ads.pdm.jp.moviesmanager.databinding.ActivityMainBinding
import ifsp.ads.pdm.jp.moviesmanager.model.entities.Movie

class MainActivity : AppCompatActivity() {
    private val amb : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val movies = mutableListOf<Movie>()

    private lateinit var movieAdapter: MovieAdapter

    private lateinit var carl : ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)
        movieAdapter = MovieAdapter(this, movies)
        amb.moviesLv.adapter = movieAdapter
    }
}