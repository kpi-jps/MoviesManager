package ifsp.ads.pdm.jp.moviesmanager.model.dao

import androidx.room.*
import ifsp.ads.pdm.jp.moviesmanager.model.entities.MovieGenre

@Dao
interface MovieGenreRoomDao {
    @Insert
    fun insertMovieGenre(movieGenre: MovieGenre) : Long //return the id of entity inserted
    @Update
    fun updateMovieGenre(movieGenre: MovieGenre) : Int //return the number of lines changed
    @Delete
    fun deleteMovieGenre(movieGenre: MovieGenre) : Int //return the number of lines changed
    @Query("SELECT * FROM movie_genre ORDER BY genre_name")
    fun getMovieGenres() : MutableList<MovieGenre>
}