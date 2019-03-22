import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        Exercise exerMatrix = new Exercise();
        File file;
        String choice;

        if(args.length > 0) {
            file = new File(args[0]);
        }else{
            file = new File("my-data.txt");
        }

        try{
            if(file.exists() && file.isFile()) {
                if(file.length() <= 1) {
                    System.out.println("File is empty!");   
                    exerMatrix.generateMatrix(file);
                }else{
                    exerMatrix.loadMatrix(file);    
                }
                
            }else{
                System.out.println("File not found. Creating new file.");    
                file.createNewFile();
                exerMatrix.generateMatrix(file);
            }
        }catch(IOException e){}
        
        do{
            printMenu();
            choice = ExerciseUtil.getStringInput(">> ").toUpperCase();
            
            try{
                Menu.search(choice);
            }catch(IllegalArgumentException e){
                System.out.println("Please select among the choices.");
                continue;
            }

            switch(Menu.valueOf(choice)){
                case SEARCH:
                        exerMatrix.search();
                        break;
                case EDIT:
                        exerMatrix.edit(file);
                        break;
                case PRINT:
                        exerMatrix.print();
                        break;
                case RESET:
                        exerMatrix.reset(file);
                        break;
                case ADDROW:
                        exerMatrix.addRow(file);
                        break;
                case ADDCELL:
                        exerMatrix.addCell(file);
                        break;
                case SORT:
                        exerMatrix.sort(file);
                        break;
                case EXIT:
                        exerMatrix.saveMatrix(file);
                        System.out.println("Bye");
            }

        }while(!(Menu.EXIT.equals(choice)));
        
    
    }

    private static void printMenu() {
        System.out.println();
        System.out.println(Menu.SEARCH);
        System.out.println(Menu.EDIT);
        System.out.println(Menu.PRINT);
        System.out.println(Menu.RESET);
        System.out.println(Menu.ADDROW);
        System.out.println(Menu.ADDCELL);
        System.out.println(Menu.SORT);
        System.out.println(Menu.EXIT);
    }
}