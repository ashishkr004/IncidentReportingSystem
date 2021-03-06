package com.irs.exceptions;

public class ReportNotCreatedException extends RuntimeException  {
    public ReportNotCreatedException(String error) {
        super(error);
    }
}
