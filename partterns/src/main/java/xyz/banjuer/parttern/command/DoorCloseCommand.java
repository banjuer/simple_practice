package xyz.banjuer.parttern.command;

import java.util.concurrent.atomic.AtomicInteger;

public class DoorCloseCommand implements Command {
    private final AtomicInteger closeCommand = new AtomicInteger(0);
    @Override
    public void execute() {
        System.out.printf("door close %d times\n", closeCommand.incrementAndGet());
    }

    @Override
    public void undo() {
        System.out.printf("door close undo, left %d times\n", closeCommand.decrementAndGet());
    }
}
