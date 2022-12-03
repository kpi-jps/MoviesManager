package ifsp.ads.pdm.jp.moviesmanager.model

object Constants {
    const val DATABASE_NAME = "database"

    const val EXTRA_MOVIE = "extra_movie"
    const val EXTRA_UPDATE_OP = "extra_update_op"
    const val EXTRA_VIEW_OP = "extra_view_op"

    //msgs
    const val MSG_MOVIE_ALREADY_REGISTERED = """ Já existe um filme cadastrado com este nome! 
        Repita a operação usando outro nome
        """
    const val MSG_RATE_OUT_OF_RANGE = "A nota precisa estar entre 0 e 10!"
    const val MSG_YEAR_RELEASE_VALUE = "O ano de lançamento precisa ser maior que 0!"
    const val MSG_DURATION_VALUE = "A duração do filme precisa ser maior que 0!"

}