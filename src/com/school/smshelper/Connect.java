package com.school.smshelper;


import com.school.config.SMS_CONFIG;
import com.school.log.AppLog;
import java.io.*;
import java.util.Enumeration;
import java.util.Properties;
import java.util.TooManyListenersException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.comm.CommPortIdentifier;
import javax.comm.SerialPort;
import javax.comm.SerialPortEvent;
import javax.comm.SerialPortEventListener;

/**
 *
 * @author DELL
 */
public class Connect implements  SerialPortEventListener
{
    public static int SMS_SENT = 1;
    public static int SMS_SENDING_FAILED = 0;
    
    public static String SMS_CONFIG_FILE_NAME = "smsconfig.properties";
    public static String BAUD_RATE_KEY = "BAUD_RATE";
    public static String SMS_DELAY_TIME_KEY = "SMS_DELAY_TIME";
    public static String DATABIT_KEY = "DATABIT";
    public static String STOPBIT_KEY = "STOPBIT";
    public static String PARITY_KEY = "PARITY";
    
    String line1 ;
    String line2 ;
    int index=0;
    
    CommPortIdentifier portId;
    String messageString = "Dont consider this sms, just for testing....:-D";
    char ch = '"';
    String dest ="";
    String s = "";
    InputStream inputStream;

    SerialPort serialPort;
    OutputStream outputStream;
    
    public Connect(String port,Properties props)throws Exception
    {
            portId = CommPortIdentifier.getPortIdentifier(port);

            serialPort = (SerialPort) portId.open("Sms_GSM", 0);
            System.out.println("SMS Sending....Port Found");
            
            inputStream = serialPort.getInputStream();                    
            outputStream = serialPort.getOutputStream();
            
            serialPort.notifyOnDataAvailable(true);
            
            serialPort.setSerialPortParams(
                    SMS_CONFIG.getBaudRate((String)props.get(BAUD_RATE_KEY)),
                    SMS_CONFIG.getDatabits((String)props.get(DATABIT_KEY)),
                    SMS_CONFIG.getStopbits((String)props.get(STOPBIT_KEY)),
                    SMS_CONFIG.getParity((String)props.get(PARITY_KEY)));
            System.out.println("setted serial port parameters");
            recieve();
    }
    
    
    public void addEventListener(SerialPort serial){
        
        try{
            serialPort.addEventListener(this);
        }
        catch (TooManyListenersException e){
            System.out.println("Exception in Adding Listener" + e);
        }
    }
    
    @Override
    public void serialEvent(SerialPortEvent event)
    {
        
        BufferedReader input = new BufferedReader(new InputStreamReader(inputStream));
        index = 0;
        if(event.getEventType()==SerialPortEvent.DATA_AVAILABLE){
            try {
                while((s=input.readLine())!=null){
                    System.out.println("line : "+s);
                    if(s.contains("CMTI")){
                        new Thread(){
                            public void run(){
                                if((index=s.indexOf(','))!=-1){
                                    s=s.substring(index+1);
                                    index = Integer.parseInt(s.trim());
                                    System.out.println("Index:"+index);
                                    try {
                                        outputStream.write("AT+CMGF=1\r\n".getBytes());
                                        outputStream.write(("AT+CMGR="+index+"\r\n").getBytes());
                                        outputStream.flush();
                                    
                                        Thread.sleep(200);
                                    } catch (Exception ex) {
                                        Logger.getLogger(AppLog.ERROR_LOG).log(Level.SEVERE, null, ex);
                                    }
                    
                                }
                            }
                        }.start();
                    }
                    if(s.contains("+CMGR:")){
                            String msg = (s+"\n"+input.readLine());
                            System.out.println("Message: "+msg);
                            String from = msg.split(",")[1];
                            String message = msg.substring(msg.lastIndexOf("\"")+1);
//                            new MessageHandler(from.replaceAll("\"", ""),message ).start();
//                            deleteMessage(index);
                    }
                    
                }
                
            } catch (IOException ex) {
                Logger.getLogger(AppLog.ERROR_LOG).log(Level.SEVERE, null, ex);
            }        
        }
      
    }
    
