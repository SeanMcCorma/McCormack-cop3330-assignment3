package ex41;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    List<String> names = Arrays.asList("Ling, Mai", "Johnson, Jim","Zarnecki, Sabrina","Jones, Chris","Jones, Aaron","Swift, Geoffrey","Xiong, Fong");
//        names.add("Ling, Mai");
//        names.add("Johnson, Jim");
//        names.add("Zarnecki, Sabrina");
//        names.add("Jones, Chris");
//        names.add("Jones, Aaron");
//        names.add("Swift, Geoffrey");
//        names.add("Xiong, Fong");
    @Test
    void split_String() {
        String[] lastNameExp = {"Ling","Johnson","Zarnecki","Jones","Jones","Swift","Xiong"};
        assertArrayEquals(lastNameExp,App.split_String(names, 0));
        String[] firstNameExp = {"Mai", "Jim", "Sabrina","Chris", "Aaron", "Geoffrey", "Fong"};
        assertArrayEquals(firstNameExp, App.split_String(names, 1));
    }

    @Test
    void alpha() {
        String[] first_name = {"Mai", "Jim", "Sabrina","Chris", "Aaron", "Geoffrey", "Fong"};
        String[] last_name = {"Ling","Johnson","Zarnecki","Jones","Jones","Swift","Xiong"};
        List<String> alpha = new ArrayList<>(Arrays.asList("Johnson, Jim","Jones, Aaron","Jones, Chris","Ling, Mai", "Swift, Geoffrey", "Xiong, Fong", "Zarnecki, Sabrina"));
        assertArrayEquals(alpha.toArray(), App.alpha(first_name,last_name).toArray());
    }

    @Test
    void flip() {
        String[] last_name = {"Ling","Johnson","Zarnecki","Jones","Jones","Swift","Xiong"};
        String[] last_name_flip12 = {"Johnson","Ling","Zarnecki","Jones","Jones","Swift","Xiong"};
        assertArrayEquals(last_name_flip12, App.flip(last_name,0,1));
    }

    @Test
    void fill() {
        String[] first_name = {"Mai", "Jim", "Sabrina","Chris", "Aaron", "Geoffrey", "Fong"};
        String[] last_name = {"Ling","Johnson","Zarnecki","Jones","Jones","Swift","Xiong"};
        assertArrayEquals(names.toArray(),App.fill(first_name,last_name).toArray());
    }
}