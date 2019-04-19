package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Memento {

    public static class Backup {

        public static ArrayList<ArrayList<Command.ExecCommand>> execCommands = new ArrayList<>();
        static ArrayList<Date> datesArrayList = new ArrayList<>();

        public static void makeOneBackup(ArrayList<Command.ExecCommand> execCommandsIn) {

            datesArrayList.add(new Date());
            execCommands.add((ArrayList<Command.ExecCommand>) execCommandsIn.clone());
        }

        public static void getInfoAboutOneBackup(int i) {

            System.out.println("Commands count: " + execCommands.get(i).size() + ", added: " + datesArrayList.get(i) + ", List Size: "+execCommands.size());
        }

        public static ArrayList< Command.ExecCommand> getBackup( int i ) {

            return  execCommands.get(i);
        }
    }
}
