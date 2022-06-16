package com.java;

import java.io.Serializable;


public class User implements Serializable {
    /**
     * User surname
     */
    private String surname;
    /**
     * User name
     */
    private String name;
    /**
     * User patronymic
     */
    private String patronymic;

    private Baggage baggage;

    public User(String surname, String name, String patronymic, Baggage baggage) {
        this.setSurname(surname);
        this.setName(name);
        this.setPatronymic(patronymic);
        this.baggage = baggage;
    }

    public Baggage getBaggage() {
        return baggage;
    }

    public void setBaggage(Baggage baggage) {
        this.baggage = baggage;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = Utils.CorrectVariableText(surname);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = Utils.CorrectVariableText(name);
    }

    public String getPatronymic() {
        return this.patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = Utils.CorrectVariableText(patronymic);
    }


    @Override
    public String toString() {
        return "\tSurname '" + getSurname() + '\'' +
                ", Name '" + getName() + '\'' +
                ", Patronymic '" + getPatronymic() + "\'" + System.lineSeparator() + baggage + System.lineSeparator();
    }
}
