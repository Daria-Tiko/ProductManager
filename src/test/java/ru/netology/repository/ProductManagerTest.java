package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.product.Book;
import ru.netology.product.Product;
import ru.netology.product.Smartphone;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product element1 = new Book(1, "Басни", 560, "И.Крылов");
    Product element2 = new Book(2, "Ведьмак из большого Киева", 470, "В.Н.Васильев");
    Product element3 = new Book(3, "Тестирование dot COM", 1200, "Р.Савин");
    Product element4 = new Smartphone(4, "Honor 10 lite", 11_000, "Honor");
    Product element5 = new Smartphone(5, "Redmi 9", 14_000, "Xiaomi");
    Product element6 = new Smartphone(6, "iPhone 5S", 45_000, "Apple ");

    @Test
    public void searchByTextBook() {
        manager.add(element1);
        manager.add(element2);
        manager.add(element3);
        manager.add(element4);
        manager.add(element5);
        manager.add(element6);

        Product[] expected = {element3};
        Product[] actual = manager.searchBy("Тестирование");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void searchByTextSmartphone() {
        manager.add(element1);
        manager.add(element2);
        manager.add(element3);
        manager.add(element4);
        manager.add(element5);
        manager.add(element6);

        Product[] expected = {element6};
        Product[] actual = manager.searchBy("iPhone 5S");

        Assertions.assertArrayEquals(expected, actual);

    }


}





