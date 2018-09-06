package Model;

import java.sql.Connection;

public class MDBImage extends MDatabase {
    int idImage;
    int idLocation;
    int idImageObjectInfo;
    int idCameraInfo;
    String date;    //varchar(11)
    String time;    //varchar(9)
    String path;    //varchar(100)

    public MDBImage(Connection connection) {
        this.connection = connection;
        this.table_name = "Image";
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public int getIdImageObjectInfo() {
        return idImageObjectInfo;
    }

    public void setIdImageObjectInfo(int idImageObjectInfo) {
        this.idImageObjectInfo = idImageObjectInfo;
    }

    public int getIdCameraInfo() {
        return idCameraInfo;
    }

    public void setIdCameraInfo(int idCameraInfo) {
        this.idCameraInfo = idCameraInfo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPath() {
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
        logger.info("[date] " + date);
        logger.info("[time] " + time);
        logger.info("[path] " + path);
    }
}
