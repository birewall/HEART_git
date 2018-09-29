package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MDBObservation extends MDatabase {
    int idObservation;
    int idImage;
    int idCollectionInfo;
    String date;    //varchar(11)
    String time;    //varchar(9)
    String sex;     //char(1)
    String status;  //varchar(10)
    int number;

    public void initialize() {
        this.idImage = 0;
        this.idCollectionInfo = 0;
        this.date = null;
        this.time = null;
        this.sex = null;
        this.number = 0;
    }

    public MDBObservation(Connection connection) {
        this.connection = connection;
        this.table_name = "Observation";
        initialize();
    }

    public String getIdObservation() {
        if(idObservation == 0)
            return null;
        else
            return String.valueOf(idObservation);
    }

    public int getIdObservation_integer() {
        return idObservation;
    }

    public void setIdObservation(int idObservation) {
        this.idObservation = idObservation;
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

    public String getIdCollectionInfo() {
        if(idCollectionInfo == 0)
            return null;
        else
            return String.valueOf(idCollectionInfo);
    }

    public void setIdCollectionInfo(int idCollectionInfo) {
        this.idCollectionInfo = idCollectionInfo;
    }

    public String getDate() {
        if(date == null || date.length() == 0) return null;
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        if(time == null || time.length() == 0) return null;
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSex() {
        if(sex == null || sex.length() == 0) return null;
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStatus() {
        if(status == null || status.length() == 0) return null;
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public boolean insert() {
        String query = "insert into Observation (idImage, idCollectionInfo, date, time, sex, status, number) values ("
                + db_string_formatting(getIdImage(), "int") + ","
                + db_string_formatting(getIdCollectionInfo(), "int") + ","
                + db_string_formatting(getDate(), "string") + ","
                + db_string_formatting(getTime(), "string") + ","
                + db_string_formatting(getSex(), "string") + ","
                + db_string_formatting(getStatus(), "string") + ","
                + db_string_formatting(getNumber(), "int")
                + ");";
        return modifyingQuery(query);    }

    public boolean delete(int idObservation) {
        String query = "delete from Observation where idObservation = " + idObservation;
        return modifyingQuery(query);
    }

    public boolean update(int idObservation) {
        String query = "update Observation set ";
        int initial_length = query.length();
        query += db_update_formatting(db_string_formatting(getIdImage(), "int"), "idImage");
        query += db_update_formatting(db_string_formatting(getIdCollectionInfo(), "int"), "idCollectionInfo");
        query += db_update_formatting(db_string_formatting(getDate(), "string"), "date");
        query += db_update_formatting(db_string_formatting(getTime(), "string"), "time");
        query += db_update_formatting(db_string_formatting(getSex(), "string"), "sex");
        query += db_update_formatting(db_string_formatting(getStatus(), "string"), "status");
        query += db_update_formatting(db_string_formatting(getNumber(), "int"), "number");
        if(query.length() == initial_length) return false;
        query = query.substring(0, query.length()-1);   // Delete last comma
        query += " where idObservation = " + idObservation;
        return modifyingQuery(query);
    }

    public int getIdObservationFromDB() {
        String query = "select idObservation from Observation where "
                + db_where_formatting(db_string_formatting(getIdImage(), "int"), "idImage") + " and "
                + db_where_formatting(db_string_formatting(getIdCollectionInfo(), "int"), "idCollectionInfo") + " and "
                + db_where_formatting(db_string_formatting(getDate(), "String"), "date") + " and "
                + db_where_formatting(db_string_formatting(getTime(), "String"), "time") + " and "
                + db_where_formatting(db_string_formatting(getSex(), "String"), "sex") + " and "
                + db_where_formatting(db_string_formatting(getStatus(), "String"), "status") + " and "
                + db_where_formatting(db_string_formatting(getNumber(), "String"), "number");
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
        return getIdObservationFromDB();
    }
}
