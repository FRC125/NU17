package com.nutrons.nu17;
import static org.junit.Assert.*;
import com.nutrons.nu17.*;

import org.junit.Test;

import lib.DebouncedBoolean;
import lib.DebouncedBooleanInterface;

public class BooleanTest {

	
	@Test 
	public void allFalse(){
		DebouncedBooleanInterface x = new DebouncedBoolean(3,true);
		x.add(false);
		assertEquals(true, x.get());
		x.add(false);
		assertEquals(true, x.get());
		x.add(false);
		assertEquals(true, x.get());
		x.add(false);
		assertEquals(false, x.get());
	}
	
	@Test
	public void allTrue(){
		DebouncedBooleanInterface x = new DebouncedBoolean(3,false);
		x.add(true);
		assertEquals(false, x.get());
		x.add(true);
		assertEquals(false, x.get());
		x.add(true);
		assertEquals(true, x.get());
		x.add(true);
		assertEquals(true, x.get());
	}
	
	@Test 
	public void changingValues(){
		DebouncedBooleanInterface x = new DebouncedBoolean (3, true);
		x.add(false);
		assertEquals(true, x.get());
		x.add(false);
		assertEquals(true, x.get());
		x.add(false);
		assertEquals(true, x.get());
		x.add(false);
		assertEquals(false, x.get());
		x.add(false);
		assertEquals(false, x.get());
		x.add(false);
		assertEquals(false, x.get());
		x.add(false);
		assertEquals(false, x.get());
		x.add(true);
		assertEquals(false, x.get());
		x.add(true);
		assertEquals(false, x.get());
		x.add(true);
		assertEquals(false, x.get());
		x.add(true);
		assertEquals(true, x.get());
	}
}
