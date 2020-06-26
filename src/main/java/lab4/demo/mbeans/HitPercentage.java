package lab4.demo.mbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@ManagedResource(
        objectName="PD:category=MBeans,name=HitPercentageMBean",
        description="Managed Bean")
@Component("HitPercentageMbean")
public class HitPercentage implements HitPercentageMBean {
    private float percentage = 0.0f;

    @Autowired
    private BullsEye bullsEyeMBean;

    @Override
    public void updatePercentage() {
        float all = bullsEyeMBean.getAllPointsCount();
        float misses = bullsEyeMBean.getAllMissesCount();
        float hits = all - misses;
        this.percentage = hits / all;
    }

    @Override
    public float getPercentage() {
        return percentage;
    }
}
