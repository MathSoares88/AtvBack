package sptech.Atv_Sprint2;

public class Mensagem {
    private String conteudo;
    private String autor;

    public Mensagem() {}

    public Mensagem(String conteudo, String autor) {
        this.conteudo = conteudo;
        this.autor = autor;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}