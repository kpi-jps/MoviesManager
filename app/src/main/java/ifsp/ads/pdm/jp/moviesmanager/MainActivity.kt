package ifsp.ads.pdm.jp.moviesmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ifsp.ads.pdm.jp.moviesmanager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val amb : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)
    }
}