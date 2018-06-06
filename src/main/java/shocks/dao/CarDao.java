package shocks.dao;

import shocks.model.Car;
import shocks.model.FilterKeeper;

import java.util.List;

public interface CarDao {
    List<Car> getCars(FilterKeeper keeper);
}
