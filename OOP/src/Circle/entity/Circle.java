package Circle.entity;


public class Circle {
    private Point center;
    private double radius;

    public void setCenter(Point center){
        this.center = center;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }

    public Point getCenter(){
        return center;
    }

    public double getRadius(){
        return radius;
    }

    public Circle(Point center, double radius){
        this.center = center;
        this.radius = checkRadius(radius);
    }

    private double checkRadius(double radius){
        if(radius >= 0){
            return radius;
        }
        throw new RuntimeException("Radius must be > 0");
    }

    public double calculateArea(){
        return Math.PI*radius*radius;
    }

    public double calculatePerimeter(){
        return 2*radius*Math.PI;
    }

    public boolean compareArea(Circle circle){
        return this.calculateArea() == circle.calculateArea();
    }

    public boolean equals(Object o){
        if(this == o)
            return true;
        if(o == null || o.getClass() != getClass())
            return false;
        Circle circle = (Circle) o;
        return circle.radius == radius && circle.center.equals(this.center);
    }

    public int hashCode(){
        int hash = 31;
        hash += Double.hashCode(radius);
        hash += center.hashCode();

        return hash;
    }

    public String toString(){
        return getClass().getSimpleName() +
                " center = " + center.toString() +
                " radius = " + radius;
    }
}
