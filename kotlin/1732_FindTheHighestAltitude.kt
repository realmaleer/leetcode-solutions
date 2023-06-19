class Solution {
    fun largestAltitude(gain: IntArray): Int {
        var currentAltitude = 0
        var highestAltitude = 0
        for (currentGain in gain) {
            currentAltitude += currentGain
            if (currentAltitude > highestAltitude) {
                highestAltitude = currentAltitude
            }
        }
        return highestAltitude
    }
}
