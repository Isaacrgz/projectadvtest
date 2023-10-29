package domain;

public class Client {
    private int idClient;
    private String clave;
    private String razonSocial;
    private String rfc;
    
    public Client() {
    }
    public Client(int idClient) {
        this.idClient = idClient;
    }
    public Client(String clave, String razonSocial, String rfc) {
        this.clave = clave;
        this.razonSocial = razonSocial;
        this.rfc = rfc;
    }
    public Client(int idClient, String clave, String razonSocial, String rfc) {
        this.idClient = idClient;
        this.clave = clave;
        this.razonSocial = razonSocial;
        this.rfc = rfc;
    }

    public int getIdClient() {
        return idClient;
    }
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }
    public String getRazonSocial() {
        return razonSocial;
    }
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
    public String getRfc() {
        return rfc;
    }
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    @Override
    public String toString() {
        return "Client [idClient=" + idClient + ", clave=" + clave +", razonSocial=" + razonSocial + ", rfc=" + rfc + "]";
    }
}
