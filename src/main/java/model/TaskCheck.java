package model;

// ToDoタスク詳細画面の入力チェックを行う

public class TaskCheck {

    private int task_status;
    private String task_label;
    private int task_seq;
    private boolean task_progress;

    public TaskCheck(int task_status, String task_label, int task_seq, boolean task_progress) {
        this.task_status = task_status;
        this.task_label = task_label;
        this.task_seq = task_seq;
        this.task_progress = task_progress;
    }

    public int getStatus() { return task_status; }
    public String getLabel() { return task_label; }
    public int getSeq() { return task_seq; }
    public boolean getProgress() { return task_progress; }
}
