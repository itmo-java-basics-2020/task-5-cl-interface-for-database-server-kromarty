package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

import java.util.Optional;

public class CreateTable implements DatabaseCommand {
    ExecutionEnvironment env;
    private String databaseName;
    private String tableName;

    public CreateTable(ExecutionEnvironment Env, String[] Params) {
        env = Env;
        databaseName=Params[1];
        try {
            tableName = Params[2];
        }
        catch (IndexOutOfBoundsException ex)
        {
            tableName = null;
        }
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        if (env.getDatabase(databaseName).isPresent()) {
            env.getDatabase(databaseName).get().createTableIfNotExists(tableName);
            return DatabaseCommandResult.Success("Table was created");
        } else {
            return DatabaseCommandResult.Error("Database isn't provided");
        }
    }
}
