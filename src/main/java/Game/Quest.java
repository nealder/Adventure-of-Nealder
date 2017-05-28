package Game;

/**
 * Currently unused. The class which in we handle game quests, which the player can complete.
 * 
 * @author Bencs Dániel
 *
 */
public class Quest {

	/**
	 * A quest has it's owner.
	 */
	public NPC npc;
	/**
	 * The description of the quest.
	 */
	public String Description;
	/**
	 * The status that show the player that the quest is completed or still active.
	 */
	public boolean completedStatus;
	/**
	 * Task are the requirements of a quest.
	 */
	public Task task;

	/**
	 * Nested class which we use to handle the tasks of quest.
	 * 
	 * @author Nealder
	 *
	 */
	public class Task {

		/**
		 * The indicator that shows if the task is still active.
		 */
		public boolean active;
		/**
		 * The indicator that shows if the task is still in progress.
		 */
		public boolean completted;

		/**
		 * Currently unused. Constructor. Map based Constructor.
		 * 
		 * @param map - map which is menat to be a goal of a task.
		 */
		public Task(MapHandler map) {

		}

		/**
		 * Returns the indicator of activation.
		 * 
		 * @return
		 */
		public boolean isActive() {
			return active;
		}

		/**
		 * Sets the indicator of activation of the quest.
		 * 
		 * @param active
		 */
		public void setActive(boolean active) {
			this.active = active;
		}

		/**
		 * Returns the indicator of complettion.
		 * 
		 * @return
		 */
		public boolean isCompletted() {
			return completted;
		}

		/**
		 * Sets the indicator of complettion of the quest.
		 * 
		 * @param completted
		 */
		public void setCompletted(boolean completted) {
			this.completted = completted;
		}

	}

	/**
	 * Returns the owner NPC of the quest.
	 * 
	 * @return
	 */
	public NPC getNpc() {
		return npc;
	}

	/**
	 * Sets the owner NPC of the quest.
	 * 
	 * @param npc
	 */
	public void setNpc(NPC npc) {
		this.npc = npc;
	}

	/**
	 * Returns the description of the quest.
	 * 
	 * @return
	 */
	public String getDescription() {
		return Description;
	}

	/**
	 * Sets the description of the quest.
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		Description = description;
	}

	/**
	 * Return the indicator of complettion.
	 * 
	 * @return
	 */
	public boolean isCompletedStatus() {
		return completedStatus;
	}

	/**
	 * Sets the indicator of complettion.
	 * 
	 * @param completedStatus
	 */
	public void setCompletedStatus(boolean completedStatus) {
		this.completedStatus = completedStatus;
	}

	/**
	 * Returns the task of the quest
	 */
	public Task getTask() {
		return task;
	}

	/**
	 * Sets the task of the quest.
	 * 
	 * @param task - to task
	 */
	public void setTask(Task task) {
		this.task = task;
	}

}
