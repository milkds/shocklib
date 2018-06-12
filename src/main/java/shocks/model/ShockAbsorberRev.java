package shocks.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shocks")
public class ShockAbsorberRev {

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

    @Column(name = "PART_NUMBER")
    private String partNo;

    @Column (name = "BODY_THICKNESS")
    private String bodyThickness;

    @Column (name = "SHOCK_NOTES")
    private String shockNotes;

    @Column (name = "SHOCK_NOTES2")
    private String shockNotes2;

    @OneToMany(mappedBy = "absorber", fetch = FetchType.EAGER)
    private List<FitmentRev> fitments;

    @Transient
    private List<String> imgLinks;

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

    public List<FitmentRev> getFitments() {
        return fitments;
    }

    public void setFitments(List<FitmentRev> fitments) {
        this.fitments = fitments;
    }

    @Override
    public String toString() {
        return "ShockAbsorber{" +
                "shockID=" + shockID +
                ", shockMake='" + shockMake + '\'' +
                ", shockSeries='" + shockSeries + '\'' +
                ", extLength='" + extLength + '\'' +
                ", colLength='" + colLength + '\'' +
                ", upMount='" + upMount + '\'' +
                ", lowMount='" + lowMount + '\'' +
                ", imgLink='" + imgLink + '\'' +
                '}';
    }

    public String getPartNo() {
        return partNo;
    }

    public void setPartNo(String partNo) {
        this.partNo = partNo;
    }

    public List<String> getImgLinks() {
        return imgLinks;
    }

    public void setImgLinks(List<String> imgLinks) {
        this.imgLinks = imgLinks;
    }

    public String getBodyThickness() {
        return bodyThickness;
    }

    public void setBodyThickness(String bodyThickness) {
        this.bodyThickness = bodyThickness;
    }

    public String getShockNotes() {
        return shockNotes;
    }

    public void setShockNotes(String shockNotes) {
        this.shockNotes = shockNotes;
    }

    public String getShockNotes2() {
        return shockNotes2;
    }

    public void setShockNotes2(String shockNotes2) {
        this.shockNotes2 = shockNotes2;
    }
}
