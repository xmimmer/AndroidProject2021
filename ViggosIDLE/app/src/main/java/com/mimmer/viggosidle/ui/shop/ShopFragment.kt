package com.mimmer.viggosidle.ui.shop

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.mimmer.viggosidle.Autoclickers
import com.mimmer.viggosidle.MainViewModel
import com.mimmer.viggosidle.R
import com.mimmer.viggosidle.Upgrades

class ShopFragment : Fragment() {

    private lateinit var homeViewModel: MainViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(MainViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val score: TextView = root.findViewById(R.id.shopScore)
        val bagelButton: Button = root.findViewById(R.id.bagelButton)
        val pizzaButton: Button = root.findViewById(R.id.pizzaButton)
        val underbergButton: Button = root.findViewById(R.id.underbergButton)
        val autoClickerButton: Button = root.findViewById(R.id.autoclickerButton)


        score.text = homeViewModel.currentScore.toString()

        fun checkShopStatus() {
            if (homeViewModel.currentScore >= Upgrades.BAGEL.price) {
                bagelButton.setBackgroundColor(Color.YELLOW)
                bagelButton.isEnabled = true
            } else {
                bagelButton.setBackgroundColor(Color.RED)
                bagelButton.isEnabled = false
            }
            if (homeViewModel.currentScore >= Upgrades.PIZZA.price) {
                pizzaButton.setBackgroundColor(Color.YELLOW)
                pizzaButton.isEnabled = true
            } else {
                pizzaButton.setBackgroundColor(Color.RED)
                pizzaButton.isEnabled = false
            }
            if (homeViewModel.currentScore >= Upgrades.UNDERBERG.price) {
                underbergButton.setBackgroundColor(Color.YELLOW)
                underbergButton.isEnabled = true
            } else {
                underbergButton.setBackgroundColor(Color.RED)
                underbergButton.isEnabled = false
            }
            if (homeViewModel.currentScore >= Autoclickers.PIGE.price) {
                autoClickerButton.setBackgroundColor(Color.YELLOW)
                autoClickerButton.isEnabled = true
            } else {
                autoClickerButton.setBackgroundColor(Color.RED)
                autoClickerButton.isEnabled = false
            }
        }

        checkShopStatus()

        bagelButton.setOnClickListener() {
            if (homeViewModel.currentScore >= Upgrades.BAGEL.price) {

                //Provide stats & spent the points
                homeViewModel.clickingPower += Upgrades.BAGEL.efficiency
                homeViewModel.currentScore -= Upgrades.BAGEL.price

                //Handle the UI
                bagelButton.setBackgroundColor(Color.GREEN)
                bagelButton.isEnabled = false
                score.text = homeViewModel.currentScore.toString()

                //Update text views
                homeViewModel.setClickingPower()
                homeViewModel.setScore()
                checkShopStatus()

                Toast.makeText(activity, "Bagel purchased!", Toast.LENGTH_SHORT).show()
            }
        }
        pizzaButton.setOnClickListener() {
            if (homeViewModel.currentScore >= Upgrades.PIZZA.price) {

                //Provide stats & spent the points
                homeViewModel.clickingPower += Upgrades.PIZZA.efficiency
                homeViewModel.currentScore -= Upgrades.PIZZA.price

                //Handle the UI
                pizzaButton.setBackgroundColor(Color.GREEN)
                pizzaButton.isEnabled = false
                score.text = homeViewModel.currentScore.toString()

                //Update text views
                homeViewModel.setClickingPower()
                homeViewModel.setScore()
                checkShopStatus()

                Toast.makeText(activity, "Pizza purchased!", Toast.LENGTH_SHORT).show()
            }
        }
        underbergButton.setOnClickListener() {
            if (homeViewModel.currentScore >= Upgrades.UNDERBERG.price) {

                //Provide stats & spent the points
                homeViewModel.clickingPower += Upgrades.UNDERBERG.efficiency
                homeViewModel.currentScore -= Upgrades.UNDERBERG.price

                //Handle the UI
                underbergButton.setBackgroundColor(Color.GREEN)
                underbergButton.isEnabled = false
                score.text = homeViewModel.currentScore.toString()

                //Update text views
                homeViewModel.setClickingPower()
                homeViewModel.setScore()
                checkShopStatus()

                Toast.makeText(activity, "Underberg purchased!", Toast.LENGTH_SHORT).show()
            }
        }

        autoClickerButton.setOnClickListener() {
            if (homeViewModel.currentScore >= Autoclickers.PIGE.price) {

                homeViewModel.currentScore -= Autoclickers.PIGE.price
                homeViewModel.idle_gains += 1
                homeViewModel.setIdleGains()
                checkShopStatus()

                Toast.makeText(activity, "Pige purchased! Delicious!", Toast.LENGTH_SHORT).show()

                Log.i("idle gains : ", homeViewModel.idle_gains.toString())
            }
        }
        return root
    }
}