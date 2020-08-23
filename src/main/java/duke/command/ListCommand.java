package duke.command;

import duke.storage.*;
import duke.ui.Ui;

public class ListCommand extends Command {

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showCurrentTasks(tasks.getTaskList());
    }

    @Override
    public boolean isDone() {
        return false;
    }
}
