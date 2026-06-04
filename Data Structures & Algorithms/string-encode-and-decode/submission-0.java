class Solution {
    // since input strings can contain 256 ascii chars
    // we can't use delimietrs like ',' or '-' to separate strings
    // So we use length of string followed by # to separate each string
    // For example if str = "hello" then encoding -> "5#hello"
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();

        for (String str: strs) {
            int len = str.length();
            encoded
                .append(len)
                .append("#")
                .append(str);
        }

        System.out.println(encoded);

        return encoded.toString();
    }

    public List<String> decode(String str) {
        int n = str.length();
        List<String> decoded = new ArrayList<>();

        int i = 0;
        while (i < n) {
            // read until '#' - length of the string
            StringBuilder len = new StringBuilder();
            while (i < n && str.charAt(i) != '#') {
                len.append(str.charAt(i));
                i += 1;
            }

            System.out.println(len);

            // skip '#'
            i += 1;

            // read 'len' characters
            StringBuilder word = new StringBuilder();
            int count = Integer.parseInt(len.toString());
            while (i < n && count > 0) {
                word.append(str.charAt(i));
                count--;
                i++;
            }

            decoded.add(word.toString());
        }

        return decoded;
    }
}
