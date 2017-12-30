import java.io.*;
public class FileCount{
	public static void main(String[] args) {
		try{
			System.out.println("Getting line number of a paritcular file example!");
			System.out.println("Argument:"+args[0]);
			File file = new File(args[0]);
			if (file.exists()){
				FileReader fr = new FileReader(file);
				LineNumberReader ln = new LineNumberReader(fr);
				int count = 0;
				while (ln.readLine() != null){
					count++;
				}
				System.out.println("Total line no: " + count);
				ln.close();
			}
			else{
				System.out.println("File does not exists!");
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}