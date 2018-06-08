package shocks.model;



import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name = "fitment")
public class Fitment {

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SHOCK_ID")
    private ShockAbsorber absorber;

    @ManyToOne
    @JoinColumn(name = "CAR_ID")
    private Car car;

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

    public ShockAbsorber getAbsorber() {
        return absorber;
    }

    public void setAbsorber(ShockAbsorber absorber) {
        this.absorber = absorber;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
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

}
