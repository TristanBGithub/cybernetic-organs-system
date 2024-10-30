package com.cybernetic;

import lombok.Data;

@Data
public class WaitingList {
    private WaitingListNode head;

    public void addPatient(Patient patient, int priority) {
        WaitingListNode new_node = new WaitingListNode(patient, priority);

        if (head == null)
            head = new_node;

        else {
            WaitingListNode currentNode = head;
            WaitingListNode previous = null;

            while (currentNode != null) {
                if (priority > currentNode.priority) {
                    if (currentNode == head) {
                        new_node.next = head;
                        head = new_node;
                        return;
                    }

                    else {
                        previous.next = new_node;
                        new_node.next = currentNode;
                    }
                }

                else if (currentNode.next == null) {
                    currentNode.next = new_node;
                    return;
                }

                previous = currentNode;
                currentNode = currentNode.next;
            }
        }
//        else {
//            WaitingListNode last = head;
//            while (last.next != null)
//                last = last.next;
//
//            last.next = new_node;
//        }
    }

    public Patient removeHighestPriority() {
        WaitingListNode currentNode = head;
        WaitingListNode highestPriorityNode = null;
        WaitingListNode previous = null;
        int highestPriority = 0;

        // Loop through the nodes and find the one with the highest priority
        while (currentNode != null) {
            if (currentNode.priority > highestPriority) {
                highestPriority = currentNode.priority;
                highestPriorityNode = currentNode;
            }
            currentNode = currentNode.next;
        }

        // If the head has the highest priority, make the following node the new head and return highestPriorityNode's patient
        if (head == highestPriorityNode) {
            head = highestPriorityNode.next;
            return  highestPriorityNode.patient;
        }

        // If a node other than the head is the current priority, loop through the nodes again to find the node before the highestPriorityNode
        currentNode = head.next;
        while (currentNode != highestPriorityNode) {
            previous = currentNode;
            currentNode = currentNode.next;
        }

        // Remove the highestPriorityNode from the list by linking the previous node to the next node and return the highestPriorityNode's patient
        previous.next = highestPriorityNode.next;
        return highestPriorityNode.patient;

    }

    public void updatePriority(String patientId, int newPriority) {
        WaitingListNode currentNode = head;

        while (currentNode != null) {
            if (currentNode.patient.getId().equals(patientId)) {
                currentNode.priority = newPriority;
                break;
            }

            currentNode = currentNode.next;
        }

        removePatient(patientId);
        addPatient(currentNode.patient, currentNode.priority);
    }

    public void displayWaitingList() {
        WaitingListNode currentNode = head;
        int patientNumber = 1;

        while (currentNode != null) {
            System.out.println(patientNumber + ". " + currentNode.patient.getName() + " (Priority: " + currentNode.priority + ")");
            patientNumber++;
            currentNode = currentNode.next;
        }
    }

    public int getPosition(String patientId) {
        WaitingListNode currentNode = head;
        int patientNumber = 1;

        while (currentNode != null) {
            if (currentNode.patient.getId().equals(patientId)) {
                return patientNumber;
            }
            patientNumber++;
            currentNode = currentNode.next;
        }

        return -1;
    }

    public void removePatient (String patientId) {
        WaitingListNode currentNode = head;
        WaitingListNode previous = null;

        if (currentNode != null && currentNode.patient.getId().equals(patientId)) {
            head = currentNode.next;
        }

        else {
            while (currentNode != null && !currentNode.patient.getId().equals(patientId)) {
                previous = currentNode;
                currentNode = currentNode.next;
            }

            if (currentNode != null)
                previous.next = currentNode.next;
            else
                System.out.println("Not found.");
        }
    }

    public WaitingListNode getHead() {
        return head;
    }
}
