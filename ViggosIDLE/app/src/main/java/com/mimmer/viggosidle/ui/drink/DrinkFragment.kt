package com.mimmer.viggosidle.ui.drink

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.mimmer.viggosidle.R

class DrinkFragment : Fragment() {

    private lateinit var homeViewModel: DrinkViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(DrinkViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        val score: TextView = root.findViewById(R.id.score)
        val imageView: ImageView = root.findViewById(R.id.main_image)

        imageView.setOnClickListener() {
            Log.i("ClickTag","Main image clicked!")
            homeViewModel.currentScore += 1
            homeViewModel.score.value

            Log.i("CurrentScore", homeViewModel.currentScore.toString())
            Log.i("score value", homeViewModel.score.value.toString())

            score.text = homeViewModel.currentScore.toString()

        }
        return root
    }
}