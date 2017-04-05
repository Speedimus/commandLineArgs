package org.ownjoo.commandLineArgs;

import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Speedy on 4/5/2017.
 */
public class ArgsTest
{
    String  expOptionOne =   "-f",
            expDataOne   =   "second",
            expOptionTwo =   "--third",
            expDataTwo   =   "fourth";

    @Test
    public void shouldConstruct()
    {
        assertNotNull(new ArgsTest());
    }

    @Test
    public void shouldConstructWithAnArrayOfStrings()
    {
        String[] args = {};
        assertNotNull(new Args(args));
    }

    @Test
    public void shouldReturnListOfOptions()
    {
        String[] strings = {expOptionOne, expDataOne, expOptionTwo, expDataTwo};
        Args args = new Args(strings);
        System.out.println(args);

        List<Option> actual = args.getOptions();
        assertNotNull(actual);
        assertTrue(actual.size() > 0);
    }

    @Test
    public void shouldReturnCorrectListOfOptions()
    {
        String[] strings = {expOptionOne, expDataOne, expOptionTwo, expDataTwo};
        Args args = new Args(strings);

        List<Option> actual = args.getOptions();
        assertTrue(expOptionOne.equals(actual.get(0).getOption()));
        assertTrue(expDataOne.equals(actual.get(0).getData()));
        assertTrue(expOptionTwo.equals(actual.get(1).getOption()));
        assertTrue(expDataTwo.equals(actual.get(1).getData()));
    }
}
