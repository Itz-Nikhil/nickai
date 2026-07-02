package com.nikhil.nickai.dto;

import java.util.List;

public class GroqResponse {

    private List<GroqChoice> choices;

    public GroqResponse() {
    }

    public List<GroqChoice> getChoices() {
        return choices;
    }

    public void setChoices(List<GroqChoice> choices) {
        this.choices = choices;
    }
}