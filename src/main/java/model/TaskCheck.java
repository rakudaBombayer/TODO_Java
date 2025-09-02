package model;

// ToDoタスク詳細画面の入力チェックを行う

public class TaskCheck {
	
	private String task_status;
	
	private String task_label;
	
	private String task_seq;
	
	private String task_progress;
	
	public TaskCheck(String task_status, String task_label, String task_seq, String task_progress) {
		
		this.task_status = task_status;
		this.task_label = task_label;
		
		this.task_seq = task_seq;
		this.task_progress = task_progress;
	}
	
	public String getStatus() {return task_status;}
	public String getLabel() {return task_label;}
	
	public String getSeq() {return task_seq;}
	public String getProgress() {return task_progress;}
}