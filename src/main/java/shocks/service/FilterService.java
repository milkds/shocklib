package shocks.service;

import org.springframework.stereotype.Service;
import shocks.model.FilterKeeper;


public interface FilterService {
    FilterKeeper getCarModels(FilterKeeper keeper);

    FilterKeeper getYears(FilterKeeper keeper);

    FilterKeeper getCarMakes(FilterKeeper keeper);

    FilterKeeper getDrives(FilterKeeper keeper);
}
