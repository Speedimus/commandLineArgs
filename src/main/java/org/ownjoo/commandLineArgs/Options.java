package org.ownjoo.commandLineArgs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Speedy on 4/5/2017.
 */
public class Options
{
    private List<String> args;
    private List<Option> options;

    public Options()
    {
        this.options = new ArrayList<>();
        this.args = new ArrayList<>();
    }

    public Options(String[] args)
    {
        this.options = new ArrayList<>();
        setArgs(args);
    }

    public boolean exists(String key)
    {
        return !options.stream()
                .filter((a) -> a.getOption().contains(key))  // if there's an option matching the key
                .collect(Collectors.toList())                // put it in a short List<Option>
                .isEmpty();                                  // and check if it's there
    }

    public Option getOption(String key)
    {
        Option result = null;
        if(exists(key))
            result = options.stream()
                    .filter((a) -> a.getOption().contains(key))  // if there's an option matching the key
                    .collect(Collectors.toList())                // put it in a short List<Option>
                    .get(0);                                     // get the first Option

        return result;
    }

    public List<Option> getOptions()
    {
        return this.options;
    }

    public void setArgs(String[] args)
    {
        this.args = Arrays.asList(args);
        parseArgs();
    }

    private void parseArgs()
    {
        String temp;
        Option option = new Option();

        for (String arg : args)
        {
            temp = arg;
            if (arg.charAt(0) == '-')
            {
                // if the next arg is a new option, save the existing one
                if (!"".equals(option.getOption()) || option.getData().size() > 0)
                {
                    this.options.add(option);
                    option = new Option();
                }
                option.setOption(temp.replace("--", "-").substring(1));
            }
            else
            {
                option.getData().add(temp);
            }
        }
        if (!"".equals(option.getOption()) || option.getData().size() > 0)
            this.options.add(option);
    }

    public String toString()
    {
        String result = "";
        ObjectMapper objectMapper = new ObjectMapper();
        try
        {
            result = objectMapper.writeValueAsString(this.options);
        }
        catch(JsonProcessingException j)
        {
            j.printStackTrace();
        }

        return result;
    }
}
