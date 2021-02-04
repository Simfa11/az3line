/**
 * @project AZ
 * @author Remy Ohajinwa
 * Created 03/02/21
 */

package com.example.az.enums;

public enum ResponseCode {

    SUCCESSFUL("00"), FAILED("01");

    private String status;

    ResponseCode(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
