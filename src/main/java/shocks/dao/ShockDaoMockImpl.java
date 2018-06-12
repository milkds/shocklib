package shocks.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import shocks.model.ShockAbsorber;
import shocks.model.ShockAbsorberRev;
import shocks.model.ShockFilter;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ShockDaoMockImpl implements ShockDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<ShockAbsorber> getShocks(ShockFilter shockFilter) {
        List<ShockAbsorber> absorbers = new ArrayList<>();
        ShockAbsorber absorber = new ShockAbsorber();
        absorber.setShockMake("SkyJacker");
        absorber.setPartNo("SuperPuperPartNumber");
        absorber.setShockSeries("7800");
        absorber.setImgLink("https://productdesk.cart.bilsteinus.com//media/products/bilstein/24-238281_1.jpg");
        absorber.setColLength("10");
        absorber.setExtLength("20");
        absorber.setUpMount("upM");
        absorber.setLowMount("lowM");

        absorbers.add(absorber);
        return absorbers;
    }

    @Override
    public ShockAbsorberRev getShock(String partNo) {
        return null;
    }
}
