package Game;

public class Quest {

	public NPC npc;
	public String Description;
	public boolean completedStatus;
	public Task task;

	public class Task {

		public boolean active;
		public boolean completted;

		public Task(MapHandler map) {

		}

		public boolean isActive() {
			return active;
		}

		public void setActive(boolean active) {
			this.active = active;
		}

		public boolean isCompletted() {
			return completted;
		}

		public void setCompletted(boolean completted) {
			this.completted = completted;
		}

	}

	public NPC getNpc() {
		return npc;
	}

	public void setNpc(NPC npc) {
		this.npc = npc;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public boolean isCompletedStatus() {
		return completedStatus;
	}

	public void setCompletedStatus(boolean completedStatus) {
		this.completedStatus = completedStatus;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

}
