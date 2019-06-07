import Circle.entity.Point;
import Circle.entity.Circle;

public class Main {
    public static void main(String[] args){
        Point centerForFirstCircle = new Point(0,0);
        Circle firstCircle = new Circle(centerForFirstCircle, 12);

        Point centerForSecondCircle = new Point(3,5);
        Circle secondCircle = new Circle(centerForSecondCircle, 11);

        if (firstCircle.compareArea(secondCircle)) {
            System.out.println("circle is equal by area");
        } else {
            System.out.println("circle is not equal by area");
        }

    }
}
