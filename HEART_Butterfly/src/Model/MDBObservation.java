package Model;

import java.sql.Connection;
import java.sql.SQLException;

public class MDBObservation extends MDatabase {
    int idObservation;
    int idImage;
    int idCollectionInfo;
    String date;    //varchar(11)
    String time;    //varchar(9)
    char sex;
    String status;  //varchar(10)
    int number;

    public MDBObservation(Connection connection) {
        this.connection = connection;
        this.table_name = "Observation";
    }

    public int getIdObservation() {
        return idObservation;
    }

    public void setIdObservation(int idObservation) {
        this.idObservation = idObservation;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public int getIdCollectionInfo() {
        return idCollectionInfo;
    }

    public void setIdCollectionInfo(int idCollectionInfo) {
        this.idCollectionInfo = idCollectionInfo;
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

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void printContents() {
        logger.info("[" + this.table_name + "]");
        logger.info("[idObservation] " + idObservation);
        logger.info("[idImage] " + idImage);
        logger.info("[idCollectionInfo] " + idCollectionInfo);
        logger.info("[date] " + date);
        logger.info("[time] " + time);
        logger.info("[sex] " + sex);
        logger.info("[status] " + status);
        logger.info("[number] " + number);
    }

    public void insert() {
        try {
            String query = "insert into Observation (idImage, idCollectionInfo, date, time, sex, status, number) values ("
                    + getIdImage() + ","
                    + getIdCollectionInfo() + ","
                    + "'" + getDate() + "',"
                    + "'" + getTime() + "',"
                    + "'" + getSex() + "',"
                    + "'" + getStatus() + "',"
                    + getNumber()
                    + ");";
            modifyingQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int idObservation) {
        try {
            String query = "delete from Observation where idObservation = " + idObservation;
            modifyingQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int idObservation) {
        try {
            String query = "update Observation set "
                    + "idImage=" + getIdImage()
                    + ",idCollectionInfo=" + getIdCollectionInfo()
                    + ",date='" + getDate() + "'"
                    + ",time='" + getTime() + "'"
                    + ",sex='" + getSex() + "'"
                    + ",status='" + getStatus() + "'"
                    + ",number=" + getNumber()
                    + " where idObservation = " + idObservation;
            modifyingQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
