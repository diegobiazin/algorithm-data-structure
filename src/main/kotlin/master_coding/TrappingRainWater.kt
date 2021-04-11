import kotlin.math.absoluteValue

fun main() {
    trappingRainWater(arrayOf(0, 1, 0, 2, 1, 0, 3, 1, 0, 1, 2))
    trappingRainWaterOptimize(arrayOf(0, 1, 0, 2, 1, 0, 3, 1, 0, 1, 2))
//    filledOrders(arrayOf(190311938,300117133,402652164, 2, 3),879654491)
//    decryptPassword("pTo*Ta*O")
}


fun trappingRainWater(heights: Array<Int>) {
    var totalWater = 0;

    for(p in heights.indices) {
        var leftP = p
        var rightP = p
        var maxLeft = 0
        var maxRight = 0

        while(leftP >= 0) {
            maxLeft = Math.max(maxLeft, heights[leftP]);
            leftP--;
        }

        while(rightP < heights.size) {
            maxRight = Math.max(maxRight, heights[rightP]);
            rightP++;
        }

        val currentWater = Math.min(maxLeft, maxRight) - heights[p];

        if(currentWater >= 0) {
            totalWater += currentWater;
        }
    }

    println(totalWater)
}

fun trappingRainWaterOptimize(heights: Array<Int>) {
    var totalWater = 0

    var left = 0
    var right = heights.size - 1
    var maxLeft = 0
    var maxRight = 0

    while(left < right) {
        if(heights[left] <= heights[right]) {
            if(heights[left] >= maxLeft) {
                maxLeft = heights[left]
            } else {
                totalWater += maxLeft - heights[left]
            }
            left++
        } else {
            if(heights[right] >= maxRight) {
                maxRight = heights[right]
            } else {
                totalWater += maxRight - heights[right]
            }

            right--
        }
    }

    println(totalWater)
}

fun filledOrders(order: Array<Int>, k: Int): Int {
    var att = 0
    var rest = k
    for (i in order.sorted()) {
        if (rest - i < 0)
            continue

        rest -= i
        if (rest >= 0)
            att++
        else
            break
    }

    print(att)
    return att
}

fun decryptPassword(s: String): String {
    var final = ""
    var i = 0
    while (s.toCharArray().size > i) {
        if (s[i].isLowerCase() && s[i+1].isUpperCase()) {
            final += s[i + 1].toString() + s[i].toString()
            i += 2
        } else {
            i++
        }

    }

    print(final)
    return final
}