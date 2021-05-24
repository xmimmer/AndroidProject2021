package com.mimmer.viggosidle.ui.drink

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.mimmer.viggosidle.MainViewModel
import com.mimmer.viggosidle.R

class DrinkFragment : Fragment() {

    private lateinit var homeViewModel: MainViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(MainViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        //Initializing views
        val score: TextView = root.findViewById(R.id.score)
        val imageView: ImageView = root.findViewById(R.id.main_image)
        val resetButton: Button = root.findViewById(R.id.resetButtonHome)
        val clickingPower: TextView = root.findViewById(R.id.clickingPower)

        //Set the correct stats when fragment is loaded
        score.text = homeViewModel.currentScore.toString()
        clickingPower.text = homeViewModel.clickingPower.toString()


        imageView.setOnClickListener() {

            homeViewModel.currentScore += homeViewModel.clickingPower
            homeViewModel.setScore()

            score.text = homeViewModel.currentScore.toString()

        }
        resetButton.setOnClickListener() {
            homeViewModel.resetStats()
            homeViewModel.setScore()
            homeViewModel.setClickingPower()
            clickingPower.text = homeViewModel.clickingPower.toString()
            score.text = homeViewModel.currentScore.toString()

            Toast.makeText(activity, "All stats have been reset!", Toast.LENGTH_SHORT).show()
        }

        fun autoClicker() {
            val timer = object : CountDownTimer(9999999, 250) {
                override fun onTick(millisUntilFinished: Long) {

                    homeViewModel.currentScore += homeViewModel.idle_gains
                    homeViewModel.setScore()

                    score.text = homeViewModel.currentScore.toString()

                }
                override fun onFinish() {
                }
            }
            timer.start()
        }

       // autoClicker()

        return root
    }
}