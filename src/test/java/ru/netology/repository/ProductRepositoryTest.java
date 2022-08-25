package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.product.Book;
import ru.netology.product.Product;
import ru.netology.product.Smartphone;

public class ProductRepositoryTest {

    ProductRepository products = new ProductRepository();

    Product element1 = new Book(1, "Басни", 560, "И.Крылов");
    Product element2 = new Book(2, "Ведьмак из большого Киева", 470, "В.Н.Васильев");
    Product element3 = new Book(3, "Тестирование dot COM", 1200, "Р.Савин");
    Product element4 = new Smartphone(4, "Honor 10 lite", 11_000, "Honor");
    Product element5 = new Smartphone(5, "Redmi 9", 14_000, "Xiaomi");
    Product element6 = new Smartphone(6, "iPhone 5S", 45_000, "Apple ");

    @BeforeEach
    public void setup() {
        products.save(element1);
        products.save(element2);
        products.save(element3);
        products.save(element4);
        products.save(element5);
        products.save(element6);

    }

    @Test
    public void ShouldFindAll() {
        Product[] expected = {element1, element2, element3, element4, element5, element6};
        Product[] actual = products.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindById() {
        Product expected = element3;
        Product actual = products.findById(3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByIdNull() {
        Product product = new Product();
        product.setId(11);

        Product expected = null;
        Product actual = products.findById(11);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        ProductRepository products = new ProductRepository();

        products.save(element1);
        products.save(element2);
        products.save(element3);
        products.save(element4);
        products.save(element5);
        products.save(element6);
        products.removeById(element2.getId());


        Product[] expected = {element1, element3, element4, element5, element6};
        Product[] actual = products.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }


}
