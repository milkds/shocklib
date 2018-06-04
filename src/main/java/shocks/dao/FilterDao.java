package shocks.dao;

import java.util.List;

public interface FilterDao {

    List<String> getYears();

    List<String> getCarMakes(String year);

    List<String> getCarModels(String year, String carMake);

    List<String> getDrives(String year, String make, String model);
}
