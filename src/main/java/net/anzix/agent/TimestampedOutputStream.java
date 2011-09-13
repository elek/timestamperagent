package net.anzix.agent;

import java.io.OutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Output stream which decorate the lines with the current timestamp.
 * 
 * @author elek
 * 
 */
public class TimestampedOutputStream extends PrintStream {

	private SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy.MM.dd HH:mm:ss.SSS");
	private boolean lineEnded = true;

	@Override
	public void print(long l) {
		if (lineEnded) {
			super.print(getPrefix() + " ");
			lineEnded = false;
		}
		super.print(l);
	}

	@Override
	public void print(String s) {
		if (lineEnded) {
			super.print(getPrefix() + " ");
		}
		super.print(s.replaceAll(System.lineSeparator(), System.lineSeparator()
				+ getPrefix() + " "));

		if (s.endsWith(System.lineSeparator())) {
			lineEnded = true;
		} else {
			lineEnded = false;
		}
	}

	@Override
	public void println(String x) {
		super.println(x);
		lineEnded = true;
	}

	public TimestampedOutputStream(OutputStream out) {
		super(out);
	}

	protected String getPrefix() {
		return sdf.format(new Date());
	}

}
