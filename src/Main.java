import java.util.Arrays;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Vector2D vector2D_1 = new Vector2D(3, 4);
        Vector2D vector2D_2 = new Vector2D(1, 2);
        Vector2D vector2D_3 = new Vector2D(5,7);

        displayCartesianCoordinates(vector2D_1);
        displayCartesianCoordinates(vector2D_2);
        displayCartesianCoordinates(vector2D_3);

        System.out.println("\n");

        displayPolarCoordinates(new Polar2DAdapter(vector2D_1));
        displayPolarCoordinates(new Polar2DAdapter(vector2D_2));
        displayPolarCoordinates(new Polar2DAdapter(vector2D_3));

        System.out.println("\n");

        Vector3DDecorator decoratedVector_1 = new Vector3DDecorator(vector2D_1);
        Vector3DDecorator decoratedVector_2 = new Vector3DDecorator(vector2D_2);
        Vector3DDecorator decoratedVector_3 = new Vector3DDecorator(vector2D_3);

        getScalarAndCrossProduct(decoratedVector_1, decoratedVector_2);
        System.out.println("\n");

        getScalarAndCrossProduct(decoratedVector_1, decoratedVector_3);
        System.out.println("\n");

        getScalarAndCrossProduct(decoratedVector_2, decoratedVector_3);
    }

    public static void displayCartesianCoordinates(IVector vector){
        System.out.println("Współrzędne kartezjańskie: " + Arrays.toString(vector.getComponents()));
    }

    public static void displayPolarCoordinates(IPolar2D vector){
        double abs = Math.round(vector.abs() * 100.0) / 100.0;
        double angle = Math.round(vector.getAngle() * 100.0) / 100.0;
        System.out.println("Współrzędne biegunowe: [" + abs + ", " + angle + "]");
    }

    public static void getScalarAndCrossProduct(Vector3DDecorator vector1, Vector3DDecorator vector2){
        double scalar = vector1.cdot(vector2);

        Vector3DInheritance cross = vector1.cross(vector2);
        System.out.println("Iloczyn skalarny: " + scalar);
        System.out.println("Iloczyn wektorowy: " + Arrays.toString(cross.getComponents()));
    }
}