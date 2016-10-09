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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_wydzialu")
    private Department department;

    @JsonIgnore
    @OneToMany(mappedBy = "building", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Building building = (Building) o;

        if (id != building.id) return false;
        if (Double.compare(building.latitude, latitude) != 0) return false;
        if (Double.compare(building.longitute, longitute) != 0) return false;
        if (!name.equals(building.name)) return false;
        if (!department.equals(building.department)) return false;
        return rooms.equals(building.rooms);

    }

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitute=" + longitute +
                ", department=" + department +
                '}';
    }
}
