package MVC;

import java.sql.*;
import javax.swing.JOptionPane;

public class FDAO {
    private int jmlData;
    private Connection koneksi;
    private Statement statement;
    //constructor berfungsi utk melakukan sebuah koneksi saat ada object baru dibuat
    public FDAO(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/film";
            koneksi = DriverManager.getConnection(url, "root", "");
            statement = koneksi.createStatement();
            JOptionPane.showMessageDialog(null, "Koneksi Berhasil");
        } catch (ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Class Not Found : " + ex);
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "SQL Exception : " + ex);
        }
    }
    
    public void Insert(FModel Model){
        try{
            String query = "INSERT INTO list VALUES (NULL,'"+Model.getJudul()+"','"+Model.getTipe()+"',"
                    + "'"+Model.getEpisode()+"','"+Model.getGenre()+"','"+Model.getStatus()+"','"+Model.getRating()+"')";
            statement.executeUpdate(query); //execute querynya
            JOptionPane.showMessageDialog(null, "Data disimpan");
        } catch (Exception sql){
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public void Update(FModel Model) {
        try{
            String query = "UPDATE list SET judul = '"+Model.getJudul()+"', tipe = '"+Model.getTipe()+"',"
                +" episode = '"+Model.getEpisode()+"', genre = '"+Model.getGenre()
                +"', status = '"+Model.getStatus()+"', rating = '"+Model.getRating()
                +"' WHERE idFilm = '"+Model.getIdfilm()+"'";
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil di Update");
        } catch (SQLException sql){
            System.out.println(sql.getMessage());
        }
    }
    
    public void Delete(FModel Model) {
        try{
            String query = "DELETE FROM list WHERE idFilm = '"+Model.getIdfilm()+"'";
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil di Hapus");
        } catch (SQLException sql){
            System.out.println(sql.getMessage());
        }
    }
    
    public String[][] readFilm(){
        try{
            int jmlData = 0; //menampung jmlh data
            //baris sejumlah data, kolomnya ada 3
            String data[][] = new String[getJmldata()][8];
            //penganmbilan dta dlm java dari db
            String query = "SELECT * FROM list";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ //lanjut kedata selanjutnya jmlData bertambah
                data[jmlData][0] = String.valueOf(jmlData+1); //nomor
                data[jmlData][1] = resultSet.getString("idFilm");//kolom nama harus sama
                data[jmlData][2] = resultSet.getString("judul");//besar kecilnya dgn database
                data[jmlData][3] = resultSet.getString("tipe");
                data[jmlData][4] = resultSet.getString("episode");
                data[jmlData][5] = resultSet.getString("genre");
                data[jmlData][6] = resultSet.getString("status");
                data[jmlData][7] = resultSet.getString("rating");
                jmlData++; //barisnya berpindah terus
            }
            return data;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    //untuk mengambil data dari db dan mengatur ke tabel
    public String[][] Search(FModel Model){
        try{
            int jmlData = 0; //menampung jmlh data
            //baris sejumlah data, kolomnya ada 3
            String judul = Model.getSearch();
            String data[][] = new String[getJmlData(judul)][8];
            //penganmbilan dta dlm java dari db
            String query = "SELECT * FROM list WHERE judul LIKE '%" + Model.getSearch() + "%'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ //lanjut kedata selanjutnya jmlData bertambah
                data[jmlData][0] = String.valueOf(jmlData+1); //nomor
                data[jmlData][1] = resultSet.getString("idFilm");//kolom nama harus sama
                data[jmlData][2] = resultSet.getString("judul");//besar kecilnya dgn database
                data[jmlData][3] = resultSet.getString("tipe");
                data[jmlData][4] = resultSet.getString("episode");
                data[jmlData][5] = resultSet.getString("genre");
                data[jmlData][6] = resultSet.getString("status");
                data[jmlData][7] = resultSet.getString("rating");
                jmlData++; //barisnya berpindah terus
            }
            return data;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public int getJmldata(){
        int jmlData = 0;
        try{
            //pengambilan data kedlm java dri db
            String query = "SELECT * FROM list";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){//lanjut kedata selanjutnya, jmlData bertambah
                jmlData++;
            }
            return jmlData;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }

    private int getJmlData(String judul) { //jumlah data untuk pencarian
        int jmlData = 0;
        try{
            //pengambilan data kedlm java dri db
            String query = "SELECT * FROM list WHERE judul LIKE '%" + judul + "%'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){//lanjut kedata selanjutnya, jmlData bertambah
                jmlData++;
            }
            return jmlData;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
}