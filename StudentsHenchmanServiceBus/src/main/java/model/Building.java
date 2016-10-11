package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @Author Mateusz Wieczorek on 10/6/16.
 */
@Entity
@Table(name = "BUDYNKI")
public class Building implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nazwa_budynku")
    private String name;

    @Column(name = "szerokosc_geograficzna")
    private double latitude;

    @Column(name = "dlugosc_geograficzna")
    private double longitute;

    @Column(name = "kod")
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_wydzialu")
    private Department department;

    @JsonIgnore
    @OneToMany(mappedBy = "building", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Room> rooms;

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public long getId() {
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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitute() {
        return longitute;
    }

    public void setLongitute(double longitute) {
        this.longitute = longitute;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Building building = (Building) o;

        if (id != building.id) return false;
        if (Double.compare(building.latitude, latitude) != 0) return false;
        if (Double.compare(building.longitute, longitute) != 0) return false;
        if (!name.equals(building.name)) return false;
        if (!code.equals(building.code)) return false;
        if (!department.equals(building.department)) return false;
        return rooms.equals(building.rooms);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + name.hashCode();
        temp = Double.doubleToLongBits(latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitute);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + code.hashCode();
        result = 31 * result + department.hashCode();
        result = 31 * result + rooms.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitute=" + longitute +
                ", code='" + code + '\'' +
                ", department=" + department +
                ", rooms=" + rooms +
                '}';
    }
}
