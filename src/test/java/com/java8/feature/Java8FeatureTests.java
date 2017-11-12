package com.java8.feature;

import static org.junit.Assert.assertSame;

import org.junit.Test;

import com.java8.feature.ChildClass;
import com.java8.feature.Hai;
import com.java8.feature.Hello;
import com.java8.feature.ParentClass;

/**
 * Unit test for java8 features.
 */
public class Java8FeatureTests {

	@Test
	public void shouldCallTheHelloClassShowMethod() {
		Hello hello = new Hello();
		assertSame("Show method of Hello Class", hello.show());
	}

	@Test
	public void shouldCallTheHelloClassDisplayMethod() {
		Hello hello = new Hello();
		assertSame("Display method of Hello Class", hello.display());
	}

	@Test
	public void shouldCallTheDefaultProcessMethodOfInterface() {
		Hello hello = new Hello();
		assertSame("interface level implementation of default process method", hello.process());
	}

	@Test
	public void shouldCallTheDefaultExecuteMethodOfInterface() {
		Hello hello = new Hello();
		assertSame("interface level implementation of default execute method", hello.execute());
	}

	@Test
	public void shouldCallTheHaiClassShowMethod() {
		Hai hai = new Hai();
		assertSame("Show method of Hai Class", hai.show());
	}

	@Test
	public void shouldCallTheHaiClassDisplayMethod() {
		Hai hai = new Hai();
		assertSame("Display method of Hai Class", hai.display());
	}

	@Test
	public void shouldCallTheHaiClassImplementedProcessMethod() {
		Hai hai = new Hai();
		assertSame("Hai class implementation of default process method", hai.process());
	}

	@Test
	public void shouldCallTheIntefaceLevelExecuteMethodUsingHaiClass() {
		Hai hai = new Hai();
		assertSame("interface level implementation of default execute method", hai.execute());
	}

	@Test
	public void shouldCallTheParentClassProcessMethodInstedOfInterface() {
		ChildClass childClass = new ChildClass();
		assertSame("Parent class process method", childClass.process());
	}

	@Test
	public void shouldCallTheDefaultMethodOfInterface2() {
		ChildClass childClass = new ChildClass();
		assertSame(10, childClass.getNumber());
	}

	@Test
	public void shouldCallTheDefaultMethodOdInterface1() {
		ParentClass parentClass = new ParentClass();
		assertSame(42, parentClass.getNumber());
	}
}
