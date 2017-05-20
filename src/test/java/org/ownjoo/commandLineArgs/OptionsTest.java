package org.ownjoo.commandLineArgs;

import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Speedy on 4/5/2017.
 */
public class OptionsTest
{
    String  expOptionOne    =   "f",
            expDataOne      =   "second",
            expOptionTwo    =   "third",
            expDataTwo      =   "fourth",
            inOptionOne     =   "-" + expOptionOne,
            inDataOne       =   expDataOne,
            inOptionTwo     =   "--" + expOptionTwo,
            inDataTwo       =   expDataTwo;
    Options options;

    @Before
    public void setupEach()
    {
        String strings[] = {inOptionOne, inDataOne, inOptionTwo, inDataTwo};
        options = new Options(strings);
    }

    @Test
    public void shouldConstructWithAnArrayOfStrings()
    {
        String[] args = {};
        assertNotNull(new Options(args));
    }

    @Test
    public void shouldReturnListOfOptions()
    {
        List<Option> actual = options.getOptions();
        assertNotNull(actual);
        assertTrue(actual.size() > 0);
    }

    @Test
    public void shouldReturnCorrectListOfOptions()
    {
        List<Option> actual = options.getOptions();
        assertTrue(expOptionOne.equals(actual.get(0).getOption()));
        assertTrue(expDataOne.equals(actual.get(0).getData().get(0)));
        assertTrue(expOptionTwo.equals(actual.get(1).getOption()));
        assertTrue(expDataTwo.equals(actual.get(1).getData().get(0)));
    }

    @Test
    public void shouldCheckExistenceOfAnOption()
    {
        assertTrue(options.exists(expOptionOne));
        assertTrue(options.exists(expOptionTwo));
        assertFalse(options.exists("notPresent"));
    }

    @Test
    public void shouldReturnOption()
    {
        Option actualOne = options.getOption(expOptionOne);
        Option actualTwo = options.getOption(expOptionTwo);

        assertTrue(expDataOne.equals(actualOne.getData().get(0)));
        assertTrue(expDataTwo.equals(actualTwo.getData().get(0)));
    }
}
