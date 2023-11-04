public class Vector3DInheritance extends Vector2D{
  private double z;

  public Vector3DInheritance(double x, double y, double z){
      super(x, y);
      this.z = z;
  }

    @Override
    public double abs(){
      double[] components = super.getComponents();
      return Math.sqrt(components[0] * components[0] + components[1] * components[1] + this.z * this.z);
    }

    @Override
    public double cdot(IVector other){
        double[] otherComponents = other.getComponents();
        double[] thisComponents = this.getComponents();
        return thisComponents[0] * otherComponents[0] + thisComponents[1] * otherComponents[1] + this.z * otherComponents[2];
    }

    @Override
    public double[] getComponents(){
      double[] components = super.getComponents();
      return new double[]{components[0], components[1], this.z};
    }

    public Vector3DInheritance cross(IVector other){
      double[] otherComponents = other.getComponents();
      double[] thisComponents = this.getComponents();
        double resultX = thisComponents[1] * otherComponents[2] - this.z * otherComponents[1];
        double resultY = this.z * otherComponents[0] - thisComponents[0] * otherComponents[2];
        double resultZ = thisComponents[0] * otherComponents[1] - thisComponents[1] * otherComponents[0];
        return new Vector3DInheritance(resultX, resultY, resultZ);
    }

    public IVector getSrcV(){
      return new Vector3DInheritance(this.getComponents()[0], this.getComponents()[1], this.z);
    }
}
