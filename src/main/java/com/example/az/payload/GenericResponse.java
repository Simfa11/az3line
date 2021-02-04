package com.example.az.payload;

import java.io.Serializable;

public class GenericResponse<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String status;
    private String statusMessage;
    private T data;
    private int code = 417;

    public GenericResponse() {
    }

    public GenericResponse(String status, String statusMessage, T data, int code) {
        this.status = status;
        this.statusMessage = statusMessage;
        this.data = data;
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
