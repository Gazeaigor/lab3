package com.company;

public class Command {

    public static class ExecCommand implements Cloneable {

        public void run() {};

    }


    public static class SubscribeCommand extends ExecCommand  {

        boolean opType;

        Observer.SubUser subUser;

        int index;
        String name = new String();
        String date = new String();
        String type = new String();

        public SubscribeCommand(int i, String a, String b, String c) {

            opType = true;
            index = i;
            name = a;
            date = b;
            type = c;
        }

        public SubscribeCommand(Observer.SubUser subUserIn) {
            opType = false;
            subUser = subUserIn;
        }

        @Override
        public void run() {
            if(opType) {

                Observer.SubUser subUser = new Observer.SubUser(index, name, date, type);
                Observer.InfoCenter.subscribe(subUser);
            } else {

                Observer.InfoCenter.subscribe(subUser);
            }

        }
    }

    public static class UnsubscribeCommand extends ExecCommand  {

        boolean opType;

        Observer.SubUser subUser;

        int index;

        public UnsubscribeCommand(Observer.SubUser subUserIn) {
            opType = true;
            subUser = subUserIn;
        }

        public UnsubscribeCommand(int i) {
            opType = false;
            index = i;
        }

        @Override
        public void run() {

            if(opType){

                Observer.InfoCenter.unsubscribe(subUser);
            } else {

                Observer.InfoCenter.unsubscribe(index);
            }

        }
    }

}
