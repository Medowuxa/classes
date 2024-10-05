fun main() {
    try {
        // Ввод координат треугольника
        println("Введите координаты вершин треугольника (x1 y1, x2 y2, x3 y3):")
        val triangleCoords = readLine()!!.split(",").map { it.trim().split(" ") }
        val a = Point(triangleCoords[0][0].toDouble(), triangleCoords[0][1].toDouble())
        val b = Point(triangleCoords[1][0].toDouble(), triangleCoords[1][1].toDouble())
        val c = Point(triangleCoords[2][0].toDouble(), triangleCoords[2][1].toDouble())

        val triangle = Triangle(a, b, c)

        // Ввод координат точки
        println("Введите координаты точки (x y):")
        val pointCoords = readLine()!!.split(" ")
        val point = Point(pointCoords[0].toDouble(), pointCoords[1].toDouble())

        // Проверка, находится ли точка внутри треугольника
        if (triangle.contains(point)) {
            println("Точка находится внутри треугольника.")
        } else {
            println("Точка находится вне треугольника.")
        }
    } catch (e: Exception) {
        println("Ошибка ввода: ${e.message}. Пожалуйста, введите корректные координаты.")
    }
}
