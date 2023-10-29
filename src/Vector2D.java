public class Vector2D implements IVector{
    private double x;
    private double y;

    Vector2D(double x, double y){
        this.x = x;
        this.y = y;
    }
    @Override
    public double abs(){
        return Math.sqrt(x * x + y * y);
    }
    @Override
    public double cdot(Vector2D vector){
        return x * vector.x + y * vector.y;
    }
    @Override
    public double[] getComponents(){
        return new double[] {this.x, this.y};
    }
}
