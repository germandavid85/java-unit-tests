package unit.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SetTest {
    private Set set;

    @BeforeEach
    public void setup() {
        set = new Set();
    }

    // isEmpty
    @Test
    public void isEmptyTrueTest() {
        assertThat(set.isEmpty(), is(true));
    }

    @Test
    public void isEmptyFalseTest() {
        set.add(1);
        set.add(2);

        assertThat(set.isEmpty(), is(false));
    }

    // size
    @Test
    public void emptySetSizeZeroTest() {
        assertThat(set.size(), is(0));
    }

    @Test
    public void emptySetSizeGreaterThanZeroTest() {
        set.add(1);
        set.add(2);

        assertThat(set.size(), is(2));
    }

    @Test
    public void sizeWithRepeatedElementsTest() {
        set.add(1);
        set.add(2);
        set.add(2);

        assertThat(set.size(), is(2));
    }

    // clear
    @Test
    public void clearSizeZeroTest() {
        set.add(1);
        set.add(2);
        set.clear();

        assertThat(set.size(), is(0));
    }

    @Test
    public void clearEmptyTrueTest() {
        set.add(1);
        set.add(2);
        set.clear();

        assertThat(set.isEmpty(), is(true));
    }

    @Test
    public void addElementsAfterClearIsEmptyFalseTest() {
        set.add(1);
        set.add(2);
        set.clear();
        set.add(4);
        set.add(8);

        assertThat(set.isEmpty(), is(false));
    }

    @Test
    public void addElementsAfterClearSizeIsGreaterThanZeroTest() {
        set.add(1);
        set.add(2);
        set.clear();
        set.add(4);

        assertThat(set.size(), is(1));
    }

    // contains

    @Test
    public void containsTrue() {
        set.add(1);

        assertThat(set.contains(1), is(true));
    }

    @Test
    public void containsFalse() {
        set.add(1);

        assertThat(set.contains(2), is(false));
    }

    // [1, null, null]
    // [null, null, null]
    @Test
    public void containsAfterRemoveFalse() {
        set.add(1);
        set.remove(1);

        assertThat(set.contains(1), is(false));
    }

    // [1, 2, 3]
    // [1, null, 3]

    // @Test
    // public void addNullSizeZeroTest() {
    //     set.add(1);
    //     set.add(2);
    //     set.add(3);

    //     set.remove(2);

    //     assertThat(set.contains(2), is(false));
    // }

    @Test
    public void containsWithSizeExceededTest() {
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(6);
        set.add(7);
        set.add(8);
        set.add(9);
        set.add(10);
        set.add(11);

        assertThat(set.contains(5), is(true));
    }

    @Test
    public void sizeExceededTest() {
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(6);
        set.add(7);
        set.add(8);
        set.add(9);
        set.add(10);
        set.add(11);

        assertThat(set.size(), is(11));
    }
}
