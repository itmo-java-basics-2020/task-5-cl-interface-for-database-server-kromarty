package ru.andrey.kvstorage;

import ru.andrey.kvstorage.console.*;

enum DatabaseCommands {
    CREATE_DATABASE {
        @Override
        DatabaseCommand getCommand(ExecutionEnvironment env, String[] params) {
            return new CreateDatabase(env, params);
        }
    },
    CREATE_TABLE {
        @Override
        DatabaseCommand getCommand(ExecutionEnvironment env, String[] params) {
            return new CreateTable(env, params);
        }
    },
    UPDATE_KEY {
        @Override
        DatabaseCommand getCommand(ExecutionEnvironment env, String[] params) {
            return new UpdateKey(env, params);
        }
    },
    READ_KEY {
        @Override
        DatabaseCommand getCommand(ExecutionEnvironment env, String[] params) {
            return new ReadKey(env, params);
        }
    };
    abstract DatabaseCommand getCommand(ExecutionEnvironment env, String[] params);
}