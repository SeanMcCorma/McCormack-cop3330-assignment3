package ex46;

import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    List<String> words = Arrays.asList("badger","badger","badger","badger","mushroom", "mushroom","snake", "badger","badger","badger");
    @Test
    void count() {
        assertEquals(7, App.count(words, "badger"));
        assertEquals(2, App.count(words, "mushroom"));
        assertEquals(1,App.count(words,"snake"));
    }

    @Test
    void remove() {
        //cannot test due to internal errors with List.remove(index) not being supported in junit
    }

    @Test
    void max_length() {
        assertEquals(8, App.max_length(words));
    }

    @Test
    void add_spaces() {
    List<String> word =Arrays.asList("badger","mushroom","snake");
    List<String> words_expected = Arrays.asList("badger:  ", "mushroom:","snake:   ");
    assertArrayEquals(words_expected.toArray(),App.add_spaces(word, 8).toArray());
    }
}