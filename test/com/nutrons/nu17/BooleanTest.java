package com.nutrons.nu17;
import static org.junit.Assert.*;
import com.nutrons.nu17.*;

import org.junit.Test;

import lib.DebouncedBoolean;
import lib.DebouncingBoolean;

public class BooleanTest {

	@Test
	public void falseTest() {
		DebouncedBoolean x = new DebouncingBoolean(3,false);
		assertEquals(false, x.get());
	}
	
	
	@Test
	public void trueTest(){
		DebouncedBoolean x = new DebouncingBoolean(3, true);
				assertEquals(true, x.get());
	}
	
	@Test
	public void passing(){
		DebouncedBoolean x = new DebouncingBoolean(3,false);
		x.add(true);
		assertEquals(true,x.get());
		System.out.println(" ");
		x.add(true);
		assertEquals(true, x.get());
		System.out.println(" ");
		x.add(true);
		assertEquals(true, x.get());
		System.out.println(" ");
	}
	
	@Test
	public void passingFalse(){
		DebouncedBoolean x = new DebouncingBoolean(3, true);
		x.add(false);
		assertEquals(false, x.get());
		x.add(false);
		assertEquals(false, x.get());
		x.add(false);
		assertEquals(false,x.get());
	}
	
	@Test
	public void changingTrue(){
		DebouncedBoolean x = new DebouncingBoolean(3,false);
		x.add(false);
		assertEquals(false, x.get());
		x.add(false);
		assertEquals(false, x.get());
		x.add(false);
		assertEquals(false, x.get());
		x.add(true);
		assertEquals(true, x.get());
		x.add(true);
		assertEquals(true, x.get());
		x.add(true);
		assertEquals(true, x.get());
	}
	
	@Test
	public void changingFalse(){
		DebouncedBoolean x = new DebouncingBoolean(3,true);
		x.add(false);
		assertEquals(false, x.get());
		x.add(false);
		assertEquals(false, x.get());
		x.add(false);
		assertEquals(false, x.get());
		x.add(true);
		assertEquals(true, x.get());
		x.add(true);
		assertEquals(true, x.get());
		x.add(true);
		assertEquals(true, x.get());
	}
}
