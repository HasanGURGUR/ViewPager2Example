package hasan.gurgur.viewpager2exampleapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class CustomPagerAdapter(fa: FragmentActivity?) : FragmentStateAdapter(fa!!) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        // can replace with any fragment that you have
        if (position == 0) {
            return FirstFragment()
        } else {
            return SecondFragment()
        }
    }
}