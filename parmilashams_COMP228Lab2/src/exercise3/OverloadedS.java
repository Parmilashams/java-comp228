package exercise3;
public class OverloadedS {

    // Overloaded method to calculate area of a rectangle (length * width)
    public static double calculateArea(double length, double width) {
        System.out.printf("%n calculateArea with rectangle (length: %.2f, width: %.2f)%n", length, width);
        return length * width;
    }

    // Overloaded method to calculate area of a circle (π * radius^2)
    public static double calculateArea(double radius) {
        System.out.printf("%n calculateArea with circle (radius: %.2f)%n", radius);
        return Math.PI * radius * radius;
    }

    // Overloaded method to calculate area of a triangle (0.5 * base * height)
    public static double calculateArea(double base, double height, boolean isTriangle) {
        if (isTriangle) {
            System.out.printf("%n calculateArea with triangle (base: %.2f, height: %.2f)%n", base, height);
            return 0.5 * base * height;
        }
        return 0.0;
    }

    public static void main(String[] args) {
        // Call overloaded method for rectangle
        double rectangleArea = calculateArea(5.0, 3.0);
        System.out.printf("Area of rectangle: %.2f%n", rectangleArea);

        // Call overloaded method for circle
        double circleArea = calculateArea(4.0);
        System.out.printf("Area of circle: %.2f%n", circleArea);

        // Call overloaded method for triangle
        double triangleArea = calculateArea(6.0, 4.0, true);
        System.out.printf("Area of triangle: %.2f%n", triangleArea);
    }
}


