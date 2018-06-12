package shocks.model;

import javax.persistence.*;

@Entity
@Table(name = "fitment")
public class FitmentRev {
    @Id
    @Column(name = "LINK_ID")
    private int linkID;

    @Column(name = "PART_NUMBER", insertable=false, updatable=false)
    private String partNo;

    @Column(name = "LIFT_START")
    private String liftStart;

    @Column(name = "LIFT_FINISH")
    private String liftFinish;

    @Column(name = "SHOCK_POSITION")
    private String shockPosition;

    @Column(name = "FITMENT_NOTES")
    private String fitmentNotes;

    @Column(name = "EXTRA_NOTES")
    private String extraNotes;

    @ManyToOne
    @JoinColumn(name = "SHOCK_ID")
    private ShockAbsorberRev absorber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CAR_ID")
    private CarRev car;

    public int getLinkID() {
        return linkID;
    }

    public void setLinkID(int linkID) {
        this.linkID = linkID;
    }

    public String getPartNo() {
        return partNo;
    }

    public void setPartNo(String partNo) {
        this.partNo = partNo;
    }

    public String getLiftStart() {
        return liftStart;
    }

    public void setLiftStart(String liftStart) {
        this.liftStart = liftStart;
    }

    public String getLiftFinish() {
        return liftFinish;
    }

    public void setLiftFinish(String liftFinish) {
        this.liftFinish = liftFinish;
    }

    public String getShockPosition() {
        return shockPosition;
    }

    public void setShockPosition(String shockPosition) {
        this.shockPosition = shockPosition;
    }

    public ShockAbsorberRev getAbsorber() {
        return absorber;
    }

    public void setAbsorber(ShockAbsorberRev absorber) {
        this.absorber = absorber;
    }

    public CarRev getCar() {
        return car;
    }

    public void setCar(CarRev car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Fitment{" +
                "linkID=" + linkID +
                ", partNo='" + partNo + '\'' +
                ", liftStart='" + liftStart + '\'' +
                ", liftFinish='" + liftFinish + '\'' +
                ", shockPosition='" + shockPosition + '\'' +
                '}';
    }

    public String getFitmentNotes() {
        return fitmentNotes;
    }

    public void setFitmentNotes(String fitmentNotes) {
        this.fitmentNotes = fitmentNotes;
    }

    public String getExtraNotes() {
        return extraNotes;
    }

    public void setExtraNotes(String extraNotes) {
        this.extraNotes = extraNotes;
    }
}
