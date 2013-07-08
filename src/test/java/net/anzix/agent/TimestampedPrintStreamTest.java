package net.anzix.agent;

import junit.framework.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

public class TimestampedPrintStreamTest {
    @Test
    public void print() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        TimestampedPrintStream ts = new TimestampedPrintStream(baos) {

            @Override
            protected String getPrefix() {
                return "PREFIX";
            }

            @Override
            public String getLineSeparator() {
                return "\n";
            }
        };

        ts.print("test1");
        ts.print("\ntest2");
        ts.print("test3\ntest4");
        ts.println("t5");
        ts.print("t6\nt7");

        Assert.assertEquals(
                "PREFIX test1\nPREFIX test2test3\nPREFIX test4t5\nPREFIX t6\nPREFIX t7",
                baos.toString().replaceAll("\r\n", "\n"));

    }

    @Test
    public void printTypes() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        TimestampedPrintStream ts = new TimestampedPrintStream(baos) {

            @Override
            protected String getPrefix() {
                return "PREFIX";
            }

            @Override
            public String getLineSeparator() {
                return "\n";
            }

        };

        ts.print(2l);
        ts.println("t5");

        Assert.assertEquals("PREFIX 2t5\n", baos.toString().replaceAll("\r\n", "\n"));

    }
}
