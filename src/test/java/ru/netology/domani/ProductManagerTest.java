package ru.netology.domani;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    @Test            // тест на добавление двух товаров в пустое репо
    void addEmptyRepository() {
        Product book1 = new Book(1, "Тестирование ПО", 1000, "Святослав Куликов");
        Product smartphone1 = new Smartphone(2, "Galaxy S22", 150_000, "Samsung");
        Product[] expected = new Product[] {book1, smartphone1};

        ProductManager manager = new ProductManager();

        manager.add(book1);
        manager.add(smartphone1);

        assertArrayEquals(expected, manager.findAll());
    }

    @Test     // тест на удаление единственного товара из репо по id
    void removeIdFromRepositoryWithOneProduct() {
        Product book1 = new Book(1, "Тестирование ПО", 1000, "Святослав Куликов");

        Product[] expected = new Product[0];
        ProductManager manager = new ProductManager();
        manager.add(book1); // добавляем наш товар

        manager.removeId(1);
        assertArrayEquals(expected, manager.findAll());
    }

    @Test     // тест на удаление двух товаров из репо по id
    void removeIdFromRepositoryWithTwoProduct() {
        Product book1 = new Book(1, "Тестирование ПО", 1000, "Святослав Куликов");
        Product smartphone1 = new Smartphone(2, "Galaxy S22", 150_000, "Samsung");
        Product[] expected = new Product[0];
        ProductManager manager = new ProductManager();
        manager.add(book1);
        manager.add(smartphone1);// добавляем наш товар

        manager.removeId(1);
        manager.removeId(2);
        assertArrayEquals(expected, manager.findAll());
    }

    // тест на поиск по названию с одиночным результатом
    @Test
    void searchByOneResult () {
        Product book1 = new Book(1, "Тестирование ПО", 1000, "Святослав Куликов");
        Product smartphone1 = new Smartphone(2, "Galaxy S22", 150_000, "Samsung");

        Product [] expected = new Product[]{book1};
        ProductManager manager = new ProductManager();
        manager.add(book1);
        manager.add(smartphone1);

        Product [] actual = manager.searchBy("Тестирование"); // поиск регистрозависимый
        assertArrayEquals(expected, actual);
    }

    // тест на поиск по несуществующему названию
    @Test
    void searchByNotResult () {
        Product book1 = new Book(1, "Тестирование ПО", 1000, "Святослав Куликов");
        Product smartphone1 = new Smartphone(2, "Galaxy S22", 150_000, "Samsung");

        Product [] expected = new Product[0];
        ProductManager manager = new ProductManager();
        manager.add(book1);
        manager.add(smartphone1);

        Product [] actual = manager.searchBy("Galaxy 100"); // поиск регистрозависимый
        assertArrayEquals(expected, actual);
    }

    // тест на поиск по двум одинаковым названиям
    @Test
    void searchByTwoResult () {
        Product book1 = new Book(1, "Тестирование ПО", 1000, "Святослав Куликов");
        Product smartphone1 = new Smartphone(2, "Galaxy S22", 150_000, "Samsung");
        Product smartphone2 = new Smartphone(3, "Galaxy S22", 200_000, "Samsung");

        Product [] expected = new Product[] {smartphone1, smartphone2};
        ProductManager manager = new ProductManager();
        manager.add(book1);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product [] actual = manager.searchBy("Galaxy S22"); // поиск регистрозависимый
        assertArrayEquals(expected, actual);
    }

}