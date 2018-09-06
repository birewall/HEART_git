package Model;

import java.sql.Connection;

public class MDBSpecimen extends MDatabase {
    int idSpecimen;
    int idCollectionInfo;
    int idImage;
    String status;          //varchar(10)
    char sex;
    String storageRoom;     //varchar(10)
    String storageCabinet;  //varchar(10)
    String comment;         //varchar(10)

    public MDBSpecimen(Connection connection) {
        this.connection = connection;
        this.table_name = "Specimen";
    }

    public int getIdSpecimen() {
        return idSpecimen;
    }

    public void setIdSpecimen(int idSpecimen) {
        this.idSpecimen = idSpecimen;
    }

    public int getIdCollectionInfo() {
        return idCollectionInfo;
    }

    public void setIdCollectionInfo(int idCollectionInfo) {
        this.idCollectionInfo = idCollectionInfo;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getStorageRoom() {
        return storageRoom;
    }

    public void setStorageRoom(String storageRoom) {
        this.storageRoom = storageRoom;
    }

    public String getStorageCabinet() {
        return storageCabinet;
    }

    public void setStorageCabinet(String storageCabinet) {
        this.storageCabinet = storageCabinet;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void printContents() {
        logger.info("[" + this.table_name + "]");
        logger.info("[idSpecimen] " + idSpecimen);
        logger.info("[idCollectionInfo] " + idCollectionInfo);
        logger.info("[idImage] " + idImage);
        logger.info("[status] " + status);
        logger.info("[sex] " + sex);
        logger.info("[storageRoom] " + storageRoom);
        logger.info("[storageCabinet] " + storageCabinet);
        logger.info("[comment] " + comment);
    }
}
