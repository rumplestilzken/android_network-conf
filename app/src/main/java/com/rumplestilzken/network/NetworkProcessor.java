package com.rumplestilzken.network;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NetworkProcessor {

    public enum ProcessType
    {
        NotSet,
        AddressInformation,
        DNSInformation,
        Ping
    }

    Context context = null;


    NetworkProcessor(Context context)
    {
        this.context =  context;
    }

    public String getNetworkOutput() {
        return getIP4Information() + System.lineSeparator() + getIP6Information();
    }

    public String getIP4Information() {
        StringBuilder sb = new StringBuilder();
        sb.append(getIP4Addresses() + System.lineSeparator());
        sb.append(getIP4DNS() + System.lineSeparator());
        sb.append(getIP4Ping() + System.lineSeparator());
        return sb.toString();
    }

    public String getIP4Ping()
    {
        return "No IP4 Ping Information found.";
    }

    public String getIP4Addresses() {
        return "No IP4 Addresses Found.";
    }

    public String getIP4DNS() {
        return "No IP4 DNS Settings found.";
    }

    public String getIP6Information() {
        StringBuilder sb = new StringBuilder();
        sb.append(getIP6Addresses() + System.lineSeparator());
        sb.append(getIP6DNS() + System.lineSeparator());
        sb.append(getIP6Ping() + System.lineSeparator());
        return sb.toString();
    }

    public String getIP6Addresses() {
        return "No IP6 Addresses Found.";
    }

    public String getIP6DNS() {
        return "No IP6 DNS Settings found.";
    }

    public String getIP6Ping()
    {
        return "No IP6 Ping Information found.";
    }



}
