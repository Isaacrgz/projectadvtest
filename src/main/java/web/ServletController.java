package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import data.AddressDaoJDBC;
import data.ClientDaoJDBC;
import domain.Address;
import domain.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/ServletController")
public class ServletController extends HttpServlet {
    
    private int idClientCurrent;
    private String globalClave;
    private List<String> claveList; 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "listarA":
                    this.listarAddress(request, response);
                    break;
                case "editA":
                    this.editAddress(request, response);
                    break;
                case "editC":
                    this.editClient(request, response);
                    break;
                case "deleteA":
                    this.deleteAddress(request, response);
                    break;
                case "deleteC":
                    this.deleteClient(request, response);
                    break;
                default:
                    this.defaultAction(request, response);
                    break;
            }
        } else {
            this.defaultAction(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "insertA":
                    this.insertAddress(request, response);
                    break;
                case "insertC":
                    this.insertClient(request, response);
                    break;
                case "modifyA":
                    this.modifyAddress(request, response);
                    break;
                case "modifyC":
                    this.modifyClient(request, response);
                    break;
                default:
                    this.defaultAction(request, response);
                    break;
            }
        } else {
            this.defaultAction(request, response);
        }
    }

    private void defaultAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Client> clients = new ClientDaoJDBC().list();
        claveList = new ArrayList<>();
        for (Client client : clients) {
            claveList.add(client.getClave());
        }
        HttpSession session = request.getSession();
        session.setAttribute("clients", clients);
        response.sendRedirect("clients.jsp");
    }

    private void listarAddress(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int idClient = Integer.parseInt(request.getParameter("idClient"));
        HttpSession session = request.getSession();
        if (idClient == 0){

            session.setAttribute("mensaje", "Selecciona un cliente primero");
        } else {
            idClient = Integer.parseInt(request.getParameter("idClient"));
            idClientCurrent = idClient;
            globalClave = request.getParameter("clave");
            System.out.println(globalClave + "----------------------------- FLAG 2");
            Client client = new Client(idClient);
            List<Address> addresses = new AddressDaoJDBC().list(client);
            session.setAttribute("mensaje", globalClave);
            session.setAttribute("addresses", addresses);
        }
        this.defaultAction(request, response);
    }

    /* AQUI EMPIEZA LOS METODOS PARA LOS CLIENTES */

    private void insertClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String razonSocial = request.getParameter("razonSocial");
        String rfc = request.getParameter("rfc");
        String clave = request.getParameter("clave");
        boolean rep = false;
        if (!claveList.isEmpty()) {
            for (String st : claveList) {
                if (clave.equals(st)) {
                    rep = true;
                    request.setAttribute("mensajeC", "Ya exite la clave");
                }
            }   
            if (!rep) {
                    Client client = new Client(clave, razonSocial, rfc);
                    int modifiedRegisters = new ClientDaoJDBC().insert(client);
                    System.out.println("Modified registers: " + modifiedRegisters);
                }
        } else {
            Client client = new Client(clave, razonSocial, rfc);
            int modifiedRegisters = new ClientDaoJDBC().insert(client);
            System.out.println("Modified registers: " + modifiedRegisters);
        }

        this.defaultAction(request, response);
    }

    private void modifyClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idClient = Integer.parseInt(request.getParameter("idClient"));
        String razonSocial = request.getParameter("razonSocial");
        String rfc = request.getParameter("rfc");
        String clave = request.getParameter("clave");

        Client client = new Client(idClient, clave, razonSocial, rfc);

        int modifiedRegisters = new ClientDaoJDBC().update(client);
        System.out.println("Modified registers: " + modifiedRegisters);

        this.defaultAction(request, response);
    }

    private void deleteClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idClient = Integer.parseInt(request.getParameter("idClient"));

        Client client = new Client(idClient);

        int modifiedRegisters = new ClientDaoJDBC().delete(client);
        System.out.println("Modified registers: " + modifiedRegisters);

        this.defaultAction(request, response);
    }

    private void editClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idClient = Integer.parseInt(request.getParameter("idClient"));
        Client client = new ClientDaoJDBC().find(new Client(idClient));
        request.setAttribute("client", client);
        String stgEditClient = "/WEB-INF/pages/client/editClient.jsp";
        request.getRequestDispatcher(stgEditClient).forward(request, response);
    }

    /* AQUI INICIA LOS METODOS PARA LAS DIRECCIONES */

    private void insertAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String calle = request.getParameter("calle");
        String colonia = request.getParameter("colonia");
        String idClientForeign = String.valueOf(idClientCurrent);

        Address address = new Address(calle, colonia, idClientForeign);

        int modifiedRegisters = new AddressDaoJDBC().insert(address);
        System.out.println("Modified registers: " + modifiedRegisters);
        this.listarAddress2(request, response);
    }

    private void listarAddress2(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int idClient = idClientCurrent;
        HttpSession session = request.getSession();
        /* if (idClient == 0){

            session.setAttribute("mensaje", "Selecciona un cliente primero");
        } else {
            Client client = new Client(idClient);
            List<Address> addresses = new AddressDaoJDBC().list(client);
            session.setAttribute("mensaje", request.getParameter("clave"));
            session.setAttribute("addresses", addresses);
        } */
        Client client = new Client(idClient);
        List<Address> addresses = new AddressDaoJDBC().list(client);
        session.setAttribute("mensaje", globalClave);
        session.setAttribute("addresses", addresses);

        this.defaultAction(request, response);
    }


    private void modifyAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idAddress = Integer.parseInt(request.getParameter("idAddress"));
        String calle = request.getParameter("calle");
        String colonia = request.getParameter("colonia");
        String idClientForeign = Integer.toString(idClientCurrent);

        Address address = new Address(idAddress, calle, colonia, idClientForeign);

        int modifiedRegisters = new AddressDaoJDBC().update(address);
        System.out.println("Modified registers: " + modifiedRegisters);

        this.listarAddress2(request, response);
    }

    private void deleteAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idAddress = Integer.parseInt(request.getParameter("idAddress"));

        Address address = new Address(idAddress);

        int modifiedRegisters = new AddressDaoJDBC().delete(address);
        System.out.println("Modified registers: " + modifiedRegisters);

        this.listarAddress2(request, response);
    }

    private void editAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idAddress = Integer.parseInt(request.getParameter("idAddress"));
        Address address = new AddressDaoJDBC().find(new Address(idAddress));
        request.setAttribute("address", address);
        String stgEditAddress = "/WEB-INF/pages/address/editAddress.jsp";
        request.getRequestDispatcher(stgEditAddress).forward(request, response);
    }
}
