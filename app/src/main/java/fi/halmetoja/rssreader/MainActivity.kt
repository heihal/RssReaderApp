package fi.halmetoja.rssreader


import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

/**
 *  @author hemhal
 *  Course exercise RSS feed reader
 * TODO Dagger2 injection, Retrofit HTTP, ..
 *
 *
 *
 *
 *
 *
 */
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_root,RSSFragment()).commit()

       val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val navView = findViewById<NavigationView>(R.id.nav_view)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout,  0, 0
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)



    }

    /**
     *  Logic in nav menu
     *
     * @param item nav menu item
     * @return boolean
     */

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_links -> {
                Toast.makeText(applicationContext, "Not implemented yet", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_categories -> {
                Toast.makeText(applicationContext, "Not implemented yet", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_about -> {
                Toast.makeText(applicationContext, "Not implemented yet", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_quit -> {
                finish()
            }

        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

}
