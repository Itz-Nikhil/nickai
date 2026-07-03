package com.nikhil.nickai.exception;

@SuppressWarnings("serial")
public class ConversationNotFoundException extends RuntimeException
{
    public ConversationNotFoundException(String message)
    {
        super(message);
    }
}