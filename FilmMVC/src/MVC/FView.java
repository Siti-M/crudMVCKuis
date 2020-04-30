package MVC;

import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FView extends JFrame{
    JLabel ljudul,ltipe,lepisode,lgenre,lstatus,lrating;
    JTextField txjudul,txtipe,txepisode,txgenre,txrating,txcari;
    JButton simpan,delete,cari,refresh,update,exit;
    JTable tabel;
    JComboBox status;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;//buat scroll
    Object namaKolom[] = { "#","ID", "Judul", "Tipe", "Episode", "Genre", "Status", "Rating"};//membuat kolom dlm array
    Statement statement;
    
    public FView(){
        //atur tabel
        tableModel = new DefaultTableModel(namaKolom,0); //0 baris
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);
        //atur tabel
        ljudul = new JLabel("Judul");
        ltipe = new JLabel("Tipe");  
        lepisode = new JLabel("Episode");
        lgenre = new JLabel("Genre");
        lstatus = new JLabel("Status");  
        lrating = new JLabel("Rating");
        
        String pilihan[] = {"Ongoing", "Completed"};
        status = new JComboBox(pilihan);
        
        //atur textfield
        txjudul = new JTextField("");
        txtipe = new JTextField("");
        txepisode = new JTextField("");
        txgenre = new JTextField("");
        txrating = new JTextField("");
        txcari = new JTextField("");
        //atur tombol
        simpan = new JButton("Create");
        delete = new JButton("Delete");
        cari = new JButton("Search");
        refresh = new JButton("Refresh");
        update = new JButton("Update");
        exit = new JButton("Exit");
        
        setLayout(null);
        add(ljudul);
        add(ltipe);
        add(lepisode);
        add(lgenre);
        add(lstatus);
        add(lrating);
        add(txjudul);
        add(txtipe);
        add(txepisode);
        add(txgenre);
        add(txrating);
        add(status);
        add(txcari);
        add(simpan);
        add(delete);
        add(refresh);
        add(update);
        add(exit);
        add(scrollPane);
        add(cari);
        
        scrollPane.setBounds(30, 20, 820, 250);
        ljudul.setBounds(30, 280, 70, 20);
        txjudul.setBounds(30, 310, 280, 20);
        ltipe.setBounds(30, 340, 70, 20);
        txtipe.setBounds(30, 370, 125, 20);
        lstatus.setBounds(180, 340, 70, 20);
        status.setBounds(180, 370, 100, 20);
        lepisode.setBounds(30, 410, 100, 20);
        txepisode.setBounds(30, 440, 125, 20);
        lrating.setBounds(180, 410, 100, 20);
        txrating.setBounds(180, 440, 125, 20);
        lgenre.setBounds(30, 470, 70, 20);
        txgenre.setBounds(30, 500, 280, 20);
        txcari.setBounds(430, 310, 200, 20);
        cari.setBounds(635, 310, 80, 22);
        refresh.setBounds(400, 500, 80, 22);
        simpan.setBounds(490, 500, 80, 22);
        update.setBounds(580, 500, 80, 22);
        delete.setBounds(670, 500, 80, 22);
        exit.setBounds(760, 500, 80, 22);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        setSize(900,600); //atur luas jendela
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public String getJudul(){
        return txjudul.getText();
    }
    
    public String getTipe(){
        return txtipe.getText();
    }
    
    public String getEpisode(){
        return txepisode.getText();
    }
    
    public String getGenre(){
        return txgenre.getText();
    }
    
    public String getStatus(){
        return status.getSelectedItem().toString();
    }
    
    public String getRating(){
        return txrating.getText();
    }
    
    public String getSearch(){
        return txcari.getText();
    }
}