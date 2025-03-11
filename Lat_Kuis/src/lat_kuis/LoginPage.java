/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lat_kuis;

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author Irham
 */
public class LoginPage extends JFrame implements ActionListener{
    JLabel Judul = new JLabel("Selamat Datang di Aplikasi Nyewa DVD");
    JLabel usernameLabel = new JLabel ("Username : ");
    JLabel passwordLabel = new JLabel ("Password : ");
    
    private JTextField usernameInput = new JTextField();
    private JPasswordField passwordInput = new JPasswordField();
    
    JButton tombolLogin = new JButton("Submit");
    JButton tombolReset = new JButton("Reset");
    
    LoginPage(){
        setVisible(true);
        setSize(480,300);
        setTitle("Latihan Kuis");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setLayout(null);
        
        add(Judul);
        
        add(usernameLabel);
        add(usernameInput);
        add(passwordLabel);
        add(passwordInput);
        
        add(tombolLogin);
        add(tombolReset);
        
        Judul.setBounds(130,20,250,24);
        
        usernameLabel.setBounds(20,84,440,12);
        passwordLabel.setBounds(20,152,440,12);
        usernameInput.setBounds(18,100,440,30);
        passwordInput.setBounds(18,168,440,30);
        
        tombolLogin.setBounds(20, 210, 100, 30);
        tombolReset.setBounds(355,210,100,30);
        
        tombolLogin.addActionListener(this);
        tombolReset.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource()==tombolLogin){
                String username = usernameInput.getText();
                char[] passChar = passwordInput.getPassword();
                String password = new String(passChar);
                
                //cek input username dan password
                if(username.equals("123230042") && password.equals("240032321")){
                    
                    System.out.println("Sukses");
                    new HomePage(username); //membuka frame homepage
                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(this, "Username atau password salah!");
                    ResetAll();
                }
            }else if (e.getSource() == tombolReset){
                ResetAll();
            }
        }catch(Exception error){
            
        }
    }
    
    public void ResetAll(){
        usernameInput.setText("");
        passwordInput.setText("");
    }
}
