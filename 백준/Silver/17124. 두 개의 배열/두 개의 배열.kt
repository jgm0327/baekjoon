import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()

    repeat(t) {
        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        val a = br.readLine().split(" ").map { it.toInt() }
        val b = br.readLine().split(" ").map { it.toInt() }.sorted()

        var closest = 0L

        repeat(n) {
            val binary = b.binarySearch(a[it])

            if (binary >= 0) {
                closest += b[binary]
            } else if (binary == -1) {
                closest += b[0]
            } else if (abs(binary)-1 == m) {
                closest += b.last()
            } else {
                val v1 = b[abs(binary) - 2]
                val v2 = b[abs(binary) - 1]

                closest += if (abs(v1 - a[it]) <= abs(v2 - a[it])) {
                    v1
                } else {
                    v2
                }
            }
        }

        println(closest)
    }
}