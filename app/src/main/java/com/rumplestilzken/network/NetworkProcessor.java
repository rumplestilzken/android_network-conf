package com.rumplestilzken.network;

public class NetworkProcessor {
    public String getNetworkOutput() {
        return getIP4Information() + System.lineSeparator() + getIP6Information();
    }

    public String getIP4Information() {
        StringBuilder sb = new StringBuilder();
        sb.append(getIP4Addresses() + System.lineSeparator());
        sb.append(getIP4DNS() + System.lineSeparator());
        return sb.toString();
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
        return sb.toString();
    }

    public String getIP6Addresses() {
        return "No IP6 Addresses Found.";
    }

    public String getIP6DNS() {
        return "No IP6 DNS Settings found.";
    }

}
