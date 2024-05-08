package de.hska.iwi.ads.solution.sorting;

import de.hska.iwi.ads.sorting.Sort;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

import static org.junit.jupiter.api.Assertions.assertSame;

public abstract class StableSortTest extends SortTest{
    @Test
    void testStableSort() {
        Sort<Integer> sort = createSort();
        Integer a = 500;
        Integer b = 500;
        Integer c = 500;
        Integer[] array = {1, a, b, c, 900};

        sort.sort(array);

        assertSame(array[1], a);
        assertSame(array[2], b);
        assertSame(array[3], c);
    }

    @Test
    void testStableSort2() {
        Sort<ChronoLocalDate> sort = createSort();

        ChronoLocalDate a = ChronoLocalDate.from(LocalDate.of(2020, 1, 1));
        ChronoLocalDate b = ChronoLocalDate.from(LocalDate.of(2020, 1, 1));
        ChronoLocalDate c = ChronoLocalDate.from(LocalDate.of(2020, 1, 1));
        ChronoLocalDate[] array = {ChronoLocalDate.from(LocalDate.of(2020, 1, 1)), a, b, c};

        sort.sort(array);

        assertSame(array[1], a);
        assertSame(array[2], b);
        assertSame(array[3], c);


    }

}
