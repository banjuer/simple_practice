package xyz.banjuer.parttern.command;

public class QuickCommand implements Command {

    private Command[] commands;

    public QuickCommand(Command[] commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        for (Command quick : commands) {
            quick.execute();
        }
    }

    @Override
    public void undo() {
        for (Command c : commands) {
            c.undo();
        }
    }
}
