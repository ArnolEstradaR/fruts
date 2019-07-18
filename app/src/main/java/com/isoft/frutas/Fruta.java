package com.isoft.frutas;

public class Fruta {
    public long id;
    public String name, description;
    public int quantity;
    public Fruta(String name,String description, int quantity)
    {
        this.name=name;
        this.description=description;
        this.quantity=quantity;
    }
}