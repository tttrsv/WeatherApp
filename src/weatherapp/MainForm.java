/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import common.Common;
import helper.Helper;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import jdk.nashorn.internal.parser.JSONParser;
import model.OpenWeatherMap;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import java.awt.Image;
import java.awt.event.FocusAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;



/**
 *
 * @author Nastya
 */
public class MainForm extends javax.swing.JFrame {
    OpenWeatherMap openWeatherMap = new OpenWeatherMap();
    String defaultCity = "Mykolayiv";
    Helper helper = new Helper();

    public String getDefaultCity() {
        return defaultCity;
    }

    public void setDefaultCity(String defaultCity) {
        this.defaultCity = defaultCity;
    }

    public MainForm() throws IOException {
        initComponents();
        setSize(700, 250);
        setResizable(false);
        setFocusable(true);
        float lat = 46.9329791f;
        float lon = 31.8679139f;
        parse(defaultCity);
    }
    
    void parse(String citySearch){
        String city, country, description, currentTemperature, icon, sunrise, sunset, wind, humidity, minTemp, maxTemp;
        String res = helper.getHTTPData(Common.apiRequest(citySearch));
        System.out.println(res);
       try{
            Gson gson = new GsonBuilder().create();
            OpenWeatherMap weather = gson.fromJson(res, OpenWeatherMap.class);
            city = weather.getName();
            country = weather.getSys().getCountry();
            description = weather.getWeather().get(0).getMain();
            currentTemperature = Integer.toString((int)weather.getMain().getTemp());
            icon = weather.getWeather().get(0).getIcon();
            sunrise = Common.unixTimeStampToDateTime(weather.getSys().getSunrise());
            sunset = Common.unixTimeStampToDateTime(weather.getSys().getSunset());
            wind = String.valueOf(weather.getWind().getSpeed());
            humidity = String.valueOf(weather.getMain().getHumidity());
            minTemp = Integer.toString((int)weather.getMain().getTemp_min());
            maxTemp = Integer.toString((int)weather.getMain().getTemp_max());
            setData(city, country, currentTemperature, description, icon, sunrise, sunset, wind, humidity, minTemp, maxTemp);
            System.out.println(city + " " + country + " " + description + " "+ currentTemperature);
            
        }
       catch(JsonSyntaxException ex){
           System.out.println(ex.getMessage());
       } 
    }
    
    void setData(String city, String country, String currentTemperature, String description, String icon, String sunrise, String sunset, String wind, String humidity, String minTemp, String maxTemp){
        lblLocation.setText(city + ", " + country);
        
        lblTemp.setText(currentTemperature + "°C");
        lblMaxTemp.setText("max: " + maxTemp + "°C");
        lblMinTemp.setText("min: " + minTemp + "°C");
        
        lblDescription.setText(description);
        
        lblSunrise.setText("Sunrise: "+sunrise);
        lblSunset.setText("Sunset: "+sunset);
        
        Calendar cal =new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        lblDate.setText(getDayOfWeek(dayOfWeek) + ", " + String.valueOf(day) + " " + getMonth(month));
        
        int minute = cal.get(Calendar.MINUTE);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        
        lblTime.setText(String.valueOf(hour) + ":" + String.valueOf(minute));
        
        lblWind.setText("Wind: " + wind + " m/s");
        
        lblHumidity.setText("Humidity: " + humidity + "%");

    }
    
    String getDayOfWeek(int day){
        String dayOfWeek = null;
        switch(day){
            case 1: dayOfWeek = "Sun"; break;
            case 2: dayOfWeek = "Mon"; break;
            case 3: dayOfWeek = "Tue"; break;
            case 4: dayOfWeek = "Wed"; break;
            case 5: dayOfWeek = "Thu"; break;
            case 6: dayOfWeek = "Fri"; break;
            case 7: dayOfWeek = "Sat"; break;
        }
        return dayOfWeek;
    }
    
