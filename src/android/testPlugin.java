package com.evoke.testPlugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.dialog.auth.ViuAuth;
import android.content.Context;
import android.util.Log;
/**
 * This class echoes a string called from JavaScript.
 */
public class testPlugin extends CordovaPlugin {
    
    private ViuAuth viuAuth;

  

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
      
        
        if (action.equals("coolMethod")) {
            String message = args.getString(0);
            this.coolMethod(message, callbackContext);
            return true;
        }else if(action.equals("getViuAutherizationToken")){
            
            
            try{
                if(this.viuAuth == null){
                    this.viuAuth = new ViuAuth(this.cordova.getActivity().getApplicationContext());
                }
                
              String tokens =  this.viuAuth.getViuAutherizationToken();
              callbackContext.success(tokens);
            }
            catch(Exception ex){
                callbackContext.error(ex.getMessage() + " " + ex.toString());
                     
            }
            return true;
              
        }
        return false;
    }
    
    
//     private void getViuAutherizationToken(String message,CallbackContext context){
//             String token =  this.viuAuth.getViuAutherizationToken();
//              context.success(token);
//      }

    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
