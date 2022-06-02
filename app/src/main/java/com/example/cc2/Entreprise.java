package com.example.cc2;

public class Entreprise {

    private int id;
    private String RaisonSoc;
    private String Adresse;
    private double Capital;

    public Entreprise(int id, String raisonSoc, String adresse, double capital) {
        this.id = id;
        RaisonSoc = raisonSoc;
        Adresse = adresse;
        Capital = capital;
    }

    public Entreprise() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRaisonSoc() {
        return RaisonSoc;
    }

    public void setRaisonSoc(String raisonSoc) {
        RaisonSoc = raisonSoc;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public double getCapital() {
        return Capital;
    }

    public void setCapital(double capital) {
        Capital = capital;
    }
}
