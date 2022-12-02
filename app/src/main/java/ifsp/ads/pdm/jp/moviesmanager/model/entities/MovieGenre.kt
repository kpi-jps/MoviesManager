package ifsp.ads.pdm.jp.moviesmanager.model.entities

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Entity(tableName = "movie_genre")
@Parcelize
data class MovieGenre (
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo(name = "genre_id")
    var genreId : Long,
    @NonNull
    @ColumnInfo(name = "genre_name")
    var genreName : String
) : Parcelable