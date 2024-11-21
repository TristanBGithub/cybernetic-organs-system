package com.cybernetic;

import java.time.LocalDateTime;

public class SystemOperation {
    String operationId;
    String operationType; // "MATCH", "TRANSPLANT", "EMERGENCY"
    LocalDateTime timestamp;
    String description;
    boolean isReversible;

    public SystemOperation(String operationId, String operationType, String description, boolean isReversible) {

        this.operationId = operationId;
        this.operationType = operationType;
        this.timestamp = LocalDateTime.now();
        this.description = description;
        this.isReversible = isReversible;
    }

    public String toString() {
        return operationId + ": " + operationType;
    }

    public String getOperationId() {
        return operationId;
    }
}
