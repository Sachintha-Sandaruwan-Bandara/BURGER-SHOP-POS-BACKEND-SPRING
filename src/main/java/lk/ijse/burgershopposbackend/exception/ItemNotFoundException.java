package lk.ijse.burgershopposbackend.exception;
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
  
 @created 10/16/2024 - 2:51 PM 
*/

public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(){
        super();
    }
    public ItemNotFoundException(String message){

        super(message);
    }
    public ItemNotFoundException(String message, Throwable cause){

        super(message,cause);
    }
}
