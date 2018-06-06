package shocks.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import shocks.model.Car;
import shocks.model.FilterKeeper;
import shocks.model.Fitment;
import shocks.model.ShockAbsorber;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoMockImpl implements CarDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Car> getCars(FilterKeeper keeper) {
        List<Car> cars = new ArrayList<>();
        List<Fitment> fitments = new ArrayList<>();

        Car car = new Car();
        Fitment fitment = new Fitment();
        ShockAbsorber absorber = new ShockAbsorber();

        car.setYearStart("2005");
        car.setYearFinish("2010");
        car.setMake("Ford");
        car.setCarModel("F-150");
        car.setDrive("4WD");

        fitment.setPartNo("1488 ZIG");
        fitment.setLiftStart("0");
        fitment.setLiftFinish("2");
        fitment.setShockPosition("Forward");

        absorber.setShockMake("Bilstein");
        absorber.setShockSeries("B8 5100");
        absorber.setColLength("14,06");
        absorber.setExtLength("18,43");
        absorber.setUpMount("S1");
        absorber.setLowMount("ES25");
        absorber.setImgLink("https://productdesk.cart.bilsteinus.com//media/products/bilstein/24-238304_1.jpg");

        fitment.setAbsorber(absorber);
        fitments.add(fitment);
        car.setFitments(fitments);
        cars.add(car);

        return cars;
    }
}
