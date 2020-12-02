package xyz.banjuer.parttern.command;

import java.util.concurrent.atomic.AtomicInteger;

public class LightOnCommand implements Command {
    private final AtomicInteger onCommand = new AtomicInteger(0);
    @Override
    public void execute() {
        System.out.printf("light on %d times\n", onCommand.incrementAndGet());
    }

    @Override
    public void undo() {
        System.out.printf("light on undo, left %d times\n", onCommand.decrementAndGet());
    }
}
