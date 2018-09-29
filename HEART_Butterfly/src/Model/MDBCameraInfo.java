package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MDBCameraInfo extends MDatabase {
    int idCameraInfo;
    String lens;            //varchar(45)
    String calibration;     //varchar(45)
    String format;          //varchar(5)

    public MDBCameraInfo(Connection connection) {
        this.connection = connection;
        this.table_name = "CameraInfo";
        initialize();
    }

    public void initialize() {
        this.lens = null;
        this.calibration = null;
        this.format = null;
    }

    public String getIdCameraInfo() {
        if(idCameraInfo == 0)
            return "null";
        else
            return String.valueOf(idCameraInfo);
    }

    public int getIdCameraInfo_integer() {
        return idCameraInfo;
    }

    public void setIdCameraInfo(int idCameraInfo) {
        this.idCameraInfo = idCameraInfo;
    }

    public String getLens() {
        if(lens == null || lens.length() == 0) return null;
        return lens;
    }

    public void setLens(String lens) {
        this.lens = lens;
    }

    public String getCalibration() {
        if(calibration == null || calibration.length() == 0) return null;
        return calibration;
    }

    public void setCalibration(String calibration) {
        this.calibration = calibration;
    }

    public String getFormat() {
        if(format == null || format.length() == 0) return null;
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void printContents() {
        logger.info("[" + this.table_name + "]");
        logger.info("[idCameraInfo] " + idCameraInfo);
        logger.info("[lens] " + lens);
        logger.info("[calibration] " + calibration);
        logger.info("[format] " + format);
    }

    public boolean insert() {
        String query = "insert into CameraInfo (lens, format, calibration) values ("
                + db_string_formatting(getLens(), "string") + ","
                + db_string_formatting(getFormat(), "string") + ","
                + db_string_formatting(getCalibration(), "string")
                + ");";
        return modifyingQuery(query);
    }

    public boolean delete(int idCameraInfo) {
        String query = "delete from CameraInfo where idCameraInfo = " + idCameraInfo;
        return modifyingQuery(query);
    }

    public boolean update(int idCameraInfo) {
        String query = "update CameraInfo set ";
        int initial_length = query.length();
        query += db_update_formatting(db_string_formatting(getLens(), "string"), "lens");
        query += db_update_formatting(db_string_formatting(getFormat(), "string"), "format");
        query += db_update_formatting(db_string_formatting(getCalibration(), "string"), "calibration");
        if(query.length() == initial_length) return false;
        query = query.substring(0, query.length()-1);   // Delete last comma
        query += " where idCameraInfo = " + idCameraInfo;
        return modifyingQuery(query);
    }

    public int getIdCameraInfoFromDB() {
        String query = "select idCameraInfo from CameraInfo where "
                + db_where_formatting(db_string_formatting(getLens(), "String"), "lens") + " and "
                + db_where_formatting(db_string_formatting(getFormat(), "String"), "format") + " and "
                + db_where_formatting(db_string_formatting(getCalibration(), "String"), "calibration");
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
        return 0;    }

    @Override
    public int getIDFromDB() {
        return getIdCameraInfoFromDB();
    }
}
