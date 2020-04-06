package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.exception.DatabaseException;

public class ReadKey implements DatabaseCommand {
    ExecutionEnvironment env;
    private String databaseName;
    private String tableName;
    private String key;

    public ReadKey(ExecutionEnvironment Env, String[] Params) {
        env = Env;
        databaseName = Params[1];
        tableName = Params[2];
        key = Params[3];
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        if (env.getDatabase(databaseName).isPresent()) {
            env.getDatabase(databaseName).get().read(tableName, key);
            return DatabaseCommandResult.Success("Key read successfully");
        } else {
            return DatabaseCommandResult.Error("Read key error");
        }
    }
}
