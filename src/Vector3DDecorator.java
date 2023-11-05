public class Vector3DDecorator implements IVector{
    private IVector srcVector;
    private double z;

    public Vector3DDecorator(IVector vector2D) {
        this.srcVector = vector2D;
    }

    @Override
    public double abs() {
        double[] components = this.getComponents();
        return Math.sqrt(components[0] * components[0] + components[1] * components[1] + components[2] * components[2]);
    }

    @Override
    public double cdot(IVector other) {
        double[] otherComponents = other.getComponents();
        double[] thisComponents = this.getComponents();

        if (thisComponents.length < 3 || otherComponents.length < 3) {
            if (thisComponents.length < 3 && otherComponents.length < 3) {
                return thisComponents[0] * otherComponents[0] + thisComponents[1] * otherComponents[1];
            } else {
                if (thisComponents.length < 3) {
                    return thisComponents[0] * otherComponents[0] + thisComponents[1] * otherComponents[1] + thisComponents[2] * 0;
                } else {
                    return thisComponents[0] * otherComponents[0] + thisComponents[1] * otherComponents[1] + 0 * otherComponents[2];
                }
            }
        } else {
            return thisComponents[0] * otherComponents[0] + thisComponents[1] * otherComponents[1] + thisComponents[2] * otherComponents[2];
        }
    }

    @Override
    public double[] getComponents() {
        double[] srcComponents = srcVector.getComponents();
        if (srcComponents.length < 2) {
            return new double[]{srcComponents[0], srcComponents[1], 0};
        }
        return new double[]{srcComponents[0], srcComponents[1], srcComponents.length > 2 ? srcComponents[2] : 0};
    }

    public IVector getSrcV() {
        return srcVector;
    }

    public Vector3DInheritance cross(Vector3DDecorator other) {
        double[] thisComponents = this.getComponents();
        double[] otherComponents = other.getComponents();

        double resultX = thisComponents[1] * otherComponents[2] - thisComponents[2] * otherComponents[1];
        double resultY = thisComponents[2] * otherComponents[0] - thisComponents[0] * otherComponents[2];
        double resultZ = thisComponents[0] * otherComponents[1] - thisComponents[1] * otherComponents[0];

        return new Vector3DInheritance(resultX, resultY, resultZ);
    }
}
