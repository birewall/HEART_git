package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MDBPerson extends MDatabase {
    int idPerson;
    String name;    //varchar(45) not null
    String sort;    //varchar(5) not null

    public MDBPerson(Connection connection) {
        this.connection = connection;
        this.table_name = "Person";
        initialize();
    }

    public void initialize() {
        this.name = null;
        this.sort = null;
    }

    public String getIdPerson() {
        if(idPerson == 0)
            return null;
        else
            return String.valueOf(idPerson);
    }

    public int getIdPerson_integer() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        if(name == null || name.length() == 0) return null;
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSort() {
        if(sort == null || sort.length() == 0) return null;
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public void printContents() {
        logger.info("[" + this.table_name + "]");
        logger.info("[idPerson] " + idPerson);
        logger.info("[name] " + name);
        logger.info("[sort] " + sort);
    }

    public boolean insert() {
        String query = "insert into Person (name, sort) values ("
                + db_string_formatting(getName(), "string") + ","
                + db_string_formatting(getSort(), "string")
                + ");";
        return modifyingQuery(query);
    }

    public boolean delete(int idPerson) {
        String query = "delete from Person where idPerson = " + idPerson;
        return modifyingQuery(query);
    }

    public boolean update(int idPerson) {
        String query = "update Person set ";
        int initial_length = query.length();
        query += db_update_formatting(db_string_formatting(getName(), "string"), "name");
        query += db_update_formatting(db_string_formatting(getSort(), "string"), "sort");
        if(query.length() == initial_length) return false;
        query = query.substring(0, query.length()-1);   // Delete last comma
        query += " where idPerson = " + idPerson;
        return modifyingQuery(query);
    }

    /* Modified Function */
    public boolean delete_by_type(String type) {
        String query = "delete from Person where sort = '" + type + "'";
        return modifyingQuery(query);
    }

    public int getIdPersonFromDB() {
        String query = "select idPerson from Person where "
                + db_where_formatting(db_string_formatting(getName(), "String"), "name") + " and "
                + db_where_formatting(db_string_formatting(getSort(), "String"), "sort");
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
        return getIdPersonFromDB();
    }
}
