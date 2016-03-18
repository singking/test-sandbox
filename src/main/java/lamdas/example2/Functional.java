package lamdas.example2;

/**
 * Language designers put a lot of thought on how to make already existing
 * functionality lambda-friendly. As a result, the concept of functional
 * interfaces has emerged. The function interface is an interface with just one
 * single method. As such, it may be implicitly converted to a lambda
 * expression. The java.lang.Runnable and java.util.concurrent.Callable are two
 * great examples of functional interfaces. In practice, the functional
 * interfaces are fragile: if someone adds just one another method to the
 * interface definition, it will not be functional anymore and compilation
 * process will fail. To overcome this fragility and explicitly declare the
 * intent of the interface as being functional, Java 8 adds special
 * annotation @FunctionalInterface (all existing interfaces in Java library have
 * been annotated with @FunctionalInterface as well). Let us take a look on this
 * simple functional interface definition:
 * 
 */
@FunctionalInterface
public interface Functional {
	void method();
}
