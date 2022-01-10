
public class AutoBase {
    public static final String BASE = "BASE";
    public static final String ROUTE = "ROUTE";
    public static final String REPAIR = "REPAIR";
    private int id;
    private String name;
    private String driver;
    private String state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "AutoPark{" +
                "id=" + id +
                ", name='" + name +
                ", driver " + driver +
                ", state='" + state;
    }
}


