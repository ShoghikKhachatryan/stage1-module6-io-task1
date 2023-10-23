package com.epam.mjc.io;

import java.io.*;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        try (BufferedReader buffer = new BufferedReader(new java.io.FileReader(file))) {
            String current;
            while ((current = buffer.readLine()) != null) {
                if (current.startsWith("Name: ")) {
                    profile.setName(current.substring(6));
                } else if (current.startsWith("Age: ")) {
                    profile.setAge(Integer.parseInt(current.substring(5)));
                } else if (current.startsWith("Email: ")) {
                    profile.setEmail(current.substring(7));
                } else if (current.startsWith("Phone: ")) {
                    profile.setPhone(Long.parseLong(current.substring(7)));
                }
            }
        } catch (IOException e) {
            System.err.print(e);
        }

        return profile;
    }

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        fileReader.getDataFromFile(new File("src/main/resources/Profile.txt"));
    }
}
