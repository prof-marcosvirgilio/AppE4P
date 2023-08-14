package br.dev.marcosvirgilio.mobile.esquadrao4patas.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Animal {
    //atributos
    private int id;
    private int codTutor;
    private String nome;
    private int codPorte;
    private int codCorPredominante;
    //
    //CONSTRUTOR - inicializa atributos de um arquivo JSon
    public Animal (JSONObject jp) {
        try {
            //id
            Integer numero = (int) jp.get("id");
            this.setId(numero);
            //tutor
            numero = (int) jp.get("tutor");
            this.setCodTutor(numero);
            //nome
            this.setNome((String) jp.get("nome"));
            //porte
            numero = (int) jp.get("porte");
            this.setCodPorte(numero);
            //cor
            numero = (int) jp.get("cor");
            this.setCodCorPredominante(numero);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    //CONSTRUTOR - Inicializa os atributos para gerar Objeto Json
    public Animal () {
        this.setId(0);
        this.setCodTutor(0);
        this.setNome("");
        this.setCodPorte(2);
        this.setCodCorPredominante(0);
    }
    //Metodo retorna o objeto com dados no formato JSON
    public JSONObject toJsonObject() {
        JSONObject json = new JSONObject();
        try {
            json.put("id", this.id);
            json.put("tutor", this.codTutor);
            json.put("nome", this.nome);
            json.put("porte", this.codPorte);
            json.put("cor", this.codCorPredominante);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }



    //métodos
    public int getId() {return this.id;}
    public int getCodTutor(){ return this.codTutor; }
    public int getCodPorte() {return this.codPorte;}
    public int getCodCorPredominante(){return this.codCorPredominante; }
    public String getNome(){return this.nome;}

    public void setId(int id){ this.id = id;}
    public void setCodTutor(int ct){ this.codTutor = ct; }
    public void setCodCorPredominante(int cc){
        if (cc >= 0 && cc <= 4){  this.codCorPredominante = cc; }
        else { this.codCorPredominante = 0;   }
    }

    public void setCodPorte(int cp){
        if (cp >= 0 && cp <= 4){this.codPorte = cp; }
        else {this.codPorte = 2; }
    }

    public void setNome(String nm){
        if (nm.length() < 3){ this.nome = "A definir"; }
        else { this.nome = nm; }
    }
}
