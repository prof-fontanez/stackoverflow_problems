package linkedin;

public class RightTriangle implements GeometricShape
{
    double h = 2;
    double w = 3;
    @Override
    public double calculateArea()
    {
        return h*w/2;
    }

}
