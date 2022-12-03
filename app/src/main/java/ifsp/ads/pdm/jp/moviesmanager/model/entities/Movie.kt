package ifsp.ads.pdm.jp.moviesmanager.model.entities

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.time.Duration

@Parcelize
@Entity(tableName = "movie")
data class Movie(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "movie_name")
    var movieName: String,
    @NonNull
    @ColumnInfo(name = "release_year")
    var releaseYear: Int,
    @NonNull
    var studio : String,
    @NonNull
    var duration: Int,
    @NonNull
    var watched: Int, //boolean flag (0 = false, 1 = true)
    var rate : Int?, //from 0 up to 10
) : Parcelable
