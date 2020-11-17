import java.io.*;
import java.util.ArrayList;

class Main {

  static ArrayList<Person> people;
  static String filename;
  static FileReader myFile;
  
  
  public static void main(String[] args) {
  
    people = new ArrayList<Person>();
    filename = "data.txt";
    String name = "", age = "", color = "";


    people.add(new Person("Lou", 21, "green"));
    people.add(new Person("A", 87, "pink"));
    people.add(new Person("B", 13, "yellow"));
    people.add(new Person("C", 55, "black"));
    people.add(new Person("D", 4, "green"));

    FileWriter toWriteFile;
    try {
      toWriteFile = new FileWriter(filename);
      BufferedWriter output = new BufferedWriter(toWriteFile);

      for(int i=0; i<people.size(); i++) {
        output.write(people.get(i).getName());
        output.newLine();
        output.write(Integer.toString(people.get(i).getAge()));
        output.newLine();
        output.write(people.get(i).getColor());
        output.newLine();

        output.flush();
      }

      output.close();
    }
    catch(IOException excpt){
      excpt.printStackTrace();
    }
    try {
      myFile = new FileReader(filename);
      BufferedReader reader = new BufferedReader(myFile);
      

      while (reader.ready()) {
        name = reader.readLine();
        age = reader.readLine();
        color = reader.readLine();

        
      }
    for(int i=people.size()-1; i>=0; i--) {
      System.out.printf("%-10s %-10s %-10s %n", people.get(i).getName(), people.get(i).getAge(), people.get(i).getColor());
    }
      reader.close();
    } catch (IOException exception) {
      System.out.println("An error occurred: " + exception);
    }

    
  }
  
}