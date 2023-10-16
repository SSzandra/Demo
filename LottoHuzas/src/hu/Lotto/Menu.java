package hu.Lotto;

// Feladat 4: konzolon menü létrehozása

import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Menu {

	public static void main(String[] args) {
		Resource resource = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		
		Scanner scan = new Scanner(System.in);
		System.out.println("*** M E N U ***");
		System.out.println("Kérem válasszon:"+"\n"+"A: Lottóhúzás"+"\n"+"B: Gyakoriság keresés"+"\n"+"C: Eredmény");
		System.out.println("Kilépés: e");
		
		char c = scan.next().charAt(0);
		while(c!='e') {
			switch(c) {
		case 'A':
			Sorsolas sorsolas=(Sorsolas)factory.getBean("sorsolasbean");
			sorsolas.proc();
			System.out.println("A sorsolások megtörténtek");
			break;
		case 'B':
			Kivalasztas kivalasztas=(Kivalasztas)factory.getBean("kivalasztasbean");
			kivalasztas.proc();
			System.out.println("A leggyakoribb elemek keresése befejeződött");
			break;
		case 'C':
			Eredmeny eredmeny=(Eredmeny)factory.getBean("eredmenybean");
			eredmeny.proc();
			break;
		default:
			System.out.println("Másik karaktert kérek");
				if(c=='e') {
					System.out.println("Viszlát!");
				}
		}
			System.out.println("*** M E N U ***");
			System.out.println("Kérem válasszon:"+"\n"+"A: Lottóhúzás"+"\n"+"B: Gyakoriság keresés"+"\n"+"C: Eredmény");
			System.out.println("Kilépés: e");
			
			c = scan.next().charAt(0);
		}
		scan.close();
	}
	}
