package leo.luz.com;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import leo.luz.com.sorts.Sort;

public class BubbleSortTest {

    @Test
    public void shouldSortArray() {
        int[] array = { 23, 43, 423, 1, 23, 33, 11, 15, 2222, 4 };
        Sort.Bubble(array);
        assertEquals("[1, 4, 11, 15, 23, 23, 33, 43, 423, 2222]", Arrays.toString(array));
    }
}
