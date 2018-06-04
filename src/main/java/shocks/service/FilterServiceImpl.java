package shocks.service;

import org.springframework.stereotype.Service;
import shocks.dao.FilterDao;
import shocks.model.FilterKeeper;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FilterServiceImpl implements FilterService {

    private FilterDao filterDao;

    @Transactional
    public FilterKeeper getCarModels(FilterKeeper keeper) {
        String year = keeper.getYear();
        String make = keeper.getCarMake();

        //populating filters
        List<String> years = this.filterDao.getYears();
        List<String> carMakes = this.filterDao.getCarMakes(year);
        List<String> carModels = this.filterDao.getCarModels(year, make);
        keeper.setYears(years);
        keeper.setCarMakes(carMakes);
        keeper.setCarModels(carModels);

        //setting previous values to null
        keeper.setCarModel(null);
        keeper.setCarDrive(null);

        return keeper;
    }

    @Transactional
    public FilterKeeper getYears(FilterKeeper keeper) {
        List<String> years = this.filterDao.getYears();
        keeper.setYears(years);

        return keeper;
    }

    @Transactional
    public FilterKeeper getCarMakes(FilterKeeper keeper) {
        String year = keeper.getYear();

        //populating filters
        List<String> years = this.filterDao.getYears();
        List<String> carMakes = this.filterDao.getCarMakes(year);
        keeper.setYears(years);
        keeper.setCarMakes(carMakes);

        //setting previous values to null
        keeper.setCarMake(null);
        keeper.setCarModel(null);
        keeper.setCarDrive(null);

        return keeper;
    }

    @Transactional
    public FilterKeeper getDrives(FilterKeeper keeper) {
        String year = keeper.getYear();
        String make = keeper.getCarMake();
        String model = keeper.getCarModel();
        List<String> drives = this.filterDao.getDrives(year,make,model);

        //if no drives in system specified for chosen YearMakeModel combo - info is enough to show search result
        if (drives.size()==0) {
            keeper.setHasDriveInfo(false);
        }
        else {
            keeper.setHasDriveInfo(true);
        }
        List<String> years = this.filterDao.getYears();
        List<String> carMakes = this.filterDao.getCarMakes(year);
        List<String> carModels = this.filterDao.getCarModels(year, make);
        keeper.setYears(years);
        keeper.setCarMakes(carMakes);
        keeper.setCarModels(carModels);
        keeper.setCarDrives(drives);

        return keeper;
    }

    public void setFilterDao(FilterDao filterDao) {
        this.filterDao = filterDao;
    }
}
