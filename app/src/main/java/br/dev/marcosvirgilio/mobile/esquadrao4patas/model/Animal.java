package br.dev.marcosvirgilio.mobile.esquadrao4patas.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Animal {
    //atributos
    private int id;
    private String chip;
    private int anoNascimento;
    private String sexo;
    private String tutor;
    private String nome;
    private int codPorte;
    private int codCorPredominante;
    //
    //CONSTRUTOR - inicializa atributos de um arquivo JSon
    public Animal (JSONObject jp) {
        try {
            //id
            this.setId(jp.getInt ("idanimal"));

            this.setChip(jp.getString ("chip"));

            this.setAnoNascimento(jp.getInt ("anonascimento"));

            this.setSexo(jp.getString ("sexo"));
            //tutor
            this.setTutor(jp.getString ("nmtutor"));
            //nome
            this.setNome(jp.getString ("nmanimal"));
            //porte
            this.setCodPorte(jp.getInt("idporte"));
            //cor
            this.setCodCorPredominante(jp.getInt ("idcor"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    //CONSTRUTOR - Inicializa os atributos para gerar Objeto Json
    public Animal () {
        this.setId(0);
        this.setChip("");
        this.setAnoNascimento(0);
        this.setSexo("");
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
            json.put("chip", this.chip);
            json.put("anonascimento", this.anoNascimento);
            json.put("sexo", this.sexo);
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

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

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
