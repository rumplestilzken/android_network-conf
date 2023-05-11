package com.rumplestilzken.shell;

import static java.util.logging.Logger.getLogger;

import android.os.Handler;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShellCommandProcessor extends Thread {
    String result = "";

    public String getResult() {
        return result;
    }

    public native String ping(int count, String address);

    @Override
    public void run() {
        StringBuilder result = new StringBuilder();
        result.append("NATIVE" + System.lineSeparator());
        result.append("Ping 8.8.8.8" + System.lineSeparator() + ping(2, "8.8.8.8") + System.lineSeparator());
        result.append("Ping google.com" + System.lineSeparator() + ping(2, "google.com") + System.lineSeparator());
        result.append("JAVA" + System.lineSeparator());
        result.append("Ping 8.8.8.8" + System.lineSeparator() + ShellCommandProcessor.sudoForResult("ping -c 2 8.8.8.8") + System.lineSeparator());
        result.append("Ping google.com" + System.lineSeparator() + ShellCommandProcessor.sudoForResult("ping -c 2 google.com") + System.lineSeparator());
        this.result = result.toString();
    }

    public static String sudoForResult(String command) {
        try {
            // Executes the command.
            ProcessBuilder pb = new ProcessBuilder(command.split(" "));
            Process p = pb.start();
            p.waitFor();
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String _temp = null;
            List<String> line = new ArrayList<String>();
            while ((_temp = in.readLine()) != null) {
                System.out.println( _temp);
                line.add(_temp);
            }
            StringBuilder b = new StringBuilder();
            line.forEach(b::append);

            return b.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
