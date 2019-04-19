package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.function.BooleanSupplier;
import java.util.function.Function;
import java.util.function.Predicate;

public class Observer {


    public class Events {


    }

    public static class InfoCenter {

        static ArrayList<SubUser> subUserList = new ArrayList<>();
        static ArrayList<Date> datesArrayList = new ArrayList<>();

        public static ArrayList<SubUser> getArrayList() {
            return subUserList;
        }

        public static void subscribe(SubUser subUser) {

            subUserList.add(subUser);
            System.out.println("User: " + subUser.getName() + ", with ID: " + subUser.getId() + " subscribed to channel with: " + subUser.getType());
        }

        public static void unsubscribe(int findId) {

            SubUser subUser = null;

            int i = 0;
            while (subUser == null && i < subUserList.size()) {
                SubUser it = subUserList.get(i);

                if (it.getId() == findId) {
                    subUser = it;
                }
                i++;
            }

            if (subUser != null) {
                subUserList.remove(subUser);
                System.out.println("User: " + subUser.getName() + ", with ID: " + subUser.getId() + " unsubscribed from channel");
            } else {

                System.out.println("User with ID: " + findId + " was not found");
            }
        }

        public static void unsubscribe(SubUser subUser) {


            if (subUserList.remove(subUser)) {

                System.out.println("User: " + subUser.getName() + ", with ID: " + subUser.getId() + " unsubscribed from channel");
            } else {

                System.out.println("User: " + subUser.getName() + "." + ", with ID: " + subUser.id + " was not found");
            }
        }

        public static void sendMessages() {
            System.out.println("---------------------------------------------------------------------");
            for (SubUser subUser : subUserList) {
                System.out.println("Message has been sent to User: " + subUser.getName());

            }
        }

    }

    public static class SubUser {

        int id;
        String name;
        String date;
        String typeOfSubscription;

        public SubUser(int inId, String inName, String inDate, String type) {

            id = inId;
            name = inName;
            date = inDate;
            typeOfSubscription = type;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getDate() {
            return date;
        }

        public String getType() {
            return typeOfSubscription;
        }
    }

}
