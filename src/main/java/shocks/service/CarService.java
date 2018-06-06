package shocks.service;

import shocks.model.Car;
import shocks.model.FilterKeeper;

import java.util.List;

public interface CarService {

    List<Car> getCars(FilterKeeper keeper);
}
