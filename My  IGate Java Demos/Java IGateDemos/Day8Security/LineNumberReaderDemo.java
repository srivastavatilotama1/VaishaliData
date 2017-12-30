
import java.io.*;
class LineNumberReaderDemo
{
    public static void main(String args[])
    {
       String s;
        try{
        
        FileReader fr = new FileReader("c:\\MarchDemo\\Output.txt");
        BufferedReader br = new BufferedReader(fr);
        LineNumberReader lr = new LineNumberReader(br);
      
       
            while((s = lr.readLine()) != null)
              //int i = Integer.parseInt(s);
              System.out.println(lr.getLineNumber()+" " +s);
        }
           catch(IOException e){ System.out.println(e.getMessage());}
        
    }
}
