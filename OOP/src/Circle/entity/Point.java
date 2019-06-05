package Circle.entity;

public class Point {
    private double x;
    private double y;

    public void setX(double x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object o){
        if(o == this)
            return true;
        if(o == null || o.getClass() != getClass())
            return false;
        Point point = (Point) o;
        return point.x == x && point.y == y;
    }

    public int hashCode(){
        int hash = 31;
        hash += Double.hashCode(x);
        hash += Double.hashCode(y);
        return hash;
    }

    public String toString(){
        return getClass().getSimpleName() +
                " x = " + x +
                " y = " + y;
    }
}
