public class Polar2DAdapter implements IPolar2D, IVector{
    private Vector2D srcVector;

    public Polar2DAdapter(Vector2D vector){
        this.srcVector = vector;
    }

    @Override
    public double abs(){
        return this.srcVector.abs();
    }

    @Override
    public double getAngle(){
        double[] components = this.srcVector.getComponents();
        double angle = Math.atan2(components[1], components[0]);
        return Math.toDegrees(angle);
    }

    @Override
    public double cdot(IVector other){
        return srcVector.cdot(other);
    }

    @Override
    public double[] getComponents(){
        return this.srcVector.getComponents();
    }
}
