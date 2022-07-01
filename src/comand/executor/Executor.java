package comand.executor;

import comand.CommandType;

public interface Executor {
    int execute(String command);

    CommandType getCommandType();
}
