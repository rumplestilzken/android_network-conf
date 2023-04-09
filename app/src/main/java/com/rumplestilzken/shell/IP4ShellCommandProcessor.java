package com.rumplestilzken.shell;

import static java.util.logging.Logger.getLogger;

import com.rumplestilzken.network.NetworkProcessor;
import com.rumplestilzken.network.ShellNetworkProcessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class IP4ShellCommandProcessor extends Thread {
    String result = "";
    NetworkProcessor.ProcessType type = NetworkProcessor.ProcessType.NotSet;

    public IP4ShellCommandProcessor(NetworkProcessor.ProcessType type)
    {
        this.type = type;
    }

    public String getResult() {
        return result;
    }

    public native String ping(int count, String address);

    @Override
    public void run() {
        StringBuilder result = new StringBuilder();

        switch (type) {
            case AddressInformation:
                result.append("Native IP4 Address Information:" + System.lineSeparator() + ShellNetworkProcessor.sudoForResult("ip -4 a") + System.lineSeparator());
                break;
            case DNSInformation:
                break;
            case Ping:
                result.append("NATIVE PING IP4:" + System.lineSeparator());
                result.append("Ping 8.8.8.8" + System.lineSeparator() + ping(2, "8.8.8.8") + System.lineSeparator());
                result.append("Ping google.com" + System.lineSeparator() + ping(2, "google.com") + System.lineSeparator());
                result.append("JAVA IP4:" + System.lineSeparator());
                result.append("Ping 8.8.8.8" + System.lineSeparator() + ShellNetworkProcessor.sudoForResult("ping -c 2 8.8.8.8") + System.lineSeparator());
                result.append("Ping google.com" + System.lineSeparator() + ShellNetworkProcessor.sudoForResult("ping -c 2 google.com") + System.lineSeparator());
                break;
        }

        this.result = result.toString();
    }

}
