package ru.netology.domani;

public class ProductRepository {
    Product[] products = new Product[0];

    // конструкторы

    public ProductRepository() {
    }

    public ProductRepository(Product[] products) {
        this.products = products;
    }

    // геттеры и сеттеры

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    // сохранение в репо

    public void add(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    // получение репо

    public Product[] findAll () {
        return getProducts();
    }

    // удаление по id

    public void removeId (int id) {
        Product[] tmp = new Product[products.length - 1];
        int i = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[i] = product;
                i++;
            }
        }
        products = tmp;
    }
}
