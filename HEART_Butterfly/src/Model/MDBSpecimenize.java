package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MDBSpecimenize extends MDatabase {
    int idSpecimenize;
    int idSpecimen;         // not null
    int idPerson;
    String date;            //varchar(11)
    String anticepticName;  //varchar(45)
    String embalmingDate;   //varchar(11)

    public void initialize() {
        this.idSpecimen = 0;
        this.idPerson = 0;
        this.date = null;
        this.anticepticName = null;
        this.embalmingDate = null;
    }

    public MDBSpecimenize(Connection connection) {
        this.connection = connection;
        this.table_name = "Specimenize";
        initialize();
    }

    public int getIdSpecimenize_integer() {
        return idSpecimenize;
    }

    public String getIdSpecimenize() {
        if(idSpecimenize == 0)
            return null;
        else
            return String.valueOf(idSpecimenize);
    }

    public void setIdSpecimenize(int idSpecimenize) {
        this.idSpecimenize = idSpecimenize;
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

    public String getAnticepticName() {
        if(anticepticName == null || anticepticName.length() == 0) return null;
        return anticepticName;
    }

    public void setAnticepticName(String anticepticName) {
        this.anticepticName = anticepticName;
    }

    public String getEmbalmingDate() {
        if(embalmingDate == null || embalmingDate.length() == 0) return null;
        return embalmingDate;
    }

    public void setEmbalmingDate(String embalmingDate) {
        this.embalmingDate = embalmingDate;
    }

    public void printContents() {
        logger.info("[" + this.table_name + "]");
        logger.info("[idSpecimenize] " + idSpecimenize);
        logger.info("[idSpecimen] " + idSpecimen);
        logger.info("[idPerson] " + idPerson);
        logger.info("[date] " + date);
        logger.info("[anticepticName] " + anticepticName);
        logger.info("[embalmingDate] " + embalmingDate);
    }

    public boolean insert() {
        String query = "insert into Specimenize (idSpecimen, idPerson, date, anticepticName, embalmingDate) values ("
                + db_string_formatting(getIdSpecimen(), "int") + ","
                + db_string_formatting(getIdPerson(), "int") + ","
                + db_string_formatting(getDate(), "string") + ","
                + db_string_formatting(getAnticepticName(), "int") + ","
                + db_string_formatting(getEmbalmingDate(), "int")
                + ");";
        return modifyingQuery(query);
    }

    public boolean delete(int idSpecimenize) {
        String query = "delete from Specimenize where idSpecimenize = " + idSpecimenize;
        return modifyingQuery(query);
    }

    public boolean update(int idSpecimenize) {
        String query = "update Specimenize set ";
        int initial_length = query.length();
        query += db_update_formatting(db_string_formatting(getIdSpecimen(), "int"), "idSpecimen");
        query += db_update_formatting(db_string_formatting(getIdPerson(), "string"), "idPerson");
        query += db_update_formatting(db_string_formatting(getDate(), "string"), "date");
        query += db_update_formatting(db_string_formatting(getAnticepticName(), "string"), "anticepticName");
        query += db_update_formatting(db_string_formatting(getEmbalmingDate(), "string"), "embalmingDate");
        if(query.length() == initial_length) return false;
        query = query.substring(0, query.length()-1);   // Delete last comma
        query += " where idSpecimenize = " + idSpecimenize;
        return modifyingQuery(query);
    }

    public int getIdSpecimenizeFromDB() {
        String query = "select idSpecimenize from Specimenize where "
                + db_where_formatting(db_string_formatting(getIdSpecimen(), "int"), "idSpecimen") + " and "
                + db_where_formatting(db_string_formatting(getIdPerson(), "int"), "idPerson") + " and "
                + db_where_formatting(db_string_formatting(getDate(), "String"), "date") + " and "
                + db_where_formatting(db_string_formatting(getAnticepticName(), "String"), "anticepticName") + " and "
                + db_where_formatting(db_string_formatting(getEmbalmingDate(), "String"), "embalmingDate");
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

    public boolean changeID(int id_before, int id_after) {
        String query = "update ButterflyGuide set idButterflyGuide=" + id_after
                + " where idButterflyGuide="
                + id_before;
        return modifyingQuery(query);
    }

    @Override
    public int getIDFromDB() {
        return getIdSpecimenizeFromDB();
    }
}
