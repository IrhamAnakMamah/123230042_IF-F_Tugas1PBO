/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lat_kuis;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;


import java.text.NumberFormat; //format uang
import java.util.Locale;

class Dvd{
    String nama;
    String stringHarga;
    int bilanganHarga;
    
    Dvd(String nama){
        this.nama = nama;
    }
    
    public String getHarga(){
        return stringHarga;
    }
    
    public String getNama(){
        return nama;
    }
    
    int HitungPPN(int buah){
        int TotalHarga = buah * bilanganHarga;
        int TotalPPN = (TotalHarga * 11)/100;
        return TotalPPN;
    }
    
    int TotalHarga(int buah){
        int TotalPPN = HitungPPN(buah);
        int TotalHarga = buah * bilanganHarga;
        TotalHarga = TotalHarga - TotalPPN;
        return TotalHarga;
    }
}

class DvdAnak extends Dvd{
    
    DvdAnak(String nama){
        super(nama);
        stringHarga = "27.891";
        bilanganHarga = 27891;
    }
}

class DvdDewasa extends Dvd{
    
    DvdDewasa(String nama){
        super(nama);
        stringHarga = "35.396";
        bilanganHarga = 35396;
    }
}

class DvdLansia extends Dvd{
    
    DvdLansia(String nama){
        super(nama);
        stringHarga = "38.550";
        bilanganHarga = 38550;
    }
}
/**
 *
 * @author Irham
 */
public class RentalDvd extends JFrame implements ActionListener{
    
    Dvd target;
    
    JLabel title = new JLabel("Halaman Pembelian");
    JLabel hasil = new JLabel("Total Pembelian");
    
    JLabel namaDvd = new JLabel();
    JLabel hargaSatuan1 = new JLabel();    
    JLabel hargaSatuan2 = new JLabel();
    JLabel jumlahPPN = new JLabel("0");
    JLabel hargaTotal = new JLabel("0");
    JLabel totalDvd = new JLabel("0");
    
    JTextField inputDvd = new JTextField();
    
    JButton beli = new JButton("Beli");
    JButton kembali = new JButton("Kembali");
    
    RentalDvd(String Tipe){
        setVisible(true);
        setSize(350, 440);
        setTitle("Latihan Kuis");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setLayout(null);
        
        cekDvd(Tipe);
        
        namaDvd.setText(target.getNama());
        hargaSatuan1.setText(target.getHarga());
        hargaSatuan2.setText(target.getHarga());
        
        add(title);
        
        JLabel kategorititel = new JLabel("Kategori");
        JLabel hargatitel1 = new JLabel("Harga");
        JLabel hargatitel2 = new JLabel("Harga Satuan");
        JLabel jumlahtitel1 = new JLabel("Jumlah");        
        JLabel jumlahtitel2 = new JLabel("Jumlah");
        JLabel ppntitel = new JLabel("Kategori");
        JLabel totaltitel = new JLabel("Total Harga");
        
        add(kategorititel);
        add(namaDvd);

        add(hargatitel1);
        add(hargaSatuan1);

        add(jumlahtitel1);
        add(inputDvd);
        
        add(beli);
        
        add(hasil);
        
        add(hargatitel2);
        add(hargaSatuan2);
        
        add(jumlahtitel2);
        
        totalDvd.setText(inputDvd.getText());
        add(totalDvd);
        
        add(ppntitel);
        add(jumlahPPN);
        
        add(totaltitel);
        add(hargaTotal);
        
        add(kembali);
        
        title.setBounds(20,20,200,20);
        
        kategorititel.setBounds(20,50,100,20);
        namaDvd.setBounds(130,50,100,20);
        
        hargatitel1.setBounds(20,80,100,20);
        hargaSatuan1.setBounds(130,80,100,20);
        
        jumlahtitel1.setBounds(20,110,100,20);
        inputDvd.setBounds(130,110,100,20);
        
        beli.setBounds(20,150,240,30);
        hasil.setBounds(20,190,100,20);
        
        hargatitel2.setBounds(20,220,100,20);
        hargaSatuan2.setBounds(130,220,100,20);
        
        jumlahtitel2.setBounds(20,250,100,20);
        totalDvd.setBounds(130,250,100,20);
        
        ppntitel.setBounds(20,280,100,20);
        jumlahPPN.setBounds(130,280,100,20);
        
        totaltitel.setBounds(20,310,100,20);
        hargaTotal.setBounds(130,310,100,20);
        
        kembali.setBounds(20,340,240,30);
        
        beli.addActionListener(this);
        kembali.addActionListener(this);
    }
    
    void cekDvd(String Tipe){
        try{
            if(Tipe.equals("Anak")){
                target = new DvdAnak("DVD Anak");
            }else if(Tipe.equals("Dewasa")){
                target = new DvdDewasa("DVD Dewasa");
            }else{
                target = new DvdLansia("DVD Lansia");
            }            
        }catch(Exception e){
            
        }

    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource() == beli){
                int jumlah = Integer.parseInt(inputDvd.getText());
                if(jumlah>=1){
                    //hitungPPN, totalHarga
                    //hargaTotal, jumlahPPN
                    totalDvd.setText(inputDvd.getText());
                    NumberFormat formatRp = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
                    jumlahPPN.setText("Rp. " + formatRp.format(target.HitungPPN(jumlah)));
                    hargaTotal.setText("Rp. " + formatRp.format(target.TotalHarga(jumlah)));
                }else{
                    throw new Exception("input harus diatas 0!");
                }
            }else{
                new HomePage("123230042");
                this.dispose();
            }
        }catch(Exception error){
            JOptionPane.showMessageDialog(this, "error : " + error.getMessage());
            ResetInput();
        }
    }
    
    public void ResetInput(){
        inputDvd.setText("");
    }
}
