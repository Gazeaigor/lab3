# lab3
 ### Java версия 8 обновление 201 (сборка 1.8.0_201-b09)
 * Команда, Memento, Observer, State, Mediator. *
 ___
 Это лабораторная работа под номером 3, где были использованы 5 шаблонов.
 Концепция проекта:
 У нас есть шаблон Command как основной способ работы с классом Observer.
 Командный класс works имеет класс ExecutableClass с методом run, другие классы расширены из него, с переопределенным методом «run».  Таким образом, это означает, что мы можем отправлять те классы методу, которые нужны в качестве параметров ExecutableClass.  Делая это, мы можем легко создать список массивов, в котором мы можем сохранить все необходимые нам команды и выполнить их, чем нам нужно.

 `` `
  ArrayList <Command.ExecCommand> commandArrayList = new ArrayList <> ();

  commandArrayList.add (новый Command.SubscribeCommand (0, «Джонни», «01.02.1994», «Мобильное приложение»));
  commandArrayList.add (новый Command.SubscribeCommand (1, «Кейт», «11.03.1992», «Мобильное приложение»));
  commandArrayList.add (новый Command.SubscribeCommand (erwin));

  for (Command.ExecCommand command: commandArrayList) {
  command.run ();
  }
 `` `
 Это приводит нас к другому шаблону - Memento!
 Memento дает нам возможность сохранить состояние списка команд Array и восстановить его при необходимости.

 `` `
  Memento.Backup.makeOneBackup (commandArrayList);
  commandArrayList = Memento.Backup.getBackup (0);
 `` `
 Класс Observer реализует шаблон «наблюдатель», где этот класс имеет список подписчиков Array и имеет метод для отправки сообщений каждому подписчику.  Работа с этим классом идет с использованием класса State, который реализует шаблон «state».

 У State есть несколько классов, которые расширяют класс 'state', делая это, я также реализую 'составной' шаблон.  Каждый класс состояний имеет методы run (), и, переключая класс состояний, мы также переключаем и исполняемый код.

 Пример:
 `` `
  State.Runnable runnableState = new State.Runnable ();
  runnableState.setState (new State.PrintAllSubscribeers ());
  runnableState.run (Observer.InfoCenter.getArrayList ());

  runnableState.setState (new State.PrintSize ());
  runnableState.run (Observer.InfoCenter.getArrayList ());

  runnableState.setState (new State.PrintAllSubscribeersAdvanced ());
  runnableState.run (Observer.InfoCenter.getArrayList ());
 `` `

 Пример кода:
 `` `
  ArrayList <Command.ExecCommand> commandArrayList = new ArrayList <> ();

  commandArrayList.add (новый Command.SubscribeCommand (0, «Джонни», «01.02.1994», «Мобильное приложение»));
  commandArrayList.add (новый Command.SubscribeCommand (1, «Кейт», «11.03.1992», «Мобильное приложение»));
  Observer.SubUser erwin = новый Observer.SubUser (22, «Erwin», «01.02.1990», «Browser»);
  commandArrayList.add (новый Command.SubscribeCommand (erwin));


  Memento.Backup.makeOneBackup (commandArrayList);
  Memento.Backup.getInfoAboutOneBackup (Memento.Backup.execCommands.size () - 1);

  commandArrayList.add (new Command.UnsubscribeCommand (0));
  commandArrayList.add (новый Command.UnsubscribeCommand (erwin));

  Memento.Backup.makeOneBackup (commandArrayList);
  Memento.Backup.getInfoAboutOneBackup (Memento.Backup.execCommands.size () - 1);

  commandArrayList = Memento.Backup.getBackup (0);

  for (Command.ExecCommand command: commandArrayList) {
  command.run ();
  }


  Observer.InfoCenter.sendMessages ();


  State.Runnable runnableState = new State.Runnable ();
  runnableState.setState (new State.PrintAllSubscribeers ());
  runnableState.run (Observer.InfoCenter.getArrayList ());

  runnableState.setState (new State.PrintSize ());
  runnableState.run (Observer.InfoCenter.getArrayList ());

  runnableState.setState (new State.PrintAllSubscribeersAdvanced ());
  runnableState.run (Observer.InfoCenter.getArrayList ());
  }
 `` `
