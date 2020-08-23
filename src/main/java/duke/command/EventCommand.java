package duke.command;

import duke.storage.*;
import duke.task.*;
import duke.ui.Ui;
import duke.exception.DukeException;

import java.util.ArrayList;

/**
 * Encapsulates a Command which creates a new Event task to add to the task
 * list.
 */
public class EventCommand extends Command {

    private String description;
    private String time;

    public EventCommand(String description, String time) {
        this.description = description;
        this.time = time;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ArrayList<Task> lib = tasks.getTaskList();

        try {
            Event event = new Event(description, time);
            tasks.addEvent(event);
            ui.printAddStatements(event.toString(), lib.size());
        } catch (DukeException ex) {
            ui.printExceptions(ex);
        }

    }

    @Override
    public boolean isDone() {
        return false;
    }

}
