data class Point(val x: Double, val y: Double) {
    // Метод для вычисления расстояния между двумя точками
    fun distanceTo(other: Point): Double {
        return Math.sqrt(Math.pow(other.x - this.x, 2.0) + Math.pow(other.y - this.y, 2.0))
    }
}
