package dhbk.android.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.Collections;
import java.util.List;

/**
 * Created by huynhducthanhphong on 4/26/16.
 */
public class Recycler_View_Adapter extends RecyclerView.Adapter<View_Holder>{
    List<Data> list = Collections.emptyList();
    Context context;

    // pass array of data and context
    public Recycler_View_Adapter(List<Data> list, Context context) {
        this.list = list;
        this.context = context;
    }

    // HIện thực recycler view thì phải hiện thực 3 hàm sau:
    // khai báo layout cho 1 hàng
    // khai báo constructor cho viewHolder
    @Override
    public View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        View_Holder holder = new View_Holder(v);
        return holder;
    }

    // dùng viewholder để populate data cho 1 hàng
    @Override
    public void onBindViewHolder(View_Holder holder, int position) {
        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
        holder.title.setText(list.get(position).title);
        holder.description.setText(list.get(position).description);
        holder.imageView.setImageResource(list.get(position).imageId);

        // anim
        animate(holder);
    }

    //returns the number of elements the RecyclerView will display
    @Override
    public int getItemCount() {
        return list.size();
    }


    // Insert a new item to the RecyclerView on a predefined position
    public void insert(int position, Data data) {
        list.add(position, data);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing a specified Data object
    public void remove(Data data) {
        int position = list.indexOf(data);
        list.remove(position);
        notifyItemRemoved(position);
    }

    public void animate(RecyclerView.ViewHolder viewHolder) {
        final Animation animAnticipateOvershoot = AnimationUtils.loadAnimation(context, R.anim.anticipate_overshoot_interpolator);
        viewHolder.itemView.setAnimation(animAnticipateOvershoot);
    }

}
