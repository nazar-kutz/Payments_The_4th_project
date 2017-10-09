package com.nazar.controller.test;

import java.io.*;

/*current.replace(" =", ", ").replace("String ", "{").
                    replace(";", "},").trim();*/

public class Refactor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("result.txt"));

        String current = "";
        while((current = reader.readLine()) != null){
            current = current.trim();
            String result;
            if(current.contains("//")) {
                result = current;
            }
            else {
                String subber = current.replace("String ", "").
                        replaceAll(" = \".*\";", "");
                String subberResult = subber.replace("_", ".").trim().toLowerCase();
                result = current.replaceAll("\".*\"", "\"" + subberResult + "\"");
            }
            System.out.println(result);
            writer.write(result);
            writer.newLine();
        }
    }
}
