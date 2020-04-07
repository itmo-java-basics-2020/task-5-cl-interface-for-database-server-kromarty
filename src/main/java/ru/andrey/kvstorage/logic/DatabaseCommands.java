package ru.andrey.kvstorage.logic;

import ru.andrey.kvstorage.console.*;

public enum DatabaseCommands {
    CREATE_DATABASE {
        @Override
        public DatabaseCommand getCommand(ExecutionEnvironment env, String[] params) {
            return new CreateDatabase(env, params);
        }
    },
    CREATE_TABLE {
        @Override
        public DatabaseCommand getCommand(ExecutionEnvironment env, String[] params) {
            return new CreateTable(env, params);
        }
    },
    UPDATE_KEY {
        @Override
        public DatabaseCommand getCommand(ExecutionEnvironment env, String[] params) {
            return new UpdateKey(env, params);
        }
    },
    READ_KEY {
        @Override
        public DatabaseCommand getCommand(ExecutionEnvironment env, String[] params) {
            return new ReadKey(env, params);
        }
    };

    public abstract DatabaseCommand getCommand(ExecutionEnvironment env, String[] params);
}