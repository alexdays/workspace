package client.entity;

public class UpdateRequestInformation {

    private String constant;

    private String temp;

    private String newTemp;

    public UpdateRequestInformation() {
    }

    public UpdateRequestInformation(String constant, String temp, String newTemp) {
        this.constant = constant;
        this.temp = temp;
        this.newTemp = newTemp;
    }

    public String getConstant() {
        return constant;
    }

    public void setConstant(String constant) {
        this.constant = constant;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getNewTemp() {
        return newTemp;
    }

    public void setNewTemp(String newTemp) {
        this.newTemp = newTemp;
    }
}
