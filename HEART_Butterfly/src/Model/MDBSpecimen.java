package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MDBSpecimen extends MDatabase {
    int idSpecimen;
    int idCollectionInfo;   // not null
    int idImage;
    String status;          //varchar(10)
    String sex;
    String storageRoom;     //varchar(10)
    String storageCabinet;  //varchar(10)
    String storageChest;    //varchar(10)
    String comment;         //varchar(10)

    public void initialize() {
        this.idCollectionInfo = 0;
        this.idImage = 0;
        this.status = null;
        this.sex = null;
        this.storageChest = null;
        this.storageCabinet = null;
        this.storageRoom = null;
        this.comment = null;
    }

    public MDBSpecimen(Connection connection) {
        this.connection = connection;
        this.table_name = "Specimen";
        initialize();
    }

    public String getIdSpecimen() {
        if(idSpecimen == 0)
            return null;
        else
            return String.valueOf(idSpecimen);
    }

    public int getIdSpecimen_integer() {
        return idSpecimen;
    }

    public void setIdSpecimen(int idSpecimen) {
        this.idSpecimen = idSpecimen;
    }

    public String getIdCollectionInfo() {
        if(idCollectionInfo == 0)
            return null;
        else
            return String.valueOf(idCollectionInfo);
    }

    public void setIdCollectionInfo(int idCollectionInfo) {
        this.idCollectionInfo = idCollectionInfo;
    }

    public String getIdImage() {
        if(idImage == 0)
            return null;
        else
            return String.valueOf(idImage);
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public String getStatus() {
        if(status == null || status.length() == 0) return null;
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSex() {
        if(sex == null || sex.length() == 0) return null;
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStorageRoom() {
        if(storageRoom == null || storageRoom.length() == 0) return null;
        return storageRoom;
    }

    public void setStorageRoom(String storageRoom) {
        this.storageRoom = storageRoom;
    }

    public String getStorageCabinet() {
        if(storageCabinet == null || storageCabinet.length() == 0) return null;
        return storageCabinet;
    }

    public void setStorageCabinet(String storageCabinet) {
        this.storageCabinet = storageCabinet;
    }

    public String getComment() {
        if(comment == null || comment.length() == 0) return null;
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStorageChest() {
        if(storageChest == null || storageChest.length() == 0) return null;
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
                + db_string_formatting(getIdCollectionInfo(), "int") + ","
                + db_string_formatting(getIdImage(), "int") + ","
                + db_string_formatting(getStatus(), "string") + ","
                + db_string_formatting(getSex(), "string") + ","
                + db_string_formatting(getStorageRoom(), "string") + ","
                + db_string_formatting(getStorageCabinet(), "string") + ","
                + db_string_formatting(getStorageChest(), "string") + ","
                + db_string_formatting(getComment(), "string")
                + ");";
        return modifyingQuery(query);
    }

    public boolean delete(int idSpecimen) {
        String query = "delete from Specimen where idSpecimen = " + idSpecimen;
        return modifyingQuery(query);
    }

    public boolean update(int idSpecimen) {
        String query = "update Specimen set ";
        int initial_length = query.length();
        query += db_update_formatting(db_string_formatting(getIdCollectionInfo(), "int"), "idCollectionInfo");
        query += db_update_formatting(db_string_formatting(getIdImage(), "int"), "idImage");
        query += db_update_formatting(db_string_formatting(getStatus(), "string"), "status");
        query += db_update_formatting(db_string_formatting(getSex(), "string"), "sex");
        query += db_update_formatting(db_string_formatting(getStorageRoom(), "string"), "storageRoom");
        query += db_update_formatting(db_string_formatting(getStorageCabinet(), "string"), "storageCabinet");
        query += db_update_formatting(db_string_formatting(getStorageChest(), "string"), "storageChest");
        query += db_update_formatting(db_string_formatting(getComment(), "string"), "comment");
        if(query.length() == initial_length) return false;
        query = query.substring(0, query.length()-1);   // Delete last comma
        query += " where idSpecimen = " + idSpecimen;
        return modifyingQuery(query);
    }

    public int getIdSpecimenFromDB() {
        String query = "select idSpecimen from Specimen where "
                + db_where_formatting(db_string_formatting(getIdCollectionInfo(), "int"), "idCollectionInfo") + " and "
                + db_where_formatting(db_string_formatting(getIdImage(), "int"), "idImage") + " and "
                + db_where_formatting(db_string_formatting(getStatus(), "String"), "status") + " and "
                + db_where_formatting(db_string_formatting(getSex(), "String"), "sex") + " and "
                + db_where_formatting(db_string_formatting(getStorageRoom(), "String"), "storageRoom") + " and "
                + db_where_formatting(db_string_formatting(getStorageCabinet(), "String"), "storageCabinet") + " and "
                + db_where_formatting(db_string_formatting(getStorageChest(), "String"), "storageChest") + " and "
                + db_where_formatting(db_string_formatting(getComment(), "String"), "comment");
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
        return getIdSpecimenFromDB();
    }
}
