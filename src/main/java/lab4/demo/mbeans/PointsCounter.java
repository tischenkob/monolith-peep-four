package lab4.demo.mbeans;

import lab4.demo.entity.Point;
import org.springframework.stereotype.Component;

import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

@Component
public class PointsCounter extends NotificationBroadcasterSupport implements PointsCounterMBean {

    private int allPointsCounter=0;
    private int missPointsCounter=0;
    private Point point=new Point();

    @Override
    public int getAllPoints(){
        return allPointsCounter;
    }

    public void addNewPoint(Point point){
        this.point=point;
        allPointsCounter++;
        if (!point.getHit())missPointsCounter++;
        if (Math.abs(point.getX())>6.2 || Math.abs(point.getY())>6.2) sendNotification(new Notification("Point_is_outside",this,missPointsCounter, System.currentTimeMillis(), "Point with coordinates ("+point.getX()+";"+point.getY()+") is outside of canvas"));
    }

    @Override
    public int getMissPoints(){return missPointsCounter;}

    @Override
    public Point getPoint(){return point;}
}
