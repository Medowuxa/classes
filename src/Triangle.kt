class Triangle(val a: Point, val b: Point, val c: Point) {
    // Функция для проверки, находится ли точка внутри треугольника
    fun contains(point: Point): Boolean {
        val area = area(a, b, c)
        val area1 = area(point, b, c)
        val area2 = area(a, point, c)
        val area3 = area(a, b, point)

        // Если сумма площадей трех меньших треугольников равна площади основного треугольника,
        // то точка находится внутри или на границе треугольника.
        return area == area1 + area2 + area3
    }

    // Функция для вычисления площади треугольника по его вершинам
    private fun area(p1: Point, p2: Point, p3: Point): Double {
        return Math.abs((p1.x * (p2.y - p3.y) + p2.x * (p3.y - p1.y) + p3.x * (p1.y - p2.y)) / 2.0)
    }

    // Метод для вычисления центра и радиуса описанной окружности
    fun circumcircle(): Pair<Point, Double> {
        val d = 2 * (a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y))
        val ux = ((a.x * a.x + a.y * a.y) * (b.y - c.y) +
                (b.x * b.x + b.y * b.y) * (c.y - a.y) +
                (c.x * c.x + c.y * c.y) * (a.y - b.y)) / d
        val uy = ((a.x * a.x + a.y * a.y) * (c.x - b.x) +
                (b.x * b.x + b.y * b.y) * (a.x - c.x) +
                (c.x * c.x + c.y * c.y) * (b.x - a.x)) / d
        val center = Point(ux, uy)
        val radius = center.distanceTo(a)

        return Pair(center, radius)
    }

    // Метод для вычисления длины стороны треугольника
    private fun sideLength(point1: Point, point2: Point): Double {
        return point1.distanceTo(point2)
    }

    // Метод для вычисления центра и радиуса вписанной окружности
    fun incircle(): Pair<Point, Double> {
        // Длина сторон треугольника
        val sideBC = sideLength(b, c) // Длина стороны BC
        val sideAC = sideLength(a, c) // Длина стороны AC
        val sideAB = sideLength(a, b) // Длина стороны AB

        // Полупериметр
        val p = (sideBC + sideAC + sideAB) / 2

        // Координаты центра вписанной окружности
        val ux = (sideBC * a.x + sideAC * b.x + sideAB * c.x) / (sideBC + sideAC + sideAB)
        val uy = (sideBC * a.y + sideAC * b.y + sideAB * c.y) / (sideBC + sideAC + sideAB)

        // Создаем точку для центра вписанной окружности
        val center = Point(ux, uy)

        // Радиус вписанной окружности
        val radius = Math.sqrt(((p - sideBC) * (p - sideAC) * (p - sideAB)) / p)

        return Pair(center, radius)
    }
}

