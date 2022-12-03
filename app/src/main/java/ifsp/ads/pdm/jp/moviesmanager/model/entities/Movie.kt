package ifsp.ads.pdm.jp.moviesmanager.model.entities

import android.os.Parcelable
import android.text.Editable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "movie")
data class Movie(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "movie_name")
    var movieName: String,
    @ColumnInfo(name = "release_year")
    var releaseYear: Int,
    var studio: String,
    var duration: Int,
    var watched: Int, //boolean flag (0 = false, 1 = true)
    var rate: Double?, //from 0 up to 10
    var genreId: Int?
) : Parcelable
