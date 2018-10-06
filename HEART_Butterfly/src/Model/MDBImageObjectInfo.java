package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MDBImageObjectInfo extends MDatabase {
    int idImageObjectInfo;
    String size;            //varchar(5)
    String wing;            //varchar(10)
    String background;      //varchar(20)
    String status;          //varchar(5)
    String sex;             //char(1)
    int number;
    String marriage;        //char(1)

    public void initialize() {
        this.size = null;
        this.wing = null;
        this.background = null;
        this.status = null;
        this.sex = null;
        this.number = 0;
        this.marriage = null;
    }

    public MDBImageObjectInfo(Connection connection) {
        this.connection = connection;
        this.table_name = "ImageObjectInfo";
        initialize();
    }

    public String getIdImageObjectInfo() {
        if(idImageObjectInfo == 0)
            return null;
        else
            return String.valueOf(idImageObjectInfo);
    }

    public int getIdImageObjectInfo_integer() {
        return idImageObjectInfo;
    }

    public void setIdImageObjectInfo(int idImageObjectInfo) {
        this.idImageObjectInfo = idImageObjectInfo;
    }

    public String getSize() {
        if(size == null || size.length() == 0) return null;
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getWing() {
        if(wing == null || wing.length() == 0) return null;
        return wing;
    }

    public void setWing(String wing) {
        this.wing = wing;
    }

    public String getBackground() {
        if(background == null || background.length() == 0) return null;
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
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

    public String getNumber() {
        if(number == 0)
            return null;
        else
            return String.valueOf(number);
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getMarriage() {
        if(marriage == null || marriage.length() == 0) return null;
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public void printContents() {
        logger.info("[" + this.table_name + "]");
        logger.info("[idImageObjectInfo] " + idImageObjectInfo);
        logger.info("[size] " + size);
        logger.info("[wing] " + wing);
        logger.info("[background] " + background);
        logger.info("[status] " + status);
        logger.info("[sex] " + sex);
        logger.info("[number] " + number);
        logger.info("[marriage] " + marriage);
    }

    public boolean insert() {
        String query = "insert into ImageObjectInfo (size, wing, background, status, sex, number, marriage) values ("
                + db_string_formatting(getSize(), "string") + ","
                + db_string_formatting(getWing(), "string") + ","
                + db_string_formatting(getBackground(), "string") + ","
                + db_string_formatting(getStatus(), "string") + ","
                + db_string_formatting(getSex(), "string") + ","
                + db_string_formatting(getNumber(), "int") + ","
                + db_string_formatting(getMarriage(), "string")
                + ");";
        return modifyingQuery(query);
    }

    public boolean delete(int idImageObjectInfo) {
        String query = "delete from ImageObjectInfo where idImageObjectInfo = " + idImageObjectInfo;
        return modifyingQuery(query);
    }

    public boolean update(int idImageObjectInfo) {
        String query = "update ImageObjectInfo set ";
        int initial_length = query.length();
        query += db_update_formatting(db_string_formatting(getSize(), "string"), "size");
        query += db_update_formatting(db_string_formatting(getWing(), "string"), "wing");
        query += db_update_formatting(db_string_formatting(getBackground(), "string"), "background");
        query += db_update_formatting(db_string_formatting(getStatus(), "string"), "status");
        query += db_update_formatting(db_string_formatting(getSex(), "string"), "sex");
        query += db_update_formatting(db_string_formatting(getNumber(), "int"), "number");
        query += db_update_formatting(db_string_formatting(getMarriage(), "string"), "marriage");
        if(query.length() == initial_length) return false;
        query = query.substring(0, query.length()-1);   // Delete last comma
        query += " where idImageObjectInfo = " + idImageObjectInfo;
        return modifyingQuery(query);
    }

    public int getIdImageObjectInfoFromDB() {
        String query = "select idImageObjectInfo from ImageObjectInfo where "
                + db_where_formatting(db_string_formatting(getSize(), "String"), "size") + " and "
                + db_where_formatting(db_string_formatting(getWing(), "String"), "wing") + " and "
                + db_where_formatting(db_string_formatting(getBackground(), "String"), "background") + " and "
                + db_where_formatting(db_string_formatting(getStatus(), "String"), "status") + " and "
                + db_where_formatting(db_string_formatting(getSex(), "String"), "sex") + " and "
                + db_where_formatting(db_string_formatting(getNumber(), "int"), "number") + " and "
                + db_where_formatting(db_string_formatting(getMarriage(), "String"), "marriage");
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
        return getIdImageObjectInfoFromDB();
    }
}
