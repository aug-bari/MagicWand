# Magic Wand
MagicWand allows you to easily interact with your powerpoint slides and much more by simpling simulating keyboard keys through a sensor connected to an Arduino and communicating to MagicWandServer via MQTT protocol. 

Modules used to build this project:
https://github.com/aug-bari/MagicWandServer
https://github.com/aug-bari/PeakSeeker
https://github.com/aug-bari/MqttKotlinAPI

### Implementation of PeekSeeker
Use this module to receive mqtt data packets and check if a peak is found.
```sh
class Example {

    companion object : OnPeakListener {

        @JvmStatic
        fun main(args: Array<String>) {

            // Create PeakSeeker object
            val peakSeeker = PeakSeeker("tcp://mybroker.com", "PeakSeekerClientName")
            
            // Perform connection
            peakSeeker.connect("username", "password")
            
            // Subscribe to topic
            peakSeeker.subscribe("topicName")

        }

        //Set custom callback to see status change
        override fun onPeak(peak: Peak) {
            println("Detected ${peak.type} peak on ${peak.axis} axis with value: ${peak.value}")
        }
    }

}
```