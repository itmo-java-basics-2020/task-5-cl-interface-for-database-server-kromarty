package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.exception.DatabaseException;

public class CreateDatabase implements DatabaseCommand {
    ExecutionEnvironment env;
    private String name;

    public CreateDatabase(ExecutionEnvironment Env, String[] Params) {
        env = Env;
        name = Params[1];
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        if (env.getDatabase(name).isPresent()) {
            return DatabaseCommandResult.Error("Database is already exists");
        } else {
            return DatabaseCommandResult.Success("Database was created");
        }
    }
}