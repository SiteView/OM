package com.siteview.xmpp.util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MacAddress {
	 public static String getOSName() {     
         return System.getProperty("os.name").toLowerCase();     
     }     
              
          
     public static String getUnixMACAddress() {     
         String mac = null;     
         BufferedReader bufferedReader = null;     
         Process process = null;     
         try {     
                 
             process = Runtime.getRuntime().exec("ifconfig eth0");   
             bufferedReader = new BufferedReader(new InputStreamReader(process     
                     .getInputStream()));     
             String line = null;     
             int index = -1;     
             while ((line = bufferedReader.readLine()) != null) {     
                      
                 index = line.toLowerCase().indexOf("hwaddr");    
                      
                 if (index != -1) {     
                          
                     mac = line.substring(index +"hwaddr".length()+ 1).trim();   
                     break;     
                 }     
             }     
         } catch (IOException e) {     
             e.printStackTrace();     
         } finally {     
             try {     
                 if (bufferedReader != null) {     
                     bufferedReader.close();     
                 }     
             } catch (IOException e1) {     
                e1.printStackTrace();     
            }     
             bufferedReader = null;     
             process = null;     
         }     
      
         return mac;     
     }     
         public static String getLinuxMACAddress() {     
             String mac = null;     
             BufferedReader bufferedReader = null;     
             Process process = null;     
             try {     
                     
                 process = Runtime.getRuntime().exec("ifconfig eth0");   
                 bufferedReader = new BufferedReader(new InputStreamReader(process     
                         .getInputStream()));     
                 String line = null;     
                 int index = -1;     
                 while ((line = bufferedReader.readLine()) != null) {     
                     index = line.toLowerCase().indexOf("硬件地址");    
                          
                     if (index != -1) {     
                              
                         mac = line.substring(index+4).trim();   
                         break;     
                     }     
                 }     
             } catch (IOException e) {     
                 e.printStackTrace();     
             } finally {     
                 try {     
                     if (bufferedReader != null) {     
                         bufferedReader.close();     
                     }     
                 } catch (IOException e1) {     
                    e1.printStackTrace();     
                }     
                 bufferedReader = null;     
                 process = null;     
             }   
          
             return mac;     
         }   
              
         public static String getWindowsMACAddress() {     
             String mac = null;     
             BufferedReader bufferedReader = null;     
             Process process = null;     
             try {     
                     
                 process = Runtime.getRuntime().exec("ipconfig /all");   
                 bufferedReader = new BufferedReader(new InputStreamReader(process     
                         .getInputStream()));     
                 String line = null;     
                 int index = -1;     
                 while ((line = bufferedReader.readLine()) != null) {     
                          
                     index = line.toLowerCase().indexOf("physical address");
                     if(index==-1)
                    	 index=line.toLowerCase().indexOf("物理地址");
                     if (index != -1) {   
                         index = line.indexOf(":");   
                         if (index != -1) {   
                                  
                            mac = line.substring(index + 1).trim();    
                        }   
                         break;     
                     }   
                 }   
             } catch (IOException e) {     
                 e.printStackTrace();     
             }finally {     
                 try {     
                     if (bufferedReader != null) {     
                         bufferedReader.close();     
                       }     
                 }catch (IOException e1) {     
                     e1.printStackTrace();     
                   }     
                 bufferedReader = null;     
                 process = null;     
             }     
          
             return mac;     
         }     
          
              
         public static void main(String[] argc) {     
             String os = getOSName();     
             System.out.println(os);     
             if(os.startsWith("windows")){     
                 String mac = getWindowsMACAddress();     
                 System.out.println("本地是windows:"+mac.replace("-", ""));     
             }else if(os.startsWith("linux")){     
                   String mac = getLinuxMACAddress();     
                 System.out.println("本地是Linux系统,MAC地址是:"+mac);   
             }else{     
                 String mac = getUnixMACAddress();                         
                 System.out.println("本地是Unix系统 MAC地址是:"+mac);   
             }     
         }     
}
