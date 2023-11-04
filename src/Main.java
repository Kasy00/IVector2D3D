import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Vector2D vector2d = new Vector2D(2, 3);
        TwoDPolarInheritance vector2 = new TwoDPolarInheritance(4,3);

        Vector3DInheritance vector3DInheritance = new Vector3DInheritance(1, 2, 4);
        Vector3DInheritance vector3DInheritance2 = new Vector3DInheritance(1, 2, 5);
        Vector3DDecorator vector3DDecorator = new Vector3DDecorator(vector2d, 3);

        displayCoordinates(vector3DInheritance);
        calculateCDotAndCrossProducts(vector3DInheritance, vector2);

    }

    public static void displayCoordinates(IVector vector){
        System.out.println("Współrzędne wektora w układzie kartezjańskim: " + Arrays.toString(vector.getComponents()));

        if(vector instanceof Vector2D){
            Polar2DAdapter polar2DAdapter = new Polar2DAdapter((Vector2D) vector);
            System.out.println("Współrzędne wektora w układzie biegunowym: " + "[" + vector.abs() + "," + " " + polar2DAdapter.getAngle() + "]");
        }
    }

    public static void calculateCDotAndCrossProducts(IVector vector1, IVector vector2) {
        double cDot = vector1.cdot(vector2);

        if (vector1.getComponents().length == 3 && vector2.getComponents().length == 3) {
            Vector3DInheritance crossProduct = ((Vector3DInheritance) vector1).cross(vector2);
            System.out.println("Iloczyn skalarny: " + cDot);
            System.out.println("Iloczyn wektorowy (współrzędne kartezjańskie): " + Arrays.toString(crossProduct.getComponents()));
        }
        else{
            System.out.println("Iloczyn skalarny: " + cDot);
        }
    }
}