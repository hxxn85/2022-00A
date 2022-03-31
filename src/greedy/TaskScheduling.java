package greedy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

public class TaskScheduling {
    private record Task(int id, int s, int e) {
        @Override
        public String toString() {
            return String.format("[%03d] %d - %d", id, s, e);
        }
    }

    private PriorityQueue<Task> q = new PriorityQueue<>();

    private int nMachine;
    private int[] lastTask;
    public TaskScheduling(int nMachine, Task[] task) {
        this.nMachine = nMachine;
        q = new PriorityQueue<>((o1, o2) -> o1.s - o2.s);
        Arrays.stream(task).forEach(q::add);
    }

    public void assignTask() {
        Iterator<Task> it = q.iterator();
        while (it.hasNext()) {
            Task task = q.poll();
        }
    }

    public static void main(String[] args) {
        Task[] t = {
                new Task(0, 7, 8),
                new Task(1, 3, 7),
                new Task(2, 1, 5),
                new Task(3, 5, 9),
                new Task(4, 0, 2),
                new Task(5, 6, 8),
                new Task(6, 1, 6),
        };
    }
}
