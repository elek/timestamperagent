package net.anzix.agent;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Simple proxy to delegate PrintStream calls to other classes.
 * 
 * @author elek
 *
 */
public class CombinedPrintStream extends PrintStream {

	private List<PrintStream> delegates = new ArrayList<PrintStream>();

	public CombinedPrintStream(PrintStream... ds) {
		super(new ByteArrayOutputStream());
		this.delegates = Arrays.asList(ds);
	}

	@Override
	public void flush() {
		for (PrintStream d : delegates) {
			d.flush();
		}
	}

	@Override
	public void close() {
		for (PrintStream d : delegates) {
			d.close();
		}
	}

	@Override
	public boolean checkError() {
		boolean result = false;
		for (PrintStream d : delegates) {
			result = result || d.checkError();
		}
		return result;
	}

	@Override
	public void write(int b) {
		for (PrintStream d : delegates) {
			d.write(b);
		}
	}

	@Override
	public void write(byte[] buf, int off, int len) {
		for (PrintStream d : delegates) {
			d.write(buf, off, len);
		}
	}

	@Override
	public void print(boolean b) {
		for (PrintStream d : delegates) {
			d.print(b);
		}
	}

	@Override
	public void print(char c) {
		for (PrintStream d : delegates) {
			d.print(c);
		}
	}

	@Override
	public void print(int i) {
		for (PrintStream d : delegates) {
			d.print(i);
		}
	}

	@Override
	public void print(long l) {
		for (PrintStream d : delegates) {
			d.print(l);
		}
	}

	@Override
	public void print(float f) {
		for (PrintStream d : delegates) {
			d.print(f);
		}
	}

	@Override
	public void print(double val) {
		for (PrintStream d : delegates) {
			d.print(val);
		}
	}

	@Override
	public void print(char[] s) {
		for (PrintStream d : delegates) {
			d.print(s);
		}
	}

	@Override
	public void print(String s) {
		for (PrintStream d : delegates) {
			d.print(s);
		}
	}

	@Override
	public void print(Object obj) {
		for (PrintStream d : delegates) {
			d.print(obj);
		}
	}

	@Override
	public void println() {
		for (PrintStream d : delegates) {
			d.print(d);
		}
	}

	@Override
	public void println(boolean x) {
		for (PrintStream d : delegates) {
			d.print(x);
		}
	}

	@Override
	public void println(char x) {
		for (PrintStream d : delegates) {
			d.println(x);
		}
	}

	@Override
	public void println(int x) {
		for (PrintStream d : delegates) {
			d.println(x);
		}
	}

	@Override
	public void println(long x) {
		for (PrintStream d : delegates) {
			d.println(x);
		}
	}

	@Override
	public void println(float x) {
		for (PrintStream d : delegates) {
			d.println(x);
		}
	}

	@Override
	public void println(double x) {
		for (PrintStream d : delegates) {
			d.println(x);
		}
	}

	@Override
	public void println(char[] x) {
		for (PrintStream d : delegates) {
			d.println(x);
		}
	}

	@Override
	public void println(String x) {
		for (PrintStream d : delegates) {
			d.println(x);
		}
	}

	@Override
	public void println(Object x) {
		for (PrintStream d : delegates) {
			d.println(x);
		}
	}

	@Override
	public PrintStream printf(String format, Object... args) {
		for (PrintStream d : delegates) {
			d.printf(format, args);
		}
		return this;
	}

	@Override
	public PrintStream printf(Locale l, String format, Object... args) {
		for (PrintStream d : delegates) {
			d.printf(l, format, args);
		}
		return this;
	}

	@Override
	public PrintStream format(String format, Object... args) {
		for (PrintStream d : delegates) {
			d.format(format, args);
		}
		return this;
	}

	@Override
	public PrintStream format(Locale l, String format, Object... args) {
		for (PrintStream d : delegates) {
			d.format(l, format, args);
		}
		return this;
	}

	@Override
	public PrintStream append(CharSequence csq) {
		for (PrintStream d : delegates) {
			d.append(csq);
		}
		return this;
	}

	@Override
	public PrintStream append(CharSequence csq, int start, int end) {
		for (PrintStream d : delegates) {
			d.append(csq, start, end);
		}
		return this;
	}

	@Override
	public PrintStream append(char c) {
		for (PrintStream d : delegates) {
			d.append(c);
		}
		return this;
	}

	@Override
	public void write(byte[] b) throws IOException {
		for (PrintStream d : delegates) {
			d.write(b);
		}
	}

}
