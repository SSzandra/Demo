package hi.file;

import java.io.IOException;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Fut {

	public static void main(String[] args) throws IOException {
		Resource resource = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);

		Kiir kiir=(Kiir)factory.getBean("kiirbean");
		kiir.proc();
		
		Beolvas beolvas=(Beolvas)factory.getBean("beolvasbean");
		beolvas.proc();
		
		Megjelenit megjelenit=(Megjelenit)factory.getBean("megjelenitbean");
		megjelenit.proc();
	}
}