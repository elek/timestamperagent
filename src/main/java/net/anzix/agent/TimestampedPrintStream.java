package net.anzix.agent;

import java.io.OutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Output stream which decorate the lines with the current timestamp.
 *
 * @author elek
 */
public class TimestampedPrintStream extends PrintStream {

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

    public String getLineSeparator() {
        return System.getProperty("line.separator");
    }

    @Override
    public void print(String s) {
        String ls = getLineSeparator();
        if (lineEnded) {
            super.print(getPrefix() + " ");
        }
        super.print(s.replaceAll(ls, ls + getPrefix() + " "));

        if (s.endsWith(ls)) {
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

    public TimestampedPrintStream(OutputStream out) {
        super(out);
    }

    protected String getPrefix() {
        return sdf.format(new Date());
    }

}
