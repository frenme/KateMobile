package bonch.dev.katemobile

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
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


    fun replaceFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.nestedScrolling, ShowDialog())
            .addToBackStack(null)
            .commit()
    }





    fun replaceFragment1() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.nestedScrolling, FullProfile())
            .addToBackStack(null)
            .commit()
    }

    fun replaceFragment2() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.nestedScrolling, Groups())
            .addToBackStack(null)
            .commit()
    }

    fun replaceFragment3() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.nestedScrolling, Video())
            .addToBackStack(null)
            .commit()
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
