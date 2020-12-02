package xyz.banjuer.parttern.command;

public class CommandPanel {

    private int keys;

    private Command[] commands;

    public CommandPanel(int keys) {
        this.keys = keys;
        commands = new Command[keys];
        for (int i = 0; i < keys; i++) {
            //初始化: 避免未设置的key出现空指针
            commands[i] = new NoCommand();
        }
    }

    public void set(int key, Command c) {
        if (key > this.keys || key < 0) return;
        this.commands[key] = c;
    }

    public void press(int key) {
        if (key > this.keys || key < 0) return;
        this.commands[key].execute();
    }

}
