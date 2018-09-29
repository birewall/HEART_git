package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MDBCollectionInfo extends MDatabase {
    int idCollectionInfo;
    int idLocation; // not null
    int idButterflyGuide;
    int idPerson;   // not null
    String date;    //varchar(11)
    String method;  //varchar(45)  not null

    public void initialize() {
        this.idLocation = 0;
        this.idButterflyGuide = 0;
        this.idPerson = 0;
        this.date = null;
        this.method = null;
    }

    public MDBCollectionInfo(Connection connection) {
        this.connection = connection;
        this.table_name = "CollectionInfo";
        initialize();
    }

    public String getIdCollectionInfo() {
        if(idCollectionInfo == 0)
            return null;
        else
            return String.valueOf(idCollectionInfo);
    }

    public int getIdCollectionInfo_integer() {
        return idCollectionInfo;
    }

    public void setIdCollectionInfo(int idCollectionInfo) {
        this.idCollectionInfo = idCollectionInfo;
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

    public String getIdButterflyGuide() {
        if(idButterflyGuide == 0)
            return null;
        else
            return String.valueOf(idButterflyGuide);
    }

    public void setIdButterflyGuide(int idButterflyGuide) {
        this.idButterflyGuide = idButterflyGuide;
    }

    public String getIdPerson() {
        if(idPerson == 0)
            return null;
        else
            return String.valueOf(idPerson);
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getDate() {
        if(date == null || date.length() == 0) return null;
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMethod() {
        if(method == null || method.length() == 0) return null;
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
                + db_string_formatting(getIdLocation(), "int") + ","
                + db_string_formatting(getIdButterflyGuide(), "int") + ","
                + db_string_formatting(getIdPerson(), "int") + ","
                + db_string_formatting(getDate(), "string") + ","
                + db_string_formatting(getMethod(), "string")
                + ");";
        return modifyingQuery(query);
    }

    public boolean delete(int idCollectionInfo) {
        String query = "delete from CollectionInfo where idCollectionInfo = " + idCollectionInfo;
        return modifyingQuery(query);
    }

    public boolean update(int idCollectionInfo) {
        String query = "update CollectionInfo set ";
        int initial_length = query.length();
        query += db_update_formatting(db_string_formatting(getIdLocation(), "int"), "idLocation");
        query += db_update_formatting(db_string_formatting(getIdButterflyGuide(), "int"), "idButterflyGuide");
        query += db_update_formatting(db_string_formatting(getIdPerson(), "int"), "idPerson");
        query += db_update_formatting(db_string_formatting(getDate(), "string"), "date");
        query += db_update_formatting(db_string_formatting(getMethod(), "string"), "method");
        if(query.length() == initial_length) return false;
        query = query.substring(0, query.length()-1);   // Delete last comma
        query += " where idCollectionInfo = " + idCollectionInfo;
        return modifyingQuery(query);
    }

    public int getIdCollectionInfoFromDB() {
        String query = "select idCollectionInfo from CollectionInfo where "
                + db_where_formatting(db_string_formatting(getIdLocation(), "int"), "idLocation") + " and "
                + db_where_formatting(db_string_formatting(getIdButterflyGuide(), "int"), "idButterflyGuide") + " and "
                + db_where_formatting(db_string_formatting(getIdPerson(), "int"), "idPerson") + " and "
                + db_where_formatting(db_string_formatting(getDate(), "String"), "date") + " and "
                + db_where_formatting(db_string_formatting(getMethod(), "String"), "method");
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
        return getIdCollectionInfoFromDB();
    }
}
