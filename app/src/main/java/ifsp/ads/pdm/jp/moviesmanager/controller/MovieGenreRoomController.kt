package ifsp.ads.pdm.jp.moviesmanager.controller

import android.os.AsyncTask
import androidx.room.Room
import ifsp.ads.pdm.jp.moviesmanager.database.Database
import ifsp.ads.pdm.jp.moviesmanager.model.Constants
import ifsp.ads.pdm.jp.moviesmanager.model.dao.MovieGenreRoomDao
import ifsp.ads.pdm.jp.moviesmanager.model.entities.Movie
import ifsp.ads.pdm.jp.moviesmanager.model.entities.MovieGenre
import ifsp.ads.pdm.jp.moviesmanager.view.MainActivity

class MovieGenreRoomController (private val mainActivity: MainActivity) {

    private val movieGenreRoomDaoImpl : MovieGenreRoomDao by lazy {
        Room.databaseBuilder(
            mainActivity,
            Database::class.java,
            Constants.DATABASE_NAME
        ).build().getMovieGenreRoomDao();
    }

    fun getMovieGenres() {
        object : AsyncTask<Unit, Unit, MutableList<MovieGenre>>() {
            override fun doInBackground(vararg params: Unit?): MutableList<MovieGenre> {
                val genres = mutableListOf<MovieGenre>()
                genres.addAll(movieGenreRoomDaoImpl.getMovieGenres())
                return genres
            }

            override fun onPostExecute(result: MutableList<MovieGenre>?) {
                super.onPostExecute(result)
                if (result != null) {
                    //atualiza lista generos da main activity
                }
            }

        }.execute()
    }

    fun insertMovieGenre(movieGenre: MovieGenre) {
        Thread {
            movieGenreRoomDaoImpl.insertMovieGenre(movieGenre)
            getMovieGenres()
        }.start()
    }

    fun updateMovieGenre(movieGenre: MovieGenre) {
        Thread {
            movieGenreRoomDaoImpl.updateMovieGenre(movieGenre)
            getMovieGenres()
        }.start()
    }

    fun deleteMovieGenre(movieGenre: MovieGenre) {
        Thread {
            movieGenreRoomDaoImpl.deleteMovieGenre(movieGenre)
            getMovieGenres()
        }.start()
    }
}