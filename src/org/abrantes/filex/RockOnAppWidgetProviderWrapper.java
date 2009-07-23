package org.abrantes.filex;

import android.util.Log;

class RockOnAppWidgetProviderWrapper {
   private RockOnAppWidgetProvider mInstance;
   
   /* class initialization fails when this throws an exception */
   static {
       try {
    	   Log.i("WIDGET-COMPAT", "checking for class AppWidgetProvider");
           Class.forName("android.appwidget.AppWidgetManager");
       } catch (Exception ex) {
           throw new RuntimeException(ex);
       }
   }

   /* calling here forces class initialization */
   public static void checkAvailable() {}

//   public static void setGlobalDiv(int div) {
//       NewClass.setGlobalDiv(div);
//   }

   
   public RockOnAppWidgetProviderWrapper() {
       mInstance = RockOnAppWidgetProvider.getInstance();
   }
   
   void performUpdate(PlayerService service, int[] appWidgetIds) {
	   mInstance.performUpdate(service, appWidgetIds);
   }
   
   void notifyChange(PlayerService service, String what) {
	   mInstance.notifyChange(service, what);
   }

}