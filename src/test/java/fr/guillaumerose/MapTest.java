package fr.guillaumerose;

import fr.guillaumerose.Map.RestrictedArea;

import org.junit.Test;

import static com.google.common.collect.Lists.*;
import static org.assertj.core.api.Assertions.*;

public class MapTest {
    @Test
    public void should_restrict_area_that_turtle_can_access() throws Exception {
        Map map = new Map(100, 100, newArrayList());
        assertThat(map.canGo(0, 0)).isTrue();
        assertThat(map.canGo(-1, 0)).isFalse();
        assertThat(map.canGo(5, -1)).isFalse();
        assertThat(map.canGo(101, 10)).isFalse();
        assertThat(map.canGo(5, 101)).isFalse();
    }

    @Test
    public void should_refuse_to_go_in_a_restricted_area() throws Exception {
        Map map = new Map(100, 100, newArrayList(new RestrictedArea(20, 10, 30, 30)));
        assertThat(map.canGo(25, 25)).isFalse();
        assertThat(map.canGo(21, 10)).isFalse();
        assertThat(map.canGo(21, 9)).isTrue();
        assertThat(map.canGo(25, 31)).isTrue();
        assertThat(map.canGo(25, 30)).isFalse();
    }

    @Test
    public void should_handle_multiples_restricted_areas() throws Exception {
        Map map = new Map(100, 100, newArrayList(new RestrictedArea(5, 5, 10, 10), new RestrictedArea(20, 20, 30, 30)));
        assertThat(map.canGo(15, 15)).isTrue();
        assertThat(map.canGo(22, 22)).isFalse();
        assertThat(map.canGo(7, 7)).isFalse();
    }
}
