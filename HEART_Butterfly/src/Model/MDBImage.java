package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MDBImage extends MDatabase {
    int idImage;
    int idLocation;
    int idImageObjectInfo;
    int idCameraInfo;
    int idButterflyGuide;
    String date;    //varchar(11)
    String time;    //varchar(9)
    String path;    //varchar(100)  not null

    public MDBImage(Connection connection) {
        this.connection = connection;
        this.table_name = "Image";
        initialize();
    }

    public void initialize() {
        this.idLocation = 0;
        this.idImageObjectInfo = 0;
        this.idCameraInfo = 0;
        this.idButterflyGuide = 0;
        this.date = null;
        this.time = null;
        this.path = null;
    }

    public String getIdImage() {
        if(idImage == 0)
            return null;
        else
            return String.valueOf(idImage);
    }

    public int getIdImage_integer() {
        return idImage;
    }

    public String getIdButterflyGuide() {
        return String.valueOf(idButterflyGuide);
    }

    public void setIdButterflyGuide(int idButterflyGuide) {
        this.idButterflyGuide = idButterflyGuide;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public String getIdLocation() {
        if(idLocation == 0)
            return null;
        else
            return String.valueOf(idLocation);
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public String getIdImageObjectInfo() {
        if(idImageObjectInfo == 0)
            return null;
        else
            return String.valueOf(idImageObjectInfo);
    }

    public void setIdImageObjectInfo(int idImageObjectInfo) {
        this.idImageObjectInfo = idImageObjectInfo;
    }

    public String getIdCameraInfo() {
        if(idCameraInfo == 0)
            return null;
        else
            return String.valueOf(idCameraInfo);
    }

    public void setIdCameraInfo(int idCameraInfo) {
        this.idCameraInfo = idCameraInfo;
    }

    public String getDate() {
        if(date == null || date.length() == 0) return null;
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        if(time == null || time.length() == 0) return null;
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPath() {
        if(path == null || path.length() == 0) return null;
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void printContents() {
        logger.info("[" + this.table_name + "]");
        logger.info("[idImage] " + idImage);
        logger.info("[idLocation] " + idLocation);
        logger.info("[idImageObjectInfo] " + idImageObjectInfo);
        logger.info("[idCameraInfo] " + idCameraInfo);
        logger.info("[idButterflyGuide] " + idButterflyGuide);
        logger.info("[date] " + date);
        logger.info("[time] " + time);
        logger.info("[path] " + path);
    }

    public boolean insert() {
        String query = "insert into Image (idLocation, idImageObjectInfo, idCameraInfo, idButterflyGuide, date, time, path) values ("
                + db_string_formatting(getIdLocation(), "int") + ","
                + db_string_formatting(getIdImageObjectInfo(), "int") + ","
                + db_string_formatting(getIdCameraInfo(), "int") + ","
                + db_string_formatting(getIdButterflyGuide(), "int") + ","
                + db_string_formatting(getDate(), "string") + ","
                + db_string_formatting(getTime(), "string") + ","
                + db_string_formatting(getPath(), "string")
                + ");";
        return modifyingQuery(query);
    }

    public boolean delete(int idImage) {
        String query = "delete from Image where idImage = " + idImage;
        return modifyingQuery(query);
    }

    public boolean update(int idImage) {
        String query = "update Image set ";
        int initial_length = query.length();
        query += db_update_formatting(db_string_formatting(getIdLocation(), "int"), "idLocation");
        query += db_update_formatting(db_string_formatting(getIdImageObjectInfo(), "int"), "idImageObjectInfo");
        query += db_update_formatting(db_string_formatting(getIdCameraInfo(), "int"), "idCameraInfo");
        query += db_update_formatting(db_string_formatting(getIdButterflyGuide(), "int"), "idButterflyGuide");
        query += db_update_formatting(db_string_formatting(getDate(), "string"), "date");
        query += db_update_formatting(db_string_formatting(getTime(), "string"), "time");
        query += db_update_formatting(db_string_formatting(getPath(), "string"), "path");
        if(query.length() == initial_length) return false;
        query = query.substring(0, query.length()-1);   // Delete last comma
        query += " where idImage = " + idImage;
        return modifyingQuery(query);
    }

    public int getIdImageFromDB() {
        String query = "select idImage from Image where "
                + db_where_formatting(db_string_formatting(getIdLocation(), "int"), "idLocation") + " and "
                + db_where_formatting(db_string_formatting(getIdImageObjectInfo(), "int"), "idImageObjectInfo") + " and "
                + db_where_formatting(db_string_formatting(getIdCameraInfo(), "int"), "idCameraInfo") + " and "
                + db_where_formatting(db_string_formatting(getIdButterflyGuide(), "int"), "idButterflyGuide") + " and "
                + db_where_formatting(db_string_formatting(getDate(), "String"), "date") + " and "
                + db_where_formatting(db_string_formatting(getTime(), "String"), "time") + " and "
                + db_where_formatting(db_string_formatting(getPath(), "String"), "path");
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
        return getIdImageFromDB();
    }
}
