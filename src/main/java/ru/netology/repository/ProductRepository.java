package ru.netology.repository;

import ru.netology.product.Product;

public class ProductRepository {

    private Product[] products = new Product[0];

    public void save(Product repo) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = repo;
        products = tmp;
    }

    public Product[] findAll() {
        return products;
    }

    public Product findById(int id) {
        for (Product repo : products) {
            if (repo.getId() == id) {
                return repo;
            }
        }
        return null;
    }

    public void removeById(int id) {
        Product[] tmp = new Product[products.length - 1];
        int copy = 0;
        for (Product repo : products) {
            if (repo.getId() != id) {
                tmp[copy] = repo;
                copy++;
            }
        }
        products = tmp;
        }

}
