package br.dev.marcosvirgilio.mobile.esquadrao4patas.ui.animal;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.dev.marcosvirgilio.mobile.esquadrao4patas.R;
import br.dev.marcosvirgilio.mobile.esquadrao4patas.model.Animal;

public class CadAnimalFragment extends Fragment implements View.OnClickListener {
    private View view = null;
    private CheckBox temTutor;
    private EditText nomeAnimal;
    private Spinner codTutor;
    private Spinner porteAnimal;
    private Spinner corAnimal;
    private Button salvar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.view = inflater.inflate(R.layout.fragment_cad_animal, container, false);
        //Binding
        this.temTutor = (CheckBox) view.findViewById(R.id.cbTemTutor);
        this.codTutor = (Spinner) view.findViewById(R.id.spTutor);
        this.nomeAnimal = (EditText) view.findViewById(R.id.etNomeAnimal);
        this.porteAnimal = (Spinner) view.findViewById(R.id.spPorte);
        this.corAnimal = (Spinner) view.findViewById(R.id.spCorPredominante);
        this.salvar = (Button) view.findViewById(R.id.btSalvar);

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
                animal.setCodTutor(this.codTutor.getSelectedItemPosition());

                break;
        }


    }
}