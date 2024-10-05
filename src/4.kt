fun main() {
    val triangle = Triangle(Point(0.0, 0.0), Point(4.0, 0.0), Point(2.0, 3.0))

    val (center, radius) = triangle.circumcircle()

    println("Центр описанной окружности: (${center.x}, ${center.y})")
    println("Радиус описанной окружности: $radius")
}
