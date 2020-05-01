package com.mergeadapter

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.MergeAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), HeaderAdapter.OnOfferClick {

    private lateinit var mergeAdapter: MergeAdapter
    private val foodList = ArrayList<Food>()
    private val headerAdapter = HeaderAdapter(this)
    private val foodListAdapter = FoodListAdapter()
    private val footerAdapter = FooterAdapter()
    private val offerAdapter = OfferAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        foodList.add(Food("French fries", "Fresh fries with tomato ketchup"))
        foodList.add(Food("Pizza", "Delicious pizza with extra cheese"))
        foodList.add(Food("Pasta", "with brown butter"))
        foodList.add(Food("Burger", "Yummy hot burger"))
        foodList.add(Food("Noodles", "Spicy Hakka noodles"))

        foodListAdapter.submitList(foodList)

        mergeAdapter = MergeAdapter(headerAdapter, foodListAdapter, footerAdapter)

        rv.adapter = mergeAdapter

        Handler().postDelayed({
            footerAdapter.changeState()
        }, 3000)

    }

    override fun onOfferClick(isShow: Boolean) {
        if (isShow) {
            // Add adapter at specified position
            mergeAdapter.addAdapter(1, offerAdapter)
        } else {
            mergeAdapter.removeAdapter(offerAdapter)
        }
    }
}
