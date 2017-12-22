package app.newskaro.com.newskaro.core;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import timber.log.Timber;


public class RecyclerAdapter<S, T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<T> {

    private Context mContext;
    private List<S> mObjects;
    private BindAdapterListener mListener;
    private Class<T> mHolderClass;
    private int layoutId;

    public interface BindAdapterListener<T extends RecyclerView.ViewHolder> {
        void onBind(T holder, int position);
    }

    public RecyclerAdapter(Context context, List<S> objects, BindAdapterListener listener, Class<T> holderClass, int layoutId) {
        mContext = context;
        mObjects = objects;
        mHolderClass = holderClass;
        mListener = listener;
        this.layoutId = layoutId;
    }


    @Override
    public T onCreateViewHolder(ViewGroup parent, int viewType) {
        try {
            return mHolderClass.getConstructor(View.class).newInstance(LayoutInflater.from(mContext).inflate(layoutId, parent, false));
        } catch (InstantiationException e) {
            Timber.e("Exception: %s", e.getMessage());
        } catch (Exception e) {
            Timber.e("Exception: %s", e.getMessage());
        }
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void onBindViewHolder(T holder, int position) {

        if (mListener != null) {
            mListener.onBind(holder, position);
        }
    }

    @Override
    public int getItemCount() {
        return mObjects == null ? 0 : mObjects.size();
    }

}