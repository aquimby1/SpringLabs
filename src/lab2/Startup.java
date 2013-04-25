package lab2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * See if you can modify this class to use Spring as in Lab1.
 */
public class Startup {

    public static void main(String[] args) {
        
        final AbstractApplicationContext context = 
                 new ClassPathXmlApplicationContext(
			       new String[] {"appContext.xml"});
        
        TipService tipMgr = (TipService)context.getBean("tipService");
        
        
        
        
        
        
        // First create some low-level instances using
        // Liskov Substitution Principle

//        TipCalculator calc1 =
//           new FoodServiceTipCalculator(TipService.ServiceQuality.FAIR,125.00);

//        TipCalculator calc2 =
//           new BaggageServiceTipCalculator(TipService.ServiceQuality.GOOD,5);

        // Next, create the high-level class
//        TipService tipMgr = new TipService(calc1);

        // Now ask the tip manager to do some work...
        double tip = tipMgr.getTip();
        String quality = tipMgr.getServiceQuality();

        // Now prove it works...
        System.out.println("\nThe tip for the "
                + tipMgr.getTipCalculator().getClass().getSimpleName() + " is: "
                + tip + ", with a service qualilty of: " + quality);

    }

}
