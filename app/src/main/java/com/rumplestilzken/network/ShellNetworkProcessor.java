package com.rumplestilzken.network;

import com.rumplestilzken.shell.ShellCommandProcessor;

public class ShellNetworkProcessor extends NetworkProcessor {
    @Override
    public String getIP4Addresses() {

        ShellCommandProcessor cmd = new ShellCommandProcessor();
        cmd.run();

        return cmd.getResult();
    }
}
