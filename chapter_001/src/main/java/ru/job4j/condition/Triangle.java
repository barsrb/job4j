package ru.job4j.condition;

public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }

    /**
     * Метод вычисления периметра по длинам сторон.
     *
     * Формула.
     *
     * (a + b + c) / 2
     *
     * @return Периметр.
     */
    public double period() {
        return ((first.distance(second) + second.distance(third) + third.distance(first)) / 2);
    }

    /**
     * Метод должен вычислить площадь треугольника.
     *
     * Формула.
     *
     * √ p *(p - ab) * (p - ac) * (p - bc)
     *
     * где √ - корень квадратный, для извлечения корня использовать метод Math.sqrt().
     *
     * @return Вернуть площадь, если треугольник существует или -1.
     */
    public double area() {
        double rsl = -1;
        double a = first.distance(second);
        double b = first.distance(third);
        double c = second.distance(third);
        double p = this.period();
        if (this.exist()) {
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        return rsl;
    }

    /**
     * Метод проверяет можно ли построить треугольник с такими длинами сторон.
     *
     * @return вернуть проверку существования треугольника с заданными координатами углов
     */
    public boolean exist() {
        return first.distance(second) + first.distance(third) > second.distance(third)
                && first.distance(second) + second.distance(third) > third.distance(first)
                && first.distance(third) + second.distance(third) > first.distance(second);
    }
}
