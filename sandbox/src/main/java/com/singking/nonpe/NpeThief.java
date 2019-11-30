package com.singking.nonpe;

/**
 * http://jawspeak.com/2010/05/26/hotspot-caused-exceptions-to-lose-their-stack-
 * traces-in-production-and-the-fix/
 * 
 * 
 * The JVM flag -XX:-OmitStackTraceInFastThrow disables the performance
 * optimization of the JVM for this use case. If this flag is set, the
 * stacktrace will be available. (editor: or if the -Xint is set).
 * 
 * The compiler in the server VM now provides correct stack backtraces for all
 * cold built-in exceptions. For performance purposes, when such an exception is
 * thrown a few times, the method may be recompiled. After recompilation, the
 * compiler may choose a faster tactic using preallocated exceptions that do not
 * provide a stack trace. To disable completely the use of preallocated
 * exceptions, use this new flag: -XX:-OmitStackTraceInFastThrow.�
 * 
 * @author tyrone
 *
 */
public class NpeThief {
	public void callManyNPEInLoop() {
		for (int i = 0; i < 100000; i++) {
			try {
				((Object) null).getClass();
			} catch (Exception e) {
				// This will switch from 2 to 0 (indicating our problem is
				// happening)
				System.out.println(e.getStackTrace().length);
			}
		}
	}

	public static void main(String... args) {
		NpeThief thief = new NpeThief();
		thief.callManyNPEInLoop();
	}
}
