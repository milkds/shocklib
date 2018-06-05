package shocks.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Repository
public class FilterDaoImpl implements FilterDao{
    private static final Logger logger = LogManager.getLogger(FilterDaoImpl.class.getName());
    private SessionFactory sessionFactory;
    @Override
    public List<String> getYears() {
        List<String> years = new LinkedList<>();
        for (int i = 2019; i >1899 ; i--) {
            years.add(i+"");
        }
        return years;
    }

    @Override
    public List<String> getCarMakes(String year) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createNativeQuery("SELECT distinct CAR_MAKE from shock_abs.cars_main where YEAR_START<="+year+" and YEAR_FINISH>="+year);
        List<String> makes = query.list();
        logger.info(Arrays.toString(makes.toArray()));
        return makes;
    }

    @Override
    public List<String> getCarModels(String year, String carMake) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createNativeQuery("SELECT distinct CAR_MODEL from shock_abs.cars_main where YEAR_START<="+year+" and YEAR_FINISH>="+year
                +" and CAR_MAKE='"+carMake+"'");
        List<String> models = query.list();
        logger.info(Arrays.toString(models.toArray()));
        return models;
    }

    @Override
    public List<String> getDrives(String year, String make, String model) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createNativeQuery("SELECT distinct CAR_DRIVE from shock_abs.cars_main where YEAR_START<="+year+" and YEAR_FINISH>="+year
                +" and CAR_MAKE='"+make+"' and CAR_MODEL='"+model+"'");
        List<String> drives = query.list();
        logger.info(Arrays.toString(drives.toArray()));

        return drives;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
