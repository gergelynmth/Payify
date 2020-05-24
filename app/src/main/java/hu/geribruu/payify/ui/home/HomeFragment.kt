package hu.geribruu.payify.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import hu.geribruu.payify.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val spendingBtn: Button = root.findViewById(R.id.home_spending_btn)
        val categoriesBtn: Button = root.findViewById(R.id.home_categories_btn)

        spendingBtn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                swapSpedingFragment()
            }
        })

        categoriesBtn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                swapCategoriesFragment()
            }
        })


        return root
    }

    private fun swapSpedingFragment() {

    }

    private fun swapCategoriesFragment() {
        
    }
}