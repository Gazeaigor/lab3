package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.Function;
import com.company.State.Runnable;

public class Main {

    public static void main(String[] args) {

//        State.Runnable.setState(new State.PrintState());
//        State.Runnable.run();
//
//        State.Runnable.setState(new State.Count());
//        State.Runnable.run();


        Observer.SubUser erwin = new Observer.SubUser(22, "Erwin", "01.02.1990", "Browser");

//        Command.RegisterCommand registerCommand = new Command.RegisterCommand();

        ArrayList<Command.ExecCommand> commandArrayList = new ArrayList<>();

        commandArrayList.add(new Command.SubscribeCommand(0, "Johny", "01.02.1994", "Mobile App"));
        commandArrayList.add(new Command.SubscribeCommand(1, "Kate", "11.03.1992", "Mobile App"));
        commandArrayList.add(new Command.SubscribeCommand(erwin));


        Memento.Backup.makeOneBackup(commandArrayList);
        Memento.Backup.getInfoAboutOneBackup(Memento.Backup.execCommands.size() - 1);

        commandArrayList.add(new Command.UnsubscribeCommand(0));
        commandArrayList.add(new Command.UnsubscribeCommand(erwin));

        Memento.Backup.makeOneBackup(commandArrayList);
        Memento.Backup.getInfoAboutOneBackup(Memento.Backup.execCommands.size() - 1);

        commandArrayList = Memento.Backup.getBackup(0);

        for (Command.ExecCommand command : commandArrayList) {
            command.run();
        }


        Observer.InfoCenter.sendMessages();


        State.Runnable runnableState = new State.Runnable();
        runnableState.setState(new State.PrintAllSubscribers());
        runnableState.run(Observer.InfoCenter.getArrayList());

        runnableState.setState(new State.PrintSize());
        runnableState.run(Observer.InfoCenter.getArrayList());

        runnableState.setState(new State.PrintAllSubscribersAdvanced());
        runnableState.run(Observer.InfoCenter.getArrayList());
    }
}
