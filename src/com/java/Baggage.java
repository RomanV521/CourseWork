package com.java;

import java.io.Serializable;
import java.util.Date;

public class Baggage implements Serializable {
    /**
     * Номер рейса
     */
    private String flightNumber;//Номер рейса
    /**
     * Номер багажной квитанции
     */
    private String baggageCheckNumber;//Номер багажной квитанции
    /**
     * Количество мест багажа
     */
    private int amountOfLuggage;//Количество мест багажа
    /**
     * Вес багаж
     */
    private double baggageWeight;//Вес багаж
    /**
     * Время размещения багажа
     */
    private Date luggagePlacementTime;//Время размещения багажа
    /**
     * Срок размещения
     */
    private Date periodOfPlacement;//Срок размещения

    public Baggage(String flightNumber, String baggageCheckNumber, int amountOfLuggage, double baggageWeight, Date luggagePlacementTime, Date periodOfPlacement) {
        this.setFlightNumber(flightNumber);
        this.setBaggageCheckNumber(baggageCheckNumber);
        this.setAmountOfLuggage(amountOfLuggage);
        this.setBaggageWeight(baggageWeight);
        this.setLuggagePlacementTime(luggagePlacementTime);
        this.setPeriodOfPlacement(periodOfPlacement);
    }


    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        flightNumber = flightNumber.strip().toUpperCase(); //UA2502
        if (Integer.parseInt(flightNumber.substring(2)) > 0) {
            this.flightNumber = flightNumber;
        } else {
            this.flightNumber = flightNumber.substring(0, 2) + (-Integer.parseInt(flightNumber.substring(2)));
        }
    }

    public String getBaggageCheckNumber() {
        return baggageCheckNumber;
    }

    public void setBaggageCheckNumber(String baggageCheckNumber) {
        this.baggageCheckNumber = baggageCheckNumber;
    }

    public int getAmountOfLuggage() {
        return amountOfLuggage;
    }

    public void setAmountOfLuggage(int amountOfLuggage) {
        if (amountOfLuggage >= 0 && amountOfLuggage < 10) {
            this.amountOfLuggage = amountOfLuggage;
        }

    }

    public double getBaggageWeight() {
        return baggageWeight;
    }

    public void setBaggageWeight(double baggageWeight) {
        if (baggageWeight >= 0 && baggageWeight < 64.1) {//Max-64кг
            this.baggageWeight = baggageWeight;
        }
    }

    public String getLuggagePlacementTime() {
        return Utils.FormatData(luggagePlacementTime);
    }

    public void setLuggagePlacementTime(Date luggagePlacementTime) {
        this.luggagePlacementTime = Utils.CorrectVariableData(luggagePlacementTime);
    }

    public String getPeriodOfPlacement() {
        return Utils.FormatData(periodOfPlacement);
    }

    public void setPeriodOfPlacement(Date periodOfPlacement) {
        this.periodOfPlacement = Utils.CorrectVariableData(periodOfPlacement);
    }

    @Override
    public String toString() {
        return
                "\tFlight Number = " + getFlightNumber() +
                        ", Baggage Check Number = " + getBaggageCheckNumber() +
                        ", Amount Of Luggage = " + getAmountOfLuggage() +
                        ", Baggage Weight = " + getBaggageWeight() +
                        ", Luggage Placement Time = " + getLuggagePlacementTime() +
                        ", Period Of Placement = " + getPeriodOfPlacement() + System.lineSeparator();
    }
}
