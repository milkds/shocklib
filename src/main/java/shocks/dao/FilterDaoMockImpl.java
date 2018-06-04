package shocks.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FilterDaoMockImpl implements FilterDao {

    private SessionFactory sessionFactory;
    @Override
    public List<String> getCarModels(String year, String carMake) {
        List<String> carModels = new ArrayList<>();
        carModels.add("Model 1");
        carModels.add("Model 2");
        carModels.add("Model 3");
        return carModels;
    }

    @Override
    public List<String> getDrives(String year, String make, String model) {
        if (year.equals("2018")){
            return new ArrayList<>();
        }
        else {
            List<String> carDrives = new ArrayList<>();
            carDrives.add("FWD");
            carDrives.add("RWD");
            carDrives.add("AWD");
            return carDrives;
        }
    }

    @Override
    public List<String> getYears() {
        List<String> years = new ArrayList<>();
        years.add("2018");
        years.add("2017");
        years.add("2016");
        return years;
    }

    @Override
    public List<String> getCarMakes(String year) {
        List<String> makes = new ArrayList<>();
        makes.add("BMW");
        makes.add("Mercedes Benz");
        makes.add("Toyota");
        return makes;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
