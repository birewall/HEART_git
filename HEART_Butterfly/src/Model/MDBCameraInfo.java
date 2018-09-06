package Model;

import java.sql.Connection;

public class MDBCameraInfo extends MDatabase {
    int idCameraInfo;
    String lens;            //varchar(45)
    String calibration;     //varchar(45)
    String format;          //varchar(5)

    public MDBCameraInfo(Connection connection) {
        this.connection = connection;
        this.table_name = "CameraInfo";
    }

    public int getIdCameraInfo() {
        return idCameraInfo;
    }

    public void setIdCameraInfo(int idCameraInfo) {
        this.idCameraInfo = idCameraInfo;
    }

    public String getLens() {
        return lens;
    }

    public void setLens(String lens) {
        this.lens = lens;
    }

    public String getCalibration() {
        return calibration;
    }

    public void setCalibration(String calibration) {
        this.calibration = calibration;
    }

    public String getFormat() {
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
}
