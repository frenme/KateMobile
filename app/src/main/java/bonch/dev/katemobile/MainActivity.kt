package bonch.dev.katemobile

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import bonch.dev.katemobile.Constants.Companion.DIALOG
import bonch.dev.katemobile.Constants.Companion.FULL_PROFILE
import bonch.dev.katemobile.Constants.Companion.GROUPS
import bonch.dev.katemobile.Constants.Companion.VIDEOS
import bonch.dev.katemobile.view.ShowDialogView
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        setSupportActionBar(toolbar)

        //for correct scrolling in NestedScrolling
        val scrollView = findViewById<View>(R.id.nestedScrolling) as NestedScrollView
        scrollView.isFillViewport = true

        supportFragmentManager.beginTransaction()
            .add(R.id.nestedScrolling, ViewPager())
            .commit()
    }


    fun replaceFragment(id: Int) {
        when (id) {
            FULL_PROFILE -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.nestedScrolling, FullProfile())
                    .addToBackStack(null)
                    .commit()
            }
            GROUPS -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.nestedScrolling, Groups())
                    .addToBackStack(null)
                    .commit()
            }
            VIDEOS -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.nestedScrolling, Video())
                    .addToBackStack(null)
                    .commit()
            }
            DIALOG -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.nestedScrolling, ShowDialogView())
                    .addToBackStack(null)
                    .commit()
            }
        }

    }

    //check Internet connection (sorry for Deprecation, I did not find an actual way to check Internet...)
    companion object {
        @Suppress("DEPRECATION")
        fun isInternet(context: Context): Boolean {
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetworkInfo
            return networkInfo != null && networkInfo.isConnected
        }
    }


    //activate Menu button
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    //for work with items in Menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
