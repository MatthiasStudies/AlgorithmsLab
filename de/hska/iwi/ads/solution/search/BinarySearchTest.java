package de.hska.iwi.ads.solution.search;

import de.hska.iwi.ads.search.Search;
import de.hska.iwi.ads.search.SearchTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BinarySearchTest extends SearchTest {
    @Override
    public <E extends Comparable<E>> Search<E> createSearch() {
        return new BinarySearch<E>();
    }

    @Test
    void testSearchIntArrayIntOutOfBounds2() {
        Integer [] a = {0, 1, 2, 3, 4, 5};
        Search<Integer> search = createSearch();
        assertThrows(ArrayIndexOutOfBoundsException.class , () -> search.search(a, 2, 7, 5) );
    }

    @Test
    void testSearchStringArrayStringNull() {
        String [] a = null;
        Search<String> search = createSearch();
        assertThrows(NullPointerException.class , () -> search.search(a, "a", 0, 1) );
    }

    @Test
    void testSearchStringArrayStringOutOfBounds() {
        String [] a = {"a", "b", "c", "d", "e"};
        Search<String> search = createSearch();
        assertThrows(ArrayIndexOutOfBoundsException.class , () -> search.search(a, "a", 0, 5) );
    }

    @Test
    void testSearchLeftEqRightKeySmallerLeft() {
        Integer [] a = {0, 1, 2, 3, 4, 5};
        Search<Integer> search = createSearch();

        assertEquals(1, search.search(a, -1, 2, 2));
    }
}
