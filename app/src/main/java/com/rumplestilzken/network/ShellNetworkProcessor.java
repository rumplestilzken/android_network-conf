package com.rumplestilzken.network;

import android.content.Context;

import com.rumplestilzken.shell.IP4ShellCommandProcessor;
import com.rumplestilzken.shell.IP6ShellCommandProcessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ShellNetworkProcessor extends NetworkProcessor {

    public ShellNetworkProcessor(Context context)
    {
        super(context);
    }

    @Override
    public String getIP4Addresses() {
        IP4ShellCommandProcessor cp = new IP4ShellCommandProcessor(ProcessType.AddressInformation);
        cp.run();
        return cp.getResult();
    }

    @Override
    public String getIP4Ping() {
        IP4ShellCommandProcessor cp = new IP4ShellCommandProcessor(ProcessType.Ping);
        cp.run();
        return cp.getResult();
    }

    @Override
    public String getIP6Addresses() {
        IP6ShellCommandProcessor cp = new IP6ShellCommandProcessor(ProcessType.AddressInformation);
        cp.run();
        return cp.getResult();
    }

    @Override
    public String getIP6Ping() {
        IP6ShellCommandProcessor cp = new IP6ShellCommandProcessor(ProcessType.Ping);
        cp.run();
        return cp.getResult();
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