     String getMonth(int month){
        String monthName = null;
        switch(month){
            case 0: monthName = "January"; break;
            case 1: monthName = "February"; break;
            case 2: monthName = "March"; break;
            case 3: monthName = "April"; break;
            case 4: monthName = "May"; break;
            case 5: monthName = "June"; break;
            case 6: monthName = "Jule"; break;
            case 7: monthName = "August"; break;
            case 8: monthName = "September"; break;
            case 9: monthName = "October"; break;
            case 10: monthName = "Novamber"; break;
            case 11: monthName = "December"; break;
        }
        return monthName;
    }
    
    
        
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        lblTemp = new javax.swing.JLabel();
        lblLocation = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        lblSunrise = new javax.swing.JLabel();
        lblSunset = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblDate = new javax.swing.JLabel();
        lblMinTemp = new javax.swing.JLabel();
        lblMaxTemp = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblHumidity = new javax.swing.JLabel();
        lblWind = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 467));
        setSize(new java.awt.Dimension(700, 300));

        jPanel1.setMaximumSize(new java.awt.Dimension(700, 467));
        jPanel1.setMinimumSize(new java.awt.Dimension(700, 467));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 467));
        jPanel1.setLayout(null);

        txtSearch.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(153, 153, 153));
        txtSearch.setText("Search city...");
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchFocusLost(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
        });
        jPanel1.add(txtSearch);
        txtSearch.setBounds(20, 9, 650, 40);

        lblTemp.setFont(new java.awt.Font("Segoe UI Semibold", 0, 90)); // NOI18N
        lblTemp.setForeground(new java.awt.Color(255, 255, 255));
        lblTemp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTemp.setText("4");
        jPanel1.add(lblTemp);
        lblTemp.setBounds(240, 210, 360, 90);

        lblLocation.setFont(new java.awt.Font("Segoe UI Light", 0, 42)); // NOI18N
        lblLocation.setForeground(new java.awt.Color(255, 255, 255));
        lblLocation.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLocation.setText("Mykilaov, UA");
        lblLocation.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(lblLocation);
        lblLocation.setBounds(30, 90, 510, 70);

        lblDescription.setFont(new java.awt.Font("Segoe UI Light", 0, 36)); // NOI18N
        lblDescription.setForeground(new java.awt.Color(255, 255, 255));
        lblDescription.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDescription.setText("Description");
        jPanel1.add(lblDescription);
        lblDescription.setBounds(330, 310, 220, 50);

        lblSunrise.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        lblSunrise.setForeground(new java.awt.Color(255, 255, 255));
        lblSunrise.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSunrise.setText("Sunrise:06:12");
        jPanel1.add(lblSunrise);
        lblSunrise.setBounds(560, 300, 130, 30);

        lblSunset.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        lblSunset.setForeground(new java.awt.Color(255, 255, 255));
        lblSunset.setText("Sunset:06:12");
        jPanel1.add(lblSunset);
        lblSunset.setBounds(560, 330, 130, 22);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(550, 160, 30, 190);

        lblDate.setFont(new java.awt.Font("Segoe UI Light", 1, 22)); // NOI18N
        lblDate.setForeground(new java.awt.Color(255, 255, 255));
        lblDate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDate.setText("Friday, 20 Apr");
        jPanel1.add(lblDate);
        lblDate.setBounds(30, 150, 220, 30);

        lblMinTemp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMinTemp.setForeground(new java.awt.Color(255, 255, 255));
        lblMinTemp.setText("Min:3");
        jPanel1.add(lblMinTemp);
        lblMinTemp.setBounds(360, 190, 90, 20);

        lblMaxTemp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMaxTemp.setForeground(new java.awt.Color(255, 255, 255));
        lblMaxTemp.setText("Max:4");
        jPanel1.add(lblMaxTemp);
        lblMaxTemp.setBounds(470, 190, 80, 17);

        lblTime.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTime.setForeground(new java.awt.Color(255, 255, 255));
        lblTime.setText("23:33");
        jPanel1.add(lblTime);
        lblTime.setBounds(30, 180, 50, 30);

        lblHumidity.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        lblHumidity.setForeground(new java.awt.Color(255, 255, 255));
        lblHumidity.setText("Humidity: 100%");
        jPanel1.add(lblHumidity);
        lblHumidity.setBounds(390, 150, 160, 40);

        lblWind.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        lblWind.setForeground(new java.awt.Color(255, 255, 255));
        lblWind.setText("Wind:16 m/s");
        jPanel1.add(lblWind);
        lblWind.setBounds(560, 150, 140, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 700, 467);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER ) parse(txtSearch.getText());
    }//GEN-LAST:event_txtSearchKeyPressed

    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        // TODO add your handling code here:
        txtSearch.setText("");
    }//GEN-LAST:event_txtSearchFocusGained

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        // TODO add your handling code here:
        txtSearch.setText("Search city...");
    }//GEN-LAST:event_txtSearchFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainForm().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblHumidity;
    private javax.swing.JLabel lblLocation;
    private javax.swing.JLabel lblMaxTemp;
    private javax.swing.JLabel lblMinTemp;
    private javax.swing.JLabel lblSunrise;
    private javax.swing.JLabel lblSunset;
    private javax.swing.JLabel lblTemp;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblWind;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
