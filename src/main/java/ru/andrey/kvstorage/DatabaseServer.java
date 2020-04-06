package ru.andrey.kvstorage;

import ru.andrey.kvstorage.console.*;
import ru.andrey.kvstorage.exception.DatabaseException;

public class DatabaseServer {

    private final ExecutionEnvironment env;

    public DatabaseServer(ExecutionEnvironment Env) {
        env = Env;
    }

    DatabaseCommandResult executeNextCommand(String commandText) {
        if (commandText == null) {
            return DatabaseCommandResult.Error("Unknown command name");
        }

        String[] commandParams = commandText.split(" ");
        boolean existsCommand = false;

        for (var command : DatabaseCommands.values()) {
            if (command.name().equals(commandParams[0])) {
                existsCommand = true;
                break;
            }
        }

        if (!existsCommand) {
            return DatabaseCommandResult.Error("Command not found");
        }

        DatabaseCommand nextCommand = DatabaseCommands.valueOf(commandParams[0]).getCommand(env, commandParams);
        try {
            return nextCommand.execute();
        } catch (DatabaseException ex) {
            return DatabaseCommandResult.Error(ex.getMessage());
        }
    }
}