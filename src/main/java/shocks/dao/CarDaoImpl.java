package shocks.dao;

import antlr.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import shocks.model.Car;
import shocks.model.FilterKeeper;
import shocks.model.Fitment;
import shocks.model.ShockAbsorber;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CarDaoImpl implements CarDao {

    private SessionFactory sessionFactory;
    private static final Logger logger = LogManager.getLogger(CarDaoImpl.class.getName());


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Car> getCars(FilterKeeper keeper) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Car> query=builder.createQuery(Car.class);
        Root<Car> root = query.from(Car.class);
        String year = keeper.getYear();
        query.where(builder.and(builder.equal(root.get("carModel"),keeper.getCarModel()),
                                builder.equal(root.get("make"),keeper.getCarMake()),
                                builder.lessThanOrEqualTo(root.get("yearStart"), year),
                                builder.greaterThanOrEqualTo(root.get("yearFinish"),year),
                                builder.equal(root.get("drive"),keeper.getCarDrive())));
        Query q = session.createQuery(query);

        List<Car> cars = q.getResultList();
        System.out.println(cars.size());
        for (Car car: cars){
            logger.info(car);
            for (Fitment fitment:car.getFitments()){
                System.out.println(fitment.getAbsorber());
            }
        }
        return cars;
    }
}
