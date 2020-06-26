package lab4.demo.mbeans;

import lab4.demo.entity.Point;

public interface BullsEyeMBean {
    int getAllMissesCount();

    int getAllPointsCount();

    int getConsecutiveMissesCount();

    void incrementConsecutiveMissesCount();

    int processPoint(Point point);
}
