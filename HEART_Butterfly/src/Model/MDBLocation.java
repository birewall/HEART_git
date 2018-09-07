package Model;

import java.sql.Connection;
import java.sql.SQLException;

public class MDBLocation extends MDatabase {
    int idLocation;
    String country;         //varchar(20)
    String location;        //varchar(20)
    String locationDetail;  //varchar(20)
    String gps;             //varchar(20)
    String alias;           //varchar(45)
    String section;         //varchar(45)
    String sectionDetail;   //varchar(45)

    public MDBLocation(Connection connection) {
        this.connection = connection;
        this.table_name = "Location";
    }

    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocationDetail() {
        return locationDetail;
    }

    public void setLocationDetail(String locationDetail) {
        this.locationDetail = locationDetail;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSectionDetail() {
        return sectionDetail;
    }

    public void setSectionDetail(String sectionDetail) {
        this.sectionDetail = sectionDetail;
    }

    public void printContents() {
        logger.info("[" + this.table_name + "]");
        logger.info("[idLocation] " + idLocation);
        logger.info("[country] " + country);
        logger.info("[location] " + location);
        logger.info("[locationDetail] " + locationDetail);
        logger.info("[gps] " + gps);
        logger.info("[alias] " + alias);
        logger.info("[section] " + section);
        logger.info("[sectionDetail] " + sectionDetail);
    }

    public void insert() {
        try {
            String query = "insert into Location (country, location, locationDetail, gps, alias, section, sectionDetail) values ("
                    + "'" + getCountry() + "',"
                    + "'" + getLocation() + "',"
                    + "'" + getLocationDetail() + "',"
                    + "'" + getGps() + "',"
                    + "'" + getAlias() + "',"
                    + "'" + getSection() + "',"
                    + "'" + getSectionDetail() + "'"
                    + ");";
            modifyingQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int idLocation) {
        try {
            String query = "delete from Location where idLocation = " + idLocation;
            modifyingQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int idLocation) {
        try {
            String query = "update Location set "
                    + "country='" + getCountry() + "'"
                    + ",location='" + getLocation() + "'"
                    + ",locationDetail='" + getLocationDetail() + "'"
                    + ",gps='" + getGps() + "'"
                    + ",alias='" + getAlias() + "'"
                    + ",section='" + getSection() + "'"
                    + ",sectionDetail='" + getSectionDetail() + "'"
                    + " where idLocation = " + idLocation;
            modifyingQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
