package org.example;
import java.io.*;


    public class IssueCounter extends Thread {
        private final File folder;

        public IssueCounter(File folder) {
            this.folder = folder;
            setName("IssueCounter-Thread");
        }

        @Override
        public void run() {
            countIssues(folder);
        }

        private void countIssues(File file) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (f.isDirectory()) {
                        countIssues(f);
                    } else if (f.getName().endsWith(".java")) {
                        checkFileForIssues(f);
                    }
                }
            }
        }


        private void checkFileForIssues(File file) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    for (String keyword : Constants.ISSUE_KEYWORDS) {
                        if (line.toLowerCase().contains(keyword)) {
                            org.example.SharedData.issueCount.incrementAndGet();
                            break;
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + file.getName());
            }
        }
    }


