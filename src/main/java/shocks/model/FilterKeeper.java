package shocks.model;

import java.util.List;

public class FilterKeeper {
    private String year;
    private String carMake;
    private String carModel;
    private String carDrive;
    private List<String> years;
    private List<String> carMakes;
    private List<String> carModels;
    private List<String> carDrives;

    private boolean hasDriveInfo;

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public List<String> getCarMakes() {
        return carMakes;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public void setCarMakes(List<String> carMakes) {
        this.carMakes = carMakes;
    }

    public List<String> getCarModels() {
        return carModels;
    }

    public void setCarModels(List<String> carModels) {
        this.carModels = carModels;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<String> getYears() {
        return years;
    }

    public void setYears(List<String> years) {
        this.years = years;
    }

    public String getCarDrive() {
        return carDrive;
    }

    public void setCarDrive(String carDrive) {
        this.carDrive = carDrive;
    }

    public List<String> getCarDrives() {
        return carDrives;
    }

    public void setCarDrives(List<String> carDrives) {
        this.carDrives = carDrives;
    }

    public boolean isHasDriveInfo() {
        return hasDriveInfo;
    }

    public void setHasDriveInfo(boolean hasDriveInfo) {
        this.hasDriveInfo = hasDriveInfo;
    }
}
