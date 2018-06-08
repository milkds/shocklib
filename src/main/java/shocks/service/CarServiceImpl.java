package shocks.service;

import org.springframework.stereotype.Service;
import shocks.dao.CarDao;
import shocks.model.Car;
import shocks.model.FilterKeeper;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private CarDao carDao;

    public void setCarDao(CarDao carDao) {
        this.carDao = carDao;
    }

    @org.springframework.transaction.annotation.Transactional
    public List<Car> getCars(FilterKeeper keeper) {
        List<Car> cars = this.carDao.getCars(keeper);
        return cars;
    }
}
