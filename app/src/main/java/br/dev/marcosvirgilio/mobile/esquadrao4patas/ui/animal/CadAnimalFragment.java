package br.dev.marcosvirgilio.mobile.esquadrao4patas.ui.animal;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONException;
import org.json.JSONObject;

import br.dev.marcosvirgilio.mobile.esquadrao4patas.R;
import br.dev.marcosvirgilio.mobile.esquadrao4patas.model.Animal;

public class CadAnimalFragment extends Fragment implements View.OnClickListener
        , Response.ErrorListener,  Response.Listener{
    private View view = null;
    private CheckBox temTutor;
    private EditText nomeAnimal;
    private EditText nomeTutor;
    private Spinner porteAnimal;
    private Spinner corAnimal;
    private Button salvar;

    //volley
    private RequestQueue requestQueue;
    private JsonObjectRequest jsonObjectReq;


    public CadAnimalFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.view = inflater.inflate(R.layout.fragment_cad_animal, container, false);
        //Binding
        this.temTutor = (CheckBox) view.findViewById(R.id.cbTemTutor);
        this.nomeTutor = (EditText) view.findViewById(R.id.etTutor);
        this.nomeAnimal = (EditText) view.findViewById(R.id.etNomeAnimal);
        this.porteAnimal = (Spinner) view.findViewById(R.id.spPorte);
        this.corAnimal = (Spinner) view.findViewById(R.id.spCorPredominante);
        this.salvar = (Button) view.findViewById(R.id.btSalvar);
        this.salvar.setOnClickListener(this);
        //
        //instanciando a fila de requests - caso o objeto seja o view
        this.requestQueue = Volley.newRequestQueue(view.getContext());
//inicializando a fila de requests do SO
        this.requestQueue.start();
        //
        return this.view;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //verificando se é o botão salvar
            case R.id.btSalvar:
            //instanciando objeto de negócio
                Animal animal = new Animal();
                animal.setNome(this.nomeAnimal.getText().toString());
                animal.setTutor(this.nomeTutor.getText().toString());
                animal.setCodPorte(this.porteAnimal.getSelectedItemPosition());
                animal.setCodCorPredominante(this.corAnimal.getSelectedItemPosition());
                //Chamar WebService
                jsonObjectReq = new JsonObjectRequest(
                        Request.Method.POST,
                        "http://10.0.2.2/e4p/cadanimal.php",
                        animal.toJsonObject(), this, this);
                requestQueue.add(jsonObjectReq);
                break;
        }


    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Snackbar mensagem = Snackbar.make(view,
                "Ops! Houve um problema ao realizar o cadastro: " +
                        error.toString(),Snackbar.LENGTH_LONG);
        mensagem.show();

    }

    @Override
    public void onResponse(Object response) {
        try {
            //instanciando objeto para manejar o JSON que recebemos
            JSONObject jason = new JSONObject(response.toString());
            //context e text são para a mensagem na tela o Toast
            Context context = view.getContext();
            //pegando mensagem que veio do json
            CharSequence mensagem = jason.getString("message");
            //duração da mensagem na tela
            int duration = Toast.LENGTH_SHORT;
            //verificando se salvou sem erro para limpar campos da tela
            if (jason.getBoolean("success")){
                //campos texto
                this.nomeAnimal.setText("");
                //selecionando primiro item dos spinners
                this.nomeTutor.setSelection(0);
                this.porteAnimal.setSelection(0);
                this.corAnimal.setSelection(0);
            }
            //mostrando a mensagem que veio do JSON
            Toast toast = Toast.makeText (context, mensagem, duration);
            toast.show();

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        //mensagem de sucesso


    }
}