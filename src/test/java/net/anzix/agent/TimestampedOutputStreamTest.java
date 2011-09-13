package net.anzix.agent;

import java.io.ByteArrayOutputStream;

import junit.framework.Assert;

import org.junit.Test;

public class TimestampedOutputStreamTest {
	@Test
	public void print() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		TimestampedOutputStream ts = new TimestampedOutputStream(baos) {

			@Override
			protected String getPrefix() {
				return "PREFIX";
			}

		};

		ts.print("test1");
		ts.print("\ntest2");
		ts.print("test3\ntest4");
		ts.println("t5");
		ts.print("t6\nt7");

		Assert.assertEquals(
				"PREFIX test1\nPREFIX test2test3\nPREFIX test4t5\nPREFIX t6\nPREFIX t7",
				baos.toString());

	}

	@Test
	public void printTypes() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		TimestampedOutputStream ts = new TimestampedOutputStream(baos) {

			@Override
			protected String getPrefix() {
				return "PREFIX";
			}

		};

		ts.print(2l);
		ts.println("t5");	

		Assert.assertEquals("PREFIX 2t5\n", baos.toString());

	}
}
