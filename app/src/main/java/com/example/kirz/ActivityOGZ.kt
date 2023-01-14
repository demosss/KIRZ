package com.example.kirz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kirz.databinding.ActivityOgzBinding
import kotlin.math.round

class ActivityOGZ : AppCompatActivity() {
    private lateinit var binding: ActivityOgzBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOgzBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvDistance.visibility = View.INVISIBLE
        binding.tvDU.visibility = View.INVISIBLE
        binding.tvGrad.visibility = View.INVISIBLE

        binding.btOGZCalculate.setOnClickListener {
            fun intChecker(string: String): Int {
                return if(string == "") 0
                else string.toInt()
            }

            val xRLS = intChecker(binding.xRLS.text.toString())
            val yRLS = intChecker(binding.yRLS.text.toString())
            val xPoint = intChecker(binding.xOrientir.text.toString())
            val yPoint = intChecker(binding.yOrientir.text.toString())
            val orient = OGZ(xRLS, yRLS, xPoint, yPoint)

            binding.tvDistance.text = orient.getDistance().toString()
            val resultToGrad = orient.getDirectionGrad()
            val resultToDU = orient.getDirectDU(resultToGrad)
            binding.tvGrad.text = (round(resultToGrad * 1000) / 1000).toString()
            binding.tvDU.text = resultToDU

            binding.tvDistance.visibility = View.VISIBLE
            binding.tvDU.visibility = View.VISIBLE
            binding.tvGrad.visibility = View.VISIBLE
        }


    }
}