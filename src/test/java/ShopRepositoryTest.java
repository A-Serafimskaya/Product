import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    Product product1 = new Product(1, "хлеб", 50);
    Product product2 = new Product(2, "сыр", 150);
    Product product3 = new Product(3, "помидор", 30);

    @Test
    public void testRemoveIfAbsent() {
        ShopRepository repo = new ShopRepository();

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(5);
        });

    }

    @Test
    public void testRemove() {
        ShopRepository repo = new ShopRepository();

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.removeById(product3.getId());


        Product[] expected = {product1, product2};
        Product[] actual = repo.getProducts();


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddIfExists() {
        ShopRepository repo = new ShopRepository();

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.add(product3);
        });

    }

    @Test
    public void testAdd() {
        ShopRepository repo = new ShopRepository();

        repo.add(product1);
        repo.add(product2);


        repo.add(product3);


        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.getProducts();


        Assertions.assertArrayEquals(expected, actual);
    }


}