    synchronized public int send(String phoneNo,String message){
        dest = ch + phoneNo + ch;
        messageString = message;
        System.out.println("To: "+dest);
        System.out.println("Message: "+message);
        
        line1 = "AT+CMGF=1\n";
        line2 = "AT+CMGS=" + dest + "\n";
         
        //String line1 = "AT+CREG=2";
        //String line2 = "AT+CGREG?";
        try
        {
            Thread.sleep(400);
            System.out.println("now sending...");
            
            outputStream.write(line1.getBytes());
            outputStream.write(line2.getBytes());
            outputStream.write(messageString.getBytes());
            outputStream.write(26);
            outputStream.flush();
            Thread.sleep(400);
            return SMS_SENT;
        }
        catch (Exception e)
        {
            System.out.println("Error writing message " + e);
        }
        return SMS_SENDING_FAILED;
    }
    public void contactEntries(int index){
        String command = "AT+CPBR="+index+"\r\n";
        try{
            outputStream.write(command.getBytes());
            outputStream.flush();
            byte[] b = new byte[20];
            inputStream.read(b , 0,20);
            String s = new String(b,0,b.length);
            System.out.println("read : "+s+": length"+s.trim().length() );
        }catch (Exception e){
            System.out.println("Error writing message " + e);
        }
       
    }
    
    public void recieve(){
        try{
            String s = "AT+CNMI=1,1,0,0,0\r";
            String source = "AT+CPMS=\"SM\"\r\n";
            outputStream.write(s.getBytes());
            outputStream.write(source.getBytes());
            outputStream.flush();
            addEventListener(serialPort);
        }catch(Exception ex){Logger.getLogger(AppLog.ERROR_LOG).log(Level.SEVERE, null, ex);}
   }
    synchronized public void deleteMessage(int index){
        String source = "AT+CMGD="+index+"\r\n";
        try {
            outputStream.write(source.getBytes());
            outputStream.flush();
        } catch (IOException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void close(){
        if(serialPort!=null){
            serialPort.close();
        }
        serialPort = null;
    }
    
    
    // ALL STATIC METHODS
    
    public static Enumeration<CommPortIdentifier> detectPorts(){
        Enumeration<CommPortIdentifier> e = CommPortIdentifier.getPortIdentifiers();
        System.out.println("Detecting Port..!");
        return e;
    }
    
    public static Properties prepareProperties(String baudRate, String databits, String stopBits, String parity,String delayTime){
        Properties props = new Properties();
        props.put(BAUD_RATE_KEY, baudRate);
        props.put(DATABIT_KEY, databits);
        props.put(STOPBIT_KEY, stopBits);
        props.put(PARITY_KEY, parity);
        props.put(SMS_DELAY_TIME_KEY, delayTime);
        return props;
    }
    
    public static void saveProperties(Properties props)throws Exception{
        File f = new File(SMS_CONFIG_FILE_NAME);
        if(!f.exists()){
            f.createNewFile();
        }
        FileOutputStream out = new FileOutputStream(f);
        props.store(out, null);
        out.close();
    }
    
    public static Properties getProperties()throws Exception{
        Properties props = null;
        File f = new File(SMS_CONFIG_FILE_NAME);
        if(!f.exists()){
            props= prepareProperties(
                    SMS_CONFIG.getBaudRate(SMS_CONFIG.BAUD_RATES[3]),
                    SMS_CONFIG.getDatabits(SMS_CONFIG.DATABITS_VALUES[3]),
                    SMS_CONFIG.getStopbits(SMS_CONFIG.STOPBITS_VALUES[0]),
                    SMS_CONFIG.getParity(SMS_CONFIG.PARITY_VALUES[2]),
                    "400" );
            saveProperties(props);
        }else{
            props = new Properties();
        }
        props.load( new FileInputStream(f));
        return props;
    }
}
