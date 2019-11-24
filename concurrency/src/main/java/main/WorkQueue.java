package concurrency.main;

public interface WorkQueue {

	public abstract void startAllThreads();

	public int stopWhenAllTaskFinished();

	public void execute(Runnable t);

}
