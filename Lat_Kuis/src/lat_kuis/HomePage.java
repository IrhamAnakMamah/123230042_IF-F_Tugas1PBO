/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lat_kuis;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Irham
 */
public class HomePage extends JFrame implements ActionListener{
    
    JLabel Ucapan = new JLabel();
    JLabel Deskripsi = new JLabel();
    
    JButton dvdAnak = new JButton("DVD Anak-Anak");
    JButton dvdDewasa = new JButton("DVD Dewasa");
    JButton dvdLansia = new JButton("DVD Lansia");
    JButton logoutButton = new JButton("Logout");
    
    HomePage(String nama){
        setVisible(true);
        setSize(720,350);
        setTitle("Hallo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setLayout(null);
        
        add(Ucapan);
        Ucapan.setText("Selamat Datang, " + nama);
        
        add(dvdAnak);
        add(dvdDewasa);
        add(dvdLansia);
        add(logoutButton);
        
        Ucapan.setBounds(270,20,200,24);
        
        dvdAnak.setBounds(80,100,120,70);
        dvdDewasa.setBounds(290,100,120,70);
        dvdLansia.setBounds(500,100,120,70);
        logoutButton.setBounds(80,200,540,70);
        
        dvdAnak.addActionListener(this);
        dvdDewasa.addActionListener(this);
        dvdLansia.addActionListener(this);
        logoutButton.addActionListener(this);

    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource()==dvdAnak){
                new RentalDvd("Anak");
            }else if(e.getSource()==dvdDewasa){
                new RentalDvd("Dewasa");
            }else if (e.getSource()==dvdLansia){
                new RentalDvd("Lansia");
            }else{
                new LoginPage();
            }
            this.dispose();
        }catch(Exception error){
            
        }
    }
}
