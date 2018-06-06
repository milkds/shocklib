package shocks.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cars_main")
public class Car {

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

    @Column(name = "CAR_DRIVE")
    private String drive;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Fitment> fitments;

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

    public List<Fitment> getFitments() {
        return fitments;
    }

    public void setFitments(List<Fitment> fitments) {
        this.fitments = fitments;
    }
}
