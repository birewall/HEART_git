package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MDBSpecimen extends MDatabase {
    int idSpecimen;
    int idCollectionInfo;
    int idImage;
    String status;          //varchar(10)
    char sex;
    String storageRoom;     //varchar(10)
    String storageCabinet;  //varchar(10)
    String storageChest;    //varchar(10)
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

    public String getStorageChest() {
        return storageChest;
    }

    public void setStorageChest(String storageChest) {
        this.storageChest = storageChest;
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
        logger.info("[storageChest] " + storageChest);
        logger.info("[comment] " + comment);
    }

    public boolean insert() {
        String query = "insert into Specimen (idCollectionInfo, idImage, status, sex, storageRoom, storageCabinet, storageChest, comment) values ("
                + getIdCollectionInfo() + ","
                + getIdImage() + ","
                + "'" + getStatus() + "',"
                + "'" + getSex() + "',"
                + "'" + getStorageRoom() + "',"
                + "'" + getStorageCabinet() + "',"
                + "'" + getStorageChest() + "',"
                + "'" + getComment() + "'"
                + ");";
        return modifyingQuery(query);
    }

    public boolean delete(int idSpecimen) {
        String query = "delete from Specimen where idSpecimen = " + idSpecimen;
        return modifyingQuery(query);
    }

    public boolean update(int idSpecimen) {
        String query = "update Specimen set "
                + "idCollectionInfo=" + getIdCollectionInfo()
                + ",idImage=" + getIdImage()
                + ",status='" + getStatus() + "'"
                + ",sex='" + getSex() + "'"
                + ",storageRoom='" + getStorageRoom() + "'"
                + ",storageCabinet='" + getStorageCabinet() + "'"
                + ",storageChest='" + getStorageChest() + "'"
                + ",comment='" + getComment() + "'"
                + " where idSpecimen = " + idSpecimen;
        return modifyingQuery(query);
    }

    public int getIdSpecimenFromDB() {
        String query = "select idSpecimen from Specimen where "
                + "idCollectionInfo=" + getIdCollectionInfo()
                + " and idImage=" + getIdImage()
                + " and status='" + getStatus() + "'"
                + " and sex='" + getSex() + "'"
                + " and storageRoom='" + getStorageRoom() + "'"
                + " and storageCabinet='" + getStorageCabinet() + "'"
                + " and storageChest='" + getStorageChest() + "'"
                + " and comment='" + getComment() + "'";
        ResultSet rs = selectQuery(query);
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
}
