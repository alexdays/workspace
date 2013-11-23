package client.controller;

public enum Action {
    ADD("add-book"),
    REMOVE("del-book"),
    GET_AUTHOR("srch-athr"),
    GET_TITLE("srch-ttl"),
    UPDATE_AUTHOR("upd-athr"),
    UPDATE_TITLE("upd-ttl"),
    UNAVAILABLE(""),
    ;
    private final String value;

    private Action(String value) {
        this.value = value;
    }

    public static Action getByValue(String value) {
        for (Action action : Action.values()) {
            if (action.value.equals(value)) {
                return action;
            }
        }
        return UNAVAILABLE;
    }
}
