package net.anzix.agent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Timestamper {

	public static void changeStreams() {
		try {
			String tsDir = System.getProperty("tsDir") == null ? System
					.getenv("TS_OUT") : System.getProperty("tsDir");
			if (tsDir != null) {

				PrintStream out = System.out;
				System.setOut(new CombinedPrintStream(out,
						new TimestampedPrintStream(new PrintStream(new File(
								tsDir, "output.log")))));

				PrintStream error = System.err;
				System.setErr(new CombinedPrintStream(error,
						new TimestampedPrintStream(new PrintStream(new File(
								tsDir, "error.log")))));

			} else {
				System.setErr(new TimestampedPrintStream(System.err));
				System.setOut(new TimestampedPrintStream(System.out));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
