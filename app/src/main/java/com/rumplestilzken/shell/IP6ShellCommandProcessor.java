package com.rumplestilzken.shell;

import com.rumplestilzken.network.NetworkProcessor;
import com.rumplestilzken.network.ShellNetworkProcessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class IP6ShellCommandProcessor extends Thread {
    String result = "";
    NetworkProcessor.ProcessType type = NetworkProcessor.ProcessType.NotSet;

    public IP6ShellCommandProcessor(NetworkProcessor.ProcessType processType)
    {
        this.type = processType;
    }

    public String getResult() {
        return result;
    }

    public native String ping6(int count, String address);

    @Override
    public void run() {
        StringBuilder result = new StringBuilder();
        switch (type) {
            case NotSet:
                break;
            case AddressInformation:
                result.append("IP6 Address Information:" + System.lineSeparator() + ShellNetworkProcessor.sudoForResult("ip -6 a") + System.lineSeparator());
                break;
            case DNSInformation:
                break;
            case Ping:
                //TODO: IP6 Addresses
                result.append("NATIVE PING IP6:" + System.lineSeparator());
                result.append("Ping6 8.8.8.8" + System.lineSeparator() + ping6(2, "8.8.8.8") + System.lineSeparator());
                result.append("Ping6 google.com" + System.lineSeparator() + ping6(2, "google.com") + System.lineSeparator());
                result.append("JAVA IP6:" + System.lineSeparator());
                result.append("Ping6 8.8.8.8" + System.lineSeparator() + ShellNetworkProcessor.sudoForResult("ping6 -c 2 8.8.8.8") + System.lineSeparator());
                result.append("Ping6 google.com" + System.lineSeparator() + ShellNetworkProcessor.sudoForResult("ping6 -c 2 google.com") + System.lineSeparator());
                break;
        }
        this.result = result.toString();
    }

}
