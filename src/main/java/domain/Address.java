package domain;

public class Address {
    private int idAddress;
    private String calle;
    private String colonia;
    private String idClientForeign;
    
    public Address() {
    }
    public Address(String idClientForeign) {
        this.idClientForeign = idClientForeign;
    }
    public Address(int idAddress) {
        this.idAddress = idAddress;
    }
    public Address(String calle, String colonia, String idClientForeign) {
        this.calle = calle;
        this.colonia = colonia;
        this.idClientForeign = idClientForeign;
    }
    public Address(int idAddress, String calle, String colonia, String idClientForeign) {
        this.idAddress = idAddress;
        this.calle = calle;
        this.colonia = colonia;
        this.idClientForeign = idClientForeign;
    }

    public int getIdAddress() {
        return idAddress;
    }
    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }
    public String getCalle() {
        return calle;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }
    public String getColonia() {
        return colonia;
    }
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }
    public String getIdClientForeign() {
        return idClientForeign;
    }
    public void setIdClientForeign(String idClientForeign) {
        this.idClientForeign = idClientForeign;
    }

    @Override
    public String toString() {
        return "Address [idAddress=" + idAddress + ", calle=" + calle + ", colonia=" + colonia + ", idClientForeign="
                + idClientForeign + "]";
    }        
}
