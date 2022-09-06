import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NotHesap {

public static double notHesap( double a, double b) {
		
		double sonuc = ((a*40/100) + (b*60/100));
		
		return sonuc;
		
	}

	public static void main(String[] args) {

	  try(FileReader fr = new FileReader("notlar.txt");
		  FileWriter fw = new FileWriter("sonuclar.txt")){
		  
		  Scanner s = new Scanner(fr);
		  
		  while(s.hasNextLine()) {
			  
			  String satir = s.nextLine();
			  
			  String dizi [] = satir.split(",");
			  
			  double vize = Double.valueOf(dizi[1]);
			  
			  double sonSinav = Double.valueOf(dizi[2]);
			  
			  String sonuc = String.valueOf(notHesap(vize,sonSinav));
			  
			  fw.write(dizi[0] +" geçme notu: " + sonuc+ "\n");
		  }
		  
		  System.out.println("Notlar hesaplandý, Sonuclar dosyasýna bakýnýz.");
		  
		  
	  } catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}

}
