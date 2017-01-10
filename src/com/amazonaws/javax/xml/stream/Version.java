package com.amazonaws.javax.xml.stream;

public class Version {
    public static void main(String[] args) {
        System.out.println(new StringBuffer().append("Sun Java Streaming XML Parser Version is '").append(Package.getPackage("com.sun.xml.stream").getImplementationVersion()).append("'").toString());
    }
}
