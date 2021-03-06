package com.irs.exceptions;

public class ReportNotUpdatedException extends RuntimeException {
    public ReportNotUpdatedException(String error) {
        super(error);
    }
}
