package shocks.model;



import javax.persistence.*;

@Entity
@Table(name = "fitment")
public class Fitment {

    @Id
    @Column(name = "LINK_ID")
    private int linkID;

    @Column(name = "LINK_ID")
    private int carID;

    @Column(name = "PART_NUMBER")
    private String partNo;

    @Column(name = "LIFT_START")
    private String liftStart;

    @Column(name = "LIFT_FINISH")
    private String liftFinish;

    @Column(name = "SHOCK_POSITION")
    private String shockPosition;

    @OneToOne(fetch = FetchType.EAGER)
    private ShockAbsorber absorber;


    public int getLinkID() {
        return linkID;
    }

    public void setLinkID(int linkID) {
        this.linkID = linkID;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
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
}
