package com.example.kirz

import kotlin.math.*

class OGZ(xRLS: Int,yRLS: Int,xPoint: Int,yPoint: Int) {

    private val xDist = (xPoint - xRLS).toDouble()
    private val yDist = (yPoint - yRLS).toDouble()

    fun getDistance(): Int {
        return sqrt(xDist.pow(2) + yDist.pow(2)).roundToInt()
    }

    fun getDirectionGrad(): Double{
        var result = 0.0
        if (xDist > 0.0 && yDist == 0.0) result = 0.0
        else if(xDist > 0.0 && yDist > 0.0) result = atan(abs(yDist / xDist))
        else if (xDist == 0.0 && yDist > 0.0) result = PI / 2
        else if (xDist < 0.0 && yDist > 0.0) result = PI - atan(abs(yDist / xDist))
        else if (xDist < 0.0 && yDist == 0.0) result = PI
        else if (xDist < 0.0 && yDist < 0.0) result = PI + atan(abs(yDist / xDist))
        else if (xDist == 0.0 && yDist < 0.0) result = 3 * PI / 2
        else if (xDist > 0.0 && yDist < 0.0) result = 2 * PI - atan(abs(yDist / xDist))
        return result * 180 / PI
    }

    fun getDirectDU(grad: Double): String {
        val du = grad * 60 / 3.6
        val bdu = (du / 100).toInt()
        val mdu = (du % 100).roundToInt()
        val strBDU: String = if (bdu < 10) "0$bdu"
        else "$bdu"
        val strMDU: String = if (mdu < 10) "0$mdu"
        else "$mdu"
        return "$strBDU-$strMDU"
    }

}