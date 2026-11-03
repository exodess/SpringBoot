package com.example.lw3;

public class FlightInfo {

    private int id;
    private String from;
    private String to;
    private String gate;

    public FlightInfo() {}

    public FlightInfo(int id, String from, String to, String gate) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.gate = gate;
    }

    public int getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getGate() {
        return gate;
    }
}
