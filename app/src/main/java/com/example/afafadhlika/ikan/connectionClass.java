package com.example.afafadhlika.ikan;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionClass {

    String classs = "com.mysql.jdbc.Driver";

    String url = "jdbc:mysql://127.0.0.1/fish";
    String un = "dev";
    String pass = "1234";

    @SuppressLint("NewAPI")
    public Connection CONN() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        String ConnUrl = null;
        try{

            Class.forName(classs);

            conn = DriverManager.getConnection(url,un,pass);

            conn = DriverManager.getConnection(ConnUrl);
        }
        catch (SQLException se) {
            Log.e("ERROR",se.getMessage());
        }
        catch (ClassNotFoundException e) {
            Log.e("ERROR",e.getMessage());
        }
        catch (Exception e) {
            Log.e("ERROR", e.getMessage());
        }
        return conn;
    }

}
