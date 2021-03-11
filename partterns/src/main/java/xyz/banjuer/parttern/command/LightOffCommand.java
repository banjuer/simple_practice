package xyz.banjuer.parttern.command;

import java.util.concurrent.atomic.AtomicInteger;

public class LightOffCommand implements Command {
    private final AtomicInteger offCommand = new AtomicInteger(0);

    @Override
    public void execute() {
        System.out.printf("light off %d times\n", offCommand.incrementAndGet());
    }

    @Override
    public void undo() {
        System.out.printf("light off undo, left %d times\n", offCommand.decrementAndGet());
    }
}
