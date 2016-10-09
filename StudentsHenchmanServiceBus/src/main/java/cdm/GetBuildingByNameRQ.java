package cdm;

/**
 * @Author Mateusz Wieczorek on 10/8/16.
 */
public class GetBuildingByNameRQ {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GetBuildingByNameRQ{" +
                "name='" + name + '\'' +
                '}';
    }
}
