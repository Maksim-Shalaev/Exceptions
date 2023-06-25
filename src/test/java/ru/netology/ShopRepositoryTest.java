package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    ShopRepository shopRepository = new ShopRepository();
    Product product1 = new Product(1, "Товар 1", 1000);
    Product product2 = new Product(2, "Товар 2", 1100);
    Product product3 = new Product(3, "Товар 3", 900);
    Product product4 = new Product(4, "Товар 4", 1200);

    @Test
    public void shouldRemoveExistId() {
        ShopRepository shopRepository = new ShopRepository();
        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);
        shopRepository.add(product4);
        shopRepository.remove(1);

        Product[] expected = {product2, product3, product4};
        Product[] actual = shopRepository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeNotExistId() {
        ShopRepository shopRepository = new ShopRepository();
        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);
        shopRepository.add(product4);
        Assertions.assertThrows(NotFoundException.class, () -> shopRepository.remove(11));
    }
}
