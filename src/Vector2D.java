public class Vector2D implements IVector{
    private double x;
    private double y;

    public Vector2D(double x, double y){
        this.x = x;
        this.y = y;
    }
    @Override
    public double abs(){
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }
    @Override
    public double cdot(IVector other){
        double[] otherComponents = other.getComponents();
        return this.x * otherComponents[0] + this.y * otherComponents[1];
    }
    @Override
    public double[] getComponents(){
        return new double[] {this.x, this.y};
    }
}
