package ifsp.ads.pdm.jp.moviesmanager.adapter

import android.content.Context
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import ifsp.ads.pdm.jp.moviesmanager.R
import ifsp.ads.pdm.jp.moviesmanager.model.entities.Movie

class MovieAdapter (
        context: Context,
        private val movies : MutableList<Movie>
        ) : ArrayAdapter<Movie> (context, R.layout.tile_movie, movies) {
            private data class TileMovieHolder(val movieNameTv : TextView, val movieRateTv : TextView)

            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val movie = movies[position]
                var movieTaleView = convertView
                if (movieTaleView == null) {
                    movieTaleView = (context.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater)
                        .inflate(R.layout.tile_movie, parent, false)
                    val tileMovieHolder = TileMovieHolder(
                        movieTaleView.findViewById(R.id.movieNameTv),
                        movieTaleView.findViewById(R.id.movieRateTv)
                    )
                    movieTaleView.tag  = tileMovieHolder
                }
                with(movieTaleView?.tag as TileMovieHolder) {
                    movieNameTv.text = movie.movieName
                    movieRateTv.text = movie.rate.toString()
                }
                return movieTaleView
            }
        }