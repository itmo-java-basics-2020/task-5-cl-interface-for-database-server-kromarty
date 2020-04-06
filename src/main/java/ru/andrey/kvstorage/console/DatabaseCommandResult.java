package ru.andrey.kvstorage.console;

import java.util.Optional;

public interface DatabaseCommandResult {

    Optional<String> getResult();

    DatabaseCommandStatus getStatus();

    boolean isSuccess();

    String getErrorMessage();

    enum DatabaseCommandStatus {
        SUCCESS, FAILED
    }

    static DatabaseCommandResult Success(String result) {
        return new DatabaseCommandResultInnerClass(true, result);
    }

    static DatabaseCommandResult Error(String error_message) {
        return new DatabaseCommandResultInnerClass(false, error_message);
    }

    class DatabaseCommandResultInnerClass implements DatabaseCommandResult {
        boolean isSuccess;
        String response;

        private DatabaseCommandResultInnerClass(boolean IsSuccess, String Response) {
            isSuccess = IsSuccess;
            response = Response;
        }

        @Override
        public Optional<String> getResult() {
            if (isSuccess) {
                return Optional.of(response);
            } else {
                return Optional.empty();
            }
        }

        @Override
        public DatabaseCommandStatus getStatus() {
            if (isSuccess) {
                return DatabaseCommandStatus.SUCCESS;
            }
            else {
                return DatabaseCommandStatus.FAILED;
            }
        }

        @Override
        public boolean isSuccess() {
            return isSuccess;
        }

        @Override
        public String getErrorMessage() {
            if (!isSuccess) {
                return response;
            } else {
                return null;
            }
        }
    }
}
