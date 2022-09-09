package hasan.gurgur.viewpager2exampleapp

import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import hasan.gurgur.viewpager2exampleapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    var def: ColorStateList? = null
    var selected: ColorStateList? = null
    lateinit var item1: TextView
    lateinit var item2: TextView
    lateinit var select: LinearLayout
    lateinit var pager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        item1 = binding.tabCustom.item1
        item2 = binding.tabCustom.item2
        select = binding.tabCustom.select
        pager = binding.viewPager

        selected = item1.textColors
        def = item2.textColors

        val pagerAdapter = CustomPagerAdapter(this)
        pager.apply {
            adapter = pagerAdapter
        }

        pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                setupTab(position)
            }
        })

        item1.setOnClickListener {
            setupTab(0)
        }
        item2.setOnClickListener {
            setupTab(1)
        }


    }


    fun setupTab(position: Int) {
        if (position == 0) {
            select.animate().x(0.0f).duration = 100
            item1.setTextColor(selected)
            item2.setTextColor(def)
            pager.setCurrentItem(0)
        } else if (position == 1) {
            item1.setTextColor(def)
            item2.setTextColor(selected)
            val size = select.width
            select.animate().x(size.toFloat()).duration = 100
            pager.setCurrentItem(1)
        }
    }

}