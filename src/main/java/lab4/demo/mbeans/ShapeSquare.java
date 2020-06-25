package lab4.demo.mbeans;

import org.springframework.stereotype.Component;

@Component
public class ShapeSquare implements ShapeSquareMBean {

    private double r=0;

    public void setR(double r){
        this.r=r;
    }

    @Override
    public double getSquare(){
        return (Math.PI+3)*r*r/4.0;
    }

}
