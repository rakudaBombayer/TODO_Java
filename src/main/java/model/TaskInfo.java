package model;

// ToDoタスク情報を保持する
public class TaskInfo {
	
	private String task_id;
	
	private String task_name;
	private String task_contents;
	
	private String task_limitdate;	
	private String task_update;
	private String task_delete;
	
	private String task_user;
	private String task_status;
	
	public TaskInfo(String task_id, String task_name, String task_contents,
            String task_limitdate, String task_update, String task_delete,
            String task_user, String task_status) {
		
		this.task_id = task_id;
		
		this.task_name = task_name;
		this.task_contents = task_contents;
		
		this.task_limitdate = task_limitdate;
		this.task_update = task_update;
		this.task_delete = task_delete;
		
		this.task_user = task_user;
		this.task_status = task_status;
	}
	
	public String getTaskId() {return task_id;}
	
	public String getTaskName() {return task_name;}
	public String getTaskContents() {return task_contents;}
	
	public String getTaskLimitdate() {return task_limitdate;}
	public String getTaskUpdate() {return task_update;}
	public String getTaskDelete() {return task_delete;}
	
	public String getTaskUser() {return task_user;}
	public String getTaskStatus() {return task_status;}
	
	public void setTaskStatus(String task_status) {
	    this.task_status = task_status;
	}

	public void setTaskDelete(String task_delete) {
	    this.task_delete = task_delete;
	}
	
}