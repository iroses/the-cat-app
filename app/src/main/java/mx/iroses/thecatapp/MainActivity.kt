package mx.iroses.thecatapp

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_main.*
import mx.iroses.thecatapp.ui.breeds.BreedsFragment
import mx.iroses.thecatapp.ui.favorites.FavoritesFragment
import mx.iroses.thecatapp.ui.gallery.GalleryFragment
import mx.iroses.thecatapp.utils.replaceFragmentInActivity
import mx.iroses.thecatapp.utils.setupActionBar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupActionBar(R.id.toolbar) {
            setHomeAsUpIndicator(R.drawable.ic_menu)
            setDisplayHomeAsUpEnabled(true)
        }

        setupNavigationDrawer()

        setupViewFragment()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        when (item.itemId) {
            android.R.id.home -> {
                drawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    private fun setupNavigationDrawer() {
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_breeds_item -> {
                    replaceFragmentInActivity(BreedsFragment.newInstance(), R.id.contentFrame)
                }
                R.id.nav_gallery_item -> {
                    replaceFragmentInActivity(GalleryFragment.newInstance(), R.id.contentFrame)
                }
                R.id.nav_favorites_item -> {
                    replaceFragmentInActivity(FavoritesFragment.newInstance(), R.id.contentFrame)
                }
            }
            menuItem.isChecked = true
            drawerLayout.closeDrawers()
            true
        }
    }

    private fun setupViewFragment() {
        supportFragmentManager.findFragmentById(R.id.contentFrame)
            ?: supportFragmentManager.beginTransaction()
                .replace(R.id.contentFrame, BreedsFragment.newInstance())
                .commit()
    }
}