package com.cybernetic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransplantHistory {
    private TransplantRecord head;

    public void addTransplantRecordAtBeginning(TransplantRecord record) {
        if (head == null)
            head = record;

        else {
            record.next = head;
            head = record;
        }
    }

    public void addTransplantRecordAtEnd(TransplantRecord record) {
        if (head == null)
            head = record;

        else {
            TransplantRecord current = head;

            while (current != null)
                current = current.next;

            current.next = record;
        }
    }

    public List<TransplantRecord> getRecentTransplants(int count) {
        List<TransplantRecord> recent = new ArrayList<>();

        int i = 0;
        TransplantRecord current = head;
        while (current != null) {
            if (i == count)
                break;
            else {
                recent.add(current);
                i++;
                current = current.next;
            }
        }

        return recent;
    }

    public List<TransplantRecord> getAllTransplantsByDate(LocalDate date) {
        List<TransplantRecord> allByDate = new ArrayList<>();

        TransplantRecord current = head;
        while (current != null) {
            if (current.timestamp.toLocalDate().isBefore(date) || current.timestamp.toLocalDate().isEqual(date))
                allByDate.add(current);
            current = current.next;
        }

        return allByDate;
    }

    public void deleteRecord(String operationId) {
        TransplantRecord current = head;
        TransplantRecord prev = null;
        while (current != null && !current.operationId.equals(operationId)) {
            prev = current;
            current = current.next;
        }

        if (current == null)
            return;

        prev.next = current.next;
    }

    public TransplantRecord searchRecord(String operationId) {
        TransplantRecord current = head;
        while (current != null) {
            if (current.operationId.equals(operationId))
                return current;
            current = current.next;
        }

        return null;
    }

}
