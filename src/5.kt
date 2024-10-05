fun main() {
    println("Введите координаты первой вершины треугольника (x1 y1):")
    val (x1, y1) = readLine()!!.split(" ").map { it.toDouble() }

    println("Введите координаты второй вершины треугольника (x2 y2):")
    val (x2, y2) = readLine()!!.split(" ").map { it.toDouble() }

    println("Введите координаты третьей вершины треугольника (x3 y3):")
    val (x3, y3) = readLine()!!.split(" ").map { it.toDouble() }

    // Создаем точки для вершин треугольника
    val pointA = Point(x1, y1)
    val pointB = Point(x2, y2)
    val pointC = Point(x3, y3)

    // Создаем треугольник
    val triangle = Triangle(pointA, pointB, pointC)

    // Вычисляем центр и радиус вписанной окружности
    val (incircleCenter, incircleRadius) = triangle.incircle()

    // Выводим результаты
    println("Центр вписанной окружности: (${incircleCenter.x}, ${incircleCenter.y})")
    println("Радиус вписанной окружности: $incircleRadius")
}
