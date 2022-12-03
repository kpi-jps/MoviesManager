package ifsp.ads.pdm.jp.moviesmanager.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import ifsp.ads.pdm.jp.moviesmanager.R
import ifsp.ads.pdm.jp.moviesmanager.model.entities.MovieGenre

class MovieGenreAdapter (context: Context,
                         private val movieGenres : MutableList<MovieGenre>
) : ArrayAdapter<MovieGenre>(context, R.layout.tile_genre, movieGenres) {
    private data class TileMovieGenreHolder(val genreTv : TextView)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val movieGenre = movieGenres[position]
        var movieGenreTaleView = convertView
        if (movieGenreTaleView == null) {
            movieGenreTaleView = (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
                .inflate(R.layout.tile_genre, parent, false)
            val tileMovieGenderHolder = TileMovieGenreHolder(
                movieGenreTaleView.findViewById(R.id.genreTv),
            )
            movieGenreTaleView.tag  = movieGenreTaleView
        }
        with(movieGenreTaleView?.tag as TileMovieGenreHolder) {
            genreTv.text = movieGenre.genreName
        }
        return movieGenreTaleView
    }
}