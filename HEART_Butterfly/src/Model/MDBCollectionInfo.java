package Model;

import java.sql.Connection;
import java.sql.SQLException;

public class MDBCollectionInfo extends MDatabase {
    int idCollectionInfo;
    int idLocation;
    int idButterflyGuide;
    int idPerson;
    String date;    //varchar(11)
    String method;  //varchar(45)

    public MDBCollectionInfo(Connection connection) {
        this.connection = connection;
        this.table_name = "CollectionInfo";
    }

    public int getIdCollectionInfo() {
        return idCollectionInfo;
    }

    public void setIdCollectionInfo(int idCollectionInfo) {
        this.idCollectionInfo = idCollectionInfo;
    }

    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public int getIdButterflyGuide() {
        return idButterflyGuide;
    }

    public void setIdButterflyGuide(int idButterflyGuide) {
        this.idButterflyGuide = idButterflyGuide;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void printContents() {
        logger.info("[" + this.table_name + "]");
        logger.info("[idCollectionInfo] " + idCollectionInfo);
        logger.info("[idLocation] " + idLocation);
        logger.info("[idButterflyGuide] " + idButterflyGuide);
        logger.info("[idPerson] " + idPerson);
        logger.info("[date] " + date);
        logger.info("[method] " + method);
    }

    public boolean insert() {
        String query = "insert into CollectionInfo (idLocation, idButterflyGuide, idPerson, date, method) values ("
                + getIdLocation() + ","
                + getIdButterflyGuide() + ","
                + getIdPerson() + ","
                + "'" + getDate() + "',"
                + "'" + getMethod() + "'"
                + ");";
        return modifyingQuery(query);
    }

    public boolean delete(int idCollectionInfo) {
        String query = "delete from CollectionInfo where idCollectionInfo = " + idCollectionInfo;
        return modifyingQuery(query);
    }

    public boolean update(int idCollectionInfo) {
        String query = "update CollectionInfo set "
                + "idLocation=" + getIdLocation()
                + "idButterflyGuide=" + getIdButterflyGuide()
                + "idPerson=" + getIdPerson()
                + ",date='" + getDate() + "'"
                + ",method='" + getMethod() + "'"
                + " where idCollectionInfo = " + idCollectionInfo;
        return modifyingQuery(query);
    }
}
