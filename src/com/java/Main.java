package com.java;

import com.sun.net.httpserver.HttpServer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.Date;
import java.util.*;

public class Main {

    public static Users users = new Users();

    public static void Start() {
        System.out.println("\nCompleted by student AT-212 \nOdessa Polytechnic University \nVykhodets Roman \n\nVariant 13 \n\n");

    }

    public static void httpServer() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8001), 0);

        server.createContext("/back/users", new com.java.HttpServer());
        server.start();
        System.out.println(System.lineSeparator() + "\033[1;32mServer started at:\tlocalhost:8001\u001B[0m");
    }

    public static void main(String[] args) throws IOException {
        Start();
        httpServer();
        AddUsers(20);

        Database db = new Database();

//        users.add(new User("FlGdsf", "PO-le", "RO\'me", new Baggage("SU1322", "2", 2, 20.5, new Date(2022, 2, 23), new Date(2012, 2, 23))));//LocalDate.of(2012, 2, 23), LocalDate.of(2012, 2, 23)
//        users.add(new User("wt", "wet", "eO\'me", new Baggage("FV9263", "2", 2, 32.5, new Date(2022, 2, 23), new Date(2012, 2, 23))));
//        users.add(new User("ewyetrytuy", "wfdet", "eO\'me", new Baggage("LU3352", "2", 2, 42.5, new Date(2022, 2, 23), new Date(2012, 2, 23))));

//
//        System.out.println(users);
//        users.BigWeight(30.0);
//        //users.remove("Flgdsf");
//        users.remove("FLgdsf");
//        users.remove("wt","wet","eO_me");
//        System.out.println("t\n"+users);
//        users.BigWeight(30);
//        users.SumWeight();


//        System.out.println(System.lineSeparator() + "Данные:" + System.lineSeparator() + users);
//        db.serialization(users);
//        db.deserialization(users);
    }

    /**
     * Функция для генерации Users со случайными данными<br><br>
     * Function to generate Users with random data
     *
     * @param num
     * @throws FileNotFoundException
     */
    public static void AddUsers(int num) throws FileNotFoundException {
        Random rand = new Random();
        File file = new File("src/com/dopFile/DataFile.txt");
        if (file.length() == 0) {
            System.out.println("Файл пуст");
        } else {
            Scanner scn = new Scanner(file);
            ArrayList<String[]> nums = new ArrayList<>();

            while (scn.hasNext()) {
                nums.add(scn.nextLine().split(","));
            }

            int columns = nums.get(0).length;
            String[][] arr = new String[nums.size()][columns];
            Iterator<String[]> iter = nums.iterator();
            for (int i = 0; i < arr.length; i++) {
                String[] s = iter.next();
                for (int j = 0; j < columns; j++) {
                    arr[i][j] = String.valueOf(s[j]);
                }
            }

//            System.out.println(Arrays.deepToString(arr)); // Вывод массива
            scn.close();
            for (int i = 0; i < num; i++) {
                users.add(new User(arr[0][rand.nextInt(columns)],
                        arr[1][rand.nextInt(columns)],
                        arr[2][rand.nextInt(columns)],
                        new Baggage(arr[3][rand.nextInt(columns)],
                        arr[4][rand.nextInt(columns)],
                                Integer.parseInt(arr[5][rand.nextInt(columns)]),
                                Double.valueOf(arr[6][rand.nextInt(columns)]),
                                new Date(rand.nextInt(2) + 2022,
                                        rand.nextInt(11) + 1,
                                        rand.nextInt(30) + 1),
                                new Date(rand.nextInt(2) + 2022,
                                        rand.nextInt(11) + 1,
                                        rand.nextInt(30) + 1))));
            }
        }
    }
}
