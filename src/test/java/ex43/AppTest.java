package ex43;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    String html = "src/main/java/ex34/website/test";
    String name = "test";
    String Author = "tester";
    @Test
    void createDirectory() {
        String expected_dir = "Created ./website/test";
        assertEquals(expected_dir, App.createDirectory(html,name));
    }

    @Test
    void index() {
        String expected_index = "Created ./website/test/index.html";
        assertEquals(expected_index, App.index(html,name,Author));
    }

    @Test
    void java() {
        String expected_java = "Created ./website/test/js/";
        assertEquals(expected_java, App.Java(name, html));
    }

    @Test
    void CSS() {
        String expected_css = "Created ./website/test/css/";
        assertEquals(expected_css,App.CSS(name, html));
    }
}