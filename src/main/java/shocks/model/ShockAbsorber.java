package shocks.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shocks")
public class ShockAbsorber {

    @Id
    @Column(name = "SHOCK_ID")
    private int shockID;

    @Column(name = "SHOCK_MAKE")
    private String shockMake;

    @Column(name = "SHOCK_SERIES")
    private String shockSeries;

    @Column(name = "EXTENDED_LENGTH")
    private String extLength;

    @Column(name = "COLLAPSED_LENGTH")
    private String colLength;

    @Column(name = "UPPER_MOUNTING")
    private String upMount;

    @Column(name = "LOWER_MOUNTING")
    private String lowMount;

    @Column(name = "IMG_LINKS")
    private String imgLink;

    public int getShockID() {
        return shockID;
    }

    public void setShockID(int shockID) {
        this.shockID = shockID;
    }

    public String getShockMake() {
        return shockMake;
    }

    public void setShockMake(String shockMake) {
        this.shockMake = shockMake;
    }

    public String getShockSeries() {
        return shockSeries;
    }

    public void setShockSeries(String shockSeries) {
        this.shockSeries = shockSeries;
    }

    public String getExtLength() {
        return extLength;
    }

    public void setExtLength(String extLength) {
        this.extLength = extLength;
    }

    public String getColLength() {
        return colLength;
    }

    public void setColLength(String colLength) {
        this.colLength = colLength;
    }

    public String getUpMount() {
        return upMount;
    }

    public void setUpMount(String upMount) {
        this.upMount = upMount;
    }

    public String getLowMount() {
        return lowMount;
    }

    public void setLowMount(String lowMount) {
        this.lowMount = lowMount;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }
}
