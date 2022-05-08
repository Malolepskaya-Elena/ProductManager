package ru.netology.domani;

public class ProductManager {
    private ProductRepository repository = new ProductRepository();

    // конструкторы

    public ProductManager() {
    }

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    // геттеры и сеттеры

    public ProductRepository getRepository() {
        return repository;
    }

    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }

    // зависимости от репо
    // добавление в репо

    public void add(Product product) {
        repository.add(product);
    }

    // получение репо

    public Product[] findAll() {
        return repository.findAll();
    }

    // удаление по id

    public void removeId(int id) {
        repository.removeId(id);
    }

    // методы менеджера
    // поиск по id

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    // метод определения соответствия товара product запросу search

    public boolean matches(Product product, String search) {
        if (product.getTitle().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
