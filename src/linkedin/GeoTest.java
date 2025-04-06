package linkedin;

public class GeoTest
{
    public static void main(String[] args)
    {
        GeometricShape s1 = new Rectangle();
        GeometricShape s2 = new RightTriangle();
        testShape(s1);
        testShape(s2);
    }
    
    public static void testShape(GeometricShape s)
    {
        System.out.println("Area of shape: " + s.calculateArea());
    }
}
