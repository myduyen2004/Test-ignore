package com.demo;

/**
 *
 * @author admin
 */
public interface Configuration {
    public static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=JobTransnew;encrypt=true;trustServerCertificate=true";
    public static String user = "sa";
    public static String pass = "1";
    public static String templatePath = null ;
}

