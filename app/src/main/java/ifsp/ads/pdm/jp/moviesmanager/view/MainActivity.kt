package ifsp.ads.pdm.jp.moviesmanager.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import ifsp.ads.pdm.jp.moviesmanager.R
import ifsp.ads.pdm.jp.moviesmanager.adapter.MovieAdapter
import ifsp.ads.pdm.jp.moviesmanager.controller.MovieRoomController
import ifsp.ads.pdm.jp.moviesmanager.databinding.ActivityMainBinding
import ifsp.ads.pdm.jp.moviesmanager.model.Constants.EXTRA_MOVIE
import ifsp.ads.pdm.jp.moviesmanager.model.Constants.EXTRA_UPDATE_OP
import ifsp.ads.pdm.jp.moviesmanager.model.Constants.MSG_MOVIE_ALREADY_REGISTERED
import ifsp.ads.pdm.jp.moviesmanager.model.entities.Movie

class MainActivity : AppCompatActivity() {
    private val amb : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val movies = mutableListOf<Movie>()

    private lateinit var movieAdapter: MovieAdapter

    private lateinit var carl : ActivityResultLauncher<Intent>

    private val movieController : MovieRoomController by lazy {
        MovieRoomController(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)
        movieAdapter = MovieAdapter(this, movies)
        amb.moviesLv.adapter = movieAdapter

        carl = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) {
            result ->
                if(result.resultCode == RESULT_OK) {
                    val movie = result.data?.getParcelableExtra<Movie>(EXTRA_MOVIE)
                    movie?.let  { _movie ->
                        if(_movie.movieName != null) {
                            val pos = movies.indexOfFirst { it.movieName == _movie.movieName }
                            if (pos != -1) {
                                var updateOp = result.data?.getBooleanExtra(EXTRA_UPDATE_OP,true)
                                if(updateOp!!) {
                                    movieController.updateMovie(_movie)
                                } else {
                                    Toast.makeText(
                                        this,
                                        MSG_MOVIE_ALREADY_REGISTERED,
                                        Toast.LENGTH_LONG
                                    ).show()
                                }
                            } else {
                                movieController.insertMovie(_movie)
                            }
                        }
                    }
                }
            }
        registerForContextMenu(amb.moviesLv)

        amb.moviesLv.onItemClickListener = AdapterView.OnItemClickListener{_,_, pos, _ ->
            val movie = movies[pos]
            val movieIntent = Intent(this@MainActivity, MovieActivity::class.java)
            movieIntent.putExtra(EXTRA_MOVIE, movie)
            movieIntent.putExtra(EXTRA_UPDATE_OP, false)
            startActivity(movieIntent)
        }
        movieController.getMovies()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.addMovieMi -> {
                carl.launch(Intent(this, MovieActivity::class.java))
                true
            }
            else -> {false}
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val pos = (item.menuInfo as AdapterContextMenuInfo).position
        val movie = movies[pos]
        return when (item.itemId) {
            R.id.removeItemMi -> {
                movieController.deleteMovie(movie)
                true
            }
            R.id.editItemMi -> {
                val movieIntent = Intent(this, MovieActivity::class.java)
                movieIntent.putExtra(EXTRA_MOVIE, movie)
                movieIntent.putExtra(EXTRA_UPDATE_OP, true)
                true
            }
            else -> {false}
        }
    }

    fun updateMovies(_movies : MutableList<Movie>) {
        movies.clear()
        movies.addAll(_movies)
        movieAdapter.notifyDataSetChanged()
    }
}