import engine.Engine;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class EngineTest {
    @Test
    public void testNormalUserCase() throws IOException {
        Engine engine = Engine.normal();
        String actualResult = engine.render(getMap1());
        writeToFile(actualResult, "actualResultPage1.html");
        assertEquals(readFromFile("expectedResultPage1.html"), actualResult);
    }

    @Test
    public void testAdminUserCase() throws IOException {
        Engine engine = Engine.normal();
        String actualResult = engine.render(getMap2());
        writeToFile(actualResult, "actualResultPage2.html");
        assertEquals(readFromFile("expectedResultPage2.html"), actualResult);
    }

    @Test
    public void testNoUserCase() throws IOException {
        Engine engine = Engine.normal();
        String actualResult = engine.render(getMap3());
        writeToFile(actualResult, "actualResultPage3.html");
        assertEquals(readFromFile("expectedResultPage3.html"), actualResult);
    }

    @Test
    public void testOriginalPage() throws IOException {
        Engine engine = Engine.tagStripping();
        String page = engine.render(new HashMap<>());
        assertEquals(readFromFile( "originalPage.html"), page);
    }

    private String readFromFile(String filename) throws IOException {
        return Files.readString(Path.of(filename));
    }

    private void writeToFile(String page, String fileName) throws FileNotFoundException {
        try (PrintStream printStream = new PrintStream(fileName)) {
            printStream.print(page);
        }
    }

    private HashMap<String, Object> getMap1() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("title", "Awesome page");
        Cart cart = new Cart();
        cart.items.add(new Item("Books", 5, 2.34));
        cart.items.add(new Item("Pens", 10, 0.23));
        cart.items.add(new Item("Laptop", 1, 232.12));
        map.put("cart", cart);
        map.put("user", new User("Haris", "Skiadas", false));
        return map;
    }

    private HashMap<String, Object> getMap2() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("title", "Another awesome page");
        Cart cart = new Cart();
        map.put("cart", cart);
        map.put("user", new User("Haris", "Skiadas", true));
        return map;
    }

    private HashMap<String, Object> getMap3() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("title", "Awesome page");
        Cart cart = new Cart();
        cart.items.add(new Item("Books", 10, 2.34));
        cart.items.add(new Item("Laptop", 1, 232.12));
        map.put("cart", cart);
        map.put("user", null);
        return map;
    }
}
