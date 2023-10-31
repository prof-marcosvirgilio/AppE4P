package br.dev.marcosvirgilio.mobile.esquadrao4patas.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Animal {
    //atributos
    private int id;
    private String tutor;
    private String nome;
    private int codPorte;
    private int codCorPredominante;
    //
    //CONSTRUTOR - inicializa atributos de um arquivo JSon
    public Animal (JSONObject jp) {
        try {
            //id
            Integer numero = (int) jp.get("idanimal");
            this.setId(numero);
            //tutor
            this.setTutor((String )jp.get("nmtutor"));
            //nome
            this.setNome((String) jp.get("nmanimal"));
            //porte
            numero = (int) jp.get("idporte");
            this.setCodPorte(numero);
            //cor
            numero = (int) jp.get("idcor");
            this.setCodCorPredominante(numero);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    //CONSTRUTOR - Inicializa os atributos para gerar Objeto Json
    public Animal () {
        this.setId(0);
        this.setTutor("");
        this.setNome("");
        this.setCodPorte(0);
        this.setCodCorPredominante(0);
    }
    //Metodo retorna o objeto com dados no formato JSON
    public JSONObject toJsonObject() {
        JSONObject json = new JSONObject();
        try {
            json.put("idanimal", this.id);
            json.put("nmtutor", this.tutor);
            json.put("nmanimal", this.nome);
            json.put("idporte", this.codPorte);
            json.put("idcor", this.codCorPredominante);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }



    //métodos
    public int getId() {return this.id;}
    public String getTutor(){ return this.tutor; }
    public int getCodPorte() {return this.codPorte;}
    public int getCodCorPredominante(){return this.codCorPredominante; }
    public String getNome(){return this.nome;}

    public void setId(int id){ this.id = id;}
    public void setTutor(String ct){ this.tutor = ct; }
    public void setCodCorPredominante(int cc){
        if (cc >= 0 && cc <= 4){  this.codCorPredominante = cc; }
        else { this.codCorPredominante = 0;   }
    }

    public void setCodPorte(int cp){
        if (cp >= 0 && cp <= 4){this.codPorte = cp; }
        else {this.codPorte = 2; }
    }

    public void setNome(String nm){

         this.nome = nm;
    }
}
