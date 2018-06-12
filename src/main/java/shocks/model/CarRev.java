package shocks.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "cars_main")
public class CarRev {
    @Id
    @Column(name = "CAR_ID")
    private int carID;

    @Column(name = "YEAR_START")
    private String yearStart;

    @Column(name = "YEAR_FINISH")
    private String yearFinish;

    @Column(name = "CAR_MAKE")
    private String make;

    @Column(name = "CAR_MODEL")
    private String carModel;

    @Column(name = "CAR_SUBMODEL")
    private String carSubModel;

    @Column(name = "CAR_DRIVE")
    private String drive;

    @OneToMany(mappedBy = "car")
    private List<FitmentRev> fitments;

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public String getYearStart() {
        return yearStart;
    }

    public void setYearStart(String yearStart) {
        this.yearStart = yearStart;
    }

    public String getYearFinish() {
        return yearFinish;
    }

    public void setYearFinish(String yearFinish) {
        this.yearFinish = yearFinish;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getDrive() {
        return drive;
    }

    public void setDrive(String drive) {
        this.drive = drive;
    }

    public List<FitmentRev> getFitments() {
        return fitments;
    }

    public void setFitments(List<FitmentRev> fitments) {
        this.fitments = fitments;
    }


    @Override
    public String toString() {
        return "Car{" +
                "carID=" + carID +
                ", yearStart='" + yearStart + '\'' +
                ", yearFinish='" + yearFinish + '\'' +
                ", make='" + make + '\'' +
                ", carModel='" + carModel + '\'' +
                ", drive='" + drive + '\'' +
                '}';
    }

    public String getCarSubModel() {
        return carSubModel;
    }

    public void setCarSubModel(String carSubModel) {
        this.carSubModel = carSubModel;
    }
}
