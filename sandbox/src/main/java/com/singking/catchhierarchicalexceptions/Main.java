package com.singking.catchhierarchicalexceptions;

public class Main {

	public void throwExceptionLevel1() throws ExceptionLevel1 {
		throw new ExceptionLevel1("shese");
	}

	public void throwRuntimeException() throws ExceptionLevel2 {
		throw new ExceptionLevel2("shese");
	}

	public void throwUnsupportedOperationException() throws ExceptionLevel2 {
		throw new UnsupportedOperationException("shese");
	}

	public static void main(String[] args) {

		try {
			new Main().throwUnsupportedOperationException();
		} catch (ExceptionLevel2 e) {
			System.out.println("caught the ExceptionLevel2 exception");
			e.printStackTrace();
		} catch (RuntimeException e) {
			System.out.println("caught the runtime exception");
			e.printStackTrace();
		}

		System.out.println("trying again ..");
		try {
			new Main().throwUnsupportedOperationException();
		} catch (Exception e) {
			System.out.println("caught the Exception exception");
			e.printStackTrace();
		}

		System.out.println("trying again 2..");
		try {
			new Main().throwExceptionLevel1();
		//} catch (ExceptionLevel2 e) {
		} catch (ExceptionLevel1 e) {
			System.out.println("caught the Exception exception");
			e.printStackTrace();
		}
		System.out.println("and we're done");
	}
}
