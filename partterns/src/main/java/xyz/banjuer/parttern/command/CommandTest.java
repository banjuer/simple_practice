package xyz.banjuer.parttern.command;

public class CommandTest {

    public static void main(String[] args) {
        managerTest();
        // panelTest();
    }

    static void managerTest() {
        Command lightOff = new LightOffCommand();
        Command lightOn = new LightOnCommand();
        CommandManager manager = new CommandManager();
        manager.execute(lightOn);
        manager.execute(lightOff);
        manager.undo();
        manager.undo();
    }

    static void panelTest() {
        Command doorOpen = new DoorOpenCommand();
        Command doorClose = new DoorCloseCommand();
        Command lightOff = new LightOffCommand();
        Command lightOn = new LightOnCommand();
        CommandPanel panel = new CommandPanel(8);
        panel.set(0, doorOpen);
        panel.set(1, doorClose);
        panel.set(2, lightOn);
        panel.set(3, lightOff);

        panel.press(0);
        panel.press(2);
        panel.press(3);
        panel.press(1);

        Command quick = new QuickCommand(new Command[]{doorOpen, lightOn});
        panel.set(4, quick);
        panel.press(4);
    }

}
