package com.irs.exceptions;

public class ReportNotFoundException extends RuntimeException {
    public ReportNotFoundException(String error) {
        super(error);
    }
}
