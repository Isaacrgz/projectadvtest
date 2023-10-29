package data;

import java.sql.*;
import java.util.*;

import domain.Client;

public class ClientDaoJDBC {
    private static final String SQL_SELECT = "SELECT id_client, clave, razon_social, rfc FROM clients";
    private static final String SQL_SELECT_BY_ID = "SELECT id_client, clave, razon_social, rfc FROM clients WHERE id_client=?";
    private static final String SQL_INSERT = "INSERT INTO clients(clave, razon_social, rfc) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE clients SET clave=?, razon_social=?, rfc=? WHERE id_client=?";
    private static final String SQL_DELETE = "DELETE FROM clients WHERE id_client=?";

    public List<Client> list() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Client client = null;
        List<Client> clients = new ArrayList<>();

        try {
            conn = ConnectionSQL.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                int idClient = rs.getInt("id_client");
                String clave = rs.getString("clave");
                String razonSocial = rs.getString("razon_social");
                String rfc = rs.getString("rfc");

                client = new Client(idClient, clave, razonSocial, rfc);
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            ConnectionSQL.close(rs);
            ConnectionSQL.close(stmt);
            ConnectionSQL.close(conn);
        }

        return clients;
    }

    public Client find(Client client) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionSQL.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, client.getIdClient());
            rs = stmt.executeQuery();
            rs.next(); 

            String clave = rs.getString("clave");
            String razonSocial = rs.getString("razon_social");
            String rfc = rs.getString("rfc");

            client.setClave(clave);
            client.setRazonSocial(razonSocial);
            client.setRfc(rfc);
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            ConnectionSQL.close(rs);
            ConnectionSQL.close(stmt);
            ConnectionSQL.close(conn);
        }

        return client;
    }

    public int insert(Client client) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = ConnectionSQL.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, client.getClave());
            stmt.setString(2, client.getRazonSocial());
            stmt.setString(3, client.getRfc());

            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            ConnectionSQL.close(stmt);
            ConnectionSQL.close(conn);
        }

        return rows;
    }

    public int update(Client client) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = ConnectionSQL.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, client.getClave());
            stmt.setString(2, client.getRazonSocial());
            stmt.setString(3, client.getRfc());
            stmt.setInt(4, client.getIdClient());

            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            ConnectionSQL.close(stmt);
            ConnectionSQL.close(conn);
        }

        return rows;
    }

    public int delete(Client client) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = ConnectionSQL.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, client.getIdClient());

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
