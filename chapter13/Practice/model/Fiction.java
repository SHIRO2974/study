package chapter13.Practice.model;

public class Fiction extends Book{

    private String  genre;  // 장르

    public Fiction(int id, String title, String author, String genre) {

        super(id, title, author);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return super.toString() + ", Genre: " + genre;
    }
}
