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
    String[] params;

    public UpdateKey(ExecutionEnvironment Env, String[] Params) {
        env = Env;
        params = Params;
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        if (env.getDatabase(params[1]).isPresent()) {
            env.getDatabase(params[1]).get().write(params[2], params[3], params[4]);
            return DatabaseCommandResult.Success("Successful key update");
        } else {
            return DatabaseCommandResult.Error("Key was updated");
        }
    }
}
