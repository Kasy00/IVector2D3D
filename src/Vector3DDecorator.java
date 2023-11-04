public class Vector3DDecorator implements IVector{
    private IVector srcVector;
    private double z = 0;

    public Vector3DDecorator(IVector vector, double z){
        this.srcVector = vector;
        this.z = z;
    }

    public IVector getSrcV(){
        return srcVector;
    }

    @Override
    public double[] getComponents(){
        double[] srcComponents = srcVector.getComponents();
        return new double[]{srcComponents[0], srcComponents[1], z};
    }

    @Override
    public double abs(){
        double[] components = this.getComponents();
        return Math.sqrt(components[0] * components[0] + components[1] * components[1] + this.z * this.z);
    }

    @Override
    public double cdot(IVector other){
        double[] otherComponents = other.getComponents();
        double[] thisComponents = this.getComponents();
        return thisComponents[0] * otherComponents[0] + thisComponents[1] * otherComponents[1] + thisComponents[2] * otherComponents[2];
    }

    public Vector3DInheritance cross(IVector other) {
        double[] thisComponents = this.getComponents();
        double[] otherComponents = other.getComponents();
        double resultX = thisComponents[1] * otherComponents[2] - thisComponents[2] * otherComponents[1];
        double resultY = thisComponents[2] * otherComponents[0] - thisComponents[0] * otherComponents[2];
        double resultZ = thisComponents[0] * otherComponents[1] - thisComponents[1] * otherComponents[0];
        return new Vector3DInheritance(resultX, resultY, resultZ);
    }
}
