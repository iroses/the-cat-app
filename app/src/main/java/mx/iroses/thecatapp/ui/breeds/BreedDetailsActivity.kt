package mx.iroses.thecatapp.ui.breeds

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import mx.iroses.thecatapp.R
import mx.iroses.thecatapp.data.Breed

class BreedDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breed_details)

        val breed: Breed =
            intent.extras?.getParcelable(BreedDetailsFragment.ARG_BREED) ?: return run { finish() }

        setSupportActionBar(toolbar)
        supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
        }

        supportFragmentManager.findFragmentById(R.id.breedContentDetailFrame)
            ?: supportFragmentManager.beginTransaction()
                .replace(R.id.breedContentDetailFrame, BreedDetailsFragment.newInstance(breed))
                .commit()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}