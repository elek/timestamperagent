package net.anzix.agent;

import java.lang.instrument.Instrumentation;

/**
 * Java agent implementation to modify
 * 
 * @author elek
 * 
 */
public class TimestamperAgent {

	public static void premain(String args, Instrumentation inst) {
		modifySystemOut();
	}

	private static void modifySystemOut() {
		Timestamper.changeStreams();
	}

	public static void main(String[] args) {
		modifySystemOut();
		System.out.println("asd");
	}
}
