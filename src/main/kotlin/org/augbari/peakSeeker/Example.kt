package org.augbari.peakSeeker

import org.jfree.ui.RefineryUtilities
import java.awt.Robot
import java.awt.event.KeyEvent

/**
 * Example class to show usage
 * */
class Example {

    companion object : OnPeakListener {

        val r = Robot()

        @JvmStatic
        fun main(args: Array<String>) {

            val demo = Window("X Accel Data")
            demo.pack()
            RefineryUtilities.centerFrameOnScreen(demo)
            demo.isVisible = true

            // Create PeakSeeker object
            val peakSeeker = PeakSeeker("tcp://broker.shiftr.io", "PeakSeeker", this, demo)

            // Perform connection
            peakSeeker.connect("aug-bari", "PasswordSuperSicura42")

            // Subscribe to topic
            peakSeeker.subscribe("la/bacchetta/sembraFunzionare")

        }

        override fun onPeak(peak: Peak) {
            //println("Detected ${peak.type} peak on ${peak.axis} axis with value: ${peak.value}")

            when(peak.type.toString().toLowerCase()) {
                "left" -> {
                    println("Received left command.")
                    r.keyPress(KeyEvent.VK_LEFT)
                    r.keyRelease(KeyEvent.VK_LEFT)
                }
                "right" -> {
                    println("Received right command.")
                    r.keyPress(KeyEvent.VK_RIGHT)
                    r.keyRelease(KeyEvent.VK_RIGHT)
                }
            }
        }
    }

}