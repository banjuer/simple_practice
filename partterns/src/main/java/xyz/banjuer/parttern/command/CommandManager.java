package xyz.banjuer.parttern.command;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class CommandManager {

    private Deque<Command> undo = new LinkedList<>();

    public void execute(Command c) {
        c.execute();
        undo.push(c);
    }

    public void undo() {
        if (!undo.isEmpty()) {
            Command pop = undo.pop();
            pop.undo();
        }
    }
}
