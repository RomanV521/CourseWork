package com.java;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

public class Users {
    private ArrayList<User> users;

    public Users() {
        users = new ArrayList<>();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public User getUsers(int index) {
        return users.get(index);
    }

    /**
     * Добавление нового пользователя<br>
     * Adding a new user
     *
     * @param user
     */
    public void add(User user) {
        this.users.add(user);
    }

    public User get(int index) {
        return this.users.get(index);
    }

    /**
     * Удаление пользователя<br>
     * Deleting a user
     *
     * @param user
     */
    public void remove(User user) {
        this.users.remove(user);
    }

    /**
     * Удаление пользователя по индексу<br>
     * Deleting a user by index
     *
     * @param index
     */
    public void remove(int index) {
        this.users.remove(index);
    }

    /**
     * Удаление по: Фамилии, Имени и Отчеству<br><br>
     * Removal by Last Name, First Name and Patronymic
     *
     * @param surname
     * @param name
     * @param patronymic
     */
    public void remove(String surname, String name, String patronymic) {
        String surname1 = Utils.CorrectVariableText(surname);
        String name1 = Utils.CorrectVariableText(name);
        String patronymic1 = Utils.CorrectVariableText(patronymic);
        this.users.removeIf(user -> Objects.equals(user.getSurname().toLowerCase(Locale.ROOT), surname1) && Objects.equals(user.getName().toLowerCase(Locale.ROOT), name1) && Objects.equals(user.getPatronymic().toLowerCase(Locale.ROOT), patronymic1));
    }

    /**
     * Удаление по: Фамилии<br><br>
     * Removal by Last Name
     *
     * @param surname
     */
    public void remove(String surname) {
        this.users.removeIf(user -> Objects.equals(user.getSurname().toLowerCase(Locale.ROOT), surname.toLowerCase(Locale.ROOT)));
    }

    /**
     * Определяет вес который больше значение limitation<br><br>
     * Specifies the weight that is greater than the limitation value
     *
     * @param limitation
     */
    public void BigWeight(double limitation) {
        System.out.println(System.lineSeparator() + "Users who have more weight " + limitation);
        for (User user : users) {
            if (user.getBaggage().getBaggageWeight() > limitation) {
                System.out.print(user);
            }
        }
    }

    /**
     * Определяет суммарный вес багажа всех пассажиров и вывод данных<br><br>
     * Determines the total baggage weight of all passengers and data output
     */
    public void SumWeight() {
        long sum = 0;
        for (User user : users) {
            sum += user.getBaggage().getBaggageWeight();
        }
        System.out.println("The total baggage weight of all passengers on the flight: " + sum);
    }

    /**
     * Вывод сведений о местонахождении багажа (номер рейса) по заданному номеру багажной квитанции<br><br>
     * <p>
     * Displaying information about the location of the baggage (flight number) according to the specified number of the baggage receipt
     *
     * @param baggageCheckNumber
     * @return
     */
    public String locationOfBaggage(String baggageCheckNumber) {
        String result = null;
        for (User user : users) {
            if (user.getBaggage().getBaggageCheckNumber().equals(baggageCheckNumber)) {
                result = "Number Flight: " + user.getBaggage().getFlightNumber();
            } else {
                result = "Number of baggage doesn't exist";
            }
        }
        return result;
    }


    @Override
    public String toString() {
//        return "Users:\n" +
//                getUsers() + baggage;
        String result = "Users:\n";
        for (User user : users) {
            result += user;
        }
        return result;
    }
}
