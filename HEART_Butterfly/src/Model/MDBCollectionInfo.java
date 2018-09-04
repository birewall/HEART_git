package Model;

import java.sql.Connection;

public class MDBCollectionInfo extends MDatabase {
    int idCollectionInfo;
    int idLoction;
    int idButterflyGuide;
    int idPerson;
    String date;    //varchar(11)
    String method;  //varchar(45)

    public MDBCollectionInfo(Connection connection) {
        this.connection = connection;
    }

    public int getIdCollectionInfo() {
        return idCollectionInfo;
    }

    public void setIdCollectionInfo(int idCollectionInfo) {
        this.idCollectionInfo = idCollectionInfo;
    }

    public int getIdLoction() {
        return idLoction;
    }

    public void setIdLoction(int idLoction) {
        this.idLoction = idLoction;
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
}
