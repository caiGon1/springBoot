package br.anhembi.spring02.model;

public class produto {
    private Long cod; //L maiusculo vs minusculo MIN- SIMPLES; MAIS- CLASSE
    private String name;
    private double price;
    public Long getCod() {
        return cod;
    }
    public void setCod(Long cod) {
        this.cod = cod;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    
}
