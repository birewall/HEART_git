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

    public MDBImageObjectInfo(Connection connection) {
        this.connection = connection;
        this.table_name = "ImageObjectInfo";
    }

    public int getIdImageObjectInfo() {
        return idImageObjectInfo;
    }

    public void setIdImageObjectInfo(int idImageObjectInfo) {
        this.idImageObjectInfo = idImageObjectInfo;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getWing() {
        return wing;
    }

    public void setWing(String wing) {
        this.wing = wing;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getMarriage() {
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
                + "'" + getSize() + "',"
                + "'" + getWing() + "',"
                + "'" + getBackground() + "',"
                + "'" + getStatus() + "',"
                + "'" + getSex() + "',"
                + getNumber() + ","
                + "'" + getMarriage() + "'"
                + ");";
        return modifyingQuery(query);
    }

    public boolean delete(int idImageObjectInfo) {
        String query = "delete from ImageObjectInfo where idImageObjectInfo = " + idImageObjectInfo;
        return modifyingQuery(query);
    }

    public boolean update(int idImageObjectInfo) {
        String query = "update ImageObjectInfo set "
                + "size='" + getSize() + "'"
                + ",wing='" + getWing() + "'"
                + ",background='" + getBackground() + "'"
                + ",status='" + getStatus() + "'"
                + ",sex='" + getSex() + "'"
                + ",number=" + getNumber()
                + ",marriage='" + getMarriage() + "'"
                + " where idImageObjectInfo = " + idImageObjectInfo;
        return modifyingQuery(query);
    }

    public int getIdImageObjectInfoFromDB() {
        String query = "select idImageObjectInfo from ImageObjectInfo where "
                + "size='" + getSize() + "'"
                + " and wing='" + getWing() + "'"
                + " and background='" + getBackground() + "'"
                + " and status='" + getStatus() + "'"
                + " and sex='" + getSex() + "'"
                + " and number=" + getNumber()
                + " and marriage='" + getMarriage() + "'";
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
