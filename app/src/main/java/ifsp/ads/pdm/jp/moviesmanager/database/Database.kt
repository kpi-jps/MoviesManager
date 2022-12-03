package ifsp.ads.pdm.jp.moviesmanager.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ifsp.ads.pdm.jp.moviesmanager.model.dao.MovieRoomDao
import ifsp.ads.pdm.jp.moviesmanager.model.entities.Movie

@Database(entities = [Movie::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract fun getMovieRoomDao() : MovieRoomDao
}