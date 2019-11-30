package com.singking.streams;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://www.javacodegeeks.com/2014/05/java-8-features-tutorial.html
 * 
 * The newly added Stream API (java.util.stream) introduces real-world
 * functional-style programming into the Java. This is by far the most
 * comprehensive addition to Java library intended to make Java developers
 * significantly more productive by allowing them to write effective, clean, and
 * concise code. Stream API makes collections processing greatly simplified (but
 * it is not limited to Java collections only as we will see later). Let us take
 * start off with simple class called Task.
 * 
 */
public class Streams {
	private enum Status {
		OPEN, CLOSED
	};

	private static final class Task {
		private final Status status;
		private final Integer points;

		Task(final Status status, final Integer points) {
			this.status = status;
			this.points = points;
		}

		public Integer getPoints() {
			return points;
		}

		public Status getStatus() {
			return status;
		}

		@Override
		public String toString() {
			return String.format("[%s, %d]", status, points);
		}
	}

	/**
	 * There are a couple of things going on here. Firstly, the tasks collection
	 * is converted to its stream representation. Then, the filter operation on
	 * stream filters out all CLOSED tasks. On next step, the mapToInt operation
	 * converts the stream of Tasks to the stream of Integers using
	 * Task::getPoints method of the each task instance. And lastly, all points
	 * are summed up using sum method, producing the final result. Before moving
	 * on to the next examples, there are some notes to keep in mind about
	 * com.singking.streams (more details here). Stream operations are divided into
	 * intermediate and terminal operations. Intermediate operations return a
	 * new stream. They are always lazy, executing an intermediate operation
	 * such as filter does not actually perform any filtering, but instead
	 * creates a new stream that, when traversed, contains the elements of the
	 * initial stream that match the given predicate Terminal operations, such
	 * as forEach or sum, may traverse the stream to produce a result or a
	 * side-effect. After the terminal operation is performed, the stream
	 * pipeline is considered consumed, and can no longer be used. In almost all
	 * cases, terminal operations are eager, completing their traversal of the
	 * underlying data source. Yet another value proposition of the com.singking.streams is
	 * out-of-the box support of parallel processing. Let us take a look on this
	 * example, which does sums the points of all the tasks.
	 * 
	 */
	public static void main(String[] args) {

		final Collection<Task> tasks = Arrays.asList(new Task(Status.OPEN, 5), new Task(Status.OPEN, 13),
				new Task(Status.CLOSED, 8));

		// Calculate total points of all active tasks using sum()
		final long totalPointsOfOpenTasks = tasks.stream().filter(task -> task.getStatus() == Status.OPEN)
				.mapToInt(Task::getPoints).sum();

		// Total points: 18
		System.out.println("Total points: " + totalPointsOfOpenTasks);

		// Calculate total points of all tasks
		final double totalPoints = tasks.stream().parallel().map(task -> task.getPoints()) // or
																							// map(
																							// Task::getPoints
																							// )
				.reduce(0, Integer::sum);

		/**
		 * It is very similar to the first example except the fact that we try
		 * to process all the tasks in parallel and calculate the final result
		 * using reduce method. Here is the console output: view sourceprint? 1
		 * Total points (all tasks): 26.
		 */
		System.out.println("Total points (all tasks): " + totalPoints);

		/**
		 * Often, there is a need to performing a grouping of the collection
		 * elements by some criteria. Streams can help with that as well as an
		 * example below demonstrates.
		 */

		// Group tasks by their status
		final Map<Status, List<Task>> map = tasks.stream().collect(Collectors.groupingBy(Task::getStatus));

		// {CLOSED=[[CLOSED, 8]], OPEN=[[OPEN, 5], [OPEN, 13]]}
		System.out.println(map);

		/**
		 * To finish up with the tasks example, let us calculate the overall
		 * percentage (or weight) of each task across the whole collection,
		 * based on its points.
		 */

		// Calculate the weight of each tasks (as percent of total points)
		final Collection<String> result = tasks.stream() // Stream< String >
				.mapToInt(Task::getPoints) // IntStream
				.asLongStream() // LongStream
				.mapToDouble(points -> points / totalPoints) // DoubleStream
				.boxed() // Stream< Double >
				.mapToLong(weigth -> (long) (weigth * 100)) // LongStream
				.mapToObj(percentage -> percentage + "%") // Stream< String>
				.collect(Collectors.toList()); // List< String >

		// [19%, 50%, 30%]
		System.out.println(result);

		/**
		 * And lastly, as we mentioned before, the Stream API is not only about
		 * Java collections. The typical I/O operations like reading the text
		 * file line by line is a very good candidate to benefit from stream
		 * processing. Here is a small example to confirm that.
		 */
		final Path path = new File("test.txt").toPath();
		try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
			lines.onClose(() -> System.out.println("Done!")).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}

		/**
		 * The onClose method called on the stream returns an equivalent stream
		 * with an additional close handler. Close handlers are run when the
		 * close() method is called on the stream. Stream API together with
		 * Lambdas and Method References baked by Interface’s Default and Static
		 * Methods is the Java 8 response to the modern paradigms in software
		 * development. For more details, please refer to official
		 * documentation.
		 */
	}
}