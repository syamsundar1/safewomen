package com.safewomen.SafeWomen.Response;

public class LoginMessage {
    String message;
    boolean status;

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "LoginMessage{" +
                "message='" + message + '\'' +
                ", status=" + status +
                '}';
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LoginMessage() {
    }

    public LoginMessage(String message, boolean status) {
        this.message = message;
        this.status = status;
    }
}
