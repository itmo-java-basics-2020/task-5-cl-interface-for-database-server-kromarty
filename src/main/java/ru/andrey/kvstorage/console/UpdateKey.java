package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

import java.util.Optional;

public class UpdateKey implements DatabaseCommand {
    ExecutionEnvironment env;
    private String databaseName;
    private String tableName;
    private String key;
    private String value;

    public UpdateKey(ExecutionEnvironment Env, String[] Params) {
        env = Env;
        databaseName = Params[1];
        try {
            tableName = Params[2];
            key = Params[3];
            value = Params[4];
        } catch (IndexOutOfBoundsException e) {
            tableName = null;
            tableName = null;
            value = null;
        }
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        if (env.getDatabase(databaseName).isPresent()) {
            env.getDatabase(databaseName).get().write(tableName, key, value);
            return DatabaseCommandResult.Success("Successful key update");
        } else {
            return DatabaseCommandResult.Error("Key was updated");
        }
    }
}
