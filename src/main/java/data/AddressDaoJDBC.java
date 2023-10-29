package data;

import java.sql.*;
import java.util.*;

import domain.Address;
import domain.Client;

public class AddressDaoJDBC {

    private static final String SQL_SELECT = "SELECT id_address, calle, colonia, id_client FROM address";
    private static final String SQL_SELECT_BY_ID = "SELECT id_address, calle, colonia, id_client FROM address WHERE id_client=?";
    private static final String SQL_SELECT_BY_IDA = "SELECT id_address, calle, colonia, id_client FROM address WHERE id_address=?";
    private static final String SQL_INSERT = "INSERT INTO address(calle, colonia, id_client) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE address SET calle=?, colonia=?, id_client=? WHERE id_address=?";
    private static final String SQL_DELETE = "DELETE FROM address WHERE id_address=?";

    public List<Address> list(Client client) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Address address = null;
        List<Address> addresses = new ArrayList<>();

        try {
            conn = ConnectionSQL.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, client.getIdClient());
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idAddress = rs.getInt("id_address");
                String calle = rs.getString("calle");
                String colonia = rs.getString("colonia");
                String idClientForeign = rs.getString("id_client");

                address = new Address(idAddress, calle, colonia, idClientForeign);
                addresses.add(address);
            }
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            ConnectionSQL.close(rs);
            ConnectionSQL.close(stmt);
            ConnectionSQL.close(conn);
        }

        return addresses;
    }

    public Address find(Address address) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionSQL.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_IDA);
            stmt.setInt(1, address.getIdAddress());
            rs = stmt.executeQuery();
            rs.next(); 

            System.out.println(rs + "----------------------------------3");

            String calle = rs.getString("calle");
            String colonia = rs.getString("colonia");
            String idClient = rs.getString("id_client");

            address.setCalle(calle);
            address.setColonia(colonia);
            address.setIdClientForeign(idClient);
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            ConnectionSQL.close(rs);
            ConnectionSQL.close(stmt);
            ConnectionSQL.close(conn);
        }

        return address;
    }

    public int insert(Address address) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = ConnectionSQL.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, address.getCalle());
            stmt.setString(2, address.getColonia());
            stmt.setString(3, address.getIdClientForeign());

            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            ConnectionSQL.close(stmt);
            ConnectionSQL.close(conn);
        }

        return rows;
    }

    public int update(Address address) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = ConnectionSQL.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, address.getCalle());
            stmt.setString(2, address.getColonia());
            stmt.setString(3, address.getIdClientForeign());
            stmt.setInt(4, address.getIdAddress());

            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            ConnectionSQL.close(stmt);
            ConnectionSQL.close(conn);
        }

        return rows;
    }

    public int delete(Address address) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = ConnectionSQL.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, address.getIdAddress());

            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            ConnectionSQL.close(stmt);
            ConnectionSQL.close(conn);
        }

        return rows;
    }
}
