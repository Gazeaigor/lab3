package com.company;

import java.util.ArrayList;

public class State {

    public static class Runnable {

         StateOfRunnable state = new StateOfRunnable();

        public  void setState(StateOfRunnable setState) {

            state = setState;
        }

        public  void run() {

            state.run();
        }

        public  void run(ArrayList<Observer.SubUser> arrayList) {

            state.run(arrayList);
        }

    }


    public static class StateOfRunnable {

        public void run() { }

        public void run(ArrayList<Observer.SubUser> arrayList) { }

    }



    public static class PrintAllSubscribers extends StateOfRunnable {

        @Override
        public void run(ArrayList<Observer.SubUser> arrayList) {

            System.out.println("_____________________________________________________________________");
            for (int i=0; i<arrayList.size(); i++) {

                System.out.println(arrayList.get(i).getName());
            }
        }
    }

    public static class PrintAllSubscribersAdvanced extends StateOfRunnable {

        @Override
        public void run(ArrayList<Observer.SubUser> arrayList) {

            System.out.println("_____________________________________________________________________");
            for (int i=0; i<arrayList.size(); i++) {
                Observer.SubUser sub = arrayList.get(i);
                System.out.println("ID:\t"+sub.getId()+"\tName:\t"+sub.getName());
            }
        }
    }


    public static class PrintSize extends StateOfRunnable {


        @Override
        public void run(ArrayList<Observer.SubUser> arrayList) {
            System.out.println("_____________________________________________________________________");
                System.out.println("Subscribers count: "+arrayList.size());

        }
    }

}
