package org.augbari.peakSeeker

import org.jfree.chart.ChartFactory
import org.jfree.chart.ChartPanel
import org.jfree.chart.plot.PlotOrientation
import org.jfree.data.xy.XYSeries
import org.jfree.data.xy.XYSeriesCollection
import org.jfree.ui.ApplicationFrame

class Window(title: String) : ApplicationFrame(title) {

    val series = XYSeries("X Accel")

    init {

        /*vals.forEachIndexed { index, d ->
            series.add(index, d)
        }*/
        val data = XYSeriesCollection(series)
        val chart = ChartFactory.createXYLineChart(
                "X Accelerometer Data",
                "time",
                "accel",
                data,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        )

        val chartPanel = ChartPanel(chart)
        chartPanel.preferredSize = java.awt.Dimension(500, 270)
        contentPane = chartPanel

    }

    public fun add(d: Double) {
        series.add(series.itemCount, d)

        if(series.itemCount > 1000) {
            series.clear()
            pack()
        }
    }

}

