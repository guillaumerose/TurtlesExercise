package fr.guillaumerose;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class MapTest {
    @Test
    public void should_restrict_area_that_turtle_can_access() throws Exception {
        Map map = new Map(100, 100);
        assertThat(map.canGo(0, 0)).isTrue();
        assertThat(map.canGo(-1, 0)).isFalse();
        assertThat(map.canGo(5, -1)).isFalse();
        assertThat(map.canGo(101, 10)).isFalse();
        assertThat(map.canGo(5, 101)).isFalse();
    }
}
