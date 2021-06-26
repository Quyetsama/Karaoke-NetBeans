import java.io.Serializable;

public class NhaCungCap implements Serializable {
    private String mncc, name, phone, address;

    public NhaCungCap(){}

    public NhaCungCap(String mncc, String name, String phone, String address) {
        this.mncc = mncc;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public void Show(){
        System.out.format("%20s %20s %20s %20s \n", this.mncc, this.name, this.phone, this.address);
    }

    public String getMncc() {
        return mncc;
    }

    public void setMncc(String mncc) {
        this.mncc = mncc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
