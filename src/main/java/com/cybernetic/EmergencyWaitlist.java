package com.cybernetic;

public class EmergencyWaitlist {
    private PriorityQueue priorityQueue;
    private BinaryTree binaryTree;

    public EmergencyWaitlist() {
        priorityQueue = new PriorityQueue();
        binaryTree = new BinaryTree();
    }

    public void addEmergencyCase(EmergencyCase eCase) {
        priorityQueue.enqueue(eCase);
        binaryTree.insert(eCase);
    }

    public EmergencyCase peek() {
        return priorityQueue.peek();
    }

    public EmergencyCase getNextUrgentCase() {
        return priorityQueue.dequeue();
    }

    public EmergencyCase findCaseById(String caseId) {
        return binaryTree.search(binaryTree.root, caseId);
    }

    public void updateCaseSeverity(String caseId, int severity) {
        priorityQueue.updateCaseSeverity(caseId, severity);
    }

    class PriorityQueue {
        int size = -1;
        EmergencyCase[] queue = new EmergencyCase[100];

        public void enqueue(EmergencyCase eCase) {
            if (size == queue.length)
                throw new IndexOutOfBoundsException("Waitlist is full.");

            queue[++size] = eCase;
        }

        public EmergencyCase peek() {
            if (isEmpty())
                throw new IllegalArgumentException("Waitlist is empty.");

            int highestSeverity = 1;
            EmergencyCase highestPriority = null;

            for (int i = 0; i <= size; i++) {
                if (queue[i].severityLevel > highestSeverity) {
                    highestPriority = queue[i];
                    highestSeverity = queue[i].severityLevel;
                }
                else if (highestSeverity == queue[i].severityLevel && highestPriority != null) {
                    if (queue[i].getWaitTime() > highestPriority.getWaitTime())
                        highestPriority = queue[i];
                }
            }

            return highestPriority;
        }

        public EmergencyCase dequeue() {
            if (size == -1)
                return null;

            EmergencyCase toDequeue = peek();
            int dequeueIndex = -1;

            for (int i = 0; i <= size; i++) {
                if (toDequeue == queue[i]) {
                    dequeueIndex = i;
                }
            }

            for (int i = dequeueIndex; i <= size; i++)
                queue[i] = queue[i + 1];

            size--;
            return toDequeue;
        }

        public void updateCaseSeverity(String caseId, int newLevel) {
            for (int i = 0; i <= size; i++) {
                if (queue[i].caseId.equals(caseId))
                    queue[i].severityLevel = newLevel;
            }
        }

        public boolean isEmpty() {
            return size == -1;
        }

    }

    class BinaryTree {
        private EmergencyCase root;

        public BinaryTree() {
            root = null;
        }

        public void insert(EmergencyCase toInsert) {
                root = insertRec(root, toInsert);
        }

        private EmergencyCase insertRec(EmergencyCase eCase, EmergencyCase toInsert) {
            if (eCase == null)
                return toInsert;

            if (toInsert.caseId.compareTo(eCase.caseId) < 0)
                eCase.left = insertRec(eCase.left, toInsert);

            else if (toInsert.caseId.compareTo(eCase.caseId) > 0)
                eCase.right = insertRec(eCase.right, toInsert);

            else
                return eCase;

            eCase.height = 1 + Math.max(height(eCase.left), height(eCase.right));

            int balance = getBalance(eCase);

            if (balance > 1 && toInsert.caseId.compareTo(eCase.caseId) < 0)
                return rightRotate(eCase);

            if (balance < -1 && toInsert.caseId.compareTo(eCase.caseId) > 0)
                return leftRotate(eCase);

            if (balance > 1 && toInsert.caseId.compareTo(eCase.caseId) > 0) {
                eCase.left = leftRotate(eCase.left);
                return  rightRotate(eCase);
            }

            if (balance < -1 && toInsert.caseId.compareTo(eCase.caseId) < 0) {
                eCase.right = rightRotate(eCase.right);
                return leftRotate(eCase);
            }

            return eCase;
        }

        private int height (EmergencyCase eCase) {
            return eCase != null ? eCase.height : - 1;
        }

        private int getBalance(EmergencyCase eCase) {
            if (eCase == null)
                return 0;
            return height(eCase.left) - height(eCase.right);
        }

        private EmergencyCase rightRotate(EmergencyCase y) {
            EmergencyCase x = y.left;
            EmergencyCase T2 = x.right;

            x.right = y;
            y.left = T2;
            y.height = 1 + Math.max(height(y.left), height(y.right));
            x.height = 1 + Math.max(height(x.left), height(x.right));

            return x;
        }

        private EmergencyCase leftRotate(EmergencyCase x) {
            EmergencyCase y = x.right;
            EmergencyCase T2 = y.left;

            y.left = x;
            x.right = T2;

            x.height = 1 + Math.max(height(x.left), height(x.right));
            y.height = 1 + Math.max(height(y.left), height(y.right));

            return y;
        }

        private EmergencyCase search(EmergencyCase root, String caseId) {
            if (root == null || root.caseId.equals(caseId))
                return root;

            if (root.caseId.compareTo(caseId) < 0)
                return search(root.right, caseId);

            return search(root.left, caseId);
        }
    }

}
