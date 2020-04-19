package fi.halmetoja.rssreader


import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*


/**
 *  @author hemhal
 *
 *  Launches [MainActivity] with [R.id.fragment_root]
 *
 *  Sets navigation [R.id.nav_view] and adds
 *
 *  listener to it
 *
 * TODO Dagger2 injection, Retrofit HTTP connection, ..
 */
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_root, RSSFragment())
            .commit()

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val navView = findViewById<NavigationView>(R.id.nav_view)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, 0, 0
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)


    }

    /**
     *  Logic in nav menu
     *
     * @param item nav [MenuItem]
     * @return [Boolean]
     */

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_links -> {
                aboutDialog("links")
            }
            R.id.nav_categories -> {
                Toast.makeText(applicationContext, "Not implemented yet", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_about -> {
                aboutDialog("readme")
            }
            R.id.nav_quit -> {
                finish()
            }

        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    /**
     * Opens dialog with hyperlinks
     *
     * @param item Choose which dialog you want to open
     */
    private fun aboutDialog(item: String) {
        val builder =
            AlertDialog.Builder(this@MainActivity)
        if (item == "readme") {
            builder.setMessage(R.string.readme)
        } else {
            builder.setMessage(R.string.links)
        }
        val alert = with(builder) {
            setCancelable(false)
            setPositiveButton(
                "Cancel"
            ) { dialog, which -> }
            create()
            show()
        }
        (alert.findViewById<View>(android.R.id.message) as TextView?)!!.movementMethod =
            LinkMovementMethod.getInstance()
    }

}
