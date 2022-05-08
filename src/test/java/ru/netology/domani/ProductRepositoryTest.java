package ru.netology.domani;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book book1 = new Book();


    // добавление в репо
    @Test
    public void shouldAddOneItem() {
        repository.add(book1);
        Product[] expected = new Product[]{book1};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    // удаление из репо по id
    @Test
    public void shouldRemoveId() {
        Product book1 = new Book(1, "Тестирование ПО", 1000, "Святослав Куликов");

        Product[] expected = new Product[0];
        repository.add(book1); // добавляем наш товар

        repository.removeId(1);
        assertArrayEquals(expected, repository.findAll());
    }

}