package shocks.model;

import java.util.List;

public class ShockFilter {

    private String shockMake;
    private String coLength;
    private String extLength;
    private String upMount;
    private String lowMount;

    private List<String> shockMakes;
    private List<String> coLengths;
    private List<String> extLengths;
    private List<String> upMounts;
    private List<String> lowMounts;

    private boolean readyForFilter;

    public String getShockMake() {
        return shockMake;
    }

    public void setShockMake(String shockMake) {
        this.shockMake = shockMake;
    }

    public String getCoLength() {
        return coLength;
    }

    public void setCoLength(String coLength) {
        this.coLength = coLength;
    }

    public String getExtLength() {
        return extLength;
    }

    public void setExtLength(String extLength) {
        this.extLength = extLength;
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

    public List<String> getShockMakes() {
        return shockMakes;
    }

    public void setShockMakes(List<String> shockMakes) {
        this.shockMakes = shockMakes;
    }

    public List<String> getCoLengths() {
        return coLengths;
    }

    public void setCoLengths(List<String> coLengths) {
        this.coLengths = coLengths;
    }

    public List<String> getExtLengths() {
        return extLengths;
    }

    public void setExtLengths(List<String> extLengths) {
        this.extLengths = extLengths;
    }

    public List<String> getUpMounts() {
        return upMounts;
    }

    public void setUpMounts(List<String> upMounts) {
        this.upMounts = upMounts;
    }

    public List<String> getLowMounts() {
        return lowMounts;
    }

    public void setLowMounts(List<String> lowMounts) {
        this.lowMounts = lowMounts;
    }

    public boolean isReadyForFilter() {
        return readyForFilter;
    }

    public void setReadyForFilter(boolean readyFoFilter) {
        this.readyForFilter = readyFoFilter;
    }

    @Override
    public String toString() {
        return "ShockFilter{" +
                "shockMake='" + shockMake + '\'' +
                ", coLength='" + coLength + '\'' +
                ", extLength='" + extLength + '\'' +
                ", upMount='" + upMount + '\'' +
                ", lowMount='" + lowMount + '\'' +
                ", readyForFilter=" + readyForFilter +
                '}';
    }
}
