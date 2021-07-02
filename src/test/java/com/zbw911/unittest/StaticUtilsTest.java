package com.zbw911.unittest;

import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class StaticUtilsTest {

    @Test
    public void test_test() {

        StaticUtils.range(2, 6);

        try (MockedStatic<StaticUtils> utilities = Mockito.mockStatic(StaticUtils.class)) {
            utilities.when(StaticUtils::name).thenReturn("Eugen");
            assertEquals(StaticUtils.name(), "Eugen");
        }

        assertEquals(StaticUtils.name(), "Baeldung");
    }
}