package br.dev.marcosvirgilio.mobile.esquadrao4patas.ui.animal;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import br.dev.marcosvirgilio.mobile.esquadrao4patas.databinding.FragmentConAnimalBinding;
import br.dev.marcosvirgilio.mobile.esquadrao4patas.model.Animal;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Animal}.
 * TODO: Replace the implementation with code for your data type.
 */
public class ConAnimalRecyclerViewAdapter extends RecyclerView.Adapter<ConAnimalRecyclerViewAdapter.ViewHolder> {

    private final List<Animal> mValues;

    public ConAnimalRecyclerViewAdapter(List<Animal> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentConAnimalBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(String.valueOf(mValues.get(position).getId()));
        holder.mContentView.setText(
               "Nome:" + mValues.get(position).getNome()
        );
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView mIdView;
        public final TextView mContentView;
        public Animal mItem;

        public ViewHolder(@NonNull FragmentConAnimalBinding binding) {
            super(binding.getRoot());
            mIdView = binding.itemNumber;
            mContentView = binding.content;
            //click dos itens
            binding.getRoot().setOnClickListener(this);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }

        @Override
        public void onClick(View view) {
            //CLICK - pegar posicao que foi clicada
            int adapterposition = this.getLayoutPosition();
            //mostrar posição clicada
            Context context =  view.getContext();
            CharSequence text = mValues.get(adapterposition).getNome();
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        }
    }
}