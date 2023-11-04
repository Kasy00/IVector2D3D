public class TwoDPolarInheritance extends Vector2D{
    public TwoDPolarInheritance(double x, double y){
        super(x, y);
    }

    public double getAngle(){
        double[] components = super.getComponents();
        double angle = Math.atan2(components[1], components[0]);
        return Math.toDegrees(angle);
    }
}
