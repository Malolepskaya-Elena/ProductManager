package ru.netology.domani;

public class Book extends Product {
    protected String author;

    // конструкторы
    public Book() {
    }

    public Book(int id, String title, int price, String author) {
        super(id, title, price);
        this.author = author;
    }

    // геттеры и сеттеры
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


}
