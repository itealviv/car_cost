package com.homework.maxcxam;

import java.util.Scanner;

public class NotePad {
    private File[] files = new File[3];

    private NotePad(){
        getData();
    }

    private class File {
        private String data;
        private int id;

        File(String data, int id){
            this.data = data;
            this.id = id;
        }

        @Override
        public String toString() {
            return String.format("File id #%s is :%s", id, data);
        }
    }

    private void getData() {
        for(int i = 0; i < files.length; i++) {
            System.out.printf("enter data for #%s file: %n", i+1);
            files[i] = new File(new Scanner(System.in).nextLine(), i+1);
        }
    }

    private File[] getFile() {
        return files;
    }

    public static void main(String[] args) {
       NotePad np = new NotePad();

       for(File f: np.getFile())
           System.out.println(f);
    }
}
