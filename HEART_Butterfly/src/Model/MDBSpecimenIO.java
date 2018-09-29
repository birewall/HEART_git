package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MDBSpecimenIO extends MDatabase {
    int idSpecimenIO;
    int idSpecimen; // not null
    int idGiver;
    int idTaker;
    String date;    //varchar(11)
    int cost;

    public void initialize() {
        this.idSpecimen = 0;
        this.idGiver = 0;
        this.idTaker = 0;
        this.date = null;
        this.cost = 0;
    }

    public MDBSpecimenIO(Connection connection) {
        this.connection = connection;
        this.table_name = "SpecimenIO";
        initialize();
    }

    public String getIdSpecimenIO() {
        if(idSpecimenIO == 0)
            return null;
        else
            return String.valueOf(idSpecimenIO);
    }

    public int getIdSpecimenIO_integer() {
        return idSpecimenIO;
    }

    public void setIdSpecimenIO(int idSpecimenIO) {
        this.idSpecimenIO = idSpecimenIO;
    }

    public String getIdSpecimen() {
        if(idSpecimen == 0)
            return null;
        else
            return String.valueOf(idSpecimen);
    }

    public void setIdSpecimen(int idSpecimen) {
        this.idSpecimen = idSpecimen;
    }

    public String getIdGiver() {
        if(idGiver == 0)
            return null;
        else
            return String.valueOf(idGiver);
    }

    public void setIdGiver(int idGiver) {
        this.idGiver = idGiver;
    }

    public String getIdTaker() {
        if(idTaker == 0)
            return null;
        else
            return String.valueOf(idTaker);
    }

    public void setIdTaker(int idTaker) {
        this.idTaker = idTaker;
    }

    public String getDate() {
        if(date == null || date.length() == 0) return null;
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCost() {
        if(cost == 0)
            return null;
        else
            return String.valueOf(cost);
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void printContents() {
        logger.info("[" + this.table_name + "]");
        logger.info("[idSpecimenIO] " + idSpecimenIO);
        logger.info("[idSpecimen] " + idSpecimen);
        logger.info("[idGiver] " + idGiver);
        logger.info("[idTaker] " + idTaker);
        logger.info("[date] " + date);
        logger.info("[cost] " + cost);
    }

    public boolean insert() {
        String query = "insert into SpecimenIO (idSpecimen, idGiver, idTaker, date, cost) values ("
                + db_string_formatting(getIdSpecimen(), "int") + ","
                + db_string_formatting(getIdGiver(), "int") + ","
                + db_string_formatting(getIdTaker(), "int") + ","
                + db_string_formatting(getDate(), "string") + ","
                + db_string_formatting(getCost(), "int")
                + ");";
        return modifyingQuery(query);
    }

    public boolean delete(int idSpecimenIO) {
        String query = "delete from SpecimenIO where idSpecimenIO = " + idSpecimenIO;
        return modifyingQuery(query);
    }

    public boolean update(int idSpecimenIO) {
        String query = "update SpecimenIO set ";
        int initial_length = query.length();
        query += db_update_formatting(db_string_formatting(getIdSpecimen(), "int"), "idSpecimen");
        query += db_update_formatting(db_string_formatting(getIdGiver(), "int"), "idGiver");
        query += db_update_formatting(db_string_formatting(getIdTaker(), "int"), "idTaker");
        query += db_update_formatting(db_string_formatting(getDate(), "string"), "date");
        query += db_update_formatting(db_string_formatting(getCost(), "int"), "cost");
        if(query.length() == initial_length) return false;
        query = query.substring(0, query.length()-1);   // Delete last comma
        query += " where idSpecimenIO = " + idSpecimenIO;
        return modifyingQuery(query);
    }

    public int getIdSpecimenIOFromDB() {
        String query = "select idSpecimenIO from SpecimenIO where "
                + db_where_formatting(db_string_formatting(getIdSpecimen(), "int"), "idSpecimen") + " and "
                + db_where_formatting(db_string_formatting(getIdGiver(), "int"), "idGiver") + " and "
                + db_where_formatting(db_string_formatting(getIdTaker(), "int"), "idTaker") + " and "
                + db_where_formatting(db_string_formatting(getDate(), "String"), "date") + " and "
                + db_where_formatting(db_string_formatting(getCost(), "String"), "cost");
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
        return getIdSpecimenIOFromDB();
    }
}
