package `in`.example.Book_Share

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var toogle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        settingUpNavigationDrawer()
        setupViewPager()

    }

    private fun settingUpNavigationDrawer() {

        toogle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()


        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setDisplayShowHomeEnabled(true)

        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_profile -> {
                    Toast.makeText(this, "Search CLicked", Toast.LENGTH_SHORT).show()


                }
                R.id.nav_mybooks -> {
                    Toast.makeText(this, "Search CLicked", Toast.LENGTH_SHORT).show()

                }

                R.id.nav_addbooks -> {
                    Toast.makeText(this, "Search CLicked", Toast.LENGTH_SHORT).show()

                }

                R.id.nav_settings -> {
                    Toast.makeText(this, "Search CLicked", Toast.LENGTH_SHORT).show()

                }

                R.id.nav_privacypolicy -> {
                    Toast.makeText(this, "Search CLicked", Toast.LENGTH_SHORT).show()

                }
                R.id.nav_about -> {
                    Toast.makeText(this, "Search CLicked", Toast.LENGTH_SHORT).show()

                }

            }
            true
        }


        bottom_navigation.setOnNavigationItemReselectedListener { item ->
            when (item.itemId) {
                R.id.bottom_home -> {
                    Toast.makeText(this, "Home CLicked", Toast.LENGTH_SHORT).show()

                    viewpager.setCurrentItem(0)

                }
                R.id.bottom_search -> {
                    Toast.makeText(this, "Search CLicked", Toast.LENGTH_SHORT).show()
                    // Respond to navigation item 1 reselection
                    viewpager.setCurrentItem(1)
                }
                R.id.bottom_books -> {
                    Toast.makeText(this, "Your Books CLicked", Toast.LENGTH_SHORT).show()
                    // Respond to navigation item 2 reselection
                    viewpager.setCurrentItem(2)
                }
            }
        }
        true



        viewpager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> bottom_navigation.getMenu().findItem(R.id.bottom_home).setChecked(true)
                    1 -> bottom_navigation.getMenu().findItem(R.id.bottom_search).setChecked(true)
                    2 -> bottom_navigation.getMenu().findItem(R.id.bottom_books).setChecked(true)
                }
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })





    }

    private fun setupViewPager() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragmnt(HomeFragment(), "")
        adapter.addFragmnt(SearchFragment(), "")
        adapter.addFragmnt(BooksFragment(), "")
        viewpager.adapter = adapter


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toogle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
