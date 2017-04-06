package org.ownjoo.commandLineArgs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Speedy on 4/5/2017.
 */
public class Option
{
    private String option;
    private List<String> data;

    public Option()
    {
        this.option="";
        this.data = new ArrayList<>();
    }

    public Option(String option, List<String> data)
    {
        this.option = option;
        this.data= new ArrayList<>();
        setData(data);
    }

    public String getOption()
    {
        return this.option;
    }

    public void setOption(String option)
    {
        this.option = option;
    }

    public List<String> getData()
    {
        return this.data;
    }

    public void setData(List<String> data)
    {
        this.data= new ArrayList<>();
        this.data.addAll(data);
    }

    public void addData(List<String> data)
    {
        this.data.addAll(data);
    }

    public String toString()
    {
        String result = "";
        ObjectMapper objectMapper = new ObjectMapper();
        try
        {
            result = objectMapper.writeValueAsString(this);
        }
        catch(JsonProcessingException j)
        {
            j.printStackTrace();
        }

        return result;
    }
}
