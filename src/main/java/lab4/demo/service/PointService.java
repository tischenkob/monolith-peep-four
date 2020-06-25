package lab4.demo.service;

import lab4.demo.entity.Point;
import lab4.demo.mbeans.PointsCounter;
import lab4.demo.mbeans.ShapeSquare;
import org.springframework.stereotype.Service;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

@Service
public class PointService {
    private PointsCounter pointsCounter;
    private ShapeSquare shapeSquare;

    PointService(PointsCounter pointsCounter, ShapeSquare shapeSquare) {
        this.pointsCounter = pointsCounter;
        this.shapeSquare=shapeSquare;
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        try {
            server.registerMBean(pointsCounter, new ObjectName("lab4:type=PointsCounter"));
            server.registerMBean(shapeSquare, new ObjectName("lab4:type=ShapeSquare"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addNewPoint(Point point) {
        pointsCounter.addNewPoint(point);
        shapeSquare.setR(point.getR());
    }

}
