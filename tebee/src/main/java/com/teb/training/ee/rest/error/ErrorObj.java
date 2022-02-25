package com.teb.training.ee.rest.error;

import java.util.ArrayList;
import java.util.List;

public class ErrorObj {

    private List<ErrorObj> subErrors;
    private String         message;
    private int            errorCode;

    public void addSubError(final ErrorObj errorObjParam) {
        if (this.subErrors == null) {
            this.subErrors = new ArrayList<>();
        }
        this.subErrors.add(errorObjParam);
    }

    public String getMessage() {
        return this.message;
    }

    public ErrorObj setMessage(final String messageParam) {
        this.message = messageParam;
        return this;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public ErrorObj setErrorCode(final int errorCodeParam) {
        this.errorCode = errorCodeParam;
        return this;
    }

    public List<ErrorObj> getSubErrors() {
        return this.subErrors;
    }

    public void setSubErrors(final List<ErrorObj> subErrorsParam) {
        this.subErrors = subErrorsParam;
    }

}
