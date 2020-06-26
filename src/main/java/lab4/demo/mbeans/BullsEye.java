package lab4.demo.mbeans;

import lab4.demo.entity.Point;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

@ManagedResource(
        objectName = "PD:category=MBeans,name=BullsEyeMBean",
        description = "Managed Bean")
@Component("BullsEyeMbean")
public class BullsEye extends NotificationBroadcasterSupport implements BullsEyeMBean {
    private int allMissesCount;
    private int allPointsCount;
    private int consecutiveMissesCount;
    private long sequenceNumber = 1;

    @Override
    public int processPoint(Point point) {
        allPointsCount++;
        if (!point.getHit()) {
            allMissesCount++;
            incrementConsecutiveMissesCount();
        } else {
            consecutiveMissesCount = 0;
        }
        return 0;
    }

    @Override
    public void incrementConsecutiveMissesCount() {
        consecutiveMissesCount++;
        if (consecutiveMissesCount % 3 == 0) {
            Notification notification = new Notification(
                    "consecutive_miss",
                    this,
                    sequenceNumber++,
                    System.currentTimeMillis(),
                    "There have been three consecutive misses!"
            );
            sendNotification(notification);
        }
    }

    @Override
    public int getAllMissesCount() {
        return allMissesCount;
    }

    @Override
    public int getAllPointsCount() {
        return allPointsCount;
    }

    @Override
    public int getConsecutiveMissesCount() {
        return consecutiveMissesCount;
    }
}
