package org.ownjoo.commandLineArgs;

import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Speedy on 4/5/2017.
 */
public class ArgsTest
{
    String  inOptionOne     =   "-f",
            inDataOne       =   "second",
            inOptionTwo     =   "--third",
            inDataTwo       =   "fourth",
            expOptionOne     =   "f",
            expDataOne       =   "second",
            expOptionTwo     =   "third",
            expDataTwo       =   "fourth";

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
        String[] strings = {inOptionOne, inDataOne, inOptionTwo, inDataTwo};
        Args args = new Args(strings);

        List<Option> actual = args.getOptions();
        assertNotNull(actual);
        assertTrue(actual.size() > 0);
    }

    @Test
    public void shouldReturnCorrectListOfOptions()
    {
        String[] strings = {inOptionOne, inDataOne, inOptionTwo, inDataTwo};
        Args args = new Args(strings);

        List<Option> actual = args.getOptions();
        assertTrue(expOptionOne.equals(actual.get(0).getOption()));
        assertTrue(expDataOne.equals(actual.get(0).getData().get(0)));
        assertTrue(expOptionTwo.equals(actual.get(1).getOption()));
        assertTrue(expDataTwo.equals(actual.get(1).getData().get(0)));
    }
}
