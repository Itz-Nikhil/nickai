package com.nikhil.nickai.dto;

public class GroqChoice
{
    private GroqMessage message;

    public GroqChoice()
    {
    }

    public GroqMessage getMessage()
    {
        return message;
    }

    public void setMessage(GroqMessage message)
    {
        this.message = message;
    }
}