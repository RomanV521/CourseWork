package com.java;

import com.google.gson.Gson;

import java.io.*;

public class Database implements Serializable {
    //    Gson gson = new GsonBuilder()
//            .setPrettyPrinting()
//            .serializeNulls()
//            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
//            .create();
    Gson gson = new Gson();


    /**
     * Сериализация(Сохранение документа с данными и документа который идет на сервер)<br><br>
     * Serialization (Saving a document with data and a document that goes to the server)
     */
    public void serialization(Users users) {
        StringBuilder jsonString = new StringBuilder("");
        try {
            FileOutputStream fos = new FileOutputStream("src/com/save/db.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (User user : users.getUsers()) {//Сериализация в бинарном виде
                oos.writeObject(user);
            }

            jsonString.append(gson.toJson(users));
            try (PrintWriter out = new PrintWriter("src/com/save/api1.txt")) {//Сериализация документа который идет на сервер
                out.println(jsonString);
            }

            oos.close();
            System.out.println(jsonString);
        } catch (IOException e) {
            System.out.println("Error:");
            e.printStackTrace();
        }
    }

    /**
     * Дисериализируем(Загрузить документ с данными) при помощи Gson<br><br>
     *
     * Disserialize (Load document with data) with Gson
     * @param users
     */
    public void deserialization(Users users) {
        StringBuilder jsonString = new StringBuilder("");
        try {
            FileInputStream fis = new FileInputStream("src/com/save/db.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            for (int i = 0; i < users.getUsers().size(); i++) {
                jsonString.append(gson.toJson(ois.readObject()));
            }
            System.out.println(System.lineSeparator() + "Deserialization: " + jsonString);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
