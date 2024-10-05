fun main() {
    println("Введите количество точек (больше 2):")
    val n = readLine()!!.toInt()

    if (n <= 2) {
        println("Количество точек должно быть больше 2.")
        return
    }

    val points = mutableListOf<Point>()

    for (i in 1..n) {
        println("Введите координаты точки $i (x y):")
        val (x, y) = readLine()!!.split(" ").map { it.toDouble() }
        points.add(Point(x, y))
    }

    var minDistance = Double.MAX_VALUE
    var maxDistance = Double.MIN_VALUE

    for (i in points.indices) {
        for (j in i + 1 until points.size) {
            val distance = points[i].distanceTo(points[j])
            minDistance = Math.min(minDistance, distance)
            maxDistance = Math.max(maxDistance, distance)
        }
    }

    println("Минимальное расстояние: $minDistance")
    println("Максимальное расстояние: $maxDistance")
}
