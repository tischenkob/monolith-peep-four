package lab4.demo.mbeans;

import lab4.demo.entity.Point;

public interface PointsCounterMBean {

    int getAllPoints();

    int getMissPoints();

    Point getPoint();
}
