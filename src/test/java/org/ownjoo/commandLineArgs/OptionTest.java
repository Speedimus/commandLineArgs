package org.ownjoo.commandLineArgs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Speedy on 4/5/2017.
 */
public class OptionTest
{
    @Test
    public void shouldConstruct()
    {
        assertNotNull(new Option());
    }

    @Test public void shouldReturnDataListReference()
    {
        Option actual = new Option();
        assertNotNull(actual.getData());
    }

    @Test public void shouldReturnConstructedOptionWithData()
    {
        String expectedOption = "option";
        String[] array = {"one", "two", "three"};
        List<String> expectedData = new ArrayList<>(Arrays.asList(array));
        Option actual = new Option(expectedOption, expectedData);

        assertTrue(actual.getOption().equals(expectedOption));
        assertTrue(actual.getData().equals(expectedData));
    }

    @Test public void shouldReturnSetOptionWithSetData()
    {
        String expectedOption = "option";
        String[] array = {"one", "two", "three"};
        List<String> expectedData = new ArrayList<>(Arrays.asList(array));
        Option actual = new Option();
        actual.setOption(expectedOption);
        actual.setData(expectedData);

        assertTrue(actual.getOption().equals(expectedOption));
        assertTrue(actual.getData().equals(expectedData));
    }

}
