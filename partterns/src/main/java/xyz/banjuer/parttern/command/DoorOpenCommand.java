package xyz.banjuer.parttern.command;

import java.util.concurrent.atomic.AtomicInteger;

public class DoorOpenCommand implements Command {
    private final AtomicInteger openCommand = new AtomicInteger(0);

    @Override
    public void execute() {
        System.out.printf("door open %d times\n", openCommand.incrementAndGet());
    }

    @Override
    public void undo() {
        System.out.printf("door open undo, left %d times\n", openCommand.decrementAndGet());
    }
}
