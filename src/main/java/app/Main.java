package app;

import app.services.DBEngine;

public class Main {

    public static void main(String[] args) {
        System.out.println(new DBEngine().isConnected());
    }

}
