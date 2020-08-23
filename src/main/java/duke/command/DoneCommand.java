package duke.command;

import duke.storage.*;
import duke.ui.Ui;
import duke.task.*;
import duke.exception.DukeException;

import java.util.ArrayList;

public class DoneCommand extends Command {
    private int index;

    public DoneCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ArrayList<Task> lib = tasks.getTaskList();

        if (index >= lib.size() || lib.size() == 0 || index < 0) {
            ui.printExceptions(new DukeException(
                    "This task ID does not exist in the database!"));
        } else {
            tasks.completeTask(index);
            ui.printDoneStatement(lib.get(index).toString());
        }
    }

    @Override
    public boolean isDone() {
        return false;
    }

}
