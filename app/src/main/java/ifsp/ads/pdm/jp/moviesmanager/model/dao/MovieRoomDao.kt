package ifsp.ads.pdm.jp.moviesmanager.model.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import ifsp.ads.pdm.jp.moviesmanager.model.entities.Movie

@Dao
interface MovieRoomDao {
    @Insert
    fun insertMovie(movie : Movie)
    @Update
    fun updateMovie(movie: Movie) : Int //return the number of lines changed
    @Delete
    fun deleteMovie(movie : Movie) : Int //return the number of lines changed
    @Query("SELECT * FROM movie ORDER BY movie_name")
    fun getMovies() : MutableList<Movie>
    @Query("SELECT * FROM movie ORDER BY rate DESC")
    fun getMoviesSortedByRate() : MutableList<Movie>
}