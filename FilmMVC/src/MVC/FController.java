package MVC;

import java.awt.event.*;
import javax.swing.*;

public class FController {
    FModel mhsmodel;//utk import class Model
    FView mhsview; //utk import class View
    FDAO mhsdao; //utk import class DAO
    String idfilm, judul, tipe, episode, genre, status, rating;
    
    public FController(FModel mhsmodel, FView mhsview, FDAO mhsdao){
        this.mhsmodel = mhsmodel;
        this.mhsview = mhsview;
        this.mhsdao = mhsdao;
        
        if(mhsdao.getJmldata() != 0){ //utk mengecek apakah DB ada data atau tidak
            String dataMahasiswa[][] = mhsdao.readFilm();
            mhsview.tabel.setModel((new JTable(dataMahasiswa, mhsview.namaKolom)).getModel());
        } else { 
            // kalau tdk ada mka akan muncul pop up
            JOptionPane.showMessageDialog(null, "Data tidak ada!");
        }
        
        mhsview.refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 String dataMahasiswa[][] = mhsdao.readFilm();
                 mhsview.tabel.setModel((new JTable (dataMahasiswa, mhsview.namaKolom)).getModel());
                
                 mhsview.txjudul.setText(null);
                 mhsview.txtipe.setText(null);
                 mhsview.txepisode.setText(null);
                 mhsview.txgenre.setText(null);
                 mhsview.txrating.setText(null);
            }
        });
        
        mhsview.simpan.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String judul = mhsview.getJudul();
                String tipe = mhsview.getTipe();
                String episode = mhsview.getEpisode();
                String genre = mhsview.getGenre();
                String status = mhsview.getStatus();
                String rating = mhsview.getRating();
                
                if(judul.isEmpty() || tipe.isEmpty() || episode.isEmpty()
                    ||genre.isEmpty() || status.isEmpty() || rating.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Harap isi semua field");
                } else {
                   
                    //memasukkan data kedlm Model
                    mhsmodel.setMhsModel(judul, tipe, episode, genre, status, rating);
                    //menjalankan perintah insert di DAO
                    mhsdao.Insert(mhsmodel);
                }
            }
        });
        
        mhsview.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                super.mouseClicked(e);
                int baris = mhsview.tabel.getSelectedRow();
                int kolom = mhsview.tabel.getSelectedColumn();
                
                idfilm = mhsview.tabel.getValueAt(baris,1).toString();
                judul = mhsview.tabel.getValueAt(baris,2).toString();
                tipe = mhsview.tabel.getValueAt(baris,3).toString();
                episode = mhsview.tabel.getValueAt(baris,4).toString();
                genre = mhsview.tabel.getValueAt(baris,5).toString();
                status = mhsview.tabel.getValueAt(baris,6).toString();
                rating = mhsview.tabel.getValueAt(baris,7).toString();
                
                mhsview.txjudul.setText(judul);
                mhsview.txtipe.setText(tipe);
                mhsview.txepisode.setText(episode);
                mhsview.txgenre.setText(genre);
                mhsview.status.setSelectedItem(status);
                mhsview.txrating.setText(rating);
            }
        });
        
        mhsview.update.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String judul = mhsview.getJudul();
                String tipe = mhsview.getTipe();
                String episode = mhsview.getEpisode();
                String genre = mhsview.getGenre();
                String status = mhsview.getStatus();
                String rating = mhsview.getRating();
                
                if(judul.isEmpty() || tipe.isEmpty() || episode.isEmpty()
                    ||genre.isEmpty() || status.isEmpty() || rating.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Harap isi semua field");
                } else {
                    mhsmodel.setIdfilm(idfilm);
                    //memasukkan data kedlm Model
                    mhsmodel.setMhsModel(judul, tipe, episode, genre, status, rating);
                    //menjalankan perintah insert di DAO
                    mhsdao.Update(mhsmodel);
                }
            }
        });
                
        mhsview.delete.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                
                int del = JOptionPane.showConfirmDialog(null, "Anda yakin ingin menghapus data ini? ","",JOptionPane.YES_NO_OPTION);

                if (del == 0){
                    mhsmodel.setIdfilm(idfilm);
                    mhsdao.Delete(mhsmodel);
//                    mhsdao.Delete(dataTerpilih);
//                    String dataMahasiswa[][] = mhsdao.readFilm();
//                    mhsview.tabel.setModel((new JTable (dataMahasiswa, mhsview.namaKolom)).getModel());
                }
            }
        });
        
        mhsview.cari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String cari = mhsview.getSearch();
                if(cari.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Harap isi field search");
                } else {
                    mhsmodel.setSearch(cari);
                    String dataMahasiswa[][] = mhsdao.Search(mhsmodel);
                    mhsview.tabel.setModel((new JTable (dataMahasiswa, mhsview.namaKolom)).getModel());
                
                }
                
            }
        });
        
        mhsview.exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                mhsview.setVisible(false);
            }
        });
    }
}