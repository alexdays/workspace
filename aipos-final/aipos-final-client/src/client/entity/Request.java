package client.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Request {

    public static final int GET_AUTHOR = 1;

    public static final int GET_TITLE = 2;

    public static final int UPDATE_AUTHOR = 3;

    public static final int UPDATE_TITLE = 4;

    private UpdateRequestInformation requestInformation;

    private int type;

    public Request() {
        super();
    }

    public Request(UpdateRequestInformation requestInformation, int type) {
        super();
        this.requestInformation = requestInformation;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public UpdateRequestInformation getRequestInformation() {
        return requestInformation;
    }

    public void setRequestInformation(UpdateRequestInformation requestInformation) {
        this.requestInformation = requestInformation;
    }
}
