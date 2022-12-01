package ifsp.ads.pdm.jp.moviesmanager.model.entities

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Entity
@Parcelize
data class MovieGenre (
    @PrimaryKey (autoGenerate = true)
    var genreId : Long,
    @NonNull
    var genreName : String
) : Parcelable