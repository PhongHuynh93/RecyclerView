package dhbk.android.recyclerview;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by huynhducthanhphong on 4/26/16.
 */
public class View_Holder extends RecyclerView.ViewHolder{

    CardView cv;
    TextView title;
    TextView description;
    ImageView imageView;

    // hiện thực hết findViewById cho 1 row.
    View_Holder(View itemView) {
        super(itemView);
        cv = (CardView) itemView.findViewById(R.id.cardView);
        title = (TextView) itemView.findViewById(R.id.title);
        description = (TextView) itemView.findViewById(R.id.description);
        imageView = (ImageView) itemView.findViewById(R.id.imageView);
    }
}
