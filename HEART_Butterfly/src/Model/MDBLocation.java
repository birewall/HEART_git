package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MDBLocation extends MDatabase {
    int idLocation;
    String country;         //varchar(20)
    String location;        //varchar(20) not null
    String locationDetail;  //varchar(20)
    String gps;             //varchar(20)
    String alias;           //varchar(45)
    String section;         //varchar(45)
    String sectionDetail;   //varchar(45)

    public void initialize() {
        this.country = null;
        this.location = null;
        this.locationDetail = null;
        this.gps = null;
        this.alias = null;
        this.section = null;
        this.sectionDetail = null;
    }

    public MDBLocation(Connection connection) {
        this.connection = connection;
        this.table_name = "Location";
        initialize();
    }

    public String getIdLocation() {
        if(idLocation == 0)
            return null;
        else
            return String.valueOf(idLocation);
    }

    public int getIdLocation_integer() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public String getCountry() {
        if(country == null || country.length() == 0) return null;
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocation() {
        if(location == null || location.length() == 0) return null;
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocationDetail() {
        if(locationDetail == null || locationDetail.length() == 0) return null;
        return locationDetail;
    }

    public void setLocationDetail(String locationDetail) {
        this.locationDetail = locationDetail;
    }

    public String getGps() {
        if(gps == null || gps.length() == 0) return null;
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public String getAlias() {
        if(alias == null || alias.length() == 0) return null;
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getSection() {
        if(section == null || section.length() == 0) return null;
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSectionDetail() {
        if(sectionDetail == null || sectionDetail.length() == 0) return null;
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

    public boolean insert() {
        String query = "insert into Location (country, location, locationDetail, gps, alias, section, sectionDetail) values ("
                + db_string_formatting(getCountry(), "string") + ","
                + db_string_formatting(getLocation(), "string") + ","
                + db_string_formatting(getLocationDetail(), "string") + ","
                + db_string_formatting(getGps(), "string") + ","
                + db_string_formatting(getAlias(), "string") + ","
                + db_string_formatting(getSection(), "string") + ","
                + db_string_formatting(getSectionDetail(), "string")
                + ");";
        return modifyingQuery(query);
    }

    public boolean delete(int idLocation) {
        String query = "delete from Location where idLocation = " + idLocation;
        return modifyingQuery(query);
    }

    public boolean update(int idLocation) {
        String query = "update Location set ";
        int initial_length = query.length();
        query += db_update_formatting(db_string_formatting(getCountry(), "string"), "country");
        query += db_update_formatting(db_string_formatting(getLocation(), "string"), "location");
        query += db_update_formatting(db_string_formatting(getLocationDetail(), "string"), "locationDetail");
        query += db_update_formatting(db_string_formatting(getGps(), "string"), "gps");
        query += db_update_formatting(db_string_formatting(getAlias(), "string"), "alias");
        query += db_update_formatting(db_string_formatting(getSection(), "string"), "section");
        query += db_update_formatting(db_string_formatting(getSectionDetail(), "string"), "sectionDetail");
        if(query.length() == initial_length) return false;
        query = query.substring(0, query.length()-1);   // Delete last comma
        query += " where idLocation = " + idLocation;
        return modifyingQuery(query);
    }

    public int getIdLocationFromDB() {
        String query = "select idLocation from Location where "
                + db_where_formatting(db_string_formatting(getCountry(), "String"), "country") + " and "
                + db_where_formatting(db_string_formatting(getLocation(), "String"), "location") + " and "
                + db_where_formatting(db_string_formatting(getLocationDetail(), "String"), "locationDetail") + " and "
                + db_where_formatting(db_string_formatting(getGps(), "String"), "gps") + " and "
                + db_where_formatting(db_string_formatting(getAlias(), "String"), "alias") + " and "
                + db_where_formatting(db_string_formatting(getSection(), "String"), "section") + " and "
                + db_where_formatting(db_string_formatting(getSectionDetail(), "String"), "sectionDetail");
        ResultSet rs = selectQuery(query);
        if(rs == null) return 0;
        try {
            rs.last();
            if(rs.getRow() > 0) {
                rs.first();
                return Integer.parseInt(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int getIDFromDB() {
        return getIdLocationFromDB();
    }
}
