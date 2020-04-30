
package MVC;

/**
 *
 * @author HP
 */
public class FModel {
    
    private String idfilm,judul,tipe,genre,status,episode,rating,search;
    //contructor
    public void setMhsModel(String jjudul, String ttipe, String eepisode, String ggenre, String sstatus, String rrating){
        this.judul = jjudul;
        this.tipe= ttipe;
        this.episode= eepisode;
        this.genre= ggenre;
        this.status= sstatus;
        this.rating= rrating;
    }
    
    public String getIdfilm(){
        return idfilm;
    }
    
    public void setIdfilm(String idfilm){
        this.idfilm = idfilm;
    }
    
    public String getJudul(){
        return judul;
    }
    
    public void setJudul(String judul){
        this.judul = judul;
    }
    
    public String getTipe(){
        return tipe;
    }
    
    public void setTipe(String tipe){
        this.tipe = tipe;
    }
    
    public String getEpisode(){
        return episode;
    }
    
    public void setEpisode(String episode){
        this.episode = episode;
    }
    
    public String getGenre(){
        return genre;
    }
    
    public void setGenre(String genre){
        this.genre = genre;
    }
    
    public String getStatus(){
        return status;
    }
    
    public void setStatus(String status){
        this.status = status;
    }

    public String getRating(){
        return rating;
    }
    
    public void setRating(String rating){
        this.rating = rating;
    }
    
    public String getSearch(){
        return search;
    }
    
    public void setSearch(String search){
        this.search = search;
    }
}