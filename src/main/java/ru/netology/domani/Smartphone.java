package ru.netology.domani;

public class Smartphone extends Product {
    protected String manufacturer;

    // конструкторы

    public Smartphone() {
    }

    public Smartphone(int id, String title, int price, String manufacturer) {
        super(id, title, price);
        this.manufacturer = manufacturer;
    }

    // геттеры и сеттеры

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }


}
