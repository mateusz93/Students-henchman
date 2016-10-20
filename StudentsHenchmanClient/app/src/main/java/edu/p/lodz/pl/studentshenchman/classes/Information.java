package edu.p.lodz.pl.studentshenchman.classes;

/**
 * Created by marcin on 21.10.16.
 */

public class Information {
    private static final String BUILDING_NAME_LABEL = "Nazwa budynku";
    private static final String SALE_NAME_LABEL = "Nazwa sali:";
    private static final String CARER_OF_THE_ROOM_LABEL = "Opiekun sali";
    private Integer id;
    private String buildingName;
    private String saleName;
    private String carerOfTheRoom;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getSaleName() {
        return saleName;
    }

    public void setSaleName(String saleName) {
        this.saleName = saleName;
    }

    public String getCarerOfTheRoom() {
        return carerOfTheRoom;
    }

    public void setCarerOfTheRoom(String carerOfTheRoom) {
        this.carerOfTheRoom = carerOfTheRoom;
    }

    public static String getFormattedFields(Information information) {
        return BUILDING_NAME_LABEL+" : "+information.getBuildingName() + "\n"
                + SALE_NAME_LABEL+" : "+information.getSaleName() + "\n"
                + CARER_OF_THE_ROOM_LABEL+" : " + information.getCarerOfTheRoom();
    }
}
