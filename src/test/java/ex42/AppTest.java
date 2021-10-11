package ex42;

import ex41.App;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    List<String> names = Arrays.asList("Ling, Mai", "Johnson, Jim","Zarnecki, Sabrina","Jones, Chris","Jones, Aaron","Swift, Geoffrey","Xiong, Fong");

    @Test
    void split_String() {
        String[] lastNameExp = {"Ling","Johnson","Zarnecki","Jones","Jones","Swift","Xiong"};
        assertArrayEquals(lastNameExp, ex42.App.split_String(names, 0));
        String[] firstNameExp = {"Mai", "Jim", "Sabrina","Chris", "Aaron", "Geoffrey", "Fong"};
        assertArrayEquals(firstNameExp, ex42.App.split_String(names, 1));

    }
}