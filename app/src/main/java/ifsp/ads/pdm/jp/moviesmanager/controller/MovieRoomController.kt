package ifsp.ads.pdm.jp.moviesmanager.controller

import android.os.AsyncTask
import androidx.room.Room
import ifsp.ads.pdm.jp.moviesmanager.database.Database
import ifsp.ads.pdm.jp.moviesmanager.model.Constants
import ifsp.ads.pdm.jp.moviesmanager.model.dao.MovieRoomDao
import ifsp.ads.pdm.jp.moviesmanager.model.entities.Movie
import ifsp.ads.pdm.jp.moviesmanager.view.MainActivity

class MovieRoomController(private val mainActivity: MainActivity) {

    private val movieRoomDaoImpl : MovieRoomDao by lazy {
        Room.databaseBuilder(
            mainActivity,
            Database::class.java,
            Constants.DATABASE_NAME
        ).build().getMovieRoomDao();
    }
    fun getMovies() {
        object : AsyncTask<Unit, Unit, MutableList<Movie>>() {
            override fun doInBackground(vararg params: Unit?): MutableList<Movie> {
                val movies = mutableListOf<Movie>()
                movies.addAll(movieRoomDaoImpl.getMovies())
                return movies
            }

            override fun onPostExecute(result: MutableList<Movie>?) {
                super.onPostExecute(result)
                if (result != null) {
                    //atualiza lista da main activity
                }
            }

        }.execute()
    }

    fun insertMovie(movie: Movie) {
        Thread {
            movieRoomDaoImpl.insertMovie(movie)
            getMovies()
        }.start()
    }

    fun updateMovie(movie: Movie) {
        Thread {
            movieRoomDaoImpl.updateMovie(movie)
            getMovies()
        }.start()
    }

    fun deleteMovie(movie: Movie) {
        Thread {
            movieRoomDaoImpl.deleteMovie(movie)
            getMovies()
        }.start()
    }

}