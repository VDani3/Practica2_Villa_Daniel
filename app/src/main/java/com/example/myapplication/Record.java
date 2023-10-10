package com.example.myapplication;

public class Record implements Comparable<Record>{
    private String name;
    private int intents;
    private int temps;

    public Record(String n, int i, int t){
        this.name = n;
        this.intents = i;
        this.temps = t;
    }

    public String getName() {
        return name;
    }

    public int getIntents() {
        return intents;
    }

    public int getTemps() {
        return temps;
    }

    public int compareTo(Record otro) {
        // Comparar por el campo 'intentos' en orden ascendente
        return Integer.compare(this.intents, otro.intents);
    }
}
