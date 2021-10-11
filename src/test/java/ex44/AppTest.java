package ex44;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void ask_user() {
        //cannot test given asks for input
    }

    @Test
    void compare() {
        int test = 1;
        String[] test_string = {"Widget","Thing","Doodad"};
        assertEquals(test, App.compare(test_string, "Thing"));
        int test2 = -1;
        assertEquals(test2, App.compare(test_string, "iPhone"));
    }
}