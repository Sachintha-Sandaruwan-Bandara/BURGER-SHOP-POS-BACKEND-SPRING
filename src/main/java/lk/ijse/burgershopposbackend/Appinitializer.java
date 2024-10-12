package lk.ijse.burgershopposbackend;
/* 
    @author 
      
 (                           )   (        (                            )   (                 (               
 )\ )     (         (     ( /(   )\ )     )\ )       (      (       ( /(   )\ )      (       )\ )     (      
(()/(     )\        )\    )\()) (()/(    (()/(     ( )\     )\      )\()) (()/(      )\     (()/(     )\     
 /(_)) ((((_)(    (((_)  ((_)\   /(_))    /(_))    )((_) ((((_)(   ((_)\   /(_))  ((((_)(    /(_)) ((((_)(   
(_))    )\ _ )\   )\___   _((_) (_))     (_))     ((_)_   )\ _ )\   _((_) (_))_    )\ _ )\  (_))    )\ _ )\  
/ __|   (_)_\(_) ((/ __| | || | |_ _|    / __|     | _ )  (_)_\(_) | \| |  |   \   (_)_\(_) | _ \   (_)_\(_) 
\__ \    / _ \    | (__  | __ |  | |     \__ \     | _ \   / _ \   | .` |  | |) |   / _ \   |   /    / _ \   
|___/   /_/ \_\    \___| |_||_| |___|    |___/     |___/  /_/ \_\  |_|\_|  |___/   /_/ \_\  |_|_\   /_/ \_\  
  
 @created 10/11/2024 - 10:39 PM 
*/

import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletRegistration;
import lk.ijse.burgershopposbackend.config.WebAppConfig;
import lk.ijse.burgershopposbackend.config.WebAppRootConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class Appinitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebAppRootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebAppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        String tempDir = System.getProperty("java.io.tmpdir");
        registration.setMultipartConfig(new MultipartConfigElement(tempDir));
    }

}
